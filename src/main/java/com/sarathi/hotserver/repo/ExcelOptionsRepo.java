package com.sarathi.hotserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarathi.hotserver.model.ExcelOptions;
import com.sarathi.hotserver.model.ExcelOptionsKey;

public interface ExcelOptionsRepo extends JpaRepository<ExcelOptions, ExcelOptionsKey>{

}
