package pl.mpas.homebudget.controller.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping("/category/save")
    public String saveCategory(@ModelAttribute ExpenseCategory expenseCategory,
                               @RequestParam String pushedButton) {
        logger.info("saveCategory(), expenseCategory: {}, pushedButton: ()",
                expenseCategory, pushedButton);

        if ("save".equals(pushedButton)){
            categoryService.saveCategory(expenseCategory);
        }
        return "redirect:/category/all";
    }

    @GetMapping("/category/add")
    public String addCategory(Model category) { //@ModelAttribute  - ta adnostacja Springa konwertuje
        // tekst z formularza HTMLowego (np "dodaj kategorię") do obiektu w Javie, który następnie ląduje w tej metodzie addCategory().
        logger.info("addCategory()");
        //TODO: MP save category

        category.addAttribute("category", new ExpenseCategory());

        return "category/new-category";
    }
}
