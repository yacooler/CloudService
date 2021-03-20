package ru.vyazankin.eureka.service;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.vyazankin.eureka.entitymapper.ProductMapper;
import ru.vyazankin.eureka.model.Product;
import ru.vyazankin.eureka.repository.ProductRepository;
import ru.vyazankin.productcommon.dto.ProductDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductDto> findAll(){
        return productRepository.findAll().stream().map(productMapper::toDto).collect(Collectors.toUnmodifiableList());
    }

    public ProductDto saveOrUpdate(ProductDto productDTO){
        return productMapper.toDto(productRepository.save(productMapper.toEntity(productDTO)));
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }


}
