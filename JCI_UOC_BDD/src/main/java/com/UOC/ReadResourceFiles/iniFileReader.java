package com.UOC.ReadResourceFiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import org.ini4j.InvalidFileFormatException;
import org.ini4j.Profile.Section;
import org.ini4j.Wini;

public class iniFileReader {

	public static String[] fullName = null;
	public static String To = null;
	public static String From = null;
	public static String Subject = null;
	public static String Body = null;
	public static String UserName = null;
	public static String Password = null;
	
	/*
	 * This method is to read credentials from config.ini file
	 * */
	
	public static void ReadINIFile()  throws InvalidFileFormatException, IOException
	{
		
		Path path = Paths.get(System.getProperty("user.dir") +"\\src\\main\\resources\\config.ini");
		
		 List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		 
		 //System.out.println(lines.toString());
		
		 for(String s:lines)
	    	{
	    		//System.out.println(s);
	    		fullName = s.split("=");
	    		String tag = fullName[0];
	    		System.out.println(tag);
	    		if(tag.equalsIgnoreCase("To"))
	    		{
	    			To = fullName[1];
	    			//System.out.println(To);
	    		}
	    		else if(tag.equalsIgnoreCase("From"))
	    		{
	    			
	    			From = fullName[1];
	    			//System.out.println(From);
					
	    		}
	    		else if(tag.equalsIgnoreCase("Subject"))
	    		{
	    			
					Subject = fullName[1];
	    		}
	    		else if(tag.equalsIgnoreCase("Body"))
	    		{
	    			Body = fullName[1];
	    			//System.out.println(Body);

	    		}
	    		else if(tag.equalsIgnoreCase("UserName"))
	    		{
	    			UserName = fullName[1];
	    			//System.out.println(UserName);

	    		}
	    		else if(tag.equalsIgnoreCase("Password"))
	    		{
	    			Password = fullName[1];
	    			//System.out.println(Password);

	    		}
	    	}        

	} 
		 
		 
	
}
