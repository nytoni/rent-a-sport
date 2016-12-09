package boundary;



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
import logiclayer.EditAccountLogicImpl;
import logiclayer.UserLogicImpl;
import objectlayer.User;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userIdString = request.getParameter("userId");
		int userId = Integer.parseInt(userIdString);
		String checkoutNameId = request.getParameter("checkoutNameId");
		String billAddressId = request.getParameter("billAddressId");
		String shippingAddressId = request.getParameter("shippingAddressId");
		String creditCardNumber = request.getParameter("creditCardNumber");
		String expireDate = request.getParameter("expireDate");
		String securityCode = request.getParameter("secureCode");
		
		HashMap<String, Object> data = EditAccountLogicImpl.changeCreditCardInfo(userId,checkoutNameId, billAddressId,shippingAddressId,creditCardNumber,expireDate,securityCode);
		
		
		User currentUser = UserLogicImpl.maintainUser(userId);
		data.put("currentUser", currentUser);
		
		String path = this.getServletContext().getRealPath("/WEB-INF/templates/");		
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
		cfg.setDirectoryForTemplateLoading(new File(path));	
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);

		cfg.setLogTemplateExceptions(false);
		Template template = cfg.getTemplate("successfulCreditCardChange.ftl");
		Writer out = new OutputStreamWriter(response.getOutputStream());
		try {
			template.process(data,out);
		} catch (TemplateException e) {
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