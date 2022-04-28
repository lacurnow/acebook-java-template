package com.makersacademy.acebook.repository;
import com.makersacademy.acebook.model.Friend;
import org.springframework.data.repository.CrudRepository;

public interface FriendsRepository extends CrudRepository<Friend, Long>{
  
}
