	// Ali Nazar
	// Gokul Evuri

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	import javax.swing.table.AbstractTableModel;


	public class User extends AbstractTableModel {

		int health, score, time;
		String name;
		
		String[][] theList = new String[MAX_ROWS][MAX_COLUMNS];
	    
	    static final int MAX_ROWS = 5;
	    static final int MAX_COLUMNS = 3;
		
		User(String n){
			
			name = n;
			health = 100;
			score = 0;
			
			setTable(name,score,time);
			/**
			 * 
			 * 
			 * 
			 * 
			 * 
			 */
		 }public void setTable(String Name,int Score,int Time){
			    try
	            {
	                Connection conn;         
	                                   
	                conn = DriverManager.getConnection("jdbc:mysql://localhost/highscore?user=root&password=muhammad");
	                   
	                Statement myStatement = conn.createStatement();
	                   
	                myStatement.executeUpdate(String.format("INSERT INTO scoreboard(name,Score,Time) VALUES ('%s','%d','%d')"));
	                   
	                conn.close();
	            }
	            catch(SQLException ex)
	            {
	                System.out.println(ex);
	            }  
	               
	            // Finally, refresh the highscore table and blank 
	            // the fields
	            updateTable();

		 }
		
		public void updateTable(){
	        try
	        {
	            Connection c;         
	                   
	            c = DriverManager.getConnection("jdbc:mysql://localhost/highscore?user=root&password=muhammad");
	           
	            Statement myStatement = c.createStatement();
	        
	            ResultSet rs = myStatement.executeQuery("SELECT * FROM scoreboard ORDER BY score DESC LIMIT "+ MAX_ROWS);
	             
	             int row= 0;
	             while (rs.next()){
	            	 
					theList [row][0]=rs.getString("name");
					theList [row][1]= rs.getString("score");
					theList [row][2]= rs.getString("time");
					row++;
	             
					
	}
	       System.out.println(rs.getString("name")+"   "+ rs.getString("score")+"   "+rs.getString("time"));
	       c.close(); 
	       // this refreshes the table and its a part of the astractTableModel class that has been extended
	       fireTableDataChanged();
	       
	}catch(SQLException e){
			System.out.println(e.getLocalizedMessage());
		
	}
	}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return MAX_COLUMNS;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return MAX_ROWS;
		}

		@Override
		public Object getValueAt(int row, int column) {
			// TODO Auto-generated method stub
			return theList[row][column];
		}

		
		public void Save(){
			try{
				Connection conn;         
	            
	            conn = DriverManager.getConnection("jdbc:mysql://localhost/highscore?user=root&password=muhammad");
	               
	            Statement myStatement = conn.createStatement();
	               
	            myStatement.executeUpdate("INSERT INTO save (player,enemy) VALUES ('%d','%d')");
	               
	            conn.close();
	        }
	        catch(SQLException ex)
	        {
	            System.out.println(ex);
	        }
	        
			}
		public void load() {
			  try
		        {
		            Connection c;         
		                   
		            c = DriverManager.getConnection("jdbc:mysql://localhost/saveload?user=root&password=muhammad");
		           
		            Statement myStatement = c.createStatement();
		        
		            ResultSet rs = myStatement.executeQuery("SELECT * FROM save ORDER BY save DESC LIMIT ");
		            
		           String playerposition=rs.getString("player");
		           String enemyposotion=rs.getString("enemy");
		           
		           
		}catch(SQLException e){
		 System.out.println(e.getLocalizedMessage());
		}
		}
		}
