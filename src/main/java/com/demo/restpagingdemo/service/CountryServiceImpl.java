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
    public CountryPageList listCountries(String tag, Pageable pageable) {

        Page<Country> countryPage = null;
        if(tag==null)
            countryPage = countryRepository.findAll(pageable);
        else
            countryPage = countryRepository.findAllByTag(tag, pageable);

        List<CountryDto> page = countryPage
                .stream()
                .map(countryMapper::countryToCountryDto)
                .collect(Collectors.toList());

        CountryPageList countryPageList = new CountryPageList(page, pageable, countryPage.getTotalElements());
        return countryPageList;
    }
}
