package com.testurl.org;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TestUrlTest
{
	private TestUrl tester = new TestUrl();
	private Map<String,String> urlPars = new HashMap<String,String>();
	
	public ArrayList<String> readInputUrlFile(String filePath) throws FileNotFoundException
	{
	    ArrayList<String> line = new ArrayList<String>();
	    FileInputStream fstream = new FileInputStream(filePath);
	    BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
	    try
	    {    	
		    String strLine;		   
		    while ((strLine = br.readLine()) != null)
		    {
		    	if (strLine.matches("^#.*$"))
		    	{
					continue;					
				}
		    	else
		    	{
		    		line.add(strLine);
//			    	System.out.println (strLine);
		    	}	
		    }
	    }
	    catch (Exception e)
	    {
	        System.err.println(e.getMessage()); 
	    }
	    finally
	    {
	        if (fstream != null) { try { fstream.close(); } catch(Throwable t) { /* ensure close happens */ } }
	        if (br != null) { try { br.close(); } catch(Throwable t) { /* ensure close happens */ } }
	    }
	    
	    return(line);
	 }
	
	@Test
	public void testDisplay()
	{		
	    assertEquals("NaveeN",tester.display("NaveeN"));
	    System.out.println(tester.display("NaveeN"));	    
	}
	
	@Test
	public void testParseUrl1() throws MalformedURLException
	{
		
		try
	    {
	    	List<String> lines = readInputUrlFile("rsc/URLs.txt");    	
//	    	Iterator itr= lines.iterator();	    	
//	    	while(itr.hasNext())
//	    	System.out.println(itr.next());
	    	for (String line : lines)
	    	{
	    		urlPars = tester.parseUrl(line);
//	    		System.out.println("The urlPars contains " + urlPars.size() + " pairs");	    		
	    		System.out.println("\t----------------------------");
	    		System.out.println("\tparsing URL: " + line);
	    		for (String key : urlPars.keySet() )
	    		{
	    			String value = urlPars.get( key );
	    			System.out.println( "\t"+ key + ": " + value);
	    		} 
	    		System.out.println("\t----------------------------");	    		
	    	}	    	
	    }
	    catch (FileNotFoundException e)
	    {
	        System.err.println(e.getMessage()); 
	    }
		catch (MalformedURLException e)
	    {
	        System.err.println(e.getMessage()); 
	    }
	}

	@Test
	public void testUrlContent2() throws MalformedURLException
	{			
		try
		{
			List<String> lines = readInputUrlFile("rsc/URLs.txt");
	    	for (String line : lines)
	    	{	    	
	    		System.out.println("\t----------------------------");
	    		System.out.println("\tContent of URL : " +line);	    			    		
	    		System.out.println(tester.parseUrlContent(line));
	    		System.out.println("\t----------------------------");
	    	}	
		}
		catch (FileNotFoundException e)
	    {
	        System.err.println(e.getMessage()); 
	    }
		catch (MalformedURLException e)
	    {
	        System.err.println(e.getMessage()); 
	    }
	}
	
	@Test
	public void testUrlHeader3() throws MalformedURLException
	{
		try
		{
			List<String> lines = readInputUrlFile("rsc/URLs.txt");
	    	for (String line : lines)
	    	{	    	
	    		System.out.println("\t----------------------------");
	    		System.out.println("\tContent of URL Header : " +line);	    			    		
	    		tester.parseUrlHeader(line.toString());
	    		System.out.println("\t----------------------------");
	    	}			
		}
		catch (FileNotFoundException e)
	    {
	        System.err.println(e.getMessage()); 
	    }
		catch (MalformedURLException e)
	    {
	        System.err.println(e.getMessage()); 
	    }
	}
}
