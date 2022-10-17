package pl.mpas.homebudget.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "Expense_Category")
public class ExpenseCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name of the category is mandatory!")
    private String categoryName;

    private LocalDateTime creationDateTime;

    private boolean deleted;

    public ExpenseCategory() {

        creationDateTime = LocalDateTime.now();
    }

    public ExpenseCategory(LocalDateTime creationDateTime, String categoryName, boolean deleted) {
        this.creationDateTime = creationDateTime;
        this.categoryName = categoryName;
        this.deleted = deleted;
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

    @Override
    public String toString() {
        return "ExpenseCategory{" +
                "id=" + id +
                ", creationDateTime=" + creationDateTime +
                ", categoryName='" + categoryName + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
