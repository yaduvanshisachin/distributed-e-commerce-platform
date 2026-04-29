package com.yadav.product;

import com.yadav.product.dto.ProductRequest;
import com.yadav.product.dto.ProductResponse;
import com.yadav.product.entity.Category;
import com.yadav.product.entity.Product;
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

    public ProductResponse toProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .availableQuantity(product.getAvailableQuantity())
                .price(product.getPrice())
                .categoryId(product.getId())
                .categoryName(product.getName())
                .categoryDescription(product.getCategory().getDescription())
                .build();

    }
}
