package com.moengage.assignment.repository;

import com.moengage.assignment.model.Brewery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BreweryRepository extends JpaRepository<Brewery,String> {


    List<Brewery> findByCity(String city);

    List<Brewery> findByName(String name);

    List<Brewery> findByType(String type);
}
