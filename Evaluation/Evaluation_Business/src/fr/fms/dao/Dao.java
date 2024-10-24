package fr.fms.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Logger;

import fr.fms.entities.Formation;

public interface Dao<T> {
	
	public static Connection connection = BddConnection.getConnection();

	public static final Logger logger = Logger.getLogger(Dao.class.getName());

	/**
	 * ajout d'une nouvelle occurence en base
	 * @param obj correspond à un enregistrement
	 */
	public boolean create(T obj);	
	
	/**
	 * renvoi un objet correspondant à l'id en base
	 * @param id de l'objet
	 * @return l'objet correspondant, si non trouvé, renvoi null
	 */
	public T read(int id);		

	/**
	 * met à jour l'objet en base
	 * @param obj
	 * @return vrai si c'est fait, sinon faux
	 */
	public boolean update(T obj);	
	
	/**
	 * supprime un objet en base
	 * @param obj
	 * @return vrai si c'est fait, sinon faux
	 */
	public boolean delete(T obj);	
	

	// Méthode qui permet d'afficher toutes les formations
	public ArrayList<T> readAll();	
	
	// Méthode qui permet d'afficher les formations affilié à une catégorie
	public ArrayList<Formation> readAllByCat(int id);
	
	// Méthode qui permet d'afficher avec une lettre
	public ArrayList<Formation> searchWithCharacter(String obj);
	
	// Méthode pour savoir si c'est présentiel ou non
	public ArrayList<Formation> readAllByTypeFormation(String t);




}
