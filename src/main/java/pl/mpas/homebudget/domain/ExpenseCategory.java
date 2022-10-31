package pl.mpas.homebudget.domain;

import org.apache.commons.lang3.builder.ToStringExclude;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "expense_category")
public class ExpenseCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name of the category is mandatory!")
    private String categoryName;

    private LocalDateTime creationDateTime;

    private boolean deleted;

    @ToStringExclude
    @OneToMany(mappedBy = "category")
    private Set<Expense> expenses;

    public ExpenseCategory() {
        creationDateTime = LocalDateTime.now();
    }

    public ExpenseCategory(String categoryName, LocalDateTime creationDateTime, boolean deleted, Set<Expense> expenses) {
        this.categoryName = categoryName;
        this.creationDateTime = creationDateTime;
        this.deleted = deleted;
        this.expenses = expenses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Set<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(Set<Expense> expenses) {
        this.expenses = expenses;
    }

    @Override
    public String toString() {
        return "ExpenseCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", creationDateTime=" + creationDateTime +
                ", deleted=" + deleted +
                ", expenses=" + expenses +
                '}';
    }
}
