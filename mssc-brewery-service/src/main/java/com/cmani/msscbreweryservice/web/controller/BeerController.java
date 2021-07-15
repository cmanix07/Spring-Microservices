package com.cmani.msscbreweryservice.web.controller;


import com.cmani.msscbreweryservice.service.BeerService;
import com.cmani.msscbreweryservice.web.model.BeerDto;
import com.cmani.msscbreweryservice.web.model.BeerPagedList;
import com.cmani.msscbreweryservice.web.model.BeerStyleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    
    private static final Integer DEFAULT_PAGE_NUMBER=0;
    private static final Integer DEFAULT_PAGE_SIZE=25;
    @GetMapping(produces = {"application/json"})
    public ResponseEntity<BeerPagedList> listBeers(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                   @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                                   @RequestParam(value = "beerName", required = false) String beerName,
                                                   @RequestParam(value = "beerStyle", required = false) BeerStyleEnum beerStyle,
                                                   @RequestParam(value = "showInventoryOnHand", required = false) Boolean showInventoryOnHand){
        if(showInventoryOnHand == null){
            showInventoryOnHand = Boolean.FALSE;
        }
        if(pageNumber == null || pageNumber<0){
            pageNumber = DEFAULT_PAGE_NUMBER;
        }
        if(pageSize == null || pageSize< 1){
            pageSize = DEFAULT_PAGE_SIZE;
        }
        BeerPagedList beerPagedList = beerService.listBeers(beerName, beerStyle, PageRequest.of(pageNumber, pageSize), showInventoryOnHand);
        return new ResponseEntity<>(beerPagedList,HttpStatus.OK);
    }
    private final BeerService beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId,
                                               @RequestParam(value = "showInventoryOnHand", required = false) Boolean showInventoryOnHand){
        return new ResponseEntity<>(beerService.getBeerById(beerId,showInventoryOnHand), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<BeerDto> saveNewBeer(@Validated @RequestBody BeerDto beer){

        HttpHeaders headers = new HttpHeaders();
        //Need to update the location full path, hostname- http://localhost:9191/api/v1/beer
       // headers.add("Location","/api/v1/beer"+beerDto.getId().toString());
        return new ResponseEntity<>(beerService.saveNewBeer(beer),HttpStatus.CREATED);
    }

    @PutMapping
    @RequestMapping("/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId,  @Validated @RequestBody BeerDto beerDto){
        return new ResponseEntity<>(beerService.updateBeerById(beerId,beerDto),HttpStatus.NO_CONTENT);
    
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerService.deleteBeer(beerId);
    }

}
