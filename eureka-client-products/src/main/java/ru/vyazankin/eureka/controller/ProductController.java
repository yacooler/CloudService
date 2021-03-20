package ru.vyazankin.eureka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vyazankin.eureka.service.ProductService;
import ru.vyazankin.productcommon.dto.ProductDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;


    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/appname")
    public String getAppName(){
        return appName;
    }

    @GetMapping
    public List<ProductDto> getAllProducts(){
        return productService.findAll();
    }

}
