package com.UOC.ReadResourceFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    @SuppressWarnings("unused")
	private File files;
	private Properties properties;
	private final String propertyFilePath= System.getProperty("user.dir") + "//src//main//resources//Config.properties";
			
	
      public ConfigFileReader() throws IOException{
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);//Load the file 
				reader.close(); //close the file 
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
		try {
		 Properties obj = new Properties();
		 
		 
		 FileInputStream Prop = new FileInputStream(System.getProperty("user.dir")+ "//src//main//resources//Config.properties");
		 obj.load(Prop);
		}
		 catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("Configuration.properties not found at " + propertyFilePath); 
		 
		 } 
      
      } 
      
      public String getApplicationUrl() {
  		String url = properties.getProperty("url");
  		if(url != null) return url;
  		else throw new RuntimeException("url not specified in the Configuration.properties file.");
  	}

      
           
      public String MindteckWebmailUrl(){
    		String webemail = properties.getProperty("mindteckEmailurl");
    		if(webemail!= null) return webemail;
    		else throw new RuntimeException("mindteck WebEmail not specified in the Configuration.properties file.");		
    	}
      
      public String Emailhost(){
    		String hostname = properties.getProperty("EmailHost");
    		if(hostname!= null) return hostname;    		
    		else throw new RuntimeException("mindteck Email Host not specified in the Configuration.properties file.");		
    	} 
      
      public String EmailPort(){
  		String portnumber = properties.getProperty("EmailPort");
  		if(portnumber!= null) return portnumber;    		
  		else throw new RuntimeException("mindteck Email Port not specified in the Configuration.properties file.");		
  	}
      
      public String EmailFolder(){
    		String folder = properties.getProperty("EmailFolder");
    		if(folder!= null) return folder;    		
    		else throw new RuntimeException("Mindteck Email Folder is not specified in the Configuration.properties file.");		
    	}
      
      public String EmailStore(){
  		String StoreName = properties.getProperty("EmailStore");
  		if(StoreName!= null) return StoreName;    		
  		else throw new RuntimeException(" Please select IMAP/SMTP as Email Store ");		
  	}
       	
      public String usenameId(){
  		String usenameId = properties.getProperty("userName");
  		if(usenameId!= null) return usenameId;
  		else throw new RuntimeException("Not specified in the Configuration.properties file.");		
  	}
      
      public String userPassword(){
    		String passwordId = properties.getProperty("userPassword");
    		if(passwordId!= null) return passwordId;
    		else throw new RuntimeException("Not specified in the Configuration.properties file.");		
    	}
      
      public String Loginbutton(){
  		String Loginbutton = properties.getProperty("btnLogin");
  		if(Loginbutton!= null) return Loginbutton;
  		else throw new RuntimeException("Not specified in the Configuration.properties file.");		
  	}
      
      public String Logintitle(){
    		String LoginTitle = properties.getProperty("LoginTitle");
    		if(LoginTitle!= null) return LoginTitle;
    		else throw new RuntimeException("Not specified in the Configuration.properties file.");		
    	}
      
      public String Loginvalidation(){
  		String Loginvalidation = properties.getProperty("Errormessage");
  		if(Loginvalidation!= null) return Loginvalidation;
  		else throw new RuntimeException("Not specified in the Configuration.properties file.");		
  	}
    
      public String Logout(){
    		String logout = properties.getProperty("Logout");
    		if(logout!= null) return logout;
    		else throw new RuntimeException("Not specified in the Configuration.properties file.");		
    	}
      
      public String getInvalidUsername(){
  		String usernameinvalid = properties.getProperty("usernameinvalid");
  		if(usernameinvalid!= null) return usernameinvalid;
  		else throw new RuntimeException(" Not specified in the Configuration.properties file.");		
  	}
  	
  	  public String getInvalidPassword(){
  		String InvalidPassword = properties.getProperty("InvalidPassword");
  		if(InvalidPassword!= null) return InvalidPassword;
  		else throw new RuntimeException("Not specified in the Configuration.properties file.");		
  	} 
  	
  	
      
}
	