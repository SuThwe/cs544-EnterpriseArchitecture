package edu.mum.cs544.service;

import edu.mum.cs544.model.Food;
import edu.mum.cs544.model.Order;
import edu.mum.cs544.repository.IOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private IOrderDao orderDao;

    public List<Order> getAll() {
        return orderDao.findAll();
    }

    public Order add(Order order) {
        order.setTotalPrice(order.calculateTotalCost(order.getFoodList()));
        return orderDao.save(order);
    }

    public Order get(int id)
    {
        return orderDao.findById(id).get();
    }

    public void update(Order order) {
        orderDao.save(order);
    }

    public void delete(int id) {
        orderDao.deleteById(id);
    }

}
