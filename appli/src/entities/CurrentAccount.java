package entities;

import java.math.BigDecimal;

/**
 * Représente un compte courant.
 */
public class CurrentAccount extends Account {

    // =========================
    // CONSTRUCTEUR
    // =========================

    public CurrentAccount(int id, BigDecimal balance, Client client) {
        super(id, balance, client);
    }
}