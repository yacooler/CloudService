package ru.vyazankin.eureka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vyazankin.eureka.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{}