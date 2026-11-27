package factory;

import java.math.BigDecimal;

import entities.Account;
import entities.Client;
import entities.CurrentAccount;
import entities.SavingsAccount;

/**
 * Centralise la création des différents types de comptes bancaires.
 */
public class AccountFactory {

    // =========================
    // MÉTHODES
    // =========================

    /**
     * Crée un compte bancaire en fonction de son type.
     *
     * @param type type de compte
     * @param id identifiant du compte
     * @param accountNumber numéro du compte
     * @param balance solde du compte
     * @param client propriétaire du compte
     * @param interestRate taux d'intérêt du compte épargne
     * @return compte bancaire correspondant au type demandé
     * @throws IllegalArgumentException si le type est inconnu
     */
    public static Account createAccount(String type, int id,
            String accountNumber, BigDecimal balance,
            Client client, BigDecimal interestRate) {

    	if (type != null && type.equals("CURRENT")) {
            return new CurrentAccount(id, accountNumber,
                    balance, client);

        } else if (type != null && type.equals("SAVINGS")) {

            return new SavingsAccount(id, accountNumber,
                    balance, client, interestRate);

        } else {

            throw new IllegalArgumentException(
                    "Type de compte inconnu : " + type);
        }
    }
}