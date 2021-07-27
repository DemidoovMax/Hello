package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String cars(@RequestParam(value = "count", required = false) Integer count,
            Model model) {
        CarService carService = new CarService();
        if (count == null) {
            model.addAttribute("cars", carService.getCarList(5));
        } else {
            model.addAttribute("cars", carService.getCarList(count));
        }
        return "cars";
    }

}
