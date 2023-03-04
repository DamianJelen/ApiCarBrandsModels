package com.example.apiCarBrandsModels.brand;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/brands")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @GetMapping("")
    public List<Brand> readAllBrands() {
        return brandService.readAllBrand();
    }

    @GetMapping("/{brandId}")
    public Brand readBrand(@PathVariable(name = "brandId") Long id) {
        return brandService.readBrand(id);
    }

    @PostMapping("/add")
    public void addBrand(@RequestBody Brand brand) {
        brandService.insertBrand(brand);
    }

    @PostMapping("/addMany")
    public void addManyBrands(@RequestBody List<Brand> brands) {
        brandService.insertManyBrand(brands);
    }
    
    @PutMapping("/mod")
    public void modBrand(@RequestBody Brand brand) {
        brandService.changeBrand(brand);
    }

    @DeleteMapping("/{brandId}")
    public void delBrand(@PathVariable Long brandId) {
        brandService.delBrand(brandId);
    }

    @DeleteMapping("")
    public void delAllBrand() {
        brandService.delAllBrand();
    }
}
