package com.demo.restpagingdemo.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountryDto {

    private UUID id;

    private String name;

    private String tag;

    private Integer population;
}
