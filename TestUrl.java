package com.testurl.org;


import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class TestUrl
{		
	private String inputLine;
	private Map<String,String> urlPars = new HashMap<String,String>();
	
//	public URL obj;
//	TestUrl(URL obj1)
//	{
//		obj= obj1;
//	}
	
	public String display (String disp)
	{
		return disp;
	}
	
	public Map<String,String> parseUrl (String testUrl) throws MalformedURLException
	{
		try
		{
			URL aURL = new URL(testUrl);		
//			System.out.println("protocol = " + aURL.getProtocol());
			urlPars.put("protocol", aURL.getProtocol());
//			System.out.println("authority = " + aURL.getAuthority());
			urlPars.put("authority", aURL.getAuthority());
//			System.out.println("host = " + aURL.getHost());
			urlPars.put("host", aURL.getHost());
//			System.out.println("port = " + aURL.getPort());
			urlPars.put("port", Integer.toString(aURL.getPort()));
//			System.out.println("path = " + aURL.getPath());
			urlPars.put("path", aURL.getPath());
//			System.out.println("query = " + aURL.getQuery());
			urlPars.put("query", aURL.getQuery());
//			System.out.println("filename = " + aURL.getFile());
			urlPars.put("filename", aURL.getFile());
//			System.out.println("ref = " + aURL.getRef());
			urlPars.put("ref", aURL.getRef());			
			urlPars.put("defaultPort",Integer.toString(aURL.getDefaultPort()));
			urlPars.put("userInfo",aURL.getUserInfo());
		}
		catch (MalformedURLException e)
	    {
	        System.err.println(e.getMessage()); 
	    }		
		
		return urlPars;
	}
	
	public String parseUrlContent(String testUrl) throws MalformedURLException
	{		
		try
		{
			URL parseUrl = new URL(testUrl);
	        URLConnection urlc = parseUrl.openConnection();
	        BufferedReader in = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
	        while ((inputLine = in.readLine()) != null)
	        	inputLine = inputLine + inputLine;
//	            System.out.println(inputLine);
	        in.close();
			
//			URL parseUrl = new URL(testUrl);			
//			BufferedReader in = new BufferedReader(new InputStreamReader(parseUrl.openStream()));			
//			while ((inputLine = in.readLine()) != null)
//				inputLine = inputLine + inputLine;
////				System.out.println(inputLine);
//			in.close();
		}
		catch (MalformedURLException e)
	    {
	        System.err.println(e.getMessage()); 
	    }
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
        }
		return inputLine;
	}
	
	public void parseUrlHeader(String testUrl) throws MalformedURLException
	{
		try
		{
			URL obj = new URL(testUrl);
			URLConnection conn = obj.openConnection();
			Map<String, List<String>> map = conn.getHeaderFields();		 			
		 
			for (Map.Entry<String, List<String>> entry : map.entrySet())
				System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
		 			
			String server = conn.getHeaderField("Server");		 
			if (server == null)
			{
				System.out.println("Server is found!");
			}
			else
			{
				System.out.println("Server: " + server);
			}			
		 
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}		
	}
}
