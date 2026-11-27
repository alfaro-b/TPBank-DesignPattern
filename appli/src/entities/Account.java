package entities;

import java.math.BigDecimal;

/**
 * Représente un compte bancaire.
 * Regroupe les caractéristiques et les comportements communs aux différents types de comptes.
 */
public abstract class Account {

    // =========================
    // ATTRIBUTS
    // =========================

    private int id;
    private String accountNumber;
    private BigDecimal balance;
    private Client client;
    

    // =========================
    // CONSTRUCTEUR
    // =========================

    protected Account(int id, String accountNumber, BigDecimal balance, Client client) {
        this.id = id;
        this.accountNumber = accountNumber;        
        this.balance = balance;
        this.client = client;
    }

    // =========================
    // ACCESSEURS
    // =========================

    public int getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    
    public BigDecimal getBalance() {
        return balance;
    }

    public Client getClient() {
        return client;
    }

    // =========================
    // MÉTHODES
    // =========================

    /**
     * Augmente le solde du compte.
     *
     * @param amount montant à déposer
     */
    public void deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    /**
     * Diminue le solde du compte.
     *
     * @param amount montant à retirer
     */
    public void withdraw(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }

    @Override
    public String toString() {
        return "Account [id=" + id
        		+ ", accountNumber=" + accountNumber
                + ", balance=" + balance
                + ", client=" + client + "]";
    }
}