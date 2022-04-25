package com.makersacademy.acebook.repository;

import com.makersacademy.acebook.model.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
  @Query(value = "SELECT id FROM users WHERE username = :username", nativeQuery=true)
  public Long findIdByUsername(@Param("username") String username);

}
