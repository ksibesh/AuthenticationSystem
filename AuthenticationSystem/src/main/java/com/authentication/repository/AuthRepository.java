package com.authentication.repository;

import org.springframework.data.repository.CrudRepository;

import com.authentication.entity.Authentication;

public interface AuthRepository extends CrudRepository<Authentication, String> {

}
