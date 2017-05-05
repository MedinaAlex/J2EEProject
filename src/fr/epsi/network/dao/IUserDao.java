package fr.epsi.network.dao;

import java.util.List;

import fr.epsi.network.beans.User;

public interface IUserDao {

	List<User> getListOfUsers();
	User getUserById(String id);
	void addUser(User user);
	void updateUser(User user);
	void deleteUser(User user);
	
}
