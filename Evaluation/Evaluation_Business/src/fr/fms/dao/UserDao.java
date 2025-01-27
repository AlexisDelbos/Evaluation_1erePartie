package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fms.entities.Formation;
import fr.fms.entities.User;

public class UserDao implements Dao<User> {

    /**
     * Méthode qui crée un utilisateur en base sans prendre en compte l'id (généré automatiquement)
     * @param User à ajouter dans la table T_Users
     * @return vrai si l'opération a réussie, faux sinon
     */
    @Override
    public boolean create(User obj) {
        String str = "INSERT INTO T_Users (loginUser, passwordUser) VALUES (?,?);";
        try (PreparedStatement ps = connection.prepareStatement(str)){
            ps.setString(1, obj.getLoginUser());
            ps.setString(2, obj.getPasswordUser());            
            if(ps.executeUpdate() == 1) return true;                
        } catch (SQLException e) {
            logger.severe("Erreur SQL sur la création d'un utilisateur: " + e.getMessage());
        }               
        return false;
    }

    /**
     * Méthode qui renvoie toutes les infos d'un utilisateur à partir de son id s'il existe dans la table T_Users
     * @param id de l'utilisateur
     * @return user si trouvé, null sinon
     */
    @Override
    public User read(int id) {
        String str = "SELECT * FROM T_Users WHERE idUser=?;";
        try (PreparedStatement ps = connection.prepareStatement(str)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return new User(rs.getInt("idUser"), rs.getString("loginUser"), rs.getString("passwordUser"));
            }
        } catch (SQLException e) {
            logger.severe("Erreur SQL lors de la lecture d'un utilisateur: " + e.getMessage());
        }
        return null;
    }

    /**
     * Méthode qui met à jour un utilisateur s'il existe (à partir de son id) dans la table T_Users
     * @param l'utilisateur concerné
     * @return vrai si mise à jour réussie, faux sinon
     */
    @Override
    public boolean update(User obj) {
        String str = "UPDATE T_Users SET loginUser=?, passwordUser=? WHERE idUser=?;";
        try (PreparedStatement ps = connection.prepareStatement(str)){
            ps.setString(1, obj.getLoginUser());
            ps.setString(2, obj.getPasswordUser());
            ps.setInt(3, obj.getIdUser());
            if(ps.executeUpdate() == 1) return true;
        } catch (SQLException e) {
            logger.severe("Erreur SQL lors de la mise à jour d'un utilisateur: " + e.getMessage());
        }
        return false;
    }

    /**
     * Méthode qui supprime un utilisateur à partir de son id (s'il existe) dans la table T_Users
     * @param user
     * @return vrai si suppression réussie, faux sinon
     */
    @Override
    public boolean delete(User obj) {
        String str = "DELETE FROM T_Users WHERE idUser=?;";
        try (PreparedStatement ps = connection.prepareStatement(str)){
            ps.setInt(1, obj.getIdUser());
            if(ps.executeUpdate() == 1) return true;        
        } catch (SQLException e) {
            logger.severe("Erreur SQL lors de la suppression d'un utilisateur: " + e.getMessage());
        }
        return false;
    }

    /**
     * Méthode qui renvoie tous les utilisateurs de la table T_Users
     * @return liste d'utilisateurs
     */
    @Override
    public ArrayList<User> readAll() {
        ArrayList<User> users = new ArrayList<>();
        String str = "SELECT * FROM T_Users;";
        try (PreparedStatement ps = connection.prepareStatement(str)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int rsId = rs.getInt(1);    
                String rsLogin = rs.getString(2);
                String rsPassword = rs.getString(3);
                users.add(new User(rsId, rsLogin, rsPassword));
            }
        } catch (SQLException e) {
            logger.severe("Erreur SQL lors de la récupération de la liste des utilisateurs: " + e.getMessage());
        }
        return users;
    }

    /**
     * Méthode qui renvoie un utilisateur correspondant au login et password saisi
     * @param login
     * @param password
     * @return User si correspond, null sinon
     */
    public User findUserByCredentials(String login, String password) {
        String str = "SELECT * FROM T_Users WHERE loginUser=? AND passwordUser=?;";
        try (PreparedStatement ps = connection.prepareStatement(str)){
            ps.setString(1, login);                                    
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e) {
            logger.severe("Erreur SQL lors de la recherche d'un utilisateur par identifiants: " + e.getMessage());
        }
        return null;
    }

    /**
     * Méthode qui renvoie un utilisateur à partir de son login
     * @param login
     * @return user
     */
    public User findUserByLogin(String login) {
        String str = "SELECT * FROM T_Users WHERE loginUser=?;";
        try (PreparedStatement ps = connection.prepareStatement(str)){
            ps.setString(1, login);                                    
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e) {
            logger.severe("Erreur SQL lors de la recherche d'un utilisateur par login: " + e.getMessage());
        }
        return null;
    }

	@Override
	public ArrayList<Formation> searchWithCharacter(String obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Formation> readAllByTypeFormation(String t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Formation> readAllByCat(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
