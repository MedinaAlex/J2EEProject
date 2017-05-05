package fr.epsi.network.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import fr.epsi.network.beans.Message;
import fr.epsi.network.beans.Status;
import fr.epsi.network.beans.User;

public class MessageDao implements IMessageDao{

	@Override
	public List<Message> getListOfMessages(User user) {
		JDBC con = new JDBC();
		List<Message> messages= new ArrayList<>();
		ResultSet result;
		try {
			result = con.sqlRequete("select * from messages where ID_USER = '" + user.getId() +"' ");
			while(result.next()){
	            messages.add(new Message(result.getLong(0), result.getString(1)
	            		, result.getString(2), user,(Timestamp) result.getObject(4),(Timestamp) result.getObject(5),(Status) result.getObject(6)));
	        }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return messages;
	}

	@Override
	public Message getMessage(Long id) {
		JDBC con = new JDBC();
		ResultSet result;
		Message message = null;
		try {
			result = con.sqlRequete("select * from messages where ID = '" + id +"' ");
			result.next();
			//TODO User à récupérer
			String id_user = result.getString(3);
			 message = new Message(result.getLong(0), result.getString(1)
            		, result.getString(2), new User() ,(Timestamp) result.getObject(4),(Timestamp) result.getObject(5),(Status) result.getObject(6));
	        
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public void addMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMessageStatus(Message message, int status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMessage(Message message) {
		// TODO Auto-generated method stub
		
	}
	

}
