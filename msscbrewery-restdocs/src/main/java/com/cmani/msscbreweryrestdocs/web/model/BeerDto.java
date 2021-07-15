package com.cmani.msscbreweryrestdocs.web.model;

import com.cmani.msscbreweryrestdocs.web.model.v2.BeerStyleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

    @Null
    private UUID id;
    @Null
    private Long version;
    
    @NotBlank
    @Size(min = 3, max = 100)
    private String beerName;
    @NotNull
    private BeerStyleEnum beerStyle;
    @NotNull
    @Positive
    private Long upc;
    @Positive
    @NotNull
    private BigDecimal price;
    @Positive
    private Integer quantityOnHand;

    @Null
    private OffsetDateTime createdDate;
    @Null
    private OffsetDateTime lastModifiedDate;
}
