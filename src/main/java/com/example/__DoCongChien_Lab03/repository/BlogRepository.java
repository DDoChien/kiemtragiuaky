package com.example.__DoCongChien_Lab03.repository;

import com.example.__DoCongChien_Lab03.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
}