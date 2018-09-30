package pl.mpas.homebudget.service;

import pl.mpas.homebudget.exception.ExpenseImportWrongRecordFormat;

import java.io.File;

/**
 * Required file's record format: expense_title;expense_amount;category;date_in_format_yyyy-MM-dd
 */

public interface BulkExpenseImport {


    void importExpenses(File path) throws ExpenseImportWrongRecordFormat;

}
