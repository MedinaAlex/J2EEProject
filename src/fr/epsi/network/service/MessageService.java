package fr.epsi.network.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import fr.epsi.network.beans.Message;
import fr.epsi.network.beans.User;
import fr.epsi.network.dao.JDBC;
import fr.epsi.network.dao.MessageDao;

public class MessageService implements IMessageService {
	
	private static Logger logger = LogManager.getLogger(MessageService.class);
	
	MessageDao messageDao = new MessageDao();

	@Override
	public List<Message> getListOfMessages(User user) {
		return messageDao.getListOfMessages(user);
	}

	@Override
	public Message getMessage(Long id) {
		return messageDao.getMessage(id);
	}

	@Override
	public void addMessage(Message message) {
		JDBC jdbc = new JDBC();
		String id = "";
		try {
			ResultSet result = jdbc.sqlRequete("SELECT ID FROM MESSAGES where ID = (select max(ID) from messages)");
			result.next();
			id = result.getString(1);
		} catch (SQLException e) {
			logger.error("Erreur requete MAX ID", e);
		}
		
		message.setId(Long.valueOf(id)+1);
		messageDao.addMessage(message);
	}

	@Override
	public void updateMessageStatus(Message message, int status) {
		messageDao.updateMessageStatus(message, status);
	}

	@Override
	public void deleteMessage(Message message) {
		//TODO check si c'est le bon user
		messageDao.deleteMessage(message);
	}

}
