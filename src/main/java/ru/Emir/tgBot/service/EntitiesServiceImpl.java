package ru.Emir.tgBot.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.Emir.tgBot.entity.ClientOrder;
import ru.Emir.tgBot.entity.Product;
import ru.Emir.tgBot.repository.ClientOrderRepository;
import ru.Emir.tgBot.repository.ClientRepository;
import ru.Emir.tgBot.repository.OrderProductRepository;
import ru.Emir.tgBot.repository.ProductRepository;

import java.util.List;

@Service
@Transactional
public class EntitiesServiceImpl implements EntitiesService {
    private final ProductRepository productRepository;
    private final ClientOrderRepository clientOrderRepository;

    @Autowired
    public EntitiesServiceImpl(ProductRepository productRepository, ClientOrderRepository clientOrderRepository) {
        this.productRepository = productRepository;
        this.clientOrderRepository = clientOrderRepository;
    }

    @Override
    public List<Product> getProductsByCategoryId(Long categoryId) {
        return productRepository.findProductsByCategoryId(categoryId);
    }

    @Override
    public List<ClientOrder> getClientOrders(Long clientId) {
        return clientOrderRepository.findByClientId(clientId);
    }

    @Override
    public List<Product> getClientProducts(Long clientId) {
        return productRepository.findProductsOfAllOrdersByClientId(clientId);
    }

    @Override
    public List<Product> getTopPopularProducts(Long limit) {
        return productRepository.findVeryPopularProducts(limit).stream().toList();
    }
}