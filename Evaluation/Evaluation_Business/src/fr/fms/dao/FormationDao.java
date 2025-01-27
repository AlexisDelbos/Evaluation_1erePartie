package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fms.entities.Formation;


public class FormationDao implements Dao<Formation> {
	
	/**
	 * Méthode qui renvoi toutes les infos d'une formation à partir de son id s'il existe dans la table T_formations
	 * @param id de la formation 
	 * @return formation si trouvé, null sinon
	 */
	@Override
	public Formation read(int idFormation) {
	    String sql = "SELECT * FROM T_formations WHERE idFormation = ?";
	    try (PreparedStatement ps = connection.prepareStatement(sql)) {
	        ps.setInt(1, idFormation);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                return new Formation(
	                    rs.getInt(1), 
	                    rs.getString(2), 
	                    rs.getString(3), 
	                    rs.getInt(4), 
	                    rs.getString(5), 
	                    rs.getDouble(6), 
	                    rs.getInt(7)
	                );
	            }
	        }
	    } catch (SQLException e) {
	        logger.severe("pb sql sur la lecture d'une formation : " + e.getMessage());
	    }
	    return null;
	}

	/**
	 * Méthode qui renvoi toutes les formations de la table T_Formations
	 * @return liste de formation
	 */
	@Override
	public ArrayList<Formation> readAll() {
	    ArrayList<Formation> formations = new ArrayList<>();
	    String sql = "SELECT *, nameCategory FROM T_formations INNER JOIN T_category ON T_formations.idCategory = T_category.idCategory";
	    try (PreparedStatement ps = connection.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {
	        while (rs.next()) {
	            formations.add(new Formation(
	                rs.getInt(1), 
	                rs.getString(2), 
	                rs.getString(3), 
	                rs.getInt(4), 
	                rs.getString(5), 
	                rs.getDouble(6), 
	                rs.getInt(7), 
	                rs.getString(9)
	            ));
	        }
	    } catch (SQLException e) {
	        logger.severe("pb sql sur le retour de toutes les formations : " + e.getMessage());
	    }
	    return formations;
	}

	/**
	 * Méthode qui recherche une formation avec une lettre donnée
	 * @param t 
	 * @return 
	 * @return liste d'articles
	 */
	public ArrayList<Formation> searchWithCharacter(String character) {
		ArrayList<Formation> formations = new ArrayList<>();
	    String sql = "SELECT * FROM T_formations WHERE nameFormation LIKE ?";
	    try (PreparedStatement ps = connection.prepareStatement(sql)) {
	        ps.setString(1, "%" + character + "%");
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            int idFormation = rs.getInt(1);
	            String nameFormation = rs.getString(2);
	            String descriptionFormation = rs.getString(3);
	            int durationFormation = rs.getInt(4);
	            String typeFormation = rs.getString(5);
	            double priceFormation = rs.getDouble(6);
	            int nameCategory = rs.getInt(7);

	            formations.add( new Formation(idFormation, nameFormation, descriptionFormation, durationFormation, typeFormation, priceFormation, nameCategory));
	        }
	    } catch (SQLException e) {
	        logger.severe("pb sql sur la recherche d'une formation : " + e.getMessage());
	    }
	    return formations;
	}
	
	/**
	 * Méthode qui renvoi toutes les formations d'une catégorie
	 * @param id de la catégorie
	 * @return liste de formation
	 */
	public ArrayList<Formation> readAllByCat(int id) {
	    ArrayList<Formation> formations = new ArrayList<>();
	    String sql = "SELECT *, nameCategory FROM T_formations INNER JOIN T_category ON T_formations.idCategory = T_category.idCategory WHERE T_formations.idCategory = ?";
	    try (PreparedStatement ps = connection.prepareStatement(sql)) {
	        ps.setInt(1, id);
	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                formations.add(new Formation(
	                    rs.getInt(1), 
	                    rs.getString(2), 
	                    rs.getString(3), 
	                    rs.getInt(4), 
	                    rs.getString(5), 
	                    rs.getDouble(6), 
	                    rs.getInt(7),
	                    rs.getString("nameCategory")
	                ));
	            }
	        }
	    } catch (SQLException e) {
	        logger.severe("pb sql sur le retour des formations par catégorie : " + e.getMessage());
	    }
	    return formations;
	}

	
	/**
	 * Méthode qui renvoi toutes les formations d'une catégorie
	 * @param id de la catégorie
	 * @return liste de formation
	 */
	public ArrayList<Formation> readAllByTypeFormation(String t) {
	    ArrayList<Formation> formations = new ArrayList<>();
	    String sql = "SELECT *, nameCategory FROM T_formations INNER JOIN T_category ON T_formations.idCategory = T_category.idCategory WHERE typeFormation = ?";
	    try (PreparedStatement ps = connection.prepareStatement(sql)) {
	        ps.setString(1, t);
	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                formations.add(new Formation(
		                    rs.getInt(1), 
		                    rs.getString(2), 
		                    rs.getString(3), 
		                    rs.getInt(4), 
		                    rs.getString(5), 
		                    rs.getDouble(6), 
		                    rs.getInt(7),
		                    rs.getString("nameCategory")
	                ));
	            }
	        }
	    } catch (SQLException e) {
	        logger.severe("pb sql sur le retour des formations par type : " + e.getMessage());
	    }
	    return formations;
	}

	@Override
	public boolean create(Formation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Formation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Formation obj) {
		// TODO Auto-generated method stub
		return false;
	}



}
