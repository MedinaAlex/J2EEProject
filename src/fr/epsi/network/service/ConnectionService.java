package fr.epsi.network.service;

import fr.epsi.network.beans.User;

public class ConnectionService implements IConnectionService {

	@Override
	public boolean isAuthorized(User user) {
		return user.getAdministrator();
	}

}
