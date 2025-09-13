package com.sarathi.hotserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarathi.hotserver.model.RawMaterial;

public interface RawMaterialRepo extends JpaRepository<RawMaterial, String> { }
