package com.militaryaircraft.militaryaircraftapi.model.dto;


import com.fasterxml.jackson.databind.ser.Serializers;
import com.militaryaircraft.militaryaircraftapi.model.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
public class CategoryDto extends BaseEntityDto {

    private Long id;

    private String categoryName;

    private String categoryDescription;

    public CategoryDto() {
    }

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.categoryName = category.getCategoryName();
        this.categoryDescription = category.getCategoryDescription();
    }
}
