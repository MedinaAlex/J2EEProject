package fr.epsi.network.service;

import java.util.List;

import fr.epsi.network.beans.Message;
import fr.epsi.network.beans.User;

public interface IMessageService {

	List<Message> getListOfMessages(User user);
	Message getMessage(Long id);
	void addMessage(Message message);
	void updateMessageStatus(Message message, int status);
	void deleteMessage(Message message);
	List<Message> getAllMessage(User user);

}
