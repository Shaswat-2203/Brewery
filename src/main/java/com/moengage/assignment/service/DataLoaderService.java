package com.moengage.assignment.service;

import com.moengage.assignment.model.Brewery;
import com.moengage.assignment.repository.BreweryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataLoaderService {

    @Autowired
    private BreweryRepository breweryRepository;

    public void loadDataFromUrl(String url) {
        RestTemplate restTemplate = new RestTemplate();
        Brewery[] data = restTemplate.getForObject(url, Brewery[].class);

        // Map only the desired columns to the entity
        List<Brewery> breweries = Arrays.stream(data)
                .map(item -> {
                    Brewery brewery = new Brewery();
                    brewery.setId(item.getId());
                    brewery.setName(item.getName());
                    brewery.setAddress_1(item.getAddress_1());
                    brewery.setState(item.getState());
                    brewery.setCity(item.getCity());
                    brewery.setWebsite_url(item.getWebsite_url());
                    brewery.setPhone(item.getPhone());
                    brewery.setBrewery_type(item.getBrewery_type());
                    return brewery;
                })
                .collect(Collectors.toList());

        // Save the mapped data to the database
        breweryRepository.saveAll(breweries);
    }
}
