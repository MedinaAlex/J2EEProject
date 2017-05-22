package fr.epsi.network.service;

import java.util.List;

import fr.epsi.network.beans.Message;
import fr.epsi.network.beans.User;
import fr.epsi.network.dao.MessageDao;

public class MessageService implements IMessageService {
	
	MessageDao messageDao;

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
		messageDao.addMessage(message);

	}

	@Override
	public void updateMessageStatus(Message message, int status) {
		messageDao.updateMessageStatus(message, status);
	}

	@Override
	public void deleteMessage(Message message) {
		messageDao.deleteMessage(message);
	}

}
