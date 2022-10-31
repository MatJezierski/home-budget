package pl.mpas.homebudget.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mpas.homebudget.dao.ExpenseRepository;
import pl.mpas.homebudget.domain.Expense;
import pl.mpas.homebudget.service.ExpenseService;

import java.util.*;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    private static final Logger logger = LoggerFactory.getLogger(ExpenseServiceImpl.class);
    private final ExpenseRepository expenseDao;

    @Autowired
    public ExpenseServiceImpl (ExpenseRepository expenseDao) {
        this.expenseDao = expenseDao;
    }

    @Override
    public List<Expense> readAllExpenses() {
        List<Expense> expensesResult = (List<Expense>) expenseDao.findAll();
        expensesResult.sort(Comparator.comparing(Expense::getExpenseTitle));
//        logger.info("Expenses from DAO, sorted by title: \n{}", expensesResult);
        return expensesResult;
    }

    @Override
    @Transactional
    public void saveExpense(Expense expense) {
        expenseDao.save(expense);
        logger.info("New expense successfully saved: \n{}", expense);
    }

    @Override
    public Optional<Expense> findExpenseById(Long id) {
        return expenseDao.findById(id);
    }

    @Override
    public List<Expense> findExpenseByAmount(double amount) {
        List<Expense> expensesByAmount = (List<Expense>) expenseDao.findAll();
        expensesByAmount.sort(Comparator.comparing(Expense::getExpenseAmount));
        logger.info("Expenses from DAO, sorted by amount: \n{}", expensesByAmount);
        return expensesByAmount;
    }

    @Override
    public void deleteExpenseById(Long id) {
        expenseDao.deleteById(id);
    }
}
