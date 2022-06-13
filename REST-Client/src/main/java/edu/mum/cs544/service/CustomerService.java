package edu.mum.cs544.service;

import edu.mum.cs544.model.Customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    @Autowired
    private RestTemplate restTemplate;

    private String customerUrl = "http://localhost:9090/api/customer";

    public Customer add(Customer customer){
        restTemplate.postForLocation(customerUrl + "/add", customer);
        return customer;
    }


    public Customer get(int id) {
        return restTemplate.getForObject(customerUrl + "/get/{id}", Customer.class, id);
    }

    public ResponseEntity<Customer[]> getAll() {

        ResponseEntity<Customer[]> responseEntity =   restTemplate.getForEntity(customerUrl+ "/", Customer[].class);
        return responseEntity;
   }

   public void update(Customer customer) {
    restTemplate.put(customerUrl + "/"+ customer.getId(), customer);

    }

    public void delete(int id) {
        restTemplate.delete(customerUrl+ "/"+ id, id);
    }

}
