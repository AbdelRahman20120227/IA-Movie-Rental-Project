package DatabaseLayer;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;


public class DataSource {
  private static DataSource dataSource ; 
  private BasicDataSource basicDataSource ; 
  private DataSource() {
      basicDataSource = new BasicDataSource() ; 
      basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
      basicDataSource.setUsername("root");
      basicDataSource.setPassword("Enter Your Password");
      basicDataSource.setUrl("jdbc:mysql://localhost/movirental");
  
      basicDataSource.setMinIdle(20);
      basicDataSource.setMaxIdle(3);
      basicDataSource.setMaxOpenPreparedStatements(20);
  }
  public static DataSource getInstance(){
	   if(dataSource==null){
		   dataSource = new DataSource() ; 
	   }
	   return dataSource ; 
  }
  public Connection getConnection() throws SQLException{
	  return this.basicDataSource.getConnection() ; 
  }
}
