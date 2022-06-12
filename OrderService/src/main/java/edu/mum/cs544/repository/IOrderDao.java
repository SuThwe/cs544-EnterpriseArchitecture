package edu.mum.cs544.repository;

import edu.mum.cs544.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDao extends JpaRepository<Order, Integer> {

}
