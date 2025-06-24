package com.belajar.userapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.belajar.userapi.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
    List<User>findByNameContainingIgnoreCase(String keyword);
    Optional<User> findByName(String name);
    @Override
    Optional<User> findById(String id);
    @Override
    void deleteById(String id);
    boolean existsByEmail(String email);
    boolean existsByName(String name);
    @Override
    boolean existsById(String id);
    @Override
    long count();
    @Override
    void deleteAll();
}
