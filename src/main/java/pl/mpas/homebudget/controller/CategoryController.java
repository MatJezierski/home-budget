package pl.mpas.homebudget.controller;

import org.springframework.ui.Model;

public interface CategoryController {

    String allCategories(Model categories);

    String addCategory(Model category);

}
