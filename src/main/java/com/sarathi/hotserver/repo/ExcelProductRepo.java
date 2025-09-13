package com.sarathi.hotserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarathi.hotserver.model.ExcelProduct;
import com.sarathi.hotserver.model.ExcelProductKey;


public interface ExcelProductRepo extends JpaRepository<ExcelProduct, ExcelProductKey>{

}
