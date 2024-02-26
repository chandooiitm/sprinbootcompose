package com.chandooiitm.springbootDockercompose.repository;

import com.chandooiitm.springbootDockercompose.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}