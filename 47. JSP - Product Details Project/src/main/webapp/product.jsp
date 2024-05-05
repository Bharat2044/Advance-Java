<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Product Details</title>
	<style>
        body {
            background-color: #000;
            color: #fff; 
            padding: 20px; 
        }

        h1 {
            color: yellow; 
            font-size: 24px; 
        }
    </style>
</head>
<body>

	<%!
		private static Connection connection = null;
		private static PreparedStatement pstmt = null;
		private static ResultSet res = null;
	
		private static final String DB_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
		private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc_db";
		private static final String DB_USERNAME = "root";
	    private static final String DB_PASSWORD = "test";
	    
	    private static final String SELECT_QUERY = "SELECT * FROM `phones` WHERE `phone_name` = ?";
	%>
	
	<h1>
		<%	
			try {
	            Class.forName(DB_DRIVER_CLASS);
	            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	            
	            pstmt = connection.prepareStatement(SELECT_QUERY);
	            
	            final String phoneName = request.getParameter("phoneName");
	
	            if ("iphone".equalsIgnoreCase(phoneName)) {
	                pstmt.setString(1, phoneName);
	            } 
	            else if ("nokia".equalsIgnoreCase(phoneName)) {
	                pstmt.setString(1, phoneName);
	            } 
	            else if ("redmi".equalsIgnoreCase(phoneName)) {
	                pstmt.setString(1, phoneName);
	            } 
	            else if ("samsung".equalsIgnoreCase(phoneName)) {
	                pstmt.setString(1, phoneName);
	            } 
	            else if ("vivo".equalsIgnoreCase(phoneName)) {
	                pstmt.setString(1, phoneName);
	            }
	            else if ("realme".equalsIgnoreCase(phoneName)) {
	                pstmt.setString(1, phoneName);
	            }
	            else if ("poco".equalsIgnoreCase(phoneName)) {
	                pstmt.setString(1, phoneName);
	            }
	            else if ("oppo".equalsIgnoreCase(phoneName)) {
	                pstmt.setString(1, phoneName);
	            }
	            else if ("motorola".equalsIgnoreCase(phoneName)) {
	                pstmt.setString(1, phoneName);
	            }
	            else if ("xiaomi".equalsIgnoreCase(phoneName)) {
	                pstmt.setString(1, phoneName);
	            }
	
	            res = pstmt.executeQuery();
	            
	            while(res.next()) {
	            	out.print("Phone Id = " + res.getString("phone_id") + "<br>");
	            	out.print("Phone Name = " + res.getString("phone_name") + "<br>");
	            	out.print("Phone Price = " + res.getDouble("price") + "<br>");
	            	out.print("Phone Rating = " + res.getDouble("rating") + "<br>");
	            }
	
	        } catch (ClassNotFoundException | SQLException e) {
	            out.println("<h1>Registration Failed :(</h1>" + e.getMessage());
	            e.printStackTrace();
	        } finally {
	        	try {
	    		    if (res != null) {
	    		        res.close();
	    		    }
	    		    if (pstmt != null) {
	    		        pstmt.close();
	    		    }
	    		    if (connection != null) {
	    		        connection.close();
	    		    }
	    		} catch (SQLException e) {
	    		    e.printStackTrace();
	    		}
			}
		%>
	</h1>
</body>
</html>