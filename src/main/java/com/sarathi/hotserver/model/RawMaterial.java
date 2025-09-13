package com.sarathi.hotserver.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "raw_material_master")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RawMaterial {
    @Id
    @Column(length = 50)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String unit;
}
