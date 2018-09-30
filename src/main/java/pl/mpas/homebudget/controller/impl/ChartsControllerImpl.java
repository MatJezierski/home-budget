package pl.mpas.homebudget.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mpas.homebudget.controller.ChartsController;

@Controller
public class ChartsControllerImpl implements ChartsController {

    @GetMapping("/charts/category")
    @Override
    public String showCategoryChart() {
        return "";
    }

    @Override
    public String showCategoryChartFromGivenPeriod() {
        return "";
    }
}
