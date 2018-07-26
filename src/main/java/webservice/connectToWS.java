package webservice;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URLConnection;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


import java.net.*;





public class connectToWS {
	
	public String someMethod() throws MalformedURLException, IOException {

		//Code to make a webservice HTTP request
		String responseString = "";
		String outputString = "";
		String wsURL = "https://coreapi.cert.heb.com:8443/SOAP/v1/CostService?wsdl";
		URL url = new URL(wsURL);
		URLConnection connection = url.openConnection();
		HttpURLConnection httpConn = (HttpURLConnection)connection;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		String xmlInput = "entire SOAP Request";

		byte[] buffer = new byte[xmlInput.length()];
		buffer = xmlInput.getBytes();
		bout.write(buffer);
		byte[] b = bout.toByteArray();
		String SOAPAction = "<SOAP action of the webservice to be consumed>";
		// Set the appropriate HTTP parameters.
		httpConn.setRequestProperty("Content-Length",
		String.valueOf(b.length));
		httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
		httpConn.setRequestProperty("SOAPAction", SOAPAction);
		httpConn.setRequestMethod("POST");
		httpConn.setDoOutput(true);
		httpConn.setDoInput(true);
		OutputStream out = httpConn.getOutputStream();
		//Write the content of the request to the outputstream of the HTTP Connection.
		out.write(b);
		out.close();
		//Ready with sending the request.

		//Read the response.
		InputStreamReader isr = null;
		if (httpConn.getResponseCode() == 200) {
		  isr = new InputStreamReader(httpConn.getInputStream());
		} else {
		  isr = new InputStreamReader(httpConn.getErrorStream());
		}

		BufferedReader in = new BufferedReader(isr);

		//Write the SOAP message response to a String.
		while ((responseString = in.readLine()) != null) {
		outputString = outputString + responseString;
		}
		//Parse the String output to a org.w3c.dom.Document and be able to reach every node with the org.w3c.dom API.
		Document document = parseXmlFile(outputString); // Write a separate method to parse the xml input.
		NodeList nodeLst = document.getElementsByTagName("<TagName of the element to be retrieved>");
		String elementValue = nodeLst.item(0).getTextContent();
		System.out.println(elementValue);

		//Write the SOAP message formatted to the console.
		String formattedSOAPResponse = formatXML(outputString); // Write a separate method to format the XML input.
		System.out.println(formattedSOAPResponse);
		return elementValue;
		}

	private String formatXML(String outputString) {
		return null;
	}

	private Document parseXmlFile(String outputString) {
		try {
	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        InputSource is = new InputSource(new StringReader(outputString));
	        return db.parse(is);
	    } catch (ParserConfigurationException e) {
	        throw new RuntimeException(e);
	    } catch (SAXException e) {
	        throw new RuntimeException(e);
	    } catch (IOException ioe) {
	        throw new RuntimeException(ioe);
	    }catch (Exception ex) {
	        throw new RuntimeException(ex);
	}

}
}
