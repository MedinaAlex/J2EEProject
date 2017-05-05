package fr.epsi.network.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	
	Connection connexion;
    
    Boolean isConnected = false;
    
    public JDBC() {

        try {
            Class.forName("org.hsqldb.jdbcDriver");
            connexion = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003", "sa","");
            isConnected = true;
        } catch (ClassNotFoundException | SQLException e) {
            
            e.printStackTrace();
        } 
        
    }
    
    public Connection getConnection() throws Exception{
    	Connection connect = null;
    	if(isConnected){
    		connect = this.connexion;
    	}
    	else{
    		throw new Exception("La connexion n'est pas établie");
    	}
    	
    	return connect;
    }
    
    public ResultSet sqlRequete(String requete) throws SQLException{
        ResultSet result = null;
        if(isConnected){
            Statement stmt = connexion.createStatement();
            result = stmt.executeQuery(requete);
        }
        return result;
    }

}
