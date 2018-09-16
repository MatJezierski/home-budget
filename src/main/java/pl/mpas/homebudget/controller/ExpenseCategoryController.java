package pl.mpas.homebudget.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.mpas.homebudget.domain.ExpenseCategory;

import java.util.Collections;
import java.util.List;

@Controller
public class ExpenseCategoryController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ExpenseCategoryController.class);

    @GetMapping("/category/all")
    public String allCategories(Model categories) { //Model categories - klasa Model z pakietu Springa

        List<ExpenseCategory> expenseCategories = Collections.emptyList();
        categories.addAttribute("categories",expenseCategories);

        return "category/categories-all";
    }

    @GetMapping("/category/add")
    public String addCategory(@ModelAttribute ExpenseCategory expenseCategory) { //@ModelAttribute  - ta adnostacja Springa konwertuje
        logger.info("addCategory()");
        // tekst z formularza HTMLowego (np "dodaj kategorię") do obiektu w Javie, który następnie ląduje w tej metodzie addCategory().
        //TODO: MP save category
        return "redirect:/category/all";
    }
}
