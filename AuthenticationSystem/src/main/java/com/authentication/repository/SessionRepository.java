package com.authentication.repository;

import org.springframework.data.repository.CrudRepository;

import com.authentication.entity.Session;

public interface SessionRepository extends CrudRepository<Session, String> {

}
