package ru.Emir.tgBot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.Emir.tgBot.entity.Product;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductsByCategoryId(Long categoryId);
    @Query("SELECT product, SUM(countProduct) AS c FROM OrderProduct op GROUP BY product ORDER BY c DESC limit :limit")
    List<Product> findVeryPopularProducts(long limit);
    @Query("SELECT p FROM Product p WHERE p.id IN (SELECT op.product.id FROM OrderProduct op WHERE op.clientOrder.client.id = :clientId)")
    List<Product> findProductsOfAllOrdersByClientId(Long clientId);
}