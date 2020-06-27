package com.demo.restpagingdemo.service;

import com.demo.restpagingdemo.api.model.CountryDto;
import com.demo.restpagingdemo.model.CountryPageList;
import javassist.NotFoundException;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CountryService {

    CountryPageList listCountries(String tag, Pageable pageable);

    CountryDto findById(UUID countryId) throws NotFoundException;
}
