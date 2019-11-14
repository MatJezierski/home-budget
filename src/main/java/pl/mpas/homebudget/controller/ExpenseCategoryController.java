package pl.mpas.homebudget.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.mpas.homebudget.domain.ExpenseCategory;

public interface ExpenseCategoryController {

    String allCategories(Model categories);

    String addCategory(Model category);

}
