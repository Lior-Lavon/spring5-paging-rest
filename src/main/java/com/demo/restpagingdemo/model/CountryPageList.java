package com.demo.restpagingdemo.model;

import com.demo.restpagingdemo.api.model.CountryDto;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class CountryPageList extends PageImpl<CountryDto> implements Serializable {

    public CountryPageList(List<CountryDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public CountryPageList(List<CountryDto> content) {
        super(content);
    }
}
