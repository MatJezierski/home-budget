package pl.mpas.homebudget.service;

import pl.mpas.homebudget.domain.ExpenseCategory;

import java.util.List;

public interface ExpenseCategoryService {

    List<ExpenseCategory> readAllExpenseCategories();
}
