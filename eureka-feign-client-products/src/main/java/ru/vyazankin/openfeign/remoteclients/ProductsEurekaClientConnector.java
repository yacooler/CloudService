package ru.vyazankin.openfeign.remoteclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vyazankin.productcommon.dto.ProductDto;

import java.util.List;

@FeignClient("eureka-client-products")
@RequestMapping("/api/v1/products")
public interface ProductsEurekaClientConnector {
    @GetMapping()
    List<ProductDto> getAllProducts();
}
