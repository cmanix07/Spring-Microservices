package com.cmani.msscbreweryrestdocs.bootstrap;


import com.cmani.msscbreweryrestdocs.domain.Beer;
import com.cmani.msscbreweryrestdocs.repository.BeerRepository;
import com.cmani.msscbreweryrestdocs.web.model.v2.BeerStyleEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        beerRepository.save( Beer.builder()
                .beerName("Tokyo Craft")
                .beerStyle("ALE")
                .quantityToBrew(300)
                .upc(3000001L)
                .minToHand(250)
                .price(new BigDecimal(250.0))
                .build());

        beerRepository.save( Beer.builder()
                .beerName("Asahi")
                .beerStyle("IPA")
                .quantityToBrew(300)
                .upc(3000002L)
                .minToHand(187)
                .price(new BigDecimal(186.75))
                .build());

        System.out.println("Beer Object loaded: "+beerRepository.count());
    }
}
