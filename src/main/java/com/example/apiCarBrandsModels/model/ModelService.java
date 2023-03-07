package com.example.apiCarBrandsModels.model;

import com.example.apiCarBrandsModels.brand.Brand;
import com.example.apiCarBrandsModels.brand.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelService {
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public void insertModel(Model model) {
        modelRepository.save(model);
    }

    public void insertModel(String brandName, String modelName) {
        Brand brand = brandRepository.findByName(brandName);
        System.out.println(brand.toString());
        Model model = new Model(brand, modelName);
        modelRepository.save(model);
    }

    public void insertManyModels(List<Model> models) {
        modelRepository.saveAll(models);
    }

    public Model readModel(String brandName, Long modelId) {
        return modelRepository.findByBrand_NameAndId(brandName, modelId);
    }

    public Model readModelByName(String brandName, String modelName) {
        return modelRepository.findByBrand_NameAndName(brandName, modelName);
    }

    public List<Model> readAllModels(String brandName) {
        return modelRepository.findAllByBrand_Name(brandName);
    }

    public void delModel(Long id) {
        modelRepository.deleteById(id);
    }

    public void delAllModel() {
        modelRepository.deleteAll();
    }

    public void delAllModelByBrand(String brandName) {
        modelRepository.deleteAllByBrand_Name(brandName);
    }
}
