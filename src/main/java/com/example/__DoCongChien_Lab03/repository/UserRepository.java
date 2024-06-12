package com.example.__DoCongChien_Lab03.repository;

import com.example.__DoCongChien_Lab03.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}