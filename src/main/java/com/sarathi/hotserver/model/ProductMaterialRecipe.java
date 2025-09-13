package com.sarathi.hotserver.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "product_material_recipe_master")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(ProductMaterialId.class)
public class ProductMaterialRecipe {

    @Id
    @Column(name = "p_id", length = 50)
    private String pId;

    @Id
    @Column(name = "r_id", length = 50)
    private String rId;

    @Column(nullable = false)
    private Double quantity;
}
