package testPackage;

import java.io.*;
/**
 * @author Kinga
 *
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/kandydaci")

public class CandidatesTable  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	 private void displayCandidates(HttpServletResponse response)
			 throws IOException{
		 
		 response.setContentType("text/html");
		 PrintWriter table = response.getWriter();
		 
		 table.println("<html><head>");
		 table.println("<title>Kandydaci:</title>");
		 table.println("</head>");
		 table.println("<table border align=center>"); 
		 table.println("<caption align=center>Kandydaci:</caption>");
		 table.println("<tr><td colspan=2 align=center>Jasnie pan kot 1</td></tr>");
		 table.println("<tr height=159>");
		 table.println("<td><img src=http://centrumpupila.pl/images/bialy-kot-renice-duze-300x225.jpg " +
		 		"width=200 height=159></td> " +	"	<td>Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
		 				"Aliquam sit amet convallis massa. Sed ullamcorper, arcu eget varius fermentum, magna " +
		 				"lacus hendrerit nibh, volutpat pharetra est velit id neque. Etiam arcu nunc, dictum non " +
		 				"elit nec, scelerisque ullamcorper turpis. Sed at magna sed ligula porta auctor nec" +
		 				" accumsan ante. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur " +
		 				"ridiculus mus. Aenean sollicitudin nulla at convallis aliquet. Donec semper ex velit, " +
		 				"eu ornare leo mattis vitae. Suspendisse nec imperdiet eros, non elementum odio.</td>");
		 table.println("</tr>");
		 table.println("<tr><td colspan=2 align=center>Jej ksiazeca mosc kot 2</td></tr>");
		 table.println("<tr height=159>");
		 table.println("<td><img src=http://t3.gstatic.com/images?q=tbn:ANd9GcS9ydlGSDoGJ-ytVWFz5YIH0JtaYWIrHZ56I9AKRdmhOLGpn-IDHg " +
		 		"width=200 height=159></td> 	<td>Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
		 				"Aliquam sit amet convallis massa. Sed ullamcorper, arcu eget varius fermentum, magna " +
		 				"lacus hendrerit nibh, volutpat pharetra est velit id neque. Etiam arcu nunc, dictum non " +
		 				"elit nec, scelerisque ullamcorper turpis. Sed at magna sed ligula porta auctor nec" +
		 				" accumsan ante. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur " +
		 				"ridiculus mus. Aenean sollicitudin nulla at convallis aliquet. Donec semper ex velit, " +
		 				"eu ornare leo mattis vitae. Suspendisse nec imperdiet eros, non elementum odio.</td>");
		 table.println("</tr>");
		 table.println("<tr><td colspan=2 align=center>Jasnie pan PM</td></tr>");
		 table.println("<tr height=159>");
		 table.println("<td><img src=http://student.agh.edu.pl/~knvif/data/uploads/home/marek.png " +
		 		"width=200 height=159></td> " +	"	<td>Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
		 				"Aliquam sit amet convallis massa. Sed ullamcorper, arcu eget varius fermentum, magna " +
		 				"lacus hendrerit nibh, volutpat pharetra est velit id neque. Etiam arcu nunc, dictum non " +
		 				"elit nec, scelerisque ullamcorper turpis. Sed at magna sed ligula porta auctor nec" +
		 				" accumsan ante. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur " +
		 				"ridiculus mus. Aenean sollicitudin nulla at convallis aliquet. Donec semper ex velit, " +
		 				"eu ornare leo mattis vitae. Suspendisse nec imperdiet eros, non elementum odio.</td>");
		 table.println("</tr>");
		 table.println("</body></html>");
	 }
	
	
	  @Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		  displayCandidates(response);
		}
}
