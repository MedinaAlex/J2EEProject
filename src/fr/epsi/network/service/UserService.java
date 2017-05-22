package fr.epsi.network.service;

import java.util.List;

import fr.epsi.network.beans.User;
import fr.epsi.network.dao.UserDAO;

public class UserService implements IUserService {
	UserDAO userDao = new UserDAO();
	
	public UserService() {
		super();
	}

	@Override
	public List<User> getListOfUsers() {
		return userDao.getListOfUsers();
	}

	@Override
	public User getUserById(String id) {
		return userDao.getUserById(id);
	}

	@Override
	public void addUser(User user) throws Exception {
		User getUser = userDao.getUserById(user.getId());
		if(getUser.getId() == null){
			userDao.addUser(user);
		}else{
			throw new Exception("User déjà existant");
		}
		
		
		
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}

	@Override
	public void deleteUser(User user) {
		userDao.deleteUser(user);
		
	}

}
