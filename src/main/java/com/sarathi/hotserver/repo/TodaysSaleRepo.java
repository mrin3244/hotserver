package com.sarathi.hotserver.repo;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarathi.hotserver.model.TodaysSale;

public interface TodaysSaleRepo extends JpaRepository<TodaysSale, Date> {

}
