package pl.mpas.homebudget.domain;

import org.apache.commons.lang3.builder.ToStringExclude;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "This field can not be empty!")
    @Column(nullable = false)
    private String expenseTitle;

    @NotNull(message = "This field can not be empty!")
    private LocalDateTime creationDateTime;

    @NotNull(message = "This field can not be empty!")
    private PaymentMethod paymentMethod;

    private String expensePlace;

    @NotNull(message = "This field can not be empty!")
    private BigDecimal expenseAmount;

    @ToStringExclude
    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "expense_category_id", nullable = false)
    private ExpenseCategory category;

    private LocalDate expenseDate;

    private boolean deleted;

    public Expense() {
        creationDateTime = LocalDateTime.now();
    }

    public Expense(String expenseTitle, PaymentMethod paymentMethod, String expensePlace, BigDecimal expenseAmount,
                   ExpenseCategory category, LocalDate expenseDate, LocalDateTime creationDateTime, boolean deleted) {
        this.expenseTitle = expenseTitle;
        this.paymentMethod = paymentMethod;
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

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod method) {
        this.paymentMethod = method;
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
                ", creationDateTime=" + creationDateTime +
                ", paymentMethod=" + paymentMethod +
                ", expensePlace='" + expensePlace + '\'' +
                ", expenseAmount=" + expenseAmount +
                ", category=" + category +
                ", expenseDate=" + expenseDate +
                ", deleted=" + deleted +
                '}';
    }
}
