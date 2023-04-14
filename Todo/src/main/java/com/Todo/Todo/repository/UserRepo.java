package com.Todo.Todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Todo.Todo.model.UserEntities;


public interface UserRepo extends JpaRepository<UserEntities, Integer> {

}

