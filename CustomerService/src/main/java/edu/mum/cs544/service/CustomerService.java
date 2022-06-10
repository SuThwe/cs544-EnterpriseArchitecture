package edu.mum.cs544.service;

import edu.mum.cs544.dao.CustomerDAO;
import edu.mum.cs544.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {

    @Resource
    private CustomerDAO customerDAO;

    public void addCustomer(Customer customer) {
        customerDAO.save(customer);
    }

    public Customer getCustomer(int id) {
        return customerDAO.findById(id).get();
    }

    public void updateCustomer(Customer customer) {
        customerDAO.save(customer);
    }

    public void delete(int id) {
        customerDAO.deleteById(id);
    }
}
