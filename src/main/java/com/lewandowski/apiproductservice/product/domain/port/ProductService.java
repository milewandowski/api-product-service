package com.lewandowski.apiproductservice.product.domain.port;

import com.lewandowski.apiproductservice.product.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public final class ProductService {

    private final ProductRepository productRepository;

    public Product get(String id) {
        return productRepository.findById(id).orElseThrow();
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product create(Product product) {

        return productRepository.save(product);
    }

    public List<Product> getProductsByIds(List<String> ids) {
        return ids.stream()
                .map(productRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
