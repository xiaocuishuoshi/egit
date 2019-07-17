package com.whfp.oa.commons.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
 
public class DataConn {

	  public String ClassString=null;
	  public String ConnectionString=null;
	  public String UserName=null;
	  public String PassWord=null;

	  public Connection Conn;
	  public Statement Stmt;
	  private static Properties prop = new Properties(); 
	  static{
	    	try { 
			 	prop.load(DataConn.class.getResourceAsStream("/config/dbcp.properties"));		 
		  	} catch (IOException e) {
				throw new RuntimeException(e);
			} 
	    }
		public static String getProperty(String key) {
			return prop.getProperty(key);
		}
		 

	  public DataConn() { 
	    ClassString=getProperty("jdbc.driverClassName");
	    ConnectionString=getProperty("jdbc.url");
	    UserName=getProperty("jdbc.username");
	    PassWord=getProperty("jdbc.password");
		  
		/*  ClassString="com.mysql.jdbc.Driver";
		    //ConnectionString="jdbc:mysql://127.0.0.1:3306/zhcx?characterEncoding=UTF-8";
		    ConnectionString="jdbc:mysql://127.0.0.1:3306/zhcx?characterEncoding=UTF-8";
		    UserName="root";
		    PassWord="djdqltj";*/
	  }
	  public DataConn(String url) { 
		    ClassString=getProperty("jdbc.driverClassName");
		    if(url==null||url.equals(""))
		    	url=getProperty("jdbc.url");
		    ConnectionString=url;//getProperty("jdbc.url");
		    UserName=getProperty("jdbc.username");
		    PassWord=getProperty("jdbc.password");
			  
			/*  ClassString="com.mysql.jdbc.Driver";
			    //ConnectionString="jdbc:mysql://127.0.0.1:3306/zhcx?characterEncoding=UTF-8";
			    ConnectionString="jdbc:mysql://127.0.0.1:3306/zhcx?characterEncoding=UTF-8";
			    UserName="root";
			    PassWord="djdqltj";*/
		  }
	  public boolean OpenConnection()
	  {
	   boolean mResult=true;
	   try
	   { 
	     Class.forName(ClassString);
	     if ((UserName==null) && (PassWord==null))
	     {
	       Conn= DriverManager.getConnection(ConnectionString);
	     }
	     else
	     {
	       Conn= DriverManager.getConnection(ConnectionString,UserName,PassWord);
	     } 

	     Stmt=Conn.createStatement();
	     mResult=true;
	   }
	   catch(Exception e)
	   {
	     System.out.println(e.toString());
	     mResult=false;
	   }
	   return (mResult);
	  }

	  //�ر���ݿ�l��
	  public void CloseConnection()
	  {
	   try
	   {
	     Stmt.close();
	     Conn.close();
	   }
	   catch(Exception e)
	   {
	     System.out.println(e.toString());
	   }
	  }
	  public String GetDateTime()
	  {
	   Calendar cal  = Calendar.getInstance();
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   String mDateTime=formatter.format(cal.getTime());
	   return (mDateTime);
	  }

	  

	   public int GetMaxID(String vTableName,String vFieldName)
	  {
	   int mResult=0;
	   boolean mConn=true;
	   String mSql=new String();
	   mSql = "select max("+vFieldName+")+1 as MaxID from " + vTableName;
	   try
	   {
	       if (Conn!=null){
	           mConn=Conn.isClosed();
	       }
	       if (mConn){
	         OpenConnection();
	       }

	       ResultSet result=ExecuteQuery(mSql);
	       if (result.next())
	       {
	         mResult=result.getInt("MaxID");
	       }
	       result.close();

	       if (mConn)
	       {
	         CloseConnection();
	       }

	     }
	     catch(Exception e)
	     {
	       System.out.println(e.toString());
	   }
	   return (mResult);
	 }


	  public ResultSet ExecuteQuery(String SqlString)
	  {
	    ResultSet result=null;
	    try
	    {
	      result=Stmt.executeQuery(SqlString);
	    }
	    catch(Exception e)
	    {
	      System.out.println(e.toString());
	    }
	    return (result);
	  }

	  public int ExecuteUpdate(String SqlString)
	  {
	    int result=0;
	    try
	    {
	      result=Stmt.executeUpdate(SqlString);
	    }
	    catch(Exception e)
	    {
	      System.out.println(e.toString());
	    }
	    return (result);
	  }
	  public static void main(String args[]){ 
		  DataConn dataConn=new DataConn();
		  dataConn.OpenConnection();
	 	  System.out.println(dataConn.Conn ); 
	  }
}
