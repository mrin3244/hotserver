package com.sarathi.hotserver.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarathi.hotserver.model.ProductMaterialId;
import com.sarathi.hotserver.model.ProductMaterialRecipe;

public interface ProductMaterialRecipeRepo extends JpaRepository<ProductMaterialRecipe, ProductMaterialId> {
    List<ProductMaterialRecipe> findByProductId(String pId);
}

