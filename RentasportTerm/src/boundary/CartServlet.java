package boundary;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
//import logiclayer.AccountLogicImpl;
import logiclayer.CartLogicImpl;
import objectlayer.Items;
//import persistlayer.UserPersister;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String templateDir = "/WebContent";
	public int userIdSaved;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userIdSaved=Integer.parseInt(request.getParameter("userId"));
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//if checkout page says go to order page load freemarker for order page a redirect there
		if(request.getParameter("submitOrder")!=null){
			//call sql to add order to orders table and redirect to home page
			ArrayList<Items> myList = CartLogicImpl.generateList(Integer.parseInt(request.getParameter("userId")));
			int total = myList.size();
			int totPrice=0;
			for(int i = 0; i<total; i++){
				totPrice += myList.get(i).getPrice();
			
			}//for
			CartLogicImpl.addOrder(Integer.parseInt(request.getParameter("userId")),totPrice, total);
		}
		
		if(request.getParameter("goToOderPage")!=null){
			//generate create revieworder page 
			response.getWriter().append("Served at: ").append(request.getContextPath());
			
			PrintWriter out = response.getWriter( );
				
				String path = this.getServletContext().getRealPath("/WEB-INF/templates/");
				Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
				cfg.setDirectoryForTemplateLoading(new File(path));
			
				cfg.setDefaultEncoding("UTF-8");

				cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
			
				cfg.setLogTemplateExceptions(false);
				try{
					Template template = cfg.getTemplate("checkoutReview.ftl");
					response.setContentType("text/html");
					HashMap<String, Object> data = new HashMap<String, Object>();
					ArrayList<Items> myList = CartLogicImpl.generateList(Integer.parseInt(request.getParameter("userId")));
				
					data.put("items", myList);
				
				
					int total = myList.size();
					int totPrice=0;
					for(int i = 0; i<total; i++){
						totPrice += myList.get(i).getPrice();
					
					}//for
					String[] otherInfo = CartLogicImpl.generateOrderInfo(Integer.parseInt(request.getParameter("userId")));
					data.put("names", request.getParameter("name"));
					data.put("sa", otherInfo[0]);
					data.put("ba", otherInfo[1]);
					data.put("cc", otherInfo[2]);
					data.put("ed", otherInfo[3]);
					
					
					data.put("totalPrice", totPrice);
					data.put("totalItems", total);
					template.process(data, out);
					out.flush();
			}catch(TemplateException e){
				System.out.println("oops");
			}//catch
		}//if
		//if mycart page sends request to go to checkout page load freemarker for it and send you there
		if( request.getParameter("checkout1")!=null){
			response.getWriter().append("Served at: ").append(request.getContextPath());
			
			PrintWriter out = response.getWriter( );
			String path = this.getServletContext().getRealPath("/WEB-INF/templates/");
			Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
			cfg.setDirectoryForTemplateLoading(new File(path));
		
			cfg.setDefaultEncoding("UTF-8");

			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
		
			cfg.setLogTemplateExceptions(false);
			//log("name:"+request.getParameter("name"));
			
			String[] creditCardNum = CartLogicImpl.getCheckouts(request.getParameter("userId"));
			try{
				 Template template = cfg.getTemplate("checkout.ftl");
				HashMap<String, Object> data = new HashMap<String, Object>();
				 data.put("cc", creditCardNum[0]);
				 data.put("addr", creditCardNum[1]);
				 template.process(data, out);
					out.flush();
			}catch(TemplateException E){
					log("error adding data to template");
				}
						 
		}else{
			//generate or regenerate cart depending on context its called in
			response.getWriter().append("Served at: ").append(request.getContextPath());
			//check and see if updating cart in sql is required
			if(request.getParameter("camping")!=null){
				CartLogicImpl.removeBundleFromCart("camping", Integer.parseInt(request.getParameter("userId")));
			}//if
			
			if(request.getParameter("soccer")!=null){
				CartLogicImpl.removeBundleFromCart("soccer", Integer.parseInt(request.getParameter("userId")));
			}//if
			
			if(request.getParameter("football")!=null){
				CartLogicImpl.removeBundleFromCart("football", Integer.parseInt(request.getParameter("userId")));
			}//if
			
			if(request.getParameter("baseball")!=null){
				CartLogicImpl.removeBundleFromCart("baseball", Integer.parseInt(request.getParameter("userId")));
			}//if
			
			if(request.getParameter("volleyball")!=null){
				CartLogicImpl.removeBundleFromCart("volleyball", Integer.parseInt(request.getParameter("userId")));
			}//if
			
			//after update is checked for and executed generate cart
			PrintWriter out = response.getWriter( );
				//Configuration cfg;
				/*cfg = new Configuration(Configuration.VERSION_2_3_25);
		      //  cfg.setDirectoryForTemplateLoading(new File("/project3/WebContent/templates"));
		        cfg.setDefaultEncoding("UTF-8");
		        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		        cfg.setLogTemplateExceptions(false);
		        cfg.setServletContextForTemplateLoading(getServletContext(), templateDir);
			*/
				String path = this.getServletContext().getRealPath("/WEB-INF/templates/");
				Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
				cfg.setDirectoryForTemplateLoading(new File(path));
			
				cfg.setDefaultEncoding("UTF-8");

				cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
			
				cfg.setLogTemplateExceptions(false);
			log("cart being generated");
			try{
				 Template template = cfg.getTemplate("myCart.ftl");
				HashMap<String, Object> data = new HashMap<String, Object>();
				ArrayList<Items> myList = CartLogicImpl.generateList(Integer.parseInt(request.getParameter("userId")));
				
				data.put("items", myList);
				
				
				int total = myList.size();
				int totPrice=0;
				for(int i = 0; i<total; i++){
					totPrice += myList.get(i).getPrice();
					
				}//for
				
				data.put("totalPrice", totPrice);
				data.put("totalItems", total);
				 template.process(data, out);
					out.flush();
			}catch(TemplateException E){
					log("error adding data to template");
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
