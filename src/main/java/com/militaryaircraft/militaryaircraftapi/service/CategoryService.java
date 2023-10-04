package com.militaryaircraft.militaryaircraftapi.service;


import com.militaryaircraft.militaryaircraftapi.mappers.CategoryMapper;
import com.militaryaircraft.militaryaircraftapi.model.dto.CategoryDto;
import com.militaryaircraft.militaryaircraftapi.model.entity.Category;
import com.militaryaircraft.militaryaircraftapi.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + id));
        return categoryMapper.toDto(category);
    }

    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();

        List<CategoryDto> categoryDtos = categories.stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());

        return categoryDtos;
    }


    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = categoryMapper.toEntity(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toDto(savedCategory);
    }

    public CategoryDto updateCategory(Long id, CategoryDto updatedCategoryDto) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + id));
        Category updatedCategory = categoryMapper.toEntity(updatedCategoryDto);

        // Tüm alanları güncelle
        existingCategory.setCategoryName(updatedCategory.getCategoryName());
        existingCategory.setCategoryDescription(updatedCategory.getCategoryDescription());

        Category savedCategory = categoryRepository.save(existingCategory);
        return categoryMapper.toDto(savedCategory);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}


