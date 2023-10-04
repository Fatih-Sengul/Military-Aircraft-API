package com.militaryaircraft.militaryaircraftapi.mappers;

import com.militaryaircraft.militaryaircraftapi.model.dto.CategoryDto;
import com.militaryaircraft.militaryaircraftapi.model.entity.Category;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {

    Category toEntity(CategoryDto categoryDto);

    CategoryDto toDto(Category category);
}
