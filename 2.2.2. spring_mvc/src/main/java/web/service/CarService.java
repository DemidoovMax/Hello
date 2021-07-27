package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {
    List<Car> carsList;

    public List<Car> getCarList(int count) {
        List<Car> cars;
        if (count > carsList.size()) {
            cars = carsList.stream().limit(carsList.size()).collect(Collectors.toList());
        } else {
            cars = carsList.stream().limit(count).collect(Collectors.toList());
        }
        return cars;
    }

    public CarService() {
        carsList = new ArrayList<>();
        carsList.add(new Car("Renault", 5, 220));
        carsList.add(new Car("BMW", 3, 250));
        carsList.add(new Car("Mercedes", 212, 250));
        carsList.add(new Car("Peugeot", 7, 230));
        carsList.add(new Car("Lada", 5, 200));
    }
}
