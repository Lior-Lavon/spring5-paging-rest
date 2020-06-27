package com.demo.restpagingdemo.service;

import com.demo.restpagingdemo.api.model.CountryDto;
import com.demo.restpagingdemo.model.CountryPageList;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface CountryService {

    CountryPageList listCountries(PageRequest pageRequest);
}
