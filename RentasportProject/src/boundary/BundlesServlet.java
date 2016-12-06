package boundary;

import persistlayer.*;
import logiclayer.*;
import objectlayer.*;

import java.io.PrintWriter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
import edu.uga.cs4300.boundary.Configuration;
import edu.uga.cs4300.boundary.DefaultObjectWrapperBuilder;
import edu.uga.cs4300.boundary.SimpleHash;
import edu.uga.cs4300.boundary.Template;
import edu.uga.cs4300.boundary.TemplateException;
*/

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		PrintWriter out= response.getWriter();
		String userId=null, imagePath=null;
		String bundleName, qty="1", time=null;
		imagePath=request.getParameter("");
		userId= request.getParameter("userId");
		bundleName=request.getParameter("action"); 
		if(bundleName!=null)
		{
			if(bundleName.equals("football"))
			{	
				out.println("BRUUUUUUHHHH!!!!!");
			}
			loadSportPkgPage(request, response, bundleName) ;
		}
		else{
		//imagePath=request.getParameter("imgPath"); //check value
				//bundleName=request.getParameter("action");
				qty=request.getParameter("quantity");
				time=request.getParameter("rentDuration");
				bundleName="football";
			}
		//loadTemplate(request,response,"viewMovie.ftl");
		
		loadRentalPageResult(request, response, userId, bundleName, qty, time);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

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
	
	public void loadSportPkgPage(HttpServletRequest request, HttpServletResponse response, String imgPath) 
	{
		Template template = null;
		DefaultObjectWrapperBuilder df = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(df.build());
	
		BundlesLogicImpl mc= new BundlesLogicImpl();
		List<Bundles> bundleList = new ArrayList<Bundles>();
		bundleList = mc.getBundleByBundleType(imgPath);
		root.put("sportNames", bundleList);
		
		try {
			String templateName = "sportPackage.ftl";
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
	
	public void loadRentalPageResult(HttpServletRequest request, HttpServletResponse response, String custId, String bundleName, String qty, String time) 
	{
		Template template = null;
		DefaultObjectWrapperBuilder df = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(df.build());

		BundlesLogicImpl mc= new BundlesLogicImpl();

		List<Cart> cartList = new ArrayList<Cart>();
		cartList = mc.getBundleBySportPkg(custId, bundleName, qty, time);
		root.put("movieNames", cartList);
		
		try {
			String templateName = "result.ftl";
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