package application;

import java.sql.SQLException;

import singleton.DatabaseConnection;
import java.math.BigDecimal;

import entities.Account;
import entities.Client;
import entities.SavingsAccount;
import factory.AccountFactory;
import dao.ClientDAO;
import dao.impl.ClientDAOImpl;

/**
 * Point d'entrée de l'application bancaire.
 */
public class Main {

    public static void main(String[] args) {
    	
    	// Test du Singleton pour la conexion à la bdd
    	
        try {
            // Premier appel : la connexion est créée
            DatabaseConnection conn1 = DatabaseConnection.getInstance();

            // Deuxième appel : réutilisation de l'instance existante
            DatabaseConnection conn2 = DatabaseConnection.getInstance();

            // Vérification de la connexion à la base de données
            System.out.println("Connexion valide : "
                    + conn1.getConnection().isValid(2));

            // Vérification du fonctionnement du Singleton
            if (conn1 == conn2) {
                System.out.println("C'est exactement le même objet de connexion.");
            } else {
                System.out.println("Les deux objets de connexion sont différents.");
            }

        } catch (SQLException e) {
            System.err.println("Erreur de connexion : " + e.getMessage());
        }
        
        // Test de la Factory pour la création d'un compte
        
        // Création d'un client de test
        Client client = new Client(1, "Jean", "Dupont", "jean@email.com");

        // Création d'un compte courant
        Account account1 = AccountFactory.createAccount(
                "CURRENT", 1, "FR76300020001",
                new BigDecimal("1500.50"), client, null);

        // Création d'un compte épargne
        Account account2 = AccountFactory.createAccount(
                "SAVINGS", 2, "FR76300020002",
                new BigDecimal("3200.00"), client,
                new BigDecimal("0.03"));

        // Vérification des types d'objets créés
        System.out.println(account1.getClass().getSimpleName());
        System.out.println(account2.getClass().getSimpleName());

        // Vérification du calcul des intérêts
        if (account2 instanceof SavingsAccount) {
            SavingsAccount savingsAccount = (SavingsAccount) account2;

            System.out.println("Intérêts : "
                    + savingsAccount.calculateInterest() + " euros");
        }
        
        // Vérification de la gestion d'un type de compte invalide
        try {
            AccountFactory.createAccount(
                    "UNKNOWN", 3, "TEST",
                    new BigDecimal("100.00"), client, null);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        // Test du DAO pour la récupération des clients
        try {
            ClientDAO clientDAO = new ClientDAOImpl();

            // Récupération d'un client par son identifiant
            System.out.println("\nClient avec l'identifiant 1 :");
            System.out.println(clientDAO.findById(1));

            // Récupération de tous les clients
            System.out.println("\nListe des clients :");

            for (Client clientFromDb : clientDAO.findAll()) {
                System.out.println(clientFromDb);
            }

        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
    }
}