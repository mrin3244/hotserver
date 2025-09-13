package com.sarathi.hotserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarathi.hotserver.model.ExcelDiscount;
import com.sarathi.hotserver.model.ExcelDiscountKey;

public interface ExcelDiscountRepo extends JpaRepository<ExcelDiscount,ExcelDiscountKey>{

}
