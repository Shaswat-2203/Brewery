package com.moengage.assignment;

import com.moengage.assignment.service.DataLoaderService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssignmentApplication {
	@Autowired
	private DataLoaderService dataLoaderService;

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}

	@PostConstruct
	public void loadDataOnStartup() {
		// Specify the URL from which you want to load data
		String url = "https://api.openbrewerydb.org/v1/breweries";
		dataLoaderService.loadDataFromUrl(url);
	}
}
