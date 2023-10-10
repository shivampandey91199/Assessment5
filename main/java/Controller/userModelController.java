package Controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.userModelDao;
import Model.userModel;
import service.Servicess;

@WebServlet("/userModelController")
public class userModelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public userModelController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("Register")) {
			userModel um = new userModel();
			um.setFname(request.getParameter("fname"));
			um.setLname(request.getParameter("lname"));
			um.setEmail(request.getParameter("email"));
			um.setContact(Long.parseLong(request.getParameter("contact")));
			um.setAddress(request.getParameter("address"));
			um.setGender(request.getParameter("gender"));
			um.setPassword(request.getParameter("password"));
			userModelDao.inserUser(um);
			request.setAttribute("msg", "Data Inserted");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else if (action.equalsIgnoreCase("login")) {
			userModel um = new userModel();
			um.setEmail(request.getParameter("email"));
			um.setPassword(request.getParameter("password"));
			userModel u = userModelDao.loginUser(um);
			HttpSession session = request.getSession();
			session.setAttribute("data", u);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else if (action.equalsIgnoreCase("changePassword")) {
			userModel um = new userModel();
			int id = Integer.parseInt(request.getParameter("id"));
			String password = request.getParameter("password");
			String cpassword = request.getParameter("cpassword");
			String npassword = request.getParameter("npassword");
			if (cpassword.equals(npassword)) {
				userModelDao.updatePassword(um, id, password);
				response.sendRedirect("home.jsp");
			} else {
				request.setAttribute("password", "Password is incorrect");
				request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
			}
		} else if (action.equalsIgnoreCase("forgotpassword")) {
			response.sendRedirect("forgotPassword.jsp");
		} else if (action.equalsIgnoreCase("sendotp")) {
			String email = request.getParameter("email");
			System.out.println(email);
			boolean flag = userModelDao.checkEmail(email);
			if (flag == true) {
				Servicess s = new Servicess();
				Random r = new Random();
				int num = r.nextInt(9999);
				System.out.println(num);
				s.sendMail(email, num);
				request.setAttribute("email", email);
				request.setAttribute("otp", num);
				request.getRequestDispatcher("otp-getPage.jsp").forward(request, response);
			} else {
				request.setAttribute("email", "your email is not register");
				request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
			}
			
		}else if(action.equalsIgnoreCase("verifyotp")) {
			String email=request.getParameter("email");
			System.out.println("email");
			int otp1 =Integer.parseInt(request.getParameter("otp1"));
			System.out.println(otp1);
			int otp2 = Integer.parseInt(request.getParameter("otp2"));
			if(otp1 == otp2) {
				request.setAttribute("email",email);
				request.getRequestDispatcher("customer-new-password.jsp").forward(request, response);
			}
		}else if(action.equalsIgnoreCase("update-password")) {
			String email=request.getParameter("email");
			System.out.println(email);
		    String cpassword = request.getParameter("cpassword");
		    String npassword = request.getParameter("npassword");
		    if(cpassword.equals(npassword)) {
		    	
		    }
		}
		

	}

}
