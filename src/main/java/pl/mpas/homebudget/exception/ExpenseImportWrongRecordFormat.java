package pl.mpas.homebudget.exception;

public class ExpenseImportWrongRecordFormat extends RuntimeException {

    public ExpenseImportWrongRecordFormat() {
        // empty
    }

    public ExpenseImportWrongRecordFormat (String message) {
        super(message);
    }

    public ExpenseImportWrongRecordFormat(String message, Throwable cause) {
        super(message, cause);
    }
}
