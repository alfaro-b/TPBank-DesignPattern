package application;

import java.sql.SQLException;

import singleton.DatabaseConnection;

/**
 * Point d'entrée de l'application bancaire.
 */
public class Main {

    public static void main(String[] args) {

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
    }
}