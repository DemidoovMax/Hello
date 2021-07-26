package web;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    List<Car> carsList;

    public List<Car> getCarList(int count) {
    List<Car> cars = new ArrayList<>();
        switch (count) {
            case 1:
                cars.add(carsList.get(0));
                break;
            case 2:
                cars.add(carsList.get(0));
                cars.add(carsList.get(1));
                break;
            case 3:
                cars.add(carsList.get(0));
                cars.add(carsList.get(1));
                cars.add(carsList.get(2));
                break;
            case 4:
                cars.add(carsList.get(0));
                cars.add(carsList.get(1));
                cars.add(carsList.get(2));
                cars.add(carsList.get(3));
                break;
            default:
                cars.add(carsList.get(0));
                cars.add(carsList.get(1));
                cars.add(carsList.get(2));
                cars.add(carsList.get(3));
                cars.add(carsList.get(4));
                break;
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
