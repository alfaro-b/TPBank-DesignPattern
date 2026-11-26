package entities;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Représente un compte épargne permettant de calculer des intérêts à partir du solde et du taux d'intérêt.
 */
public class SavingsAccount extends Account {

    // =========================
    // ATTRIBUTS
    // =========================

    private BigDecimal interestRate;

    // =========================
    // CONSTRUCTEUR
    // =========================

    public SavingsAccount(int id, BigDecimal balance, Client client, BigDecimal interestRate) {
        super(id, balance, client);
        this.interestRate = interestRate;
    }

    // =========================
    // ACCESSEURS
    // =========================

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    // =========================
    // MÉTHODES
    // =========================

    /**
     * Calcule les intérêts du compte à partir du solde actuel.
     * Le taux d'intérêt est exprimé sous forme décimale.
     *
     * @return montant des intérêts arrondi à deux décimales
     */
    public BigDecimal calculateInterest() {
        return getBalance()
                .multiply(interestRate)
                .setScale(2, RoundingMode.HALF_UP);
    }
}