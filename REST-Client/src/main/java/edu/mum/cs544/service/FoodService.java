package edu.mum.cs544.service;

import edu.mum.cs544.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FoodService {

    @Autowired
    private RestTemplate restTemplate;

    private String foodUrl = "http://localhost:8081/api/foods";

    public void add(Food food) {
        restTemplate.postForLocation(foodUrl + "/", food);
    }

    public Food get(int id) {
        return restTemplate.getForObject(foodUrl + "/{id}", Food.class, id);
    }
}
