package edu.mum.cs544.service;

import edu.mum.cs544.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FoodService {

    @Autowired
    private RestTemplate restTemplate;

    private String foodUrl = "http://localhost:8081/api/foods";

    public Food add(Food food) {
        restTemplate.postForLocation(foodUrl + "/add", food);
        return food;
    }

    public Food get(int id) {
        return restTemplate.getForObject(foodUrl + "/{id}", Food.class, id);
    }

    public ResponseEntity<Food[]> getAll() {

       
        ResponseEntity<Food[]> responseEntity =   restTemplate.getForEntity(foodUrl+ "/", Food[].class);

        return responseEntity;
   }

   public void update(Food food) {
    restTemplate.postForLocation(foodUrl + "/"+ food.getId(), food);

    }

    public void delete(int id) {
        restTemplate.delete(foodUrl+ "/"+ id, id);
    }

}
