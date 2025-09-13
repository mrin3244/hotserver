package com.sarathi.hotserver.service;

import org.springframework.stereotype.Service;

import com.sarathi.hotserver.exception.NotFoundException;
import com.sarathi.hotserver.model.RawMaterial;
import com.sarathi.hotserver.repo.RawMaterialRepo;

import java.util.List;

@Service
public class RawMaterialService {
	
    private final RawMaterialRepo repo;
    public RawMaterialService(RawMaterialRepo repo) { this.repo = repo; }

    public RawMaterial create(RawMaterial r) { return repo.save(r); }

    public RawMaterial update(String id, RawMaterial updated) {
        RawMaterial existing = repo.findById(id).orElseThrow(() -> new NotFoundException("RawMaterial not found: " + id));
        existing.setName(updated.getName());
        existing.setUnit(updated.getUnit());
        return repo.save(existing);
    }

    public void delete(String id) { repo.deleteById(id); }

    public RawMaterial getById(String id) { return repo.findById(id).orElseThrow(() -> new NotFoundException("RawMaterial not found: " + id)); }

    public List<RawMaterial> list() { return repo.findAll(); }
}

