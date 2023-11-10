package com.moengage.assignment.repository;

import com.moengage.assignment.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Integer> {

    List<Review> findAllByBreweryId(String id);
}
