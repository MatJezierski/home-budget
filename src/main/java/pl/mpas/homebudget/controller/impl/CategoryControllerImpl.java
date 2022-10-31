package pl.mpas.homebudget.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pl.mpas.homebudget.controller.CategoryController;
import pl.mpas.homebudget.domain.ExpenseCategory;
import pl.mpas.homebudget.service.CategoryService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class CategoryControllerImpl implements CategoryController {
    private static final Logger logger = LoggerFactory.getLogger(CategoryControllerImpl.class);
    private final CategoryService categoryService;

    @Autowired
    public CategoryControllerImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/category/all")
    public String allCategories(Model categories) {
        logger.info("showAllCategories()");
        List<ExpenseCategory> expenseCategories = categoryService.readAllExpenseCategories();
        categories.addAttribute("categories", expenseCategories);

        return "category/categories-all";
    }

    @PostMapping("/category/save")
    //TODO: to deal with duplicated values
    public String saveCategory(@Valid @ModelAttribute ExpenseCategory expenseCategory, BindingResult result, Model model,
                               @RequestParam(name = "pressed-button") String pushedButton) {
        logger.info("expenseCategory: {}, pushedButton: {}", expenseCategory, pushedButton);

        if (result.hasErrors()) {
            model.addAttribute("expenseCategory", expenseCategory);
            logger.info("Has errors = " + result.hasErrors());
            for (FieldError err : result.getFieldErrors()) {
                System.out.println(err.getDefaultMessage()); // Output: must be greater than or equal to 10
            }
            return "errors/error";
        }

        if ("save".equalsIgnoreCase(pushedButton)) {
            categoryService.saveCategory(expenseCategory);
        }

        return "redirect:/category/all";
    }

    @GetMapping("/category/add")
    public String addCategory(Model category) {
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

    @GetMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable Long id, Model model) {
        logger.info("deleteCategory(), id: {}", id);
        Optional<ExpenseCategory> categoryToAsk = categoryService.findCategoryById(id);
        categoryToAsk.ifPresent(expenseCategory -> model.addAttribute("categoryToAsk", expenseCategory));
        categoryService.deleteCategoryById(id);

        return "redirect:/category/all";
    }
}
