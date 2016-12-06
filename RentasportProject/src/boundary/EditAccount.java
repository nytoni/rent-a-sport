///package boundary;

import java.io.*;
import java.io.File;
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
 * Servlet implementation class CartServlet
 */
@WebServlet("/EditAccount")
public class EditAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String oldPassId = request.getParameter("oldPassId");
		String newPassId = request.getParameter("newPassId");
		String confirmPass = request.getParameter("confirmPassId");
		String userIdString = request.getParameter("userId");
		int userId = Integer.parseInt(userIdString);
		boolean dTVGTb =true;
		int didTheVerificationGetThrough = 0;
		try {
			didTheVerificationGetThrough = EditAccountLogicImpl.checkOldPassword(userId, oldPassId);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if(didTheVerificationGetThrough ==1)
		{
			dTVGTb =true;
		}
		else{
			dTVGTb = false;

			}
		String path = this.getServletContext().getRealPath("/WEB-INF/template/");
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
		cfg.setDirectoryForTemplateLoading(new File(path));
	
		cfg.setDefaultEncoding("UTF-8");

		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
	
		cfg.setLogTemplateExceptions(false);

		
		if(dTVGTb){
			HashMap<String, Object> data = EditAccountLogicImpl.changePassword(userId, confirmPass);
			Template template = cfg.getTemplate("successfulPasswordChange.ftl");
			Writer out = new OutputStreamWriter(response.getOutputStream());
			try {
				template.process(data,out);
			} catch (TemplateException e) {
				e.printStackTrace();	
			}
		} else {
			HashMap<String, Object> data = new HashMap();
			data.put("userId", userId);
			Template template = cfg.getTemplate("un-successfulPasswordChange.ftl");
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
