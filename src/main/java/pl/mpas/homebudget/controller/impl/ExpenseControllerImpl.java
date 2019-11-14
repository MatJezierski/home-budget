package pl.mpas.homebudget.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mpas.homebudget.controller.ExpenseController;
import pl.mpas.homebudget.domain.Expense;
import pl.mpas.homebudget.domain.PaymentMethod;
import pl.mpas.homebudget.service.ExpenseCategoryService;
import pl.mpas.homebudget.service.ExpenseService;

import java.util.List;
import java.util.Optional;

@Controller
public class ExpenseControllerImpl implements ExpenseController {

    private static final Logger logger = LoggerFactory.getLogger(ExpenseControllerImpl.class);

    private ExpenseService expenseService;
    private ExpenseCategoryService categoryService;

    @Autowired
    public ExpenseControllerImpl(ExpenseService expenseService, ExpenseCategoryService categoryService){
        this.expenseService = expenseService;
        this.categoryService = categoryService;
    }

    @GetMapping("/expense/all")
    public String allExpenses(Model expenses) {

        logger.info("showAllExpenses()");
        List<Expense> expensesList = expenseService.readallExpenses();
        expenses.addAttribute("expenses", expensesList);

        return "expense/expenses-all";
    }

    @PostMapping("/expense/save")
    public String saveExpense(@ModelAttribute Expense expenseTitle,
                              @RequestParam(name = "pressed-button") String pushedButton) {

        logger.info("saveExpense(), expenseTitle: {}, pushedButton: ()", expenseTitle, pushedButton);

        if ("save".equalsIgnoreCase(pushedButton)) {
            expenseService.saveExpense(expenseTitle);
        }

        return "redirect:/expense/all";
    }

    @GetMapping("/expense/add")
    public String addExpense(Model expense) {

        expense.addAttribute("operationTitle", "New");
        expense.addAttribute("mainParagraph", "Add new");
        expense.addAttribute("newExpense", new Expense());
        expense.addAttribute("categories", categoryService.readAllExpenseCategories());
        expense.addAttribute("paymentMethods", PaymentMethod.getAllPaymentMethods());

        return "expense/new-expense";
    }

    @GetMapping("/expense/edit/{id}")
    public String editExpense(@PathVariable Long id, Model model){
        logger.info("editExpense(), id: ()", id);

        model.addAttribute("operationTitle", "Edit");
        model.addAttribute("mainParagraph", "Edit");

        Optional<Expense> foundExpense = expenseService.findExpenseById(id);
        foundExpense.ifPresent(expense -> model.addAttribute("newExpense", expense));

        return "expense/new-expense";
    }

    @GetMapping("/expense/delete-confirmation/{id}")
    public String deleteConfirmation(@PathVariable Long id, Model model) {
        logger.info("deleteExpense(), id: ()", id);

        Optional<Expense> expenseToAsk = expenseService.findExpenseById(id);
        expenseToAsk.ifPresent(expense -> model.addAttribute("expenseToAsk", expense));

        model.addAttribute("operationTitle", "Delete");

        return "expense/delete-confirmation";
    }

    public String deleteExpense(Model removedExpense) {

        return "redirect:/newExpense/all";
    }

    public String showChart(Model chart) {

        return "charts/newExpense-chart";
    }



}
