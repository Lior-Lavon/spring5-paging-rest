package com.demo.restpagingdemo.service;

import com.demo.restpagingdemo.model.CountryPageList;
import org.springframework.data.domain.Pageable;

public interface CountryService {

    CountryPageList listCountries(String tag, Pageable pageable);
}
