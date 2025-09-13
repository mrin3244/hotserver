package com.sarathi.hotserver.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "closing_stock")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(ClosingStockId.class)
public class ClosingStock {

    @Id
    private LocalDate date;

    @Id
    @Column(length = 50)
    private String rId;

    @Column(nullable = false)
    private Double amount;
}
