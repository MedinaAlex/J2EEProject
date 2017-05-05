package fr.epsi.network.service;

import java.util.List;

import fr.epsi.network.beans.User;

public interface IUserService {

	List<User> getListOfUsers();
	User getUserById(String id);
	void addUser(User user);
	void updateUser(User user);
	void deleteUser(User user);

}
