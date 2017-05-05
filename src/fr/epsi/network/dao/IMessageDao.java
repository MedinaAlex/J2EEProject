package fr.epsi.network.dao;

import java.util.List;

import fr.epsi.network.beans.Message;
import fr.epsi.network.beans.Status;
import fr.epsi.network.beans.User;

public interface IMessageDao {

	List<Message> getListOfMessages(User user);
	Message getMessage(Long id);
	void addMessage(Message message);
	void updateMessageStatus(Message message, Status status);
	void deleteMessage(Message message);

}
