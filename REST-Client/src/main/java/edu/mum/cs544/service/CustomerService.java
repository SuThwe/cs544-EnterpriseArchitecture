package edu.mum.cs544.service;

import edu.mum.cs544.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    @Autowired
    private RestTemplate restTemplate;

    private String customerUrl = "http://localhost:9090/customer";

    public void add(Customer customer){
        restTemplate.postForLocation(customerUrl + "/add", customer);
    }

    public Customer get(int id) {
        return restTemplate.getForObject(customerUrl + "/get/{id}", Customer.class, id);
    }
}
