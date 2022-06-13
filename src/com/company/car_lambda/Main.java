package com.company.car_lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        // 1. Создание  автомобилей
        Car rav4 = new Car("Toyota RAV4", 1325000, 158);
        Car camry = new Car("Toyota Camry", 3500000, 200);
        Car civic = new Car("Honda Civic", 730000, 140);
        Car accord = new Car("Honda Accord", 1650000, 220);
        Car bmw_x6 = new Car("BMW X6", 2000000, 555);
        Car mercedes_g = new Car("Mercedes-Benz G-Class", 4000000, 585);
        Car tucson = new Car("Hyundai Tucson", 765000, 142);
        Car solaris = new Car("Hyundai Solaris", 400000, 123);
        Car mpv = new Car("Mazda MPV", 400000, 170);
        Car note = new Car("Nissan Note", 400000, 109);

        // 2. Создание списка автомобилей
        ArrayList<Car> carList = new ArrayList<>();

        // 3. Заполнение списка автомобилями
        carList.add(rav4);
        carList.add(camry);
        carList.add(civic);
        carList.add(accord);
        carList.add(bmw_x6);
        carList.add(mercedes_g);
        carList.add(tucson);
        carList.add(solaris);
        carList.add(mpv);
        carList.add(note);

        // 4. Вывод данных об автомобилях на экран.
        System.out.println("\t\t\t\tСписок автомобилей: ");
        carList.forEach(System.out::println);

        // 5. Выборка автомобилей ценой более 1 000 000 и вывод на экран
        System.out.println("\n\t\t\t\tАвтомобили стоимостью больше 1 000 000 рублей: ");
        carList.forEach((car) -> {
            if (car.getPrice() > 1000000) {
                System.out.println(car);
            }
        });

        // 6. Сортировка автомобилей по цене и мощности (автомобили с одной ценой сортируются по мощности)
        carList.sort(Comparator.comparing(Car::getPrice)
                .thenComparing(Car::getPower));

        System.out.println("\n\t\t\t\tАвтомобили отсортированные по цене и мощности: ");
        //  Вывод данных об автомобилях на экран.
        carList.forEach(System.out::println);

        // 7. Поиск автомобиля с указанной стоимостью
        // (реализация объекта функционального интерфейса через анонимный класс)
        System.out.println("\n\t\t\t\tПоиск автомобиля с указанной стоимостью: ");
        Search coastCar = new Search() {
            @Override
            public void searchCarWithPrice(ArrayList<Car> carList, double price) {
                // счетчик для выполнения условия если автомобиль не найден
                AtomicInteger count = new AtomicInteger();
                carList.forEach((car) -> {
                    if (price == car.getPrice()) {
                        System.out.println(car);
                        count.getAndIncrement();

                    }
                });
                if (count.get() == 0) {
                    System.out.println("Автомобиль с запрошенной ценой не найден");
                }
            }
        };
        coastCar.searchCarWithPrice(carList, 1325000.0);
        coastCar.searchCarWithPrice(carList, 150000.0);

        // 8. Случилась инфляция, необходимо увеличить стоимость всех авто на 20%
        System.out.println("\n\t\t\t\tСлучилась инфляция, стоимость всех авто увеличилась на 20%: ");
        carList.forEach((car) -> {
                    double inflation = (car.getPrice() * 20 / 100) + car.getPrice();
                    car.setPrice(inflation);
                    System.out.println(car);
                }
        );

        // 9. Случилось снижение инфляции, необходимо снизить стоимость всех авто на 20%.
        System.out.println("\n\t\t\t\tСлучилась инфляция, стоимость всех авто снизилась на 20%: ");

        carList.forEach((car) -> {
                    double inflation = car.getPrice() - (car.getPrice() * 20 / 100);
                    car.setPrice(inflation);
                    System.out.println(car);
                }
        );

    }//main
}//class close
