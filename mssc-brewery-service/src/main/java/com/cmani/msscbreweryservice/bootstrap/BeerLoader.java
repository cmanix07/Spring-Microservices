package com.cmani.msscbreweryservice.bootstrap;


import com.cmani.msscbreweryservice.domain.Beer;
import com.cmani.msscbreweryservice.repository.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class BeerLoader implements CommandLineRunner {
    
    public static final String UPC_BEER_1 = "0631234200036";
    public static final String UPC_BEER_2 = "0631234300019";
    public static final String UPC_BEER_3 = "0083783375213";
    public static final UUID BEER_1_UUID = UUID.fromString("0a818933-087d-47f2-ad83-2f986ed087eb");
    public static final UUID BEER_2_UUID = UUID.fromString("a712d914-61ea-4623-8bd0-32c0f6545bfd");
    public static final UUID BEER_3_UUID = UUID.fromString("026cc3c8-3a0c-4083-a05b-e908048c1b08");
    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        beerRepository.save( Beer.builder()
                .beerName("Tokyo Craft")
                .beerStyle("Pale Ale")
                .quantityToBrew(300)
                .upc(UPC_BEER_1)
                .minToHand(250)
                .price(new BigDecimal(250.0))
                .build());

        beerRepository.save( Beer.builder()
                .beerName("Asahi")
                .beerStyle("IPA")
                .quantityToBrew(300)
                .upc(UPC_BEER_2)
                .minToHand(187)
                .price(new BigDecimal(186.75))
                .build());
    
        beerRepository.save( Beer.builder()
                .beerName("Start Select Strong")
                .beerStyle("STRONG")
                .quantityToBrew(300)
                .upc(UPC_BEER_3)
                .minToHand(187)
                .price(new BigDecimal(186.75))
                .build());

        System.out.println("Beer Object loaded: "+beerRepository.count());
    }
}
