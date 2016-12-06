

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * Servlet implementation class reviewOrdersServlet
 */
@WebServlet("/reviewOrdersServlet")
public class reviewOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reviewOrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String userIdString = request.getParameter("userId");
		System.out.println(userIdString);
		int userId = Integer.parseInt(userIdString);
		
		//check to see if 1 item is left in order
		boolean iTAI = true;
		int isThereAnItem =0;
		isThereAnItem = ProduceCartLogicImpl.checkItems(userId);
		
		if(isThereAnItem>=1)
		{
			iTAI = true;
		}
		else{
			iTAI = false;
		}
		
	
		String path = this.getServletContext().getRealPath("/WEB-INF/template/");
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
		cfg.setDirectoryForTemplateLoading(new File(path));
	
		cfg.setDefaultEncoding("UTF-8");

		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
	
		cfg.setLogTemplateExceptions(false);
		User currentUser = UserLogicImpl.maintainUser(userId);

		if(iTAI)
		{
			HashMap<String, Object> data = ProduceCartLogicImpl.produceCartPage(userId);
			data.add("currentUser", currentUser);
			Template template = cfg.getTemplate("reviewOrder.ftl");
			Writer out = new OutputStreamWriter(response.getOutputStream());
			try {
				template.process(data,out);
			} catch (TemplateException e) {
				e.printStackTrace();	
			}	
		}
		else{
			HashMap<String,Object> data = new HashMap();
			data.add("currentUser", currentUser);
			data.put("userId", userId);
			Template template = cfg.getTemplate("noOrder.ftl");
			Writer out = new OutputStreamWriter(response.getOutputStream());
			try {
				template.process(data,out);
			} catch (TemplateException e) {
				e.printStackTrace();	
			}
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
