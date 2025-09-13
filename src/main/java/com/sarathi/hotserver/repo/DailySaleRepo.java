package com.sarathi.hotserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarathi.hotserver.model.DailySale;
import com.sarathi.hotserver.model.DailySaleKey;

public interface DailySaleRepo extends JpaRepository<DailySale, DailySaleKey> {

}
