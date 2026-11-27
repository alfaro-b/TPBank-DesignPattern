package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Centralise la connexion à la base de données.
 * Garantit une instance unique grâce au pattern Singleton.
 */
public class DatabaseConnection {

    // =========================
    // ATTRIBUTS
    // =========================

    private static DatabaseConnection instance;

    private String url;
    private String user;
    private String password;
    private Connection connection;

    // =========================
    // CONSTRUCTEUR
    // =========================

    private DatabaseConnection() throws SQLException {
        this.url = System.getenv("DB_URL");
        this.user = System.getenv("DB_USER");
        this.password = System.getenv("DB_PASSWORD");

        this.connection = DriverManager.getConnection(url, user, password);
    }

    // =========================
    // MÉTHODES
    // =========================

    /**
     * Retourne l'instance unique du Singleton.
     *
     * @return instance de DatabaseConnection
     * @throws SQLException si la connexion échoue
     */
    public static synchronized DatabaseConnection getInstance()
            throws SQLException {

        if (instance == null) {
            instance = new DatabaseConnection();
        }

        return instance;
    }

    /**
     * Retourne la connexion JDBC à la base de données.
     *
     * @return connexion à la base de données
     */
    public Connection getConnection() {
        return connection;
    }
}