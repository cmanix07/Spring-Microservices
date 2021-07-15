package com.cmani.msscbreweryrestdocs.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    private UUID id;
    private String customerName;
    private String emailId;
}
