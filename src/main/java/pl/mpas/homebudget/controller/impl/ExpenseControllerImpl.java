package pl.mpas.homebudget.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mpas.homebudget.controller.ExpenseController;
import pl.mpas.homebudget.domain.Expense;
import pl.mpas.homebudget.domain.PaymentMethod;
import pl.mpas.homebudget.service.ExpenseCategoryService;
import pl.mpas.homebudget.service.ExpenseService;

import java.util.List;

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

    @GetMapping("/expenses/all")
    @Override
    public String showAllExpenses(Model expenses) {

        logger.info("showAllExpenses()");
        List<Expense> expensesList = expenseService.readallExpenses();
        expenses.addAttribute("expenses", expensesList);

        return "expense/expenses-all";
    }

    @PostMapping("/expense/saved")
    public String saveExpense(@ModelAttribute Expense expenseTitle,
                              @RequestParam(name = "pressed-button") String pushedButton) {
        logger.info("saveExpense(), expenseTitle: {}, pushedButton: ()",
                expenseTitle, pushedButton);

        if ("save".equalsIgnoreCase(pushedButton)) {
            expenseService.saveExpense(expenseTitle); // jeśli "Save", to zapisz i dodaj do wszystkich wydatków
        }

        return "redirect:/category/all"; //jeśli "Cancel", to powróć do wszystkich wydatków
    }

    @PostMapping("/expense/add")
    @Override
    public String addExpense(Model newExpense) {

        newExpense.addAttribute("operationTitle", "New");
        newExpense.addAttribute("mainParagraph", "New");
        newExpense.addAttribute("expense", new Expense());
        newExpense.addAttribute("categories", categoryService.readAllExpenseCategories());
        newExpense.addAttribute("paymentMethods", PaymentMethod.getAllPaymentMethods());

        return "new-expense";
    }

    @Override
    public String showChart(Model newChart) {

        return "charts/category-charts";
    }

    @Override
    public String removeExpense(Model removedExpense) {

        return "redirect:/category/all";
    }
}
