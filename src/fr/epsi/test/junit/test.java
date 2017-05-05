package fr.epsi.test.junit;

import static org.junit.Assert.*;
import org.junit.Test;

import java.sql.Timestamp;

import fr.epsi.network.beans.*;
import fr.epsi.network.dao.*;

public class test {

	@Test
	public void test() {
		
		Long id = new Long(1);
		
		User admin = new User("1", "password", true);
		Message ajaj = new Message(id, "title", "content", admin, new Timestamp(System.currentTimeMillis()), null,
				Status.PUBLIC);
		MessageDao msgDao = new MessageDao();
		msgDao.addMessage(ajaj);
		assertTrue(msgDao.getMessage(id) == ajaj);
	}

}
