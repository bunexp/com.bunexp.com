package com.usermanagement.pro.db;

import java.util.Date;
import java.util.List;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/insertdocument")
public class doInsertDocument {
	MongoClient clientConnectBunexpdb = new MongoClient("localhost", 27017);
	MongoDatabase clientBunexpdb = clientConnectBunexpdb.getDatabase("bunexp");
	MongoCollection<Document> clientUserCollection = clientBunexpdb.getCollection("app.users");	

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String insertDocument(@QueryParam("firstname") String firstName
			,@QueryParam("lastname") String lastName
			, @QueryParam("username") String userName
			, @QueryParam("password") String password
			, @QueryParam("role") String role
			, @QueryParam("gender") String gender)  throws Exception  {
		try {

			Document credential = new Document ("user_name", userName)
					.append("password", password);
			
			Document InsertedDoc = new Document("first_name", firstName)
					.append("last_name", lastName)
					.append("gender", gender)
					.append("insertedTime", new Date().getTime())
					.append("credential", credential);
										
			// doc.remove("_id"); // remove the _id key
			clientUserCollection.insertOne(InsertedDoc); // second insert

			Document returnMessage = new Document (
					"messageId", 104)
					.append("messageDescrption", "Inserted successfully ")
					.append("dateTime", new Date().getTime()
					);

			return returnMessage.toJson();

		} catch (Exception e) {
			return e.getMessage();
		} finally {
			clientConnectBunexpdb.close();
		}

	}
	
	@Path("/version")
	@GET
	@Produces(MediaType.TEXT_HTML)	
	public String getdocumentversion() throws Exception  {
		try {			
			return "insertdocument class version : 0001.00.00";
		} catch (Exception e) {
			return e.toString();
		} finally {
			clientConnectBunexpdb.close();
		}
	}
}
