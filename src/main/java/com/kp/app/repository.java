package com.kp.app;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class repository {
    List<alien> l;
    Connection con;

    // Constructor with exception handling
    public repository()  {
        try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Corrected database URL
        try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "kpkp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Initialize the alien list
        l = new ArrayList<>();
    }

    // Method to fetch all aliens from the database
    List<alien> getaliens() throws SQLException {
        // Querying the database
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM rest");

        while (rs.next()) {
            alien a1 = new alien();
            a1.setId(rs.getInt(1));     // Set ID
            a1.setName(rs.getString(2)); // Set name

            // Add alien to list
            l.add(a1);
        }

        // Return the list of aliens
        return l;
    }

    // Method to get a specific alien by ID
    alien getalien(int id) throws SQLException {
        // Iterate over the list and find the alien by ID
    	 Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("SELECT * FROM rest WHER id="+id);
    	
//        for (alien i : l) {
//            if (i.getId() == id) {
//                return i;
//            }
//        }
         if(rs.next())
         {
        	 alien a1 = new alien();
             a1.setId(rs.getInt(1));     // Set ID
             a1.setName(rs.getString(2)); // Set name

             // Add alien to list
            // l.add(a1);
             return a1;
         }
        return null;
    }

    // Method to create a new alien
    void createalien(alien i) {
    	try {
			PreparedStatement ps=con.prepareStatement("INSERT INTO rest VALUES(?,?)");
			ps.setInt(1, i.getId());
			ps.setString(2,i.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
       // l.add(i);  // Add the alien to the list
        System.out.println(i.toString());  // Print alien details
    }
    void update(alien i)
    {
    	try {
			PreparedStatement ps=con.prepareStatement("UPDATE rest SET name=? WHERE id=?");
			ps.setString(1, i.getName());
			ps.setInt(2,i.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
       // l.add(i);  // Add the alien to the list
        System.out.println(i.toString());  // Print alien details
    	
    }
    void delete(int i)
    {
    	try {
			PreparedStatement ps=con.prepareStatement("DELETE FROM rest WHERE id=?");
			//ps.setString(1, i.getName());
			ps.setInt(1,i);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
       // l.add(i);  // Add the alien to the list
      //  System.out.println(i.toString());  // Print alien details
    	
    }
}
