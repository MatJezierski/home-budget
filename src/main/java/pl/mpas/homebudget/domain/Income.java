package pl.mpas.homebudget.domain;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Income {

    private Long id;

    private String title;

    private IncomeSource incomeSource;

    private BigDecimal incomeAmount;

    private LocalDateTime creationDateTime;

    private LocalDate incomeDate;

    private boolean deleted;

    public Income() {
    }

    public Income(Long id, String title, IncomeSource incomeSource, BigDecimal incomeAmount, LocalDateTime creationDateTime, LocalDate incomeDate, boolean deleted) {
        this.id = id;
        this.title = title;
        this.incomeSource = incomeSource;
        this.incomeAmount = incomeAmount;
        this.creationDateTime = creationDateTime;
        this.incomeDate = incomeDate;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public IncomeSource getIncomeSource() {
        return incomeSource;
    }

    public void setIncomeSource(IncomeSource incomeSource) {
        this.incomeSource = incomeSource;
    }

    public BigDecimal getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(BigDecimal incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public LocalDate getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(LocalDate incomeDate) {
        this.incomeDate = incomeDate;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Income{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", incomeSource=" + incomeSource +
                ", incomeAmount=" + incomeAmount +
                ", creationDateTime=" + creationDateTime +
                ", incomeDate=" + incomeDate +
                ", deleted=" + deleted +
                '}';
    }
}
