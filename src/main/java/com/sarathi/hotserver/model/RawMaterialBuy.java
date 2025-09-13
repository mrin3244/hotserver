package com.sarathi.hotserver.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "raw_material_buy")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RawMaterialBuy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="r_id", length = 50, nullable = false)
    private String rId;

    @Column(nullable = false)
    private Double quantity;

    @Column(name = "unit_price", nullable = false)
    private Double unitPrice;

    @Column(name = "total_price", nullable = false)
    private Double totalPrice;

    @Column(name = "buy_date", nullable = false)
    private OffsetDateTime buyDate;
}
