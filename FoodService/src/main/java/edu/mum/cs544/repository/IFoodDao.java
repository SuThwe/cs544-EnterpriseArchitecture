package edu.mum.cs544.repository;

import edu.mum.cs544.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoodDao extends JpaRepository<Food, Integer> {

}
