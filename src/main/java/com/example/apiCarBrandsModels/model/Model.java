package com.example.apiCarBrandsModels.model;

import com.example.apiCarBrandsModels.brand.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Model {
    @Id
    @SequenceGenerator(
            name = "model_id_seq",
            sequenceName = "model_id_seq",
            initialValue = 100,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "model_id_seq"
    )
    private Long id;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
    private String name;

    public Model(Brand brand, String name) {
        this.brand = brand;
        this.name = name;
    }
}
