package com.demo.restpagingdemo.service;

import com.demo.restpagingdemo.api.mapper.CountryMapper;
import com.demo.restpagingdemo.api.model.CountryDto;
import com.demo.restpagingdemo.model.Country;
import com.demo.restpagingdemo.model.CountryPageList;
import com.demo.restpagingdemo.repository.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public CountryServiceImpl(CountryRepository countryRepository, CountryMapper countryMapper) {
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }

    @Override
    public CountryPageList listCountries(PageRequest pageRequest) {

        Page<Country> countryPage = countryRepository.findAll(pageRequest);

        List<CountryDto> page = countryPage
                .stream()
                .map(countryMapper::countryToCountryDto)
                .collect(Collectors.toList());

        CountryPageList countryPageList = new CountryPageList(page, pageRequest, countryPage.getTotalElements());
        return countryPageList;
    }
}
