package com.lewandowski.apiproductservice.product.domain.port;

import com.lewandowski.apiproductservice.product.domain.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
