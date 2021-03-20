package ru.vyazankin.eureka.entitymapper;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.vyazankin.eureka.model.Product;
import ru.vyazankin.eureka.repository.ProductRepository;
import ru.vyazankin.productcommon.dto.ProductDto;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class ProductMapper implements BaseMapper<Product, ProductDto> {

    private final ProductRepository productRepository;

    @Override
    public Product toEntity(ProductDto dto) {
        if (dto.getId() != null){
            return productRepository.findById(dto.getId()).orElseThrow(()-> new NoSuchElementException("Product not found ID="+dto.getId()));
        }
        return new Product(dto.getTitle(), dto.getPrice());
    }

    @Override
    public ProductDto toDto(Product entity) {
        return new ProductDto(
                entity.getId(),
                entity.getTitle(),
                entity.getPrice());
    }
}
