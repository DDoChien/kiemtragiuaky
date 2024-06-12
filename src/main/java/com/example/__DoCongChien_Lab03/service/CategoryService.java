package com.example.__DoCongChien_Lab03.service;

import com.example.__DoCongChien_Lab03.model.Catelogy;
import com.example.__DoCongChien_Lab03.repository.CatelogyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {
    private final CatelogyRepository catologyRepository;
    public List<Catelogy> getAlCatologies(){
        return catologyRepository.findAll();
    }
    public Optional<Catelogy> getCategoryById(Long id) {
        return catologyRepository.findById(id);
    }
    public void addCategory(Catelogy category) {
        catologyRepository.save(category);
    }
    public void updateCategory( Catelogy category) {
        Catelogy existingCategory = catologyRepository.findById((long)
                        category.getId())
                .orElseThrow(() -> new IllegalStateException("Category with ID " +
                        category.getId() + " does not exist."));
        existingCategory.setName(category.getName());
        catologyRepository.save(existingCategory);
    }
    public void deleteCategoryById(Long id) {
        if (!catologyRepository.existsById(id)) {
            throw new IllegalStateException("Category with ID " + id + " does no exist.");
        }
        catologyRepository.deleteById(id);
    }
}