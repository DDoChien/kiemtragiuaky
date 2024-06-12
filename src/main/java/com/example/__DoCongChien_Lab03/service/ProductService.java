package com.example.__DoCongChien_Lab03.service;

import com.example.__DoCongChien_Lab03.model.Product;
import com.example.__DoCongChien_Lab03.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {
    private final ProductRepository productRepository;
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById((long)
                        product.getId())
                .orElseThrow(() -> new IllegalStateException("Product with ID " +
                        product.getId() + " does not exist."));
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setNums(product.getNums());
        existingProduct.setDetail(product.getDetail());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setMeta(product.getMeta());
        existingProduct.setOrder(product.getOrder());
        existingProduct.setLink(product.getLink());
        existingProduct.setHide(product.isHide());
        return productRepository.save(existingProduct);
    }
    public void deleteProductById(Long id) {
        if (!productRepository.existsById(id)) {
            throw new IllegalStateException("Product with ID " + id + " does no exist.");
        }
        productRepository.deleteById(id);
    }
}
