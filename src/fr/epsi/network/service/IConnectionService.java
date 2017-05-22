package fr.epsi.network.service;

import fr.epsi.network.beans.User;

public interface IConnectionService {

	boolean isAdmin(User user);
	
}
