package com.sarathi.hotserver.repo;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarathi.hotserver.model.TodaysSaleHistory;

public interface TodaysSaleHistoryRepo extends JpaRepository<TodaysSaleHistory, Date> {

}
