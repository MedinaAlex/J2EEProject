package fr.epsi.network.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import fr.epsi.network.beans.User;

public class UserDAO implements IUserDao {
	
	private static Logger logger = Logger.getLogger(UserDAO.class);

	@Override
	public List<User> getListOfUsers() {
		JDBC con = new JDBC();
		List<User> users= new ArrayList<>();
		ResultSet result;

		try {
			result = con.sqlRequete("select * from users");
			while(result.next()){
	            users.add(new User(result.getString(1), result.getString(2), result.getBoolean(3)));
	        }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User getUserById(String id) {
		JDBC con = new JDBC();
		ResultSet result;
		User user = new User();
		try {
			result = con.sqlRequete("select * from USERS where ID = " + id);
			result.next();
			user = new User(result.getString(1), result.getString(2), result.getBoolean(3));

	        
		} catch (SQLException e) {
		
			logger.debug("Attention aucun User ne correspond à l'id", e);
		}
		return user;
	}

	@Override
	public void addUser(User user) {
		JDBC con = new JDBC();

		try {
			
			Connection connexion = con.getConnection();
			PreparedStatement ppr = connexion.prepareStatement("insert into users values(?, ?, ?)");
			ppr.setString(1, user.getId());
			ppr.setString(2, user.getPassword());
			ppr.setBoolean(3, user.getAdministrator());
			
			ppr.executeUpdate();
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}

	}

	@Override
	public void updateUser(User user) {
		JDBC con = new JDBC();
		
		try {
			Connection connexion = con.getConnection();
			PreparedStatement ppr = connexion.prepareStatement("UPDATE users set PASSWORD = ?, ISADMINISTRATOR = ? WHERE id = ?");
			ppr.setString(1, user.getPassword());
			ppr.setBoolean(2, user.getAdministrator());
			ppr.setString(3, user.getId());
			ppr.executeUpdate();
			connexion.close();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteUser(User user) {
		JDBC con = new JDBC();

		try {
			con.sqlRequete("delete from users where id = "+ user.getId());
			logger.info("User " + user.getId() + " supprimé");
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
