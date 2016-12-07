package boundary;

import logiclayer.*;
import objectlayer.*;

import java.io.PrintWriter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import freemarker.template.*;

/**
 * Servlet implementation class BundlesServlet
 */
@WebServlet("/BundlesServlet")
public class BundlesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Configuration cfg = null;
	private String templateDir = "/WEB-INF/templates"; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BundlesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init()
    {
    	cfg = new Configuration(Configuration.VERSION_2_3_25);
    	cfg.setServletContextForTemplateLoading(getServletContext(), templateDir);
    	cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    	cfg.setLogTemplateExceptions(false);
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String userId=null, bundleName= null, qty="1", time=null;
		
		//Get servlet parameters
		userId= request.getParameter("userId");
		bundleName=request.getParameter("action");
		//If first servlet sent, then process this if statement
		if(bundleName!=null)
		{
			loadSportPkgPage(request, response, bundleName);
		}
		else{//If second servlet sent, then process this else statement
			//Get servlet parameters
				userId=request.getParameter("userId");
				bundleName=request.getParameter("bundleType");
				qty=request.getParameter("quantity");
				time=request.getParameter("rentDuration");
				loadRentalPageResult(request, response, userId, bundleName, qty, time);
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/*This method just loads a specific FTL file
	 */
	public void loadTemplate(HttpServletRequest request, HttpServletResponse response, String templateName)
	{
		Template template = null;
		DefaultObjectWrapperBuilder df = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(df.build());
		try {
			template = cfg.getTemplate(templateName );
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			template.process(root, out);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
	
	/*This method processes when a selection is made 
	 *from the browseBundle.html and returns a freemarker
	 *result page
	 */
	public void loadSportPkgPage(HttpServletRequest request, HttpServletResponse response, String imgPath) 
	{
		Template template = null;
		DefaultObjectWrapperBuilder df = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(df.build());
		String userIdString = request.getParameter("userId");

	
		BundlesLogicImpl mc= new BundlesLogicImpl();
		List<Bundles> bundleList = new ArrayList<Bundles>();
		bundleList = mc.getBundleByBundleType(imgPath);
		root.put("sportNames", bundleList);
		User currentUser = UserLogicImpl.maintainUser(Integer.parseInt(userIdString));
		try {
			root.put("currentUser", currentUser);
			String templateName = "sportPackage.ftl";
			template = cfg.getTemplate(templateName );
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			//root.put("sportNames", bundleList);
			template.process(root, out);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
	
	/*This method processes when a selection is made 
	 *from sportPackage.ftl and returns a freemarker
	 *result page to show that the insert worked
	 */
	public void loadRentalPageResult(HttpServletRequest request, HttpServletResponse response, String custId, String bundleName, String qty, String time) 
	{
		Template template = null;
		DefaultObjectWrapperBuilder df = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(df.build());

		BundlesLogicImpl mc= new BundlesLogicImpl();

		List<Cart> cartList = new ArrayList<Cart>();
		cartList = mc.getBundleBySportPkg(custId, bundleName, qty, time);
		root.put("toCart", cartList);
		
		User currentUser = UserLogicImpl.maintainUser(Integer.parseInt(custId));
		try {
			root.put("currentUser", currentUser);
			String templateName = "bee.ftl";
			template = cfg.getTemplate(templateName );
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			template.process(root, out);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
	
}