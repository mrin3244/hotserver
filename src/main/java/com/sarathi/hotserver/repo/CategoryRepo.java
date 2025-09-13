package com.sarathi.hotserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarathi.hotserver.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
