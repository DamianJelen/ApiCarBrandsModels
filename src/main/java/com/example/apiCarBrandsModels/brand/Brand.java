package com.example.apiCarBrandsModels.brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Brand {
    @Id
    @SequenceGenerator(
            name = "brand_id_seq",
            sequenceName = "brand_id_seq",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "brand_id_seq"
    )
    private Long id;
    private String name;

    public Brand(String name) {
        this.name = name;
    }
}
