package ru.vyazankin.openfeign.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vyazankin.openfeign.remoteclients.ProductsEurekaClientConnector;
import ru.vyazankin.productcommon.dto.ProductDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductsEurekaClientConnector productsEurekaClientConnector;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/appname")
    public String getAppName(){
        return appName;
    }

    //Тут не нужен путь api/v1/products - считаем, что этот слой сам решает, с каким api ему работать
    @RequestMapping("/products")
    public List<ProductDto> feignTest(){
        return productsEurekaClientConnector.getAllProducts();
    }

}
