package com.thoughtworks.javaweb.servlets;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BMIServlet
 */
public class BMIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BMIServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Calculate the BMI here
		OutputStream out = response.getOutputStream();
		Float heightVal = null ;
		Float weightVal = null;
		try {
			//bmi formula makes use of height and weight
		    String height = request.getParameter("height");
		    String weight = request.getParameter("weight");
		  //Check if height and weight have some appropiate values
			if((height == null) || (height.length() == 0)) {
				throw new IllegalArgumentException("Height is required for BMI calculation");
			}
			if((weight == null) || (weight.length() == 0)){
				throw new IllegalArgumentException("Weight is required for BMI calculation");
			}
			//Convert String to Float value
			heightVal = Float.valueOf(height);
			weightVal = Float.valueOf(weight);
		} catch (Exception e) {
			//If we get a exception write the error response on the UI
			String result = "<html><head><title>An Error has occurred</title>"
					+ "</head><body><h1>Both weight and height must be specified and they must be numbers"+"</h1></body></html>";
			//Convert String to bytes
			out.write(result.getBytes());
			//We do not want to do any further processing in case of an error
			//So return
			return;
			
		}
		//Calculate the bmiResult by bmi formula
		Float bmiResult = (weightVal/(heightVal * heightVal))*703;
		String result = "<html><head><title>Your BMI Index</title>"
				+ "</head><body><h1>Your bmi is "+bmiResult+"</h1></body></html>";
		//Convert String to bytes
		out.write(result.getBytes());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
