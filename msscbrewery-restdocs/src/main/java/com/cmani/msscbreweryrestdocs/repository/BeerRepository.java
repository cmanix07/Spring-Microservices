package com.cmani.msscbreweryrestdocs.repository;

import com.cmani.msscbreweryrestdocs.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer,UUID> {

}
