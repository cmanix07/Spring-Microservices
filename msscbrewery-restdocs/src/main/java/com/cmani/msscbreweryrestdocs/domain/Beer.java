package com.cmani.msscbreweryrestdocs.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Beer {
    
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy ="org.hibernate.id.UUIDGenerator" )
    @Column(length = 30, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID id;
    @Null
    private Long version;
    @CreationTimestamp
    private Timestamp createdDate;
    @UpdateTimestamp
    private Timestamp lastModifiedDate;
    private String beerName;
    private String beerStyle;
    @Column(unique = true)
    private Long upc;
    private BigDecimal price;
    
    private Integer minToHand;
    private Integer quantityToBrew;
    
}
