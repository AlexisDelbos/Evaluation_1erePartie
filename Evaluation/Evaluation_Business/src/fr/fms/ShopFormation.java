package fr.fms;

import fr.fms.authentication.Authenticate;
import fr.fms.business.IBusinessImpl;
import fr.fms.entities.Category;
import fr.fms.entities.Customer;
import fr.fms.entities.Formation;
import java.util.List;
import java.util.Scanner;

public class ShopFormation {
	
	private static Scanner scan = new Scanner(System.in);
	private static IBusinessImpl business = new IBusinessImpl();
	private static Authenticate authenticate = new Authenticate();

    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_NAME = "NOM";
    private static final String COLUMN_DESCRIPTION = "DESCRIPTION";
    private static final String COLUMN_CATEGORY = "CATEGORY";
    private static final String COLUMN_DURING = "DUREE";
    private static final String COLUMN_PRICE = "PRIX";
    private static final String COLUMN_QUANTITY = "QUANTITE";


	private static int idUser = 0;
	private static String login = null; 
	
	public static void main(String[] args) {
		System.out.println(" ____  _                   _____                          _   _             \r\n"
	            + "/ ___|| |__   ___  _ __   |  ___|__  _ __ _ __ ___   __ _| |_(_) ___  _ __  \r\n"
	            + "\\___ \\| '_ \\ / _ \\| '_ \\  | |_ / _ \\| '__| '_ ` _ \\ / _` | __| |/ _ \\| '_ \\ \r\n"
	            + " ___) | | | | (_) | |_) | |  _| (_) | |  | | | | | | (_| | |_| | (_) | | | |\r\n"
	            + "|____/|_| |_|\\___/| .__/  |_|  \\___/|_|  |_| |_| |_|\\__,_|\\__|_|\\___/|_| |_|\r\n"
	            + "                  |_|                                                       ");
		int choice = 0;
	    while (choice != 11) {  
	    	displayMenu();
	        choice = scanInt();
	        scan.nextLine();
	        switch (choice) {
	        case 1:
	                displayAllFormations();
	                break;
	            case 2:
	                displayFormationsByCategory();
	                break;
	            case 3:
	                searchFormationsByKeyword();
	                break;
	            case 4:
	                displayFormationsByType("presentiel");
	                break;
	            case 5:
	                displayFormationsByType("distanciel");
	                break;
	            case 6:
	                addFormation(); 
	                break;
	            case 7:
	                removeFormation();
	                break;
	            case 8:
	            	displayCart(true); 
	                break;
	            case 9:
	            	connection();
	                break;
	            default:
	                System.out.println("Choix invalide, veuillez réessayer.");
	        }
	    }
	}

	public static void displayMenu() {
	    System.out.println();
	    if(login != null) {
	        System.out.println("👤 Bonjour : " + login);  // Icône utilisateur
	    }
	    System.out.println("========= Menu du Shop =========");
	    System.out.println("1. 📋 Afficher toutes les formations");
	    System.out.println("2. 📂 Afficher les formations par catégorie");
	    System.out.println("3. 🔍 Rechercher des formations par mot-clé");
	    System.out.println("4. 🏫 Afficher les formations en présentiel");
	    System.out.println("5. 💻 Afficher les formations en distanciel");
	    System.out.println("6. 🛒 Ajouter un article au panier");
	    System.out.println("7. 🗑️ Retirer un article du panier");
	    System.out.println("8. 💳 Passer une commande");
	    System.out.println("9. 🔐 Se Connecter / Déconnecter");
	    System.out.print("Choisissez une option : ");
	}

    /**
     * Méthode qui affiche toutes les formations disponibles
     */
    public static void displayAllFormations() {
    	
		System.out.printf("-------------------------------------------------------------------------------------------------------------------------------%n");
		System.out.printf("|%-10s | %-15s | %-45s | %-10s | %-10s | %-20s |%n",COLUMN_ID,COLUMN_NAME,COLUMN_DESCRIPTION, COLUMN_DURING, COLUMN_PRICE, COLUMN_CATEGORY);
		System.out.printf("|-------------------------------------------------------------------------------------------------------------------------------%n");
		business.readFormations().forEach( c -> System.out.printf("|%-10s | %-15s | %-45s | %-10s | %-10s | %-20s |%n",c.getIdFormation(),c.getNameFormation(),c.getDescriptionFormation(),c.getDurationFormation(),c.getPriceFormation(),c.getNameCategory()));	
		System.out.printf("-------------------------------------------------------------------------------------------------------------------------------%n");

    }

    /**
     * Méthode qui affiche les formations par catégorie
     */
    private static void displayFormationsByCategory() {
        System.out.print("Entrez l'ID de la catégorie : ");
        int id = scanInt();
        Category category = business.readOneCategory(id);
        if(category != null) {
        	System.out.printf("AFFICHAGE PAR CATEGORIE : %s   %n", category.getNameCategory());
        	System.out.printf("-------------------------------------------------------------------------------------------------------------------------------%n");
    		System.out.printf("|%-10s | %-15s | %-45s | %-10s | %-10s | %-20s |%n",COLUMN_ID,COLUMN_NAME,COLUMN_DESCRIPTION, COLUMN_DURING, COLUMN_PRICE, COLUMN_CATEGORY);
    		System.out.printf("|-------------------------------------------------------------------------------------------------------------------------------%n");
    		business.readFormationsByCatId(id).forEach( c -> System.out.printf("|%-10s | %-15s | %-45s | %-10s | %-10s | %-20s |%n",c.getIdFormation(),c.getNameFormation(),c.getDescriptionFormation(),c.getDurationFormation(),c.getPriceFormation(),c.getNameCategory()));	
    		System.out.printf("-------------------------------------------------------------------------------------------------------------------------------%n");


        }
		else System.out.println("Categorie non trouvé !");

    }

    /**
     * Méthode qui recherche des formations par mot-clé
     */
    public static void searchFormationsByKeyword() {
        System.out.print("Entrez un mot-clé : ");
        String keyword = scan.nextLine();
        System.out.printf("-------------------------------------------------------------------------------------------------------------------------------%n");
		System.out.printf("|%-10s | %-15s | %-45s | %-10s | %-10s | %-20s |%n",COLUMN_ID,COLUMN_NAME,COLUMN_DESCRIPTION, COLUMN_DURING, COLUMN_PRICE, COLUMN_CATEGORY);
		System.out.printf("|-------------------------------------------------------------------------------------------------------------------------------%n");
		business.searchWithCharacter(keyword).forEach( c -> System.out.printf("|%-10s | %-15s | %-45s | %-10s | %-10s | %-20s |%n",c.getIdFormation(),c.getNameFormation(),c.getDescriptionFormation(),c.getDurationFormation(),c.getPriceFormation(),c.getNameCategory()));	
		System.out.printf("-------------------------------------------------------------------------------------------------------------------------------%n");


    }

    /**
     * Méthode qui affiche les formations par type (présentiel ou distanciel)
     */
    public static void displayFormationsByType(String type) {
    	System.out.printf("------------------------------------------------" + type.toUpperCase() + "-------------------------------------------------------------------------------%n");
		System.out.printf("|%-10s | %-15s | %-45s | %-10s | %-10s | %-20s |%n",COLUMN_ID,COLUMN_NAME,COLUMN_DESCRIPTION, COLUMN_DURING, COLUMN_PRICE, COLUMN_CATEGORY);
		System.out.printf("|-------------------------------------------------------------------------------------------------------------------------------%n");
		business.readAllByTypeFormation(type).forEach( c -> System.out.printf("|%-10s | %-15s | %-45s | %-10s | %-10s | %-20s |%n",c.getIdFormation(),c.getNameFormation(),c.getDescriptionFormation(),c.getDurationFormation(),c.getPriceFormation(),c.getNameCategory()));	
		System.out.printf("-------------------------------------------------------------------------------------------------------------------------------%n");

    }

    // Méthode qui affiche tous les articles en base en centrant le texte 

    public static void printFormations(List<Formation> formations) {
        System.out.printf("---------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("%-10s | %-15s | %-50s | %-15s | %-5s | %-5s |%n", 
                COLUMN_ID, COLUMN_NAME, COLUMN_DESCRIPTION, COLUMN_CATEGORY, COLUMN_DURING, COLUMN_PRICE);
        System.out.printf("---------------------------------------------------------------------------------------------------------------------%n");

        if (formations.isEmpty()) {
            System.out.println("Aucune formation trouvée.");
        } else {
            formations.forEach(a -> System.out.printf("%-10s | %-15s | %-50s | %-15s | %-5s | %-5s |%n",
                    a.getIdFormation(), a.getNameFormation(), a.getDescriptionFormation(), a.getTypeFormation(), a.getDurationFormation(), a.getPriceFormation()));
        }

        System.out.printf("---------------------------------------------------------------------------------------------------------------------%n");
    }
    

	
	/**
	 * Méthode qui affiche le contenu du panier + total de la commande + propose de passer commande
	 */
	private static void displayCart(boolean flag) {
		if(business.isCartEmpty()) 	System.out.println("PANIER VIDE");
		else {
			System.out.println("CONTENU DU PANIER :");
			System.out.printf("------------------------------------------------------------------------------------------------------------------------%n");
			System.out.printf("%-10s | %-25s | %-50s | %-15s | %-25s %n",COLUMN_ID,COLUMN_NAME,COLUMN_DESCRIPTION,COLUMN_PRICE,COLUMN_QUANTITY);
			System.out.printf("------------------------------------------------------------------------------------------------------------------------%n");
			business.getCart().forEach( a -> System.out.printf("%-10s | %-25s | %-50s | %-15s | %-25s %n",a.getIdFormation(),a.getNameFormation(),a.getDescriptionFormation(), a.getPriceFormation(), a.getQuantity()));
			System.out.printf("------------------------------------------------------------------------------------------------------------------------%n");
			if(flag) {
				System.out.println("MONTANT TOTAL : " + business.getTotal());
				System.out.println("Souhaitez vous passer commande ? Oui/Non :");
				if(scan.next().equalsIgnoreCase("Oui")) {
					nextStep();
				}
			}
		}
	}
	
	private static void nextStep() {
		if(login == null)	{ 
			System.out.println("Vous devez être connecté pour continuer");
			connection();
		}
		if(login != null) {
			int idCustomer = newCustomer(idUser);	
			if(idCustomer != 0) {
				int idOrder = business.order(idCustomer);	
				if(idOrder == 0)	System.out.println("pb lors du passage de commande");
				else {
					System.out.println("Votre commande a bien été validé, voici son numéro : " + idOrder);
					business.clearCart();
				}
			}
		}
	}

	/**
	 * Méthode qui ajoute un client en base s'il n'existe pas déjà 
	 * @return id du client afin de l'associer à la commande en cours
	 */
	private static int newCustomer(int idUser) {
		System.out.println("Avez vous déjà un compte client ? Saisissez une adresse email valide :");
		String mailCustomer = scan.next();		
		if(isValidEmail(mailCustomer)) {	
			Customer customer = authenticate.existCustomerByEmail(mailCustomer);
			if(customer == null) {
				System.out.println("Nous n'avons pas de compte client associé, nous allons le créer ");
				scan.nextLine();	
				System.out.println("saisissez votre nom :");
				String nameCustomer = scan.nextLine();
				System.out.println("saisissez votre prénom :");
				String surnameCustomer = scan.next();					
				System.out.println("saisissez votre tel :");
				String phoneCustomer = scan.next();		
				scan.nextLine(); 
				System.out.println("saisissez votre adresse :");
				String addressCustomer = scan.nextLine();
				Customer cust = new Customer(nameCustomer, surnameCustomer, mailCustomer, phoneCustomer, addressCustomer, idUser); 
				if(authenticate.addCustomer(cust))	
					return authenticate.existCustomerByEmail(mailCustomer).getIdCustomer();
			}
			else {
				System.out.println("Nous allons associer la commande en cours avec le compte client : " + customer);
				return customer.getIdCustomer();
			}
		}
		else System.out.println("vous n'avez pas saisi un email valide");	
		return 0;
	}

	/**
	 * Méthode qui réalise la connexion/deconnexion d'un utilisateur
	 * si l'utilisateur n'existe pas, il lui est proposé d'en créer un
	 */
	private static void connection() {
	    if(login != null) {
	        System.out.println("🔓 Souhaitez-vous vous déconnecter ? Oui/Non");
	        String response = scan.next();
	        if(response.equalsIgnoreCase("Oui")) {
	            System.out.println("A bientôt 👋 " + login);  // Icône de salutation
	            login = null;
	            idUser = 0;
	        }                
	    } else {
	        System.out.println("🔑 saisissez votre login : ");
	        String log = scan.next();
	        System.out.println("🔒 saisissez votre password : ");
	        String pwd = scan.next();
	        
	        int id = authenticate.existUser(log,pwd);
	        if(id > 0) {
	            login = log;
	            idUser = id;
	            System.out.println("✅ Connexion réussie !");
	        } else {
	            System.out.println("❌ Login ou password incorrect");
	            System.out.println("Nouvel utilisateur, pour créer un compte, tapez 'ok'");
	            String ok = scan.next();
	            if(ok.equalsIgnoreCase("ok")) {
	                newUser();
	            }
	        }
	    }
	}

	/**
	 * Méthode qui ajoute un nouvel utilisateur en base
	 */
	public static void newUser() {
		System.out.println("saisissez un login :");
		String login = scan.next();			
		int id = authenticate.existUser(login);	
		if(id == 0) { 
			System.out.println("saisissez votre password :");
			String password = scan.next();
			authenticate.addUser(login,password);		
			System.out.println("Ne perdez pas ces infos de connexion...");
			System.out.println("création de l'utilisateur terminé, merci de vous connecter");
		}
		else	System.out.println("Login déjà existant en base, veuillez vous connecter");
	}
	
	// Méthode qui supprime un article du panier
	 
	public static void removeFormation() {
	        displayCart(false); 
	        if (business.isCartEmpty()) {
	            System.out.println("Le panier est vide, aucun article à retirer.");
	            return;
	        }        
	        System.out.println("Sélectionnez l'ID de la formation à supprimer du panier :");
	        int id = scanInt();
	        business.rmFromCart(id);
	        displayCart(false);
	    
	}


	// Méthode qui ajoute un article au panier
	
	public static void addFormation() {
			displayAllFormations();
	        System.out.println("Selectionner l'id de la formation à ajouter au panier");
	        int id = scanInt();
	        Formation formation = business.readOneFormation(id);
	        if (formation != null) {
	            business.addToCart(formation);
	            displayCart(false);
	        } else {
	            System.out.println("La formation n'existe pas");
	        }
	    
	}

	// Méthode qui permet de vérifier si c'est un int
	
	public static int scanInt() {
		while(!scan.hasNextInt()) {
			System.out.println("saisissez une valeur entière svp");
			scan.next();
		}
		return scan.nextInt();
	}
	
	public static boolean isValidEmail(String email) {
		String regExp = "^[A-Za-z0-9._-]+@[A-Za-z0-9._-]+\\.[a-z][a-z]+$";	
		return email.matches(regExp);
	}
	
	
}
