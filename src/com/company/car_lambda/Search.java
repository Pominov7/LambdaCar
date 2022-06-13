package com.company.car_lambda;

import java.util.ArrayList;

//Интерфейс - для поиска автомобилей по разным параметрам
public interface Search {
    void searchCarWithPrice(ArrayList<Car> carList, double price);
}
