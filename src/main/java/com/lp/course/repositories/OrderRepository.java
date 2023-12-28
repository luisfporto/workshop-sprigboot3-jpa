package com.lp.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lp.course.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
