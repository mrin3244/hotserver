package com.sarathi.hotserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarathi.hotserver.model.ExcelTransaction;

public interface ExcelTransactionRepo extends JpaRepository<ExcelTransaction, String>{

}
