package com.sarathi.hotserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarathi.hotserver.model.UserInfo;

public interface UserInfoRepo extends JpaRepository<UserInfo, String> {

}
