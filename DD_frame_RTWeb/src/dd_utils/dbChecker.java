package dd_utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class dbChecker 
{
	public static void main(String a[])
	{
		dbChecker db = new dbChecker();
		System.out.println(db.commandTableCheck("307524", "Poll Reefer Status"));
	}
	public boolean commandTableCheck(String assetId, String  commandName)
	{
		boolean status=false;
		TestUtil s = new TestUtil();
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} 
		catch (ClassNotFoundException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Connection con = null;
		
		try 
		{
			con = DriverManager.getConnection("jdbc:oracle:thin:@172.19.1.133:1521:STGPQA","gp_sentry","gp_sentry");
		} 
		catch (SQLException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try
		{
			
			Statement stmt = con.createStatement();
			System.out.println("Created DB Connection....");
			String id="null";
			String query = "select Reefer_Asset_Id from Reefer_Asset where Reefer_Asset_Name='"+assetId+"'";
			//String query = "select * from Asset";
			System.out.println(query);
			
			ResultSet r = stmt.executeQuery(query); 
			if(r.next())
			{
				id=r.getString(1);
				System.out.println(id);
			}
			else
			{
				System.out.println("No result found...");
			}
			
			query = "select * from REEFER_SENTRY_COMMAND where Reefer_Asset_Id ='"+id+"' order by SENT_STAMP DESC";
			
			System.out.println(query);
			
			r = stmt.executeQuery(query);
			ResultSetMetaData rsmd = r.getMetaData();
			int j=0;
			String commandCode = null;
			String commandType = null;
			while(r.next() && j<2)
			//while(r.next())
			{
				j=r.getRow();
				System.out.println("Row number:"+r.getRow());
				int i =1;
				while(i<=rsmd.getColumnCount())
				{
					System.out.println("Column Index : "+i);
					System.out.println("Column name:"+rsmd.getColumnLabel(i));
					System.out.println("Value : "+r.getString(i));
					commandCode = r.getString(2);
					commandType = r.getString(5);
					i++;
				}
				j++;
			}
				
			
			System.out.println("Command Code : "+commandCode);
			System.out.println("Command Type : "+commandType);
			
			query="select * from COMMAND_NAME_FINDER where COMMAND_TYPE='"+commandType+"' and COMMAND_ID='"+commandCode+"'";
			System.out.println(query);
			
			r = stmt.executeQuery(query);
			String tableCommandCode,tableCommandType;
			while(r.next())
			{
				tableCommandCode=r.getString(2);
				tableCommandType=r.getString(1);
				System.out.println(tableCommandCode+"::"+commandCode);
				System.out.println(tableCommandType+"::"+commandType);
				if(tableCommandCode.equalsIgnoreCase(commandCode) && tableCommandType.equalsIgnoreCase(commandType))
				{
					System.out.println(r.getString(3));
					if(true)
					{
						System.out.println("Pass");
						status=true;
						break;
					}
					else
					{
						System.out.println("Fail");
						break;
					}
				}
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
			}
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return status;
		}
	}
}
