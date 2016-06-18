package com.authentication.repository;

import org.springframework.data.repository.CrudRepository;

import com.authentication.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
