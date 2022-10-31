package pl.mpas.homebudget.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.mpas.homebudget.domain.Expense;
import pl.mpas.homebudget.service.ChartsService;
import pl.mpas.homebudget.service.ExpenseService;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChartsServiceImpl implements ChartsService {
    private static final Logger logger = LoggerFactory.getLogger(ChartsService.class);
    private final ExpenseService expenseService;

    public ChartsServiceImpl (ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @Override
    public Map<String, BigDecimal> readCategoriesOverAmounts() {

        List<Expense> allExpenses = expenseService.readAllExpenses();
        Map<String, BigDecimal> result = new LinkedHashMap<>();

        for (Expense expense: allExpenses) {
           String expenseCategory = expense.getCategory().getCategoryName();
           BigDecimal expenseValue = expense.getExpenseAmount();

           if (result.containsKey(expenseCategory)) {
               BigDecimal newCategoryValue = expenseValue.add(result.get(expenseCategory));
               result.put(expenseCategory, newCategoryValue);
           } else {
               result.put(expenseCategory, expenseValue);
           }

       }

//        allExpenses.stream()
//                .map(newExpense -> newExpense.getCategory().getCategoryName());

        return Collections.emptyMap();
    }
}
