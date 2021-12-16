package ru.dimedrollo.repositories;

import ru.dimedrollo.models.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    void save (Product product);
}
