package pl.mpas.homebudget.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mpas.homebudget.controller.ExpenseController;
import pl.mpas.homebudget.domain.PaymentMethod;
import pl.mpas.homebudget.service.ExpenseCategoryService;
import pl.mpas.homebudget.service.ExpenseService;

@Controller
public class ExpenseControllerImpl implements ExpenseController {

    private static final Logger logger = LoggerFactory.getLogger(ExpenseControllerImpl.class);

    private ExpenseService expenseService;
    private ExpenseCategoryService categoryService;

    @Autowired
    public ExpenseControllerImpl(ExpenseService expenseService,
                                 ExpenseCategoryService categoryService){
        this.expenseService = expenseService;
        this.categoryService = categoryService;
    }

    @Override
    public String showAllExpenses(Model model) {

        logger.info("showAllExpenses()");
        model.addAttribute("expenses",expenseService.readallExpenses());
        return "expense/expenses-all";
    }

    @GetMapping("/expense/all")
    @Override
    public String addExpense(Model model) {

        model.addAttribute("paymentMethods", PaymentMethod.values());
        return "expense/new-edit";
    }
}
