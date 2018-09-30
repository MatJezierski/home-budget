package pl.mpas.homebudget.service.impl;

import pl.mpas.homebudget.exception.ExpenseImportWrongRecordFormat;
import pl.mpas.homebudget.service.BulkExpenseImport;

import java.io.File;

public class BulkExpenseImportImpl implements BulkExpenseImport {
    @Override
    public void importExpenses(File path) throws ExpenseImportWrongRecordFormat {
        // iterate over lines
        // skip empty ones
        // create Expense object for each record
        // add object to collection
        // save collection

        // nie musimy tu robić adnotacji @Table, bo CrudRepository ma zaszytą metodę "saveAll"
    }
}
