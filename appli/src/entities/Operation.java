package entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Représente une opération bancaire effectuée sur un compte.
 * Une opération correspond à un dépôt ou à un retrait.
 */
public class Operation {

    // =========================
    // CONSTANTES
    // =========================

    public static final String DEPOSIT = "DEPOSIT";
    public static final String WITHDRAWAL = "WITHDRAWAL";

    // =========================
    // ATTRIBUTS
    // =========================

    private int id;
    private BigDecimal amount;
    private String type;
    private LocalDateTime date;
    private Account account;

    // =========================
    // CONSTRUCTEUR
    // =========================

    public Operation(int id, BigDecimal amount, String type, LocalDateTime date, Account account) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.date = date;
        this.account = account;
    }

    // =========================
    // ACCESSEURS
    // =========================

    public int getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Account getAccount() {
        return account;
    }

    // =========================
    // MÉTHODES
    // =========================

    @Override
    public String toString() {
        return "Operation [id=" + id
                + ", amount=" + amount
                + ", type=" + type
                + ", date=" + date
                + ", accountId=" + account.getId() + "]";
    }
}