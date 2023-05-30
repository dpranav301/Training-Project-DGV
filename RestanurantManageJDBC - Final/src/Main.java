import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Main {
	
	

	public static void main(String[] args) {
		try
		{
			String url="jdbc:mysql://172.33.1.8:3306/training_database";
			String username="training_user";
			String password="Training@123";
			Connection con=DriverManager.getConnection(url, username, password);
			//Statement stm=con.createStatement();
			//String query="create table PRANAV_DESAI_USER_DEMOTABLE()"
			//String queryForPreparedStatement="Insert into table_Name()values(?,?,?)
			//PreparedStatement stm=con.prepareStatement(query)
			//stm.setInt(
			
			//stm.execute(query);
			//System.out.println("Connection success");
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
