package com.sarathi.hotserver.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "material_consumption")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(MaterialConsumptionId.class)
public class MaterialConsumption {
    @Id
    private Long saleId;

    @Id
    @Column(length = 50)
    private String rId;

    @Column(nullable = false)
    private OffsetDateTime date;

    @Column(nullable = false)
    private Double quantity;

    @Column(nullable = false)
    private Double amount;
}

