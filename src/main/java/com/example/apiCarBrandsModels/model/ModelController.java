package com.example.apiCarBrandsModels.model;

import com.example.apiCarBrandsModels.brand.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/{brandName}")
@RequiredArgsConstructor
public class ModelController {
    private final ModelService modelService;

    @GetMapping("")
    public List<Model> readAllModels (@PathVariable String brandName) {
        return modelService.readAllModels(brandName);
    }

    @GetMapping("/{modelId}")
    public Model readModel(@PathVariable String brandName, @PathVariable(name = "modelId") Long id) {
        return modelService.readModel(brandName, id);
    }

    @PostMapping("/addModel")
    public void addModel(@RequestBody Model model) {
        modelService.insertModel(model);
    }

    @PostMapping("/add")
    public void addModel(@PathVariable String brandName,
                         @RequestBody String modelName) {
        modelService.insertModel(brandName, modelName);
    }

    @DeleteMapping("/{modelId}")
    public void delModel(@PathVariable Long modelId) {
        modelService.delModel(modelId);
    }

    @DeleteMapping("")
    public void delAllModelsByBrand(@PathVariable String brandName) {
        modelService.delAllModelByBrand(brandName);
    }

    @DeleteMapping("../model/delAllModels")
    public void delAllModels() {
        modelService.delAllModel();
    }
}
