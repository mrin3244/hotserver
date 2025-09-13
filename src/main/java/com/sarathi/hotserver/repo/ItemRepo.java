package com.sarathi.hotserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarathi.hotserver.model.Items;

public interface ItemRepo extends JpaRepository<Items, Integer> {

}
