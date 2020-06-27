package com.demo.restpagingdemo.repository;

import com.demo.restpagingdemo.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CountryRepository extends JpaRepository<Country, UUID> {

    Page<Country> findAllByTag(String tag, Pageable pageable);
}

