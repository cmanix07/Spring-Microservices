package com.cmani.msscbreweryrestdocs.web.controller.v2;

import com.cmani.msscbreweryrestdocs.service.v2.BeerServiceV2;
import com.cmani.msscbreweryrestdocs.web.model.BeerDto;
import com.cmani.msscbreweryrestdocs.web.model.v2.BeerDtoV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v2/beer")
public class BeerControllerV2 {

    @Autowired
    public BeerServiceV2 beerServiceV2;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){

        //return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
        return new ResponseEntity(beerServiceV2.getBeerById(beerId), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<BeerDtoV2> saveBeer(@RequestBody BeerDtoV2 beer){

        BeerDtoV2 beerDto = beerServiceV2.saveBeer(beer);
        HttpHeaders headers = new HttpHeaders();
        //Need to update the location full path, hostname- http://localhost:9191/api/v1/beer
        headers.add("Locations","/api/v1/beer"+beerDto.getId().toString());
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @PutMapping
    @RequestMapping("/{beerId}")
    public ResponseEntity updateBeer(@PathVariable("beerId") UUID beerId,  @RequestBody BeerDtoV2 beerDto){
        beerServiceV2.updateBeer(beerId,beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(UUID beerId){
        beerServiceV2.deleteBeer(beerId);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e) {
        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
        e.getConstraintViolations().forEach(constraintViolation -> {
            errors.add(constraintViolation.getPropertyPath()
                    + " -> " + constraintViolation.getMessage());
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
