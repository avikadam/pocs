package com.example.graphql.resolver;

import com.example.graphql.model.Product;
import com.example.graphql.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class ProductResolver {
    
    private final ProductRepository productRepository;
    
    @QueryMapping("product")
    public Mono<Product> product(@Argument("id") Long id) {
        return productRepository.findById(id);
    }
    
    @QueryMapping("products")
    public Flux<Product> products(@Argument("category") String category) {
        if (category != null) {
            return productRepository.findByCategory(category);
        }
        return productRepository.findAll();
    }
} 