package com.lp.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lp.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
