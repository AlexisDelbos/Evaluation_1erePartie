package fr.fms.dao;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import fr.fms.entities.Category;
import fr.fms.entities.Formation;

public class CategoryDao implements Dao<Category>{

	@Override
	public boolean create(Category obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Category read(int id) {
		try (Statement statement = connection.createStatement()){
			String str = "SELECT * FROM T_Category where idCategory=" + id + ";";									
			ResultSet rs = statement.executeQuery(str);
			if(rs.next()) return new Category(rs.getInt(1) , rs.getString(2) , rs.getString(3));
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		return null;
	}

	@Override
	public boolean update(Category obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Category obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Category> readAll() {
		ArrayList<Category> categories = new ArrayList<Category>();
		String sql = "select * from T_Category";
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(sql)){
				while(resultSet.next()) {
					categories.add(new Category(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
				}
				return categories;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

	@Override
	public ArrayList<Formation> readAllByCat(int id) {
		// TODO Auto-generated method stub
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

}
