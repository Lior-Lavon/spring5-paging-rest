package com.demo.restpagingdemo.controller;

import com.demo.restpagingdemo.model.CountryPageList;
import com.demo.restpagingdemo.service.CountryService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 10;

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<CountryPageList> listCountries(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                         @RequestParam(value = "pageSize", required = false) Integer pageSize){

        if(pageNumber==null || pageNumber<0)
            pageNumber = DEFAULT_PAGE_NUMBER;

        if(pageSize==null || pageSize<0)
            pageSize = DEFAULT_PAGE_SIZE;

        CountryPageList countryList = countryService.listCountries(PageRequest.of(pageNumber, pageSize));

        return new ResponseEntity<>(countryList, HttpStatus.OK);
    }
}
