package edu.mum.cs544.service;

import edu.mum.cs544.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class OrderService {

    @Autowired
    private RestTemplate restTemplate;

    private String orderUrl = "http://localhost:9900/api/order";

    public void add(Order order) {
        restTemplate.postForLocation(orderUrl + "/add", order);
    }

    public Order get(int id) {
        return restTemplate.getForObject(orderUrl + "/{id}", Order.class, id);
    }
}
