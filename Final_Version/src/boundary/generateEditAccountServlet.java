package boundary;


import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
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
import logiclayer.UserLogicImpl;
import objectlayer.User;

/**
 * Servlet implementation class generateEditAccountServlet
 */
@WebServlet("/generateEditAccountServlet")
public class generateEditAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public generateEditAccountServlet() {
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
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		User currentUser = UserLogicImpl.maintainUser(Integer.parseInt(userIdString));
		data.put("currentUser", currentUser);
		
		String path = this.getServletContext().getRealPath("/WEB-INF/templates/");
		
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
		cfg.setDirectoryForTemplateLoading(new File(path));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
		cfg.setLogTemplateExceptions(false);
		
		Template template = cfg.getTemplate("editAccount.ftl");
		Writer out = new OutputStreamWriter(response.getOutputStream());
		try {
			template.process(data, out);	
		} catch(TemplateException e) {
			e.printStackTrace();	
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