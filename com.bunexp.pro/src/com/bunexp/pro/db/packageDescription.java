package com.bunexp.pro.db;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bson.Document;
import org.bson.types.ObjectId;

@Path("/packagedescription")
public class packageDescription {
	@GET
	@Produces(MediaType.TEXT_HTML)	
	public String packageDescription(@QueryParam("packageName") String packagename) throws Exception  {
		try {	
	        if (packagename.equals("usermanagement")) {
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
	        } else if (packagename == "usermanagement1") {
	        	return "first "+packagename;
	        } else if (packagename == "usermanagement2") {
	        	return "first "+packagename;
	        } else if (packagename == "usermanagement3") {
	        	return "first "+packagename;
	        } else {
	        	return "first last "+packagename;
	        }
			
		} catch (Exception e) {
			return e.toString();
		} finally {
			System.out.println(packagename);	
		}
	}
}



/*
 <!DOCTYPE html>
<html>

  <head>
    <link rel="stylesheet" href="style.css">
    <script src="script.js"></script>
  </head>

  <body>
    <h3 align="center">API Description</h3>
  <table border=1 style="width:100%">
  <tr>
    <th align=left>Clase Name</th>
    <th align=left>Versioin</th>
    <th align=left>Description</th>
    <th align=left>Specting</th>
    <th align=left>Returning</th>
  </tr>
  <tr>
    <td align=left>doInsertDocument</td>
    <td align=left>0001.00.00</td>
    <td align=left>Adding users insering</td>
    <td align=left>firstname,
lastname,
username,
password,
gender</td>
    <td>
      { "messageId" : 104, "messageDescrption" : "Inserted successfully ", "dateTime" : { "$numberLong" : "1516685905660" } }
    </td>
  </tr>
  <tr>
    <td colspan=10>
      Example of request:http://bunexp.eastus.cloudapp.azure.com:8080/com.bunexp.pro/api/insertdocument?firstname=bolivar&lastname=soriano&username=bsoriano&password&thisMyPass&gender=masculino
    </td>
  </tr>
</table>
  </body>

</html>
 */
 