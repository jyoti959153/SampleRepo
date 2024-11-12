package com.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

public class DatabaseUtility {
    Connection conn;
	public void getDatabaseConnection(String url,String username,String password) throws SQLException
	{
	try {
    Driver driveRef=new Driver();
    DriverManager.registerDriver(driveRef);
    conn=DriverManager.getConnection(url, username, password);
	}
	catch(Exception e)
	{
	//handling
	}
	conn.close();
	}
	
	
	public void connectToDatabase1() throws SQLException
	{
	try {
    Driver driveRef=new Driver();
    DriverManager.registerDriver(driveRef);
    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
	}
	catch(Exception e)
	{
	//handling
	}
	}
	
	public void colseConnection()
	{
	try {
	conn.close();
	}
	catch(Exception e)
	{
	//handling
	}
	}
	
	public ResultSet executeSelectQuery(String query) {
	ResultSet result=null;
	try {
	Statement stat = conn.createStatement();
    result = stat.executeQuery(query);
	}
	catch(Exception e)
	{
	//handling
	}
	return result;
	}
	
	public int executeNonSelectQuery(String query) {
	int result=0;
	try {
	Statement stat = conn.createStatement();
    result = stat.executeUpdate(query);
    }
	catch(Exception e)
    {
    //handling
	}
	return result;
	}
}

