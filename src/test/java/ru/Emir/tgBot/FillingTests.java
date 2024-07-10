package ru.Emir.tgBot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.Emir.tgBot.entity.*;
import ru.Emir.tgBot.repository.*;

import java.math.BigDecimal;

@SpringBootTest
public class FillingTests {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientOrderRepository clientOrderRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Test
    void createRecords() {
        // Тест 1
        /*
         Основные категории
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
            "Другие"
         */

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

        // Создание по три товара для каждой категорий/подкатегорий
        // Создание товаров для основной категории "Пицца"
        Product margaritaPizza = new Product(pizzaCategory, "Маргарита", "Классическая пицца с томатами, сыром и базиликом", new BigDecimal("450.00"));
        productRepository.save(margaritaPizza);
        Product pepperoniPizza = new Product(pizzaCategory, "Пепперони", "Пицца с пепперони, сыром и томатным соусом", new BigDecimal("500.00"));
        productRepository.save(pepperoniPizza);
        Product fourCheesePizza = new Product(pizzaCategory, "Четыре сыра", "Пицца с четырьмя видами сыра", new BigDecimal("550.00"));
        productRepository.save(fourCheesePizza);

        // Создание товаров для основной категории "Роллы"
        Product dragonRoll = new Product(rollsCategory, "Дракон", "Ролл с угрём, авокадо и соусом терияки", new BigDecimal("380.00"));
        productRepository.save(dragonRoll);
        Product canadaRoll = new Product(rollsCategory, "Канада", "Ролл с лососем, авокадо и сливочным сыром", new BigDecimal("370.00"));
        productRepository.save(canadaRoll);
        Product thaiRoll = new Product(rollsCategory, "Тайский", "Ролл с креветкой, манго и сливочным сыром", new BigDecimal("390.00"));
        productRepository.save(thaiRoll);

        // Создание товаров для основной категории "Бургеры"
        Product bigMacBurger = new Product(burgersCategory, "Биг Мак", "Бургер с двумя котлетами, сыром и соусом", new BigDecimal("350.00"));
        productRepository.save(bigMacBurger);
        Product royalCheeseBurger = new Product(burgersCategory, "Роял Чизбургер", "Бургер с говядиной, сыром и маринованным огурцом", new BigDecimal("330.00"));
        productRepository.save(royalCheeseBurger);
        Product doubleRoyalBurger = new Product(burgersCategory, "Двойной Роял", "Бургер с двумя котлетами и двойной порцией сыра", new BigDecimal("400.00"));
        productRepository.save(doubleRoyalBurger);

        // Создание товаров для основной категории "Напитки"
        Product milkshakeDrink = new Product(drinksCategory, "Молочный коктейль", "Коктейль на основе молока и мороженого", new BigDecimal("150.00"));
        productRepository.save(milkshakeDrink);
        Product lemonadeDrink = new Product(drinksCategory, "Лимонад", "Освежающий лимонад с мятой и лимоном", new BigDecimal("130.00"));
        productRepository.save(lemonadeDrink);
        Product cocoaDrink = new Product(drinksCategory, "Какао", "Горячий напиток с какао и молоком", new BigDecimal("110.00"));
        productRepository.save(cocoaDrink);

        // Создание товаров для подкатегории "Классические роллы" категории "Роллы"
        Product philadelphiaRoll = new Product(classicRollsCategory, "Филадельфия", "Ролл с лососем, сливочным сыром и огурцом", new BigDecimal("300.00"));
        productRepository.save(philadelphiaRoll);
        Product californiaRoll = new Product(classicRollsCategory, "Калифорния", "Ролл с крабом, авокадо и огурцом", new BigDecimal("320.00"));
        productRepository.save(californiaRoll);
        Product unagiRoll = new Product(classicRollsCategory, "Унаги", "Ролл с угрём, сливочным сыром и огурцом", new BigDecimal("350.00"));
        productRepository.save(unagiRoll);

        // Создание товаров для подкатегории "Запечённые роллы" категории "Роллы"
        Product bakedPhiladelphiaRoll = new Product(bakedRollsCategory, "Запечённая Филадельфия", "Запечённый ролл с лососем, сливочным сыром и огурцом", new BigDecimal("400.00"));
        productRepository.save(bakedPhiladelphiaRoll);
        Product bakedCaliforniaRoll = new Product(bakedRollsCategory, "Запечённая Калифорния", "Запечённый ролл с крабом, авокадо и огурцом", new BigDecimal("420.00"));
        productRepository.save(bakedCaliforniaRoll);
        Product bakedUnagiRoll = new Product(bakedRollsCategory, "Запечённый Унаги", "Запечённый ролл с угрём, сливочным сыром и огурцом", new BigDecimal("450.00"));
        productRepository.save(bakedUnagiRoll);

        // Создание товаров для подкатегории "Сладкие роллы" категории "Роллы"
        Product sweetBananaRoll = new Product(sweetRollsCategory, "Сладкий банан", "Ролл с бананом и шоколадом", new BigDecimal("280.00"));
        productRepository.save(sweetBananaRoll);
        Product sweetStrawberryRoll = new Product(sweetRollsCategory, "Сладкая клубника", "Ролл с клубникой и сливочным сыром", new BigDecimal("300.00"));
        productRepository.save(sweetStrawberryRoll);
        Product sweetMangoRoll = new Product(sweetRollsCategory, "Сладкий манго", "Ролл с манго и кокосом", new BigDecimal("320.00"));
        productRepository.save(sweetMangoRoll);

        // Создание товаров для подкатегории "Наборы" категории "Роллы"
        Product philadelphiaSet = new Product(setsRollsCategory, "Сет Филадельфия", "Набор из роллов Филадельфия", new BigDecimal("800.00"));
        productRepository.save(philadelphiaSet);
        Product ninjaHotSet = new Product(setsRollsCategory, "Сет Нинзя Хот", "Набор из роллов Эби", new BigDecimal("850.00"));
        productRepository.save(ninjaHotSet);
        Product tempuraSet = new Product(setsRollsCategory, "Сет Темпура", "Набор из роллов Темпура", new BigDecimal("900.00"));
        productRepository.save(tempuraSet);

        // Создание товаров для подкатегории "Классические бургеры" категории "Бургеры"
        Product cheeseBurger = new Product(classicBurgersCategory, "Чизбургер", "Классический бургер с говядиной и сыром", new BigDecimal("250.00"));
        productRepository.save(cheeseBurger);
        Product hamBurger = new Product(classicBurgersCategory, "Гамбургер", "Классический бургер с говядиной", new BigDecimal("230.00"));
        productRepository.save(hamBurger);
        Product doubleCheeseBurger = new Product(classicBurgersCategory, "Двойной чизбургер", "Бургер с двойной порцией говядины и остальных добавок", new BigDecimal("300.00"));
        productRepository.save(doubleCheeseBurger);

        // Создание товаров для подкатегории "Острые бургеры" категории "Бургеры"
        Product spicyCheeseBurger = new Product(spicyBurgersCategory, "Острый Чизбургер", "Бургер с говядиной, сыром и острым соусом", new BigDecimal("270.00"));
        productRepository.save(spicyCheeseBurger);
        Product spicyHamBurger = new Product(spicyBurgersCategory, "Острый Гамбургер", "Бургер с говядиной и острым соусом", new BigDecimal("250.00"));
        productRepository.save(spicyHamBurger);
        Product spicyDoubleCheeseBurger = new Product(spicyBurgersCategory, "Острый Двойной чизбургер", "Бургер с двойной порцией говядины, сыра и остальных добавок", new BigDecimal("320.00"));
        productRepository.save(spicyDoubleCheeseBurger);

        // Создание товаров для подкатегории "Газированные напитки" категории "Напитки"
        Product colaCarbonatedDrink = new Product(carbonatedDrinksCategory, "Кола", "Газированный напиток со вкусом колы", new BigDecimal("100.00"));
        productRepository.save(colaCarbonatedDrink);
        Product fantaCarbonatedDrink = new Product(carbonatedDrinksCategory, "Фанта", "Газированный напиток со вкусом апельсина", new BigDecimal("100.00"));
        productRepository.save(fantaCarbonatedDrink);
        Product spriteCarbonatedDrink = new Product(carbonatedDrinksCategory, "Спрайт", "Газированный напиток со вкусом лайма", new BigDecimal("100.00"));
        productRepository.save(spriteCarbonatedDrink);

        // Создание товаров для подкатегории "Энергетические напитки" категории "Напитки"
        Product redBullEnergyDrink = new Product(energyDrinksCategory, "Red Bull", "Энергетический напиток с оригинальным вкусом энергетика", new BigDecimal("123.00"));
        productRepository.save(redBullEnergyDrink);
        Product adrenalinRushEnergyDrink = new Product(energyDrinksCategory, "Adrenalin Rush", "Энергетический напиток с персиковым привкусом", new BigDecimal("120.00"));
        productRepository.save(adrenalinRushEnergyDrink);
        Product burnEnergyDrink = new Product(energyDrinksCategory, "Burn", "Энергетический напиток с апельсиновым привкусом", new BigDecimal("99.00"));
        productRepository.save(burnEnergyDrink);

        // Создание товаров для подкатегории "Соки" категории "Напитки"
        Product orangeJuice = new Product(juicesDrinksCategory, "Апельсиновый сок", "Свежевыжатый апельсиновый сок", new BigDecimal("120.00"));
        productRepository.save(orangeJuice);
        Product appleJuice = new Product(juicesDrinksCategory, "Яблочный сок", "Свежевыжатый яблочный сок", new BigDecimal("120.00"));
        productRepository.save(appleJuice);
        Product cherryJuice = new Product(juicesDrinksCategory, "Вишневый сок", "Свежевыжатый вишневый сок", new BigDecimal("120.00"));
        productRepository.save(cherryJuice);

        // Создание товаров для подкатегории "Другие" категории "Напитки"
        Product stillWaterOtherDrink = new Product(othersDrinksCategory, "Вода без газа", "Чистая питьевая вода", new BigDecimal("50.00"));
        productRepository.save(stillWaterOtherDrink);
        Product sparklingWaterOtherDrink = new Product(othersDrinksCategory, "Вода с газом", "Газированная вода", new BigDecimal("50.00"));
        productRepository.save(sparklingWaterOtherDrink);
        Product teaOtherDrink = new Product(othersDrinksCategory, "Чай", "Чай с сахаром и лимоном", new BigDecimal("70.00"));
        productRepository.save(teaOtherDrink);

        // Тест 2
        // Создание клиентов
        Client client1 = new Client();
        client1.setExternalId(1111L);
        client1.setFullName("Иван Иванов Иванович");
        client1.setPhoneNumber("+79780000000");
        client1.setAddress("г. Москва");
        clientRepository.save(client1);

        Client client2 = new Client();
        client2.setExternalId(1112L);
        client2.setFullName("Алексей Алексеев Алексеевич");
        client2.setPhoneNumber("+79781234567");
        client2.setAddress("г. Санкт-Петербург");
        clientRepository.save(client2);

        // Создание заказов для клиента 1
        ClientOrder order1 = new ClientOrder();
        order1.setClient(client1);
        order1.setStatus(1);
        order1.setTotal(BigDecimal.valueOf(margaritaPizza.getPrice().doubleValue() + burnEnergyDrink.getPrice().doubleValue() * 2));
        clientOrderRepository.save(order1);

        ClientOrder order2 = new ClientOrder();
        order2.setClient(client1);
        order2.setStatus(2);
        order2.setTotal(BigDecimal.valueOf(unagiRoll.getPrice().doubleValue()));
        clientOrderRepository.save(order2);

        // Создание заказов для клиента 2
        ClientOrder order3 = new ClientOrder();
        order3.setClient(client2);
        order3.setStatus(1);
        order3.setTotal(BigDecimal.valueOf(bigMacBurger.getPrice().doubleValue() + spicyCheeseBurger.getPrice().doubleValue()));
        clientOrderRepository.save(order3);

        // Добавление продуктов в заказы
        OrderProduct orderProduct1 = new OrderProduct();
        orderProduct1.setClientOrder(order1);
        orderProduct1.setProduct(margaritaPizza);
        orderProduct1.setCountProduct(1);
        orderProductRepository.save(orderProduct1);

        OrderProduct orderProduct2 = new OrderProduct();
        orderProduct2.setClientOrder(order1);
        orderProduct2.setProduct(burnEnergyDrink);
        orderProduct2.setCountProduct(2);
        orderProductRepository.save(orderProduct2);

        OrderProduct orderProduct3 = new OrderProduct();
        orderProduct3.setClientOrder(order2);
        orderProduct3.setProduct(unagiRoll);
        orderProduct3.setCountProduct(1);
        orderProductRepository.save(orderProduct3);

        OrderProduct orderProduct4 = new OrderProduct();
        orderProduct4.setClientOrder(order3);
        orderProduct4.setProduct(bigMacBurger);
        orderProduct4.setCountProduct(1);
        orderProductRepository.save(orderProduct4);

        OrderProduct orderProduct5 = new OrderProduct();
        orderProduct5.setClientOrder(order3);
        orderProduct5.setProduct(spicyCheeseBurger);
        orderProduct5.setCountProduct(1);
        orderProductRepository.save(orderProduct5);
    }
}