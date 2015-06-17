package serwlety;

import java.io.IOException;
import java.io.PrintWriter;
 
import java.sql.*;
import java.sql.DriverManager;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditAccounts extends HttpServlet{
	private static final long serialVersionUID = 1L;
	 
    int id;
    String pesel;
    String imie;
    String nazwisko;
    
    
    
    
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        
        if (request.getParameter("peselSearch") != null){
            final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
            final String DB_URL="jdbc:mysql://mysql.agh.edu.pl:3306/dorotaj1";
            final String USER = "dorotaj1";
            final String PASS = "J56VfF3b";
            
            ResultSet rs;
            String sql;
            Connection conn;
            Statement stmt;
            
            try{
            	Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection(DB_URL,USER,PASS);
	            stmt = conn.createStatement();
	            sql = "SELECT * FROM uzytkownicy WHERE PESEL=" + request.getParameter("peselSearch");
	            rs = stmt.executeQuery(sql);
	            
	            while(rs.next()){
		            String editUserForm = ""
		        		+ "<form action='edituserinfo' method='POST'>"
							+ "PESEL <input type='text' name='pesel' value='" + rs.getString("PESEL") +  "' /> <br/>"
							+ "Imie <input type='text' name='imie' value='" + rs.getString("imie") +  "' /> <br/>"
							+ "Nazwisko <input type='text' name='nazwisko' value='" + rs.getString("nazwisko") +  "' /> <br/>"
							+ "Numer dowodu <input type='text' name='nrDowodu' value='" + rs.getString("nr_dowodu") +  "' /> <br/>"
							+ "Ulica <input type='text' name='ulica' value='" + rs.getString("ulica") +  "' /> <br/>"
							+ "Miasto <input type='text' name='miasto' value='" + rs.getString("miasto") +  "' /> <br/>"
							+ "Kod pocztowy <input type='text' name='kodPocztowy' value='" + rs.getString("kod_pocztowy") +  "' /> <br/>"
							+ "Uprawnienia <input type='text' name='role' value='" + rs.getString("rola") +  "' /> <br/>"
							+ "<input type='submit' value='Zaakceptuj zmiany' /> <br/>"
						+ "</form>";
	            out.print(editUserForm);
	            }
            }
            catch(Exception e){
            	out.println("Ups, cos poszlo nie tak... <br/>");
            	out.println(e + "<br/>");
            }
        }
        
        String searchForUserForm = ""
           		+ "<form action = 'edituserinfo' method = 'GET'>"
            		+ "Podaj PESEL uzytkownika: <input type = 'text' name = 'peselSearch' value='" + request.getParameter("peselSearch") + "'/> <br/>"
            		+ "<input type='submit' value='Wyszukaj' /> <br/>"
            	+ "</form>"; 
        out.print(searchForUserForm);   
    }
    
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
    	
    	// wsadz do bazy na powrot
    	out.println("Pomyslnie zmieniono dane uzytkowika");
    	
    	
    	Map<String, String[]> m = request.getParameterMap();
    	Set s = m.entrySet();
    	Iterator it = s.iterator();
    	
    	 while(it.hasNext()){
             Map.Entry<String,String[]> entry = (Map.Entry<String,String[]>)it.next();
             String key = entry.getKey();
             String[] value = entry.getValue();
            // out.print(key + " - " + value);
    	 }
    }

}
