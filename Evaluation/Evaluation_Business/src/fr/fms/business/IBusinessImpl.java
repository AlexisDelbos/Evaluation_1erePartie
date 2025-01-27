package fr.fms.business;

import java.util.ArrayList;
import java.util.HashMap;

import fr.fms.dao.Dao;
import fr.fms.dao.DaoFactory;
import fr.fms.entities.Category;
import fr.fms.entities.Customer;
import fr.fms.entities.Formation;
import fr.fms.entities.Order;
import fr.fms.entities.OrderItem;



public class IBusinessImpl implements IBusiness {
	private HashMap<Integer,Formation> cart;
	private Dao<Formation> formationDao = DaoFactory.getFormationDao();
	private Dao<Order> orderDao = DaoFactory.getOrderDao();
	private Dao<OrderItem> orderItemDao = DaoFactory.getOrderItemDao();
	private Dao<Customer> customerDao = DaoFactory.getCustomerDao();
	private Dao<Category> categoryDao = DaoFactory.getCategoryDao();

	
	
	public IBusinessImpl() {
		this.cart = new HashMap<Integer,Formation>();
	}
	


	// Ajouter un article au panier
	@Override
	public void addToCart(Formation formation) {
		Formation formati = cart.get(formation.getIdFormation());
		if(formati != null) {
			formati.setQuantity(formati.getQuantity() + 1);
		}
		else cart.put(formation.getIdFormation(), formation);		
	}

	// Supprimer un article du panier
	@Override
	public void rmFromCart(int id) {
		Formation formation = cart.get(id);
		if(formation != null) {
			if(formation.getQuantity() ==1) cart.remove(id);
			else formation.setQuantity(formation.getQuantity() - 1);
		}		
	}

	// Passer commande
	@Override
	public int order(int idCustomer) {
		if(customerDao.read(idCustomer) != null) {
			double amountTotal = getTotal();
			Order order = new Order(amountTotal, idCustomer);
			if(orderDao.create(order)) {
				for(Formation formation : cart.values()) {
					orderItemDao.create(new OrderItem(0, formation.getIdFormation(), formation.getQuantity(),formation.getPriceFormation(), order.getIdOrder()));
				}
				return order.getIdOrder();

			}
		}
		return 0;
	}


	public double getTotal() {
		double [] total = {0};
		cart.values().forEach((a) -> total[0] += a.getPriceFormation() * a.getQuantity()); 	
		return total[0];
	}

	// Afficher les formations ou le caractère est contenu dans le nom
	@Override
	public ArrayList<Formation> searchWithCharacter(String obj){
		return formationDao.searchWithCharacter(obj);
	}

	// Afficher toutes les formations
	@Override
	public ArrayList<Formation> readFormations() {
		return formationDao.readAll();
	}

	// Afficher une formation
	@Override
	public Formation readOneFormation(int id) {
		return formationDao.read(id);
	}

	// Afficher les formations de la catégorie
	public ArrayList<Formation> readFormationsByCatId(int idCat){
		return formationDao.readAllByCat(idCat);
	}

	
	@Override
	public ArrayList<Formation> getCart() {
		return new ArrayList<Formation> (cart.values());
	}
	
	public ArrayList<Formation> readAllByTypeFormation(String t){
		return formationDao.readAllByTypeFormation(t);
	}
	// Lire les formations par la category
	public Category readOneCategory(int id) {
		return categoryDao.read(id);
	}

	public boolean isCartEmpty() {
		return cart.isEmpty();
	}

	public void clearCart() {
		cart.clear();		
	}


}
