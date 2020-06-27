package com.demo.restpagingdemo.api.mapper;

import com.demo.restpagingdemo.api.model.CountryDto;
import com.demo.restpagingdemo.model.Country;
import org.mapstruct.Mapper;

@Mapper
public interface CountryMapper {

    CountryDto countryToCountryDto(Country country);
    Country countryDtoToCountry(CountryDto countryDto);
}
