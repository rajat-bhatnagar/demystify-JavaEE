package com.thoughtworks.javaweb.servlets;

import java.io.IOException;
import java.io.ObjectOutput;
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
		
		OutputStream out = response.getOutputStream();
		this.writeForm(out,"","","","");
		
	}

	//Helper method
	private void writeForm(OutputStream out, String height, String weight ,String heightError, String weightError) throws IOException{
		//Do the HTML form stuff here
				//To make your life easy copy paste HTML from form here. Replace " with \", by selecting the HTML lines
				//\" is escape sequence and then append out.write before and .getBytes() after
				//to quickly complete your changes
				out.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>".getBytes());
				out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">".getBytes());
				out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">".getBytes());
				out.write("<head>".getBytes());
				out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />".getBytes());
				out.write("<title>Please enter your height and weight. so we can comupute your BMI</title>".getBytes());
				out.write("</head>".getBytes());
				out.write("<body>".getBytes());
				out.write("<form method=\"post\" action=\"/demystify-JavaEE/bmi\">".getBytes());
				out.write(("Height in Inches:  <input type=\"text\" name=\"height\" value=\"" + height + "\"/> "+ heightError + "<br/>").getBytes());
				out.write(("Weight in Pounds:  <input type=\"text\" name=\"weight\"  value=\""+ weight + "\"/> "+ weightError + "<br/>").getBytes());
				out.write("<input type=\"submit\" value=\"Calculate your BMI\"/>".getBytes());
				out.write("</form>".getBytes());
				out.write("</body>".getBytes());
				out.write("</html>".getBytes());
		
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OutputStream out = response.getOutputStream();
		//Calculate the BMI here
		Float heightVal = null ;
		Float weightVal = null;
		//bmi formula makes use of height and weight
	    String height = request.getParameter("height");
	    String weight = request.getParameter("weight");
	    String heightError = "";
	    String weightError = "";
		
		  //Check if height and weight have some appropiate values
			if((height == null) || (height.length() == 0)) {
				heightError = "You must supply a height in inches";
			}
			if((weight == null) || (weight.length() == 0)){
				weightError = "You must supply a weight in pounds";
			}
			if(heightError.length() == 0){
				try{
					//Convert String to Float value
					heightVal = Float.valueOf(height);
					}catch(Exception e){
						heightError = "The height must be a number";
					}
			}
			
			if(weightError.length() == 0){
				try{
					weightVal = Float.valueOf(weight);
					}catch(Exception e){
						weightError = "The weight must be a number";
					}
			}
			if(heightError.length() + weightError.length() > 0){
				this.writeForm(out, height, weight, heightError, weightError);
				return;
			}
				//Calculate the bmiResult by bmi formula
				Float bmiResult = (weightVal/(heightVal * heightVal))*703;
				String result = "<html><head><title>Your BMI Index</title>"
						+ "</head><body><h1>Your bmi is "+bmiResult+"</h1></body></html>";
				//Convert String to bytes
				out.write(result.getBytes());
				//doGet(request, response);
				return;
			
			
		} 
		
		
	}

