package com.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.disini.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {

}
