// TODO: refactor database connection handling code

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
	private static final boolean ISDEBUGMODE = true;
	
    int id;
    String pesel;
    String imie;
    String nazwisko;
    
    final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
    final String DB_URL="jdbc:mysql://mysql.agh.edu.pl:3306/dorotaj1";
    final String USER = "dorotaj1";
    final String PASS = "J56VfF3b";
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        
        String peselInputContent = (request.getParameter("peselSearch") != null) ? request.getParameter("peselSearch") : "";
        String searchForUserForm = ""
           		+ "<form action = 'edituserinfo' method = 'GET'>"
            		+ "Podaj PESEL uzytkownika: <input type = 'text' name = 'peselSearch' value='" + peselInputContent + "'/> <br/>"
            		+ "<input type='submit' value='Wyszukaj' /> <br/>"
            	+ "</form>"; 
        out.print(searchForUserForm);   
        
        if ((request.getParameter("peselSearch") != null) && (request.getParameter("peselSearch") != "")){
            ResultSet rs;
            String sql;
            Connection conn;
            Statement stmt;
            
            try{
            	Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection(DB_URL,USER,PASS);
	            stmt = conn.createStatement();
	            sql = "SELECT * FROM uzytkownicy WHERE PESEL = " + request.getParameter("peselSearch");
	            rs = stmt.executeQuery(sql);
	            
	            if(!rs.next()) out.print("Nie znaleziono uzytkownika o numerze PESEL " + request.getParameter("peselSearch"));
	            else rs.beforeFirst();
	            
	            while(rs.next()){
		            String editUserForm = ""
		        		+ "<form action='edituserinfo' method='POST'>"
							//	+ "PESEL <input type='text' name='pesel' value='" + rs.getString("PESEL") +  "' required/> <br/>"
							+ "<input type='text' name='pesel' value='" + rs.getString("PESEL") +  "' required hidden/> <br/>"
							+ "Imie <input type='text' name='imie' value='" + rs.getString("imie") +  "' required/> <br/>"
							+ "Nazwisko <input type='text' name='nazwisko' value='" + rs.getString("nazwisko") +  "' required/> <br/>"
							+ "Numer dowodu <input type='text' name='nrDowodu' value='" + rs.getString("nr_dowodu") +  "' required/> <br/>"
							+ "Ulica <input type='text' name='ulica' value='" + rs.getString("ulica") +  "' required/> <br/>"
							+ "Miasto <input type='text' name='miasto' value='" + rs.getString("miasto") +  "' required/> <br/>"
							+ "Kod pocztowy <input type='text' name='kodPocztowy' value='" + rs.getString("kod_pocztowy") +  "' required/> <br/>"
							+ "Uprawnienia <input type='text' name='rola' value='" + rs.getString("rola") +  "' required/> <br/>"
							+ "<input type='submit' value='Zaakceptuj zmiany'/> <br/>"
							+ "<button type='reset' value='Reset'>Resetuj wartosci</button>"
						+ "</form>";
		            
	            out.print(editUserForm);
	            }
            }
            catch(Exception e){
            	out.println("Ups, cos poszlo nie tak... <br/>");
            	if(ISDEBUGMODE) out.println(e + "<br/>");
            }
        }
    }
    
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
    	
        String updateUserDataQuery = ""
        		+ "UPDATE uzytkownicy "
        		+ "SET "
        			+ "imie = '%s', "
        			+ "nazwisko = '%s', "
        			+ "nr_dowodu = '%s', "
        			+ "ulica = '%s', "
        			+ "miasto = '%s', "
        			+ "kod_pocztowy = '%s', "
        			+ "rola = '%s' "
        		+ "WHERE pesel = %s";
        
        updateUserDataQuery = String.format(updateUserDataQuery, 
        		request.getParameter("imie"),
        		request.getParameter("nazwisko"),
        		request.getParameter("nrDowodu"),
        		request.getParameter("ulica"),
        		request.getParameter("miasto"),
        		request.getParameter("kodPocztowy"),
        		request.getParameter("rola"),
        		request.getParameter("pesel"));
        
        try{
        	//ResultSet rs;
        	int rs;
            Connection conn;
            Statement stmt;
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            rs = stmt.executeUpdate(updateUserDataQuery);

            if(rs > 0){
            	out.println("Pomyslnie zmieniono dane uzytkowika " + request.getParameter("imie") + " " + request.getParameter("nazwisko"));
            }
            else{
            	out.println("Wystapil blad podczas zmiany danych uzytkownika");
            }
            
        }
        catch(Exception e){
        	out.println("Ups, cos poszlo nie tak... <br/>");
        	if(ISDEBUGMODE) out.println(e + "<br/>");
        }

    	 String goBackBtn = ""
	        		+ "<form action='edituserinfo' method='GET'>" 
	        			+ "<input type='submit' value='Wroc do ekranu edycji'/> <br/>"
	        		+ "</form>";
    	 out.print(goBackBtn);    	 
    }

}
