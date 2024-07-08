package ru.Emir.tgBot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.Emir.tgBot.entity.Category;
import ru.Emir.tgBot.entity.Product;
import ru.Emir.tgBot.repository.CategoryRepository;
import ru.Emir.tgBot.repository.ProductRepository;

import java.math.BigDecimal;

@SpringBootTest
public class FillingTests {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void createCategories() {
        /* Основные категории
            "Пицца"
            "Роллы"
            "Бургеры"
            "Напитки"
        Подкатегории категории "Роллы"
            "Классические роллы"
            "Запечённые роллы"
            "Сладкие роллы"
            "Наборы"
        Подкатегории категории "Бургеры"
            "Классические бургеры"
            "Острые бургеры"
        Подкатегории категории "Напитки"
            "Газированные напитки"
            "Энергетические напитки"
            "Соки"
            "Другие" */

        // Создание основных категорий
        // Создание основной категории "Пицца"
        Category pizzaCategory = new Category("Пицца", null);
        categoryRepository.save(pizzaCategory);
        // Создание основной категории "Роллы"
        Category rollsCategory = new Category("Роллы", null);
        categoryRepository.save(rollsCategory);
        // Создание основной категории "Бургеры"
        Category burgersCategory = new Category("Бургеры", null);
        categoryRepository.save(burgersCategory);
        // Создание основной категории "Напитки"
        Category drinksCategory = new Category("Напитки", null);
        categoryRepository.save(drinksCategory);

        // Создание подкатегорий
        // Создание подкатегории "Классические роллы" категории "Роллы"
        Category classicRollsCategory = new Category("Классические роллы", rollsCategory);
        categoryRepository.save(classicRollsCategory);
        // Создание подкатегории "Запечённые роллы" категории "Роллы"
        Category bakedRollsCategory = new Category("Запечённые роллы", rollsCategory);
        categoryRepository.save(bakedRollsCategory);
        // Создание подкатегории "Сладкие роллы" категории "Роллы"
        Category sweetRollsCategory = new Category("Сладкие роллы", rollsCategory);
        categoryRepository.save(sweetRollsCategory);
        // Создание подкатегории "Наборы" категории "Роллы"
        Category setsRollsCategory = new Category("Наборы", rollsCategory);
        categoryRepository.save(setsRollsCategory);
        // Создание подкатегории "Классические бургеры" категории "Бургеры"
        Category classicBurgersCategory = new Category("Классические бургеры", burgersCategory);
        categoryRepository.save(classicBurgersCategory);
        // Создание подкатегории "Острые бургеры" категории "Бургеры"
        Category spicyBurgersCategory = new Category("Острые бургеры", burgersCategory);
        categoryRepository.save(spicyBurgersCategory);
        // Создание подкатегории "Газированные напитки" категории "Напитки"
        Category carbonatedDrinksCategory = new Category("Газированные напитки", drinksCategory);
        categoryRepository.save(carbonatedDrinksCategory);
        // Создание подкатегории "Энергетические напитки" категории "Напитки"
        Category energyDrinksCategory = new Category("Энергетические напитки", drinksCategory);
        categoryRepository.save(energyDrinksCategory);
        // Создание подкатегории "Соки" категории "Напитки"
        Category juicesDrinksCategory = new Category("Соки", drinksCategory);
        categoryRepository.save(juicesDrinksCategory);
        // Создание подкатегории "Другие" категории "Напитки"
        Category othersDrinksCategory = new Category("Другие", drinksCategory);
        categoryRepository.save(othersDrinksCategory);
    }

    @Test
    void createProducts() {
        // Получение категорий/подкатегорий из репозитория
        Category pizzaCategory = categoryRepository.findByName("Пицца");
        Category rollsCategory = categoryRepository.findByName("Роллы");
        Category burgersCategory = categoryRepository.findByName("Бургеры");
        Category drinksCategory = categoryRepository.findByName("Напитки");
        Category classicRollsCategory = categoryRepository.findByName("Классические роллы");
        Category bakedRollsCategory = categoryRepository.findByName("Запечённые роллы");
        Category sweetRollsCategory = categoryRepository.findByName("Сладкие роллы");
        Category setsRollsCategory = categoryRepository.findByName("Наборы");
        Category classicBurgersCategory = categoryRepository.findByName("Классические бургеры");
        Category spicyBurgersCategory = categoryRepository.findByName("Острые бургеры");
        Category carbonatedDrinksCategory = categoryRepository.findByName("Газированные напитки");
        Category energyDrinksCategory = categoryRepository.findByName("Энергетические напитки");
        Category juicesDrinksCategory = categoryRepository.findByName("Соки");
        Category othersDrinksCategory = categoryRepository.findByName("Другие");

        // Создание товаров для основной категории "Пицца"
        productRepository.save(new Product(pizzaCategory, "Маргарита", "Классическая пицца с томатами, сыром и базиликом", new BigDecimal("450.00")));
        productRepository.save(new Product(pizzaCategory, "Пепперони", "Пицца с пепперони, сыром и томатным соусом", new BigDecimal("500.00")));
        productRepository.save(new Product(pizzaCategory, "Четыре сыра", "Пицца с четырьмя видами сыра", new BigDecimal("550.00")));

        // Создание товаров для основной категории "Роллы"
        productRepository.save(new Product(rollsCategory, "Дракон", "Ролл с угрём, авокадо и соусом терияки", new BigDecimal("380.00")));
        productRepository.save(new Product(rollsCategory, "Канада", "Ролл с лососем, авокадо и сливочным сыром", new BigDecimal("370.00")));
        productRepository.save(new Product(rollsCategory, "Тайский", "Ролл с креветкой, манго и сливочным сыром", new BigDecimal("390.00")));

        // Создание товаров для основной категории "Бургеры"
        productRepository.save(new Product(burgersCategory, "Биг Мак", "Бургер с двумя котлетами, сыром и соусом", new BigDecimal("350.00")));
        productRepository.save(new Product(burgersCategory, "Роял Чизбургер", "Бургер с говядиной, сыром и маринованным огурцом", new BigDecimal("330.00")));
        productRepository.save(new Product(burgersCategory, "Двойной Роял", "Бургер с двумя котлетами и двойной порцией сыра", new BigDecimal("400.00")));

        // Создание товаров для основной категории "Напитки"
        productRepository.save(new Product(drinksCategory, "Молочный коктейль", "Коктейль на основе молока и мороженого", new BigDecimal("150.00")));
        productRepository.save(new Product(drinksCategory, "Лимонад", "Освежающий лимонад с мятой и лимоном", new BigDecimal("130.00")));
        productRepository.save(new Product(drinksCategory, "Какао", "Горячий напиток с какао и молоком", new BigDecimal("110.00")));

        // Создание товаров для подкатегории "Классические роллы" категории "Роллы"
        productRepository.save(new Product(classicRollsCategory, "Филадельфия", "Ролл с лососем, сливочным сыром и огурцом", new BigDecimal("300.00")));
        productRepository.save(new Product(classicRollsCategory, "Калифорния", "Ролл с крабом, авокадо и огурцом", new BigDecimal("320.00")));
        productRepository.save(new Product(classicRollsCategory, "Унаги", "Ролл с угрём, сливочным сыром и огурцом", new BigDecimal("350.00")));

        // Создание товаров для подкатегории "Запечённые роллы" категории "Роллы"
        productRepository.save(new Product(bakedRollsCategory, "Запечённая Филадельфия", "Запечённый ролл с лососем, сливочным сыром и огурцом", new BigDecimal("400.00")));
        productRepository.save(new Product(bakedRollsCategory, "Запечённая Калифорния", "Запечённый ролл с крабом, авокадо и огурцом", new BigDecimal("420.00")));
        productRepository.save(new Product(bakedRollsCategory, "Запечённый Унаги", "Запечённый ролл с угрём, сливочным сыром и огурцом", new BigDecimal("450.00")));

        // Создание товаров для подкатегории "Сладкие роллы" категории "Роллы"
        productRepository.save(new Product(sweetRollsCategory, "Сладкий банан", "Ролл с бананом и шоколадом", new BigDecimal("280.00")));
        productRepository.save(new Product(sweetRollsCategory, "Сладкая клубника", "Ролл с клубникой и сливочным сыром", new BigDecimal("300.00")));
        productRepository.save(new Product(sweetRollsCategory, "Сладкий манго", "Ролл с манго и кокосом", new BigDecimal("320.00")));

        // Создание товаров для подкатегории "Наборы" категории "Роллы"
        productRepository.save(new Product(setsRollsCategory, "Сет Филадельфия", "Набор из роллов Филадельфия", new BigDecimal("800.00")));
        productRepository.save(new Product(setsRollsCategory, "Сет Нинзя Хот", "Набор из роллов Эби", new BigDecimal("850.00")));
        productRepository.save(new Product(setsRollsCategory, "Сет Темпура", "Набор из роллов Темпура", new BigDecimal("900.00")));

        // Создание товаров для подкатегории "Классические бургеры" категории "Бургеры"
        productRepository.save(new Product(classicBurgersCategory, "Чизбургер", "Классический бургер с говядиной и сыром", new BigDecimal("250.00")));
        productRepository.save(new Product(classicBurgersCategory, "Гамбургер", "Классический бургер с говядиной", new BigDecimal("230.00")));
        productRepository.save(new Product(classicBurgersCategory, "Двойной чизбургер", "Бургер с двойной порцией говядины и остальных добавок", new BigDecimal("300.00")));

        // Создание товаров для подкатегории "Острые бургеры" категории "Бургеры"
        productRepository.save(new Product(spicyBurgersCategory, "Острый Чизбургер", "Бургер с говядиной, сыром и острым соусом", new BigDecimal("270.00")));
        productRepository.save(new Product(spicyBurgersCategory, "Острый Гамбургер", "Бургер с говядиной и острым соусом", new BigDecimal("250.00")));
        productRepository.save(new Product(spicyBurgersCategory, "Острый Двойной чизбургер", "Бургер с двойной порцией говядины, сыра и остальных добавок", new BigDecimal("320.00")));

        // Создание товаров для подкатегории "Газированные напитки" категории "Напитки"
        productRepository.save(new Product(carbonatedDrinksCategory, "Кола", "Газированный напиток со вкусом колы", new BigDecimal("100.00")));
        productRepository.save(new Product(carbonatedDrinksCategory, "Фанта", "Газированный напиток со вкусом апельсина", new BigDecimal("100.00")));
        productRepository.save(new Product(carbonatedDrinksCategory, "Спрайт", "Газированный напиток со вкусом лайма", new BigDecimal("100.00")));

        // Создание товаров для подкатегории "Энергетические напитки" категории "Напитки"
        productRepository.save(new Product(energyDrinksCategory, "Red Bull", "Энергетический напиток с оригинальным вкусом энергетика", new BigDecimal("123.00")));
        productRepository.save(new Product(energyDrinksCategory, "Adrenalin Rush", "Энергетический напиток с персиковым привкусом", new BigDecimal("120.00")));
        productRepository.save(new Product(energyDrinksCategory, "Burn", "Энергетический напиток с апельсиновым привкусом", new BigDecimal("99.00")));

        // Создание товаров для подкатегории "Соки" категории "Напитки"
        productRepository.save(new Product(juicesDrinksCategory, "Апельсиновый сок", "Свежевыжатый апельсиновый сок", new BigDecimal("120.00")));
        productRepository.save(new Product(juicesDrinksCategory, "Яблочный сок", "Свежевыжатый яблочный сок", new BigDecimal("120.00")));
        productRepository.save(new Product(juicesDrinksCategory, "Вишневый сок", "Свежевыжатый вишневый сок", new BigDecimal("120.00")));

        // Создание товаров для подкатегории "Другие" категории "Напитки"
        productRepository.save(new Product(othersDrinksCategory, "Вода без газа", "Чистая питьевая вода", new BigDecimal("50.00")));
        productRepository.save(new Product(othersDrinksCategory, "Вода с газом", "Газированная вода", new BigDecimal("50.00")));
        productRepository.save(new Product(othersDrinksCategory, "Чай", "Чай с сахаром и лимоном", new BigDecimal("70.00")));
    }
}