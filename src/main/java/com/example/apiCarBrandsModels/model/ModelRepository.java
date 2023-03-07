package com.example.apiCarBrandsModels.model;

import com.example.apiCarBrandsModels.brand.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
    List<Model> findAllByBrand_Name(String brandName);
    Model findByBrand_NameAndId(String brandName, Long modelId);
    Model findByBrand_NameAndName(String brandName, String modelName);
    void deleteAllByBrand_Name(String brandName);
}
