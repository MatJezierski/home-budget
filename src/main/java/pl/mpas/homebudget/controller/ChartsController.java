package pl.mpas.homebudget.controller;

import org.springframework.ui.Model;

public interface ChartsController {

    String showCategoryChart(Model data);
    String showCategoryChartFromGivenPeriod();



}
