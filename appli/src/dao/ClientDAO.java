package dao;

import java.sql.SQLException;
import java.util.List;

import entities.Client;

/**
 * Définit les opérations d'accès aux données des clients.
 */
public interface ClientDAO {

    /**
     * Récupère un client à partir de son identifiant.
     */
    Client findById(int id) throws SQLException;

    /**
     * Récupère la liste de tous les clients.
     */
    List<Client> findAll() throws SQLException;

}