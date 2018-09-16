package pl.mpas.homebudget.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

//@Entity
public class Expense {

  //  @Id
    //@GeneratedValue
    private Long id;

    //@Column (nullable = false)
    private String expenseTitle;

    private PaymentMethod method;

    private String expensePlace;

    private BigDecimal expenseAmount;

    private ExpenseCategory category;

    private LocalDate expenseDate;

    private LocalDateTime creationDateTime;

    private boolean deleted;

    public Expense() {
    }

    public Expense(String expenseTitle, PaymentMethod method, String expensePlace, BigDecimal expenseAmount, ExpenseCategory category, LocalDate expenseDate, LocalDateTime creationDateTime, boolean deleted) {
        //this.id = id;
        this.expenseTitle = expenseTitle;
        this.method = method;
        this.expensePlace = expensePlace;
        this.expenseAmount = expenseAmount;
        this.category = category;
        this.expenseDate = expenseDate;
        this.creationDateTime = creationDateTime;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpenseTitle() {
        return expenseTitle;
    }

    public void setExpenseTitle(String expenseTitle) {
        this.expenseTitle = expenseTitle;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public String getExpensePlace() {
        return expensePlace;
    }

    public void setExpensePlace(String expensePlace) {
        this.expensePlace = expensePlace;
    }

    public BigDecimal getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(BigDecimal expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public ExpenseCategory getCategory() {
        return category;
    }

    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", expenseTitle='" + expenseTitle + '\'' +
                ", method=" + method +
                ", expensePlace='" + expensePlace + '\'' +
                ", expenseAmount=" + expenseAmount +
                ", category=" + category +
                ", expenseDate=" + expenseDate +
                ", creationDateTime=" + creationDateTime +
                ", deleted=" + deleted +
                '}';
    }
}
