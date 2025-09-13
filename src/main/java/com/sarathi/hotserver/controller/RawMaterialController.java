package com.sarathi.hotserver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sarathi.hotserver.model.RawMaterial;
import com.sarathi.hotserver.model.RawMaterialBuy;
import com.sarathi.hotserver.repo.RawMaterialBuyRepo;
import com.sarathi.hotserver.service.RawMaterialService;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/raw-materials")
public class RawMaterialController {
    private final RawMaterialService service;
    private final RawMaterialBuyRepo repo;
    public RawMaterialController(RawMaterialService service, RawMaterialBuyRepo repo) { this.service = service; this.repo = repo;}

    @PostMapping
    public ResponseEntity<RawMaterial> create(@RequestBody RawMaterial payload){
        return ResponseEntity.ok(service.create(payload));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RawMaterial> update(@PathVariable String id, @RequestBody RawMaterial payload){
        return ResponseEntity.ok(service.update(id, payload));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RawMaterial> get(@PathVariable String id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<RawMaterial>> list(){
        return ResponseEntity.ok(service.list());
    }
    
    @PostMapping("/buy")
    public RawMaterialBuy create(RawMaterialBuy buy) {
        if (buy.getUnitPrice() == null || buy.getQuantity() == null) throw new IllegalArgumentException("quantity and unitPrice required");
        buy.setTotalPrice(buy.getQuantity() * buy.getUnitPrice());
        if (buy.getBuyDate() == null) buy.setBuyDate(OffsetDateTime.now());
        return repo.save(buy);
    }
    
}
