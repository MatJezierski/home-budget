package pl.mpas.homebudget.controller.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.mpas.homebudget.controller.ExpenseCategoryController;
import pl.mpas.homebudget.domain.ExpenseCategory;
import pl.mpas.homebudget.service.ExpenseCategoryService;

import java.util.List;

@Controller
public class ExpenseCategoryControllerImpl implements ExpenseCategoryController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ExpenseCategoryControllerImpl.class);

    private ExpenseCategoryService categoryService;

    @Autowired
    public ExpenseCategoryControllerImpl(ExpenseCategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/category/all")
    public String allCategories(Model categories) { //Model categories - klasa Model z pakietu Springa

        List<ExpenseCategory> expenseCategories = categoryService.readAllExpenseCategories();
        categories.addAttribute("categories",expenseCategories);

        return "category/categories-all";
    }

    @GetMapping("/category/add")
    public String addCategory(@ModelAttribute ExpenseCategory expenseCategory) { //@ModelAttribute  - ta adnostacja Springa konwertuje
        // tekst z formularza HTMLowego (np "dodaj kategorię") do obiektu w Javie, który następnie ląduje w tej metodzie addCategory().
        //TODO: MP save category

        logger.info("addCategory()");
        return "redirect:/category/all";
    }
}
