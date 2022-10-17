package pl.mpas.homebudget.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pl.mpas.homebudget.controller.ExpenseCategoryController;
import pl.mpas.homebudget.domain.ExpenseCategory;
import pl.mpas.homebudget.service.ExpenseCategoryService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class ExpenseCategoryControllerImpl implements ExpenseCategoryController {

    private static final Logger logger = LoggerFactory.getLogger(ExpenseCategoryControllerImpl.class);

    private final ExpenseCategoryService categoryService;

    @Autowired
    public ExpenseCategoryControllerImpl(ExpenseCategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/category/all")
    public String allCategories(Model categories) { //Model categories - klasa Model z pakietu Springa

        logger.info("showAllCategories()");
        List<ExpenseCategory> expenseCategories = categoryService.readAllExpenseCategories();
        categories.addAttribute("categories", expenseCategories);

        return "category/categories-all";
    }

    @PostMapping("/category/save")
    //TODO: to deal with duplicated values
    public String saveCategory(@Valid @ModelAttribute ExpenseCategory expenseCategory, BindingResult result, Model model,
                               @RequestParam(name = "pressed-button") String pushedButton) {

        logger.info("saveCategory(), expenseCategory: {}, pushedButton: {}",
                expenseCategory, pushedButton);

        if (result.hasErrors()){
            model.addAttribute("expenseCategory", expenseCategory);
            logger.info("Has errors = "+result.hasErrors());
            for (FieldError err:result.getFieldErrors()){
                System.out.println(err.getDefaultMessage()); // Output: must be greater than or equal to 10
            }
            return "errors/error";
        }

        if ("save".equalsIgnoreCase(pushedButton)) {
            categoryService.saveCategory(expenseCategory); // jeśli "Save", to zapisz i dodaj do wszystkich kategorii
        }
        return "redirect:/category/all"; //jeśli "Cancel", to powróć do wszystkich kategorii
    }

    @GetMapping("/category/add")
    public String addCategory(Model category) { //@ModelAttribute  - ta adnotacja Springa konwertuje
        // tekst z formularza HTMLowego (np "dodaj kategorię") do obiektu w Javie, który następnie ląduje w tej metodzie addCategory().
        logger.info("addCategory()");

        category.addAttribute("operationTitle", "New");
        category.addAttribute("mainParagraph", "Add new");
        category.addAttribute("newCategory", new ExpenseCategory());

        return "category/new-category";

    }

    @GetMapping("/category/edit/{id}")
    public String editCategory(@PathVariable Long id, Model model) {
        logger.info("editCategory(), id: {}", id);

        model.addAttribute("operationTitle", "Edit");
        model.addAttribute("mainParagraph", "Edit");

        Optional<ExpenseCategory> foundCategory = categoryService.findCategoryById(id);
        foundCategory.ifPresent(expenseCategory -> model.addAttribute("newCategory", expenseCategory));

        return "category/new-category";
    }

    @GetMapping("/category/delete-confirmation/{id}")
    public String deleteConfirmation(@PathVariable Long id, Model model) {
        logger.info("deleteCategory(), id: {}", id);

        Optional<ExpenseCategory> categoryToAsk = categoryService.findCategoryById(id);
        categoryToAsk.ifPresent(expenseCategory -> model.addAttribute("categoryToAsk", expenseCategory));

        model.addAttribute("operationTitle", "Delete");

        return "category/delete-confirmation";
    }

    @DeleteMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        logger.info("deleteCategory(), id: ()", id);

        categoryService.deleteCategoryById(id);

        return "redirect:/category/all";
    }
}
