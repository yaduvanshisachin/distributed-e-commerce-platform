package com.yadav.product;

import com.yadav.product.entity.Category;
import com.yadav.product.entity.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public Product toProduct(ProductRequest request){
        return Product.builder()
                .Id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .availableQuantity(request.getAvailableQuantity())
                .category(
                        Category.builder()
                                .Id(request.getCategoryId())
                                .build())
                .build();
    }

    public ProductResponse fromProduct(Product product){
        return ProductResponse.builder()
                .build();
    }
}
