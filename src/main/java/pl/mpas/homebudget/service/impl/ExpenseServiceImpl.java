package pl.mpas.homebudget.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mpas.homebudget.dao.ExpenseRepository;
import pl.mpas.homebudget.domain.Expense;
import pl.mpas.homebudget.service.ExpenseService;

import java.util.*;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private static final Logger logger = LoggerFactory.getLogger(ExpenseServiceImpl.class);

    private ExpenseRepository expenseDao;


    @Autowired
    public ExpenseServiceImpl (ExpenseRepository expenseDao) {

        this.expenseDao = expenseDao;
    }

    @Override
    public List<Expense> readallExpenses() {

        logger.info("readAllExpenses()");

        List<Expense> expensesResult = (List<Expense>) expenseDao.findAll();
        Collections.sort(expensesResult, Comparator.comparing(Expense::getExpenseTitle));
        logger.info("Sorted expenses read from dao: {}", expensesResult);

        return expensesResult;
    }

    @Override
    public boolean saveExpense(Expense expense) {

        Expense savedExpense = expenseDao.save(expense);

        return null != savedExpense.getId();
    }

    @Override
    public Optional<Expense> findExpenseById(Long id) {

        return expenseDao.findById(id);
    }

    @Override
    public List<Expense> findExpenseByAmount(double amount) {

        logger.info("findExpenseByAmount()");

        List<Expense> expensesByAmount = (List<Expense>) expenseDao.findAll();
        Collections.sort(expensesByAmount, Comparator.comparing(Expense::getExpenseAmount));
        logger.info("Expenses sorted by amount, read from dao: {}", expensesByAmount);

        return expensesByAmount;
    }

    @Override
    public void deleteExpenseById(Long id) {

        expenseDao.deleteById(id);
    }
}
