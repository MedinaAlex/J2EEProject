package test.junit;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;

import fr.epsi.network.beans.Message;
import fr.epsi.network.beans.User;
import fr.epsi.network.dao.MessageDao;
import fr.epsi.network.dao.UserDAO;


public class test {
	
	
	@Test
	public void test1() {
		
		MessageDao msgDao = new MessageDao();
		UserDAO userDao = new UserDAO();
		
		Long id = new Long(564);
		
		User admin = new User("116", "password", true);
		userDao.addUser(admin);
		
		Message ajaj = new Message(id, "title", "content", admin, null, null, 1);
		msgDao.addMessage(ajaj);

		Assert.assertEquals(msgDao.getMessage(id), ajaj);
		
		msgDao.deleteMessage(ajaj);
		userDao.deleteUser(admin);
	}
	
	@Test
	public void test2() {
		
		MessageDao msgDao = new MessageDao();
		UserDAO userDao = new UserDAO();
		
		User admin = new User("116", "password", true);
		userDao.addUser(admin);
		
		Message ajaj = new Message(new Long(11112), "title", "content", admin, null, null, 1);
		Message ajaj2 = new Message(new Long(22223), "title2", "content2", admin, null, null, 1);
		
		msgDao.addMessage(ajaj);
		msgDao.addMessage(ajaj2);
		
		msgDao.updateMessageStatus(ajaj, 2);

		List<Message> messages = msgDao.getListOfMessages(admin);
		Assert.assertEquals(2, messages.size());
		
		Assert.assertEquals(2, messages.get(0).getStatus());
		Assert.assertEquals(ajaj2, messages.get(1));
		
		msgDao.deleteMessage(ajaj);
		msgDao.deleteMessage(ajaj2);
		userDao.deleteUser(admin);
		
	}
	
	@Test
	public void test3(){
		UserDAO userDao = new UserDAO();
		
		User admin = new User("116", "password", true);
		User user1 = new User("117", "password", false);
		
		userDao.addUser(admin);
		userDao.addUser(user1);
		
		user1.setAdministrator(true);
		userDao.updateUser(user1);
		
		List<User> users = userDao.getListOfUsers();
		
		User user2 = userDao.getUserById("117");
		
		Assert.assertTrue(!users.isEmpty());
		Assert.assertEquals(user1, user2);
		Assert.assertTrue(users.get(1).getAdministrator());
		
		userDao.deleteUser(user1);
		userDao.deleteUser(admin);
		
		
	}

}
