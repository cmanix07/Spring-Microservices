package com.cmani.msscbreweryrestdocs.web.controller;

import com.cmani.msscbreweryrestdocs.service.BeerService;
import com.cmani.msscbreweryrestdocs.service.CustomerService;
import com.cmani.msscbreweryrestdocs.web.model.BeerDto;
import com.cmani.msscbreweryrestdocs.web.model.v2.BeerStyleEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContext;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.constraints.ConstraintDescriptions;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentationConfigurer;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.restdocs.request.RequestDocumentation;
import org.springframework.restdocs.snippet.Attributes;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.UUID;

@ExtendWith(RestDocumentationExtension.class)
@AutoConfigureRestDocs(uriPort = 8181)
@WebMvcTest(BeerController.class)
@ComponentScan(basePackages = "com/cmani/msscbreweryrestdocs/web/mapper/BeerMapper.java")
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    public BeerService beerService;
    @MockBean
    public CustomerService customerService;
    
    
    
    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(RestDocumentationRequestBuilders.get("/api/v1/beer/{beerId}" , UUID.randomUUID().toString())
                .param("isCold","Yes")
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcRestDocumentation.document("v1/beer-get",
                        RequestDocumentation.pathParameters(
                                RequestDocumentation.parameterWithName("beerId").description("UUID of desired Beer to get")
                        ),
                        RequestDocumentation.requestParameters(
                                RequestDocumentation.parameterWithName("isCold").description("Is Beer Cold Query Param")
                        ),
                        PayloadDocumentation.responseFields(
                                PayloadDocumentation.fieldWithPath("id").description("Id of Beer"),
                                PayloadDocumentation.fieldWithPath("version").ignored(),
                                PayloadDocumentation.fieldWithPath("beerName").description("Beer Name"),
                                PayloadDocumentation.fieldWithPath("beerStyle").description("Beer Style Type"),
                                PayloadDocumentation.fieldWithPath("upc").description("UPC of Beer"),
                                PayloadDocumentation.fieldWithPath("price").description("Beer price per unit"),
                                PayloadDocumentation.fieldWithPath("quantityOnHand").description("Quantity of Beer"),
                                PayloadDocumentation.fieldWithPath("createdDate").description("Creation date"),
                                PayloadDocumentation.fieldWithPath("lastModifiedDate").description("Last Modification date")
                                
                        )
                ));
    
    }

    @Test
    void saveNewBeer() throws Exception {
        BeerDto beerDto = getValidBeerDto();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);
        ConstrainedFields fields = new ConstrainedFields(BeerDto.class);
        
        mockMvc.perform(RestDocumentationRequestBuilders.post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcRestDocumentation.document("v1/beer-save",
                        PayloadDocumentation.requestFields(
                                fields.withPath("id").ignored(),
                                fields.withPath("version").ignored(),
                                fields.withPath("createdDate").ignored(),
                                fields.withPath("lastModifiedDate").ignored(),
                                fields.withPath("beerName").description("Beer Name"),
                                fields.withPath("beerStyle").description("Beer Style"),
                                fields.withPath("upc").description("UPC of beer").attributes(),
                                fields.withPath("price").description("Beer Price"),
                                fields.withPath("quantityOnHand").ignored()
                                
//                                PayloadDocumentation.fieldWithPath("id").ignored(),
//                                PayloadDocumentation.fieldWithPath("version").ignored(),
//                                PayloadDocumentation.fieldWithPath("createdDate").ignored(),
//                                PayloadDocumentation.fieldWithPath("lastModifiedDate").ignored(),
//                                PayloadDocumentation.fieldWithPath("beerName").description("Beer Name"),
//                                PayloadDocumentation.fieldWithPath("beerStyle").description("Beer Style"),
//                                PayloadDocumentation.fieldWithPath("upc").description("UPC of beer").attributes(),
//                                PayloadDocumentation.fieldWithPath("price").description("Beer Price"),
//                                PayloadDocumentation.fieldWithPath("quantityOnHand").ignored()
                                
                        )));
    }

    @Test
    void updateBeerById() throws Exception {
        BeerDto beerDto = getValidBeerDto();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/beer/"+UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
        
    }

    @Test
    void deleteBeer() {
    }
    
    private BeerDto getValidBeerDto(){
        return BeerDto.builder().beerName("My Beer")
                .beerStyle(BeerStyleEnum.PALE)
                .price(new BigDecimal(185.20))
                .upc(100001L)
                .build();
    }
    
    private static class ConstrainedFields{
        private final ConstraintDescriptions constraintDescriptions;
        ConstrainedFields(Class<?> input){
            this.constraintDescriptions = new ConstraintDescriptions(input);
        }
        private FieldDescriptor withPath(String path){
            return PayloadDocumentation.fieldWithPath(path).attributes(Attributes.key("constraints")
                    .value(StringUtils.collectionToDelimitedString(
                            this.constraintDescriptions.descriptionsForProperty(path),". ")));
        }
    }
}