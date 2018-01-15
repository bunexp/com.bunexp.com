package com.bunexp.pro.db;

import java.util.Date;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/dbManagement")
public class doInsertDocument {
	MongoClient clientBunexpdb = new MongoClient("localhost", 27017);
	MongoDatabase db = clientBunexpdb.getDatabase("bunexp");
	MongoCollection<Document> coll = db.getCollection("app.users");
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String insertDocument()  throws Exception {
		return "Good test ";
	}
	
	@GET
	@Path("/insertDocument")
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
			coll.insertOne(InsertedDoc); // second insert

			Document returnMessage = new Document (
					"messageId", 104)
					.append("messageDescrption", "Inserted successfully ")
					.append("dateTime", new Date().getTime()
					);

			return returnMessage.toJson();

		} catch (Exception e) {
			return e.getMessage();
		} finally {
			clientBunexpdb.close();
		}

	}
}
