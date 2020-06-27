package com.demo.restpagingdemo.api.model;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountryDto implements Serializable {

    private static final long serialVersionUID = -7551543057081867613L;

    private UUID id;

    private String name;

    private String tag;

    private Integer population;

}
