package ru.Emir.tgBot.service;

import ru.Emir.tgBot.entity.ClientOrder;
import ru.Emir.tgBot.entity.Product;

import java.util.List;

public interface EntitiesService {
    List<Product> getProductsByCategoryId(Long categoryId);
    List<ClientOrder> getClientOrders(Long clientId);
    List<Product> getClientProducts(Long clientId);
    List<Product> getTopPopularProducts(Long limit);
}