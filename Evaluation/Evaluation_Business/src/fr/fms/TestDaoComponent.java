package fr.fms;

import fr.fms.dao.FormationDao;
import fr.fms.entities.Formation;

public class TestDaoComponent {

	public static void main(String[] args) {
		
		FormationDao formation1 = new FormationDao();
		
		// Chercher une formation
		System.out.println("-------------------------------------------");
		System.out.println(formation1.read(3));
		
		// Chercher par un caractère
		System.out.println("-------------------------------------------");
		System.out.println(formation1.searchWithCharacter("j"));
		
		// Méthode Read ALL
		System.out.println("-------------------------------------------");
		for(Formation formations : new FormationDao().readAll()) {
			System.out.println(formations);
		}
		
		// Chercher par catégorie
		System.out.println("-------------------------------------------");
		System.out.println(formation1.readAllByCat(2));
		
		// Chercher si distanciel ou non
		System.out.println("-------------------------------------------");
		System.out.println(formation1.readAllByTypeFormation("distanciel"));

	}

}
