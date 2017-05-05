package fr.epsi.network.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import fr.epsi.network.beans.Message;
import fr.epsi.network.beans.Status;
import fr.epsi.network.beans.User;

public class MessageDao implements IMessageDao{
	
	private static Logger logger = Logger.getLogger(UserDAO.class);

	@Override
	public List<Message> getListOfMessages(User user) {
		JDBC con = new JDBC();
		List<Message> messages= new ArrayList<>();
		ResultSet result;
		try {
			result = con.sqlRequete("select * from messages where USER_ID = '" + user.getId() +"' ");
			while(result.next()){
	            messages.add(new Message(result.getLong(1), result.getString(2)
	            		, result.getString(3), user,(Timestamp) result.getObject(5),(Timestamp) result.getObject(6), result.getInt(7)));
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
		User user = new User();
		try {
			Connection connection = con.getConnection();
			PreparedStatement stmt = connection.prepareStatement("select * from messages where ID = ?");
			stmt.setLong(1, id);
			result = stmt.executeQuery();
			result.next();
			
			String id_user = result.getString(4);
			IUserDao userDao = new UserDAO();
			user = userDao.getUserById(id_user);
			message = new Message(result.getLong(1), result.getString(2)
	        		, result.getString(3), user ,(Timestamp) result.getObject(5),(Timestamp) result.getObject(6), result.getInt(7));
			
			
	        
		} catch (Exception e) {
		
			logger.debug("", e);
		}
		return message;
	}

	@Override
	public void addMessage(Message message) {
		JDBC con = new JDBC();


		try {
			
			Connection connexion = con.getConnection();
			PreparedStatement ppr = connexion.prepareStatement("insert into messages values(?, ?, ?, ?, ?, ?, ?)");
			ppr.setLong(1, message.getId());
			ppr.setString(2, message.getTitle());
			ppr.setString(3, message.getContent());
			ppr.setObject(4, message.getAuthor().getId());
			ppr.setObject(5, message.getCreationDate());
			ppr.setObject(6, message.getUpdateDate());
			ppr.setObject(7, message.getStatus());
			ppr.executeUpdate();
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateMessageStatus(Message message, int status) {
		JDBC con = new JDBC();
		
		try {
			Connection connexion = con.getConnection();
			PreparedStatement ppr = connexion.prepareStatement("UPDATE messages set STATUS = ? WHERE id = ?");
			ppr.setInt(1, status);
			ppr.setLong(2, message.getId());
			ppr.executeUpdate();
			connexion.close();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMessage(Message message) {
		JDBC con = new JDBC();
		
		try {
			con.sqlRequete("delete from messages where id = '"+message.getId()+"'");
			
			logger.info("Message " + message.getId() + " supprim�");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}
