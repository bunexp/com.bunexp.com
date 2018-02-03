package com.bunexp.pro.db;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/packagedescription")
public class packageDescription {
	@GET
	@Produces(MediaType.TEXT_HTML)	
	public String packageDescription(@QueryParam("packageName") String packageName) throws Exception  {
		try {	
	        if (packageName.equals("usermanagement")) {
	        		return "<!DOCTYPE html>\n" + 
	        				"<html>\n" + 
	        				"\n" + 
	        				"  <head>\n" + 
	        				"    <link rel=\"stylesheet\" href=\"style.css\">\n" + 
	        				"    <script src=\"script.js\"></script>\n" + 
	        				"  </head>\n" + 
	        				"\n" + 
	        				"  <body>\n" + 
	        				"    <h3 align=\"center\">API Description</h3>\n" + 
	        				"  <table border=1 style=\"width:100%\">\n" + 
	        				"  <tr>\n" + 
	        				"    <th align=left>Clase Name</th>\n" + 
	        				"    <th align=left>Versioin</th>\n" + 
	        				"    <th align=left>Description</th>\n" + 
	        				"    <th align=left>Specting</th>\n" + 
	        				"    <th align=left>Returning</th>\n" + 
	        				"  </tr>\n" + 
	        				"  <tr>\n" + 
	        				"    <td align=left>doInsertDocument</td>\n" + 
	        				"    <td align=left>0001.00.00</td>\n" + 
	        				"    <td align=left>Adding users insering</td>\n" + 
	        				"    <td align=left>firstname,\n" + 
	        				"lastname,\n" + 
	        				"username,\n" + 
	        				"password,\n" + 
	        				"gender</td>\n" + 
	        				"    <td>\n" + 
	        				"      { \"messageId\" : 104, \"messageDescrption\" : \"Inserted successfully \", \"dateTime\" : { \"$numberLong\" : \"1516685905660\" } }\n" + 
	        				"    </td>\n" + 
	        				"  </tr>\n" + 
	        				"  <tr>\n" + 
	        				"    <td colspan=10>\n" + 
	        				"      Example of request:http://bunexp.eastus.cloudapp.azure.com:8080/com.bunexp.pro/api/insertdocument?firstname=bolivar&lastname=soriano&username=bsoriano&password&thisMyPass&gender=masculino\n" + 
	        				"    </td>\n" + 
	        				"  </tr>\n" + 
	        				"</table>\n" + 
	        				"  </body>\n" + 
	        				"\n" + 
	        				"</html>";
	        } else if (packageName == "usermanagement1") {
	        	return "first "+packageName;
	        } else if (packageName == "usermanagement2") {
	        	return "first "+packageName;
	        } else if (packageName == "usermanagement3") {
	        	return "first "+packageName;
	        } else {
	        	return "first last "+packageName;
	        }
			
		} catch (Exception e) {
			return e.toString();
		} finally {
			System.out.println(packageName);	
		}
	}
}
 