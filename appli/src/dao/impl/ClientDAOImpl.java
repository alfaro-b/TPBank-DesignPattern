package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ClientDAO;
import entities.Client;
import singleton.DatabaseConnection;

/**
 * Implémentation des opérations d'accès aux données des clients avec JDBC.
 */
public class ClientDAOImpl implements ClientDAO {

    // =========================
    // ATTRIBUTS
    // =========================

    private Connection connection;

    // =========================
    // CONSTRUCTEUR
    // =========================

    public ClientDAOImpl() throws SQLException {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    // =========================
    // MÉTHODES
    // =========================

    /**
     * Récupère un client à partir de son identifiant.
     */
    @Override
    public Client findById(int id) throws SQLException {

        String sql = "SELECT * FROM client WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return new Client(
                            rs.getInt("id"),
                            rs.getString("prenom"),
                            rs.getString("nom"),
                            rs.getString("email")
                    );
                }
            }
        }

        return null;
    }

    /**
     * Récupère la liste de tous les clients.
     */
    @Override
    public List<Client> findAll() throws SQLException {

        List<Client> clients = new ArrayList<>();

        String sql = "SELECT * FROM client";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Client client = new Client(
                        rs.getInt("id"),
                        rs.getString("prenom"),
                        rs.getString("nom"),
                        rs.getString("email")
                );

                clients.add(client);
            }
        }

        return clients;
    }
}