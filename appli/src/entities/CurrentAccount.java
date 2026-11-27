package entities;

import java.math.BigDecimal;

/**
 * Représente un compte courant.
 */
public class CurrentAccount extends Account {

    // =========================
    // CONSTRUCTEUR
    // =========================

    public CurrentAccount(int id, String accountNumber, BigDecimal balance, Client client) {
        super(id, accountNumber, balance, client);
    }
}