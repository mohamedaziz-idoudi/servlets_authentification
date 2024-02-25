package main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/servlet1")
public class FirstServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");  //setting the content of the response
        PrintWriter out = response.getWriter();  // creating an object allowing us to write content in response

        String n=request.getParameter("username");  // getting the password and username from the request
        String p=request.getParameter("userpass");

        if(LoginDao.validate(n, p)){   // validating the user and password
            RequestDispatcher rd=request.getRequestDispatcher("/servlet2");  //creating a RequestDispatcher

            rd.forward(request,response);                                    // forward the request to the next resource
        }
        else{
            out.print("Sorry username or password error");  				// else returning a message and
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  //the login page
            rd.include(request,response);
        }

        out.close();
    }
}