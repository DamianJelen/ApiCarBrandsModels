package com.example.apiCarBrandsModels.brand;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;

    public void insertBrand(Brand brand) {
        brandRepository.save(brand);
    }

    public void insertManyBrand(List<Brand> brands) {
        brandRepository.saveAll(brands);
    }

    public List<Brand> readAllBrand() {
        return brandRepository.findAll();
    }

    public Brand readBrand(Long brandId) {
        return brandRepository.findById(brandId).orElse(null);
    }

    public void changeBrand(Brand brand) {
        Brand changedBrand = readBrand(brand.getId());
        changedBrand.setName(brand.getName());
        brandRepository.save(changedBrand);
    }

    public void delBrand(Long brandId) {
        Brand delBrand = readBrand(brandId);
        brandRepository.delete(delBrand);
    }

    public void delAllBrand() {
        brandRepository.deleteAll();
    }
}
