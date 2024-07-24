

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Invoice
 */
@WebServlet("/Invoice")
public class Invoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Invoice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int eid=Integer.parseInt(request.getParameter("eid"));
		String name=request.getParameter("name");
		String designation=request.getParameter("desig");
		double salary=Double.parseDouble(request.getParameter("salary"));
		out.print("Emp id is: "+eid +"<br>");
		out.print("Emp Name is : "+name +"<br>");
		out.print("Emp Designation is: "+designation +"<br>");
		out.print("Emp salary is: "+salary +"<br>");
		double TA=0.0,DA=0.0,HRA=0.0,PF=0.0,Gross_salary=0.0,NetSalary=0.0;
		if(salary<30000) {
			TA=(salary*7)/100;
			DA=(salary*9)/100;
			HRA=(salary*11)/100;
			PF=(salary*15)/100;
			
		}else if(salary>=30000 && salary<50000) {
			TA=(salary*12)/100;
			DA=(salary*13)/100;
			HRA=(salary*17)/100;
			PF=(salary*22)/100;
		
	}else if(salary>=50000) {
		TA=(salary*17)/100;
		DA=(salary*19)/100;
		HRA=(salary*21)/100;
		PF=(salary*25)/100;
	}
		Gross_salary=salary+TA+DA+HRA;
		NetSalary=Gross_salary-PF;
		out.print("TA is: "+TA+"<br>");
		out.print("DA is: "+DA+"<br>");
		out.print("HRA is: "+HRA+"<br>");
		out.print("PF is: "+PF+"<br>");
		out.print("GrossSalary is: "+Gross_salary+"<br>");
		out.print("NetSalary is: "+NetSalary+"<br>");
}
}