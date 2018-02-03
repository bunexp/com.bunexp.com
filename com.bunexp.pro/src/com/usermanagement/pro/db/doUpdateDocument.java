package com.usermanagement.pro.db;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Path("/updatedocument")
public class doUpdateDocument {
	MongoClient clientConnectBunexpdb = new MongoClient("localhost", 27017);
	MongoDatabase clientBunexpdb = clientConnectBunexpdb.getDatabase("bunexp");
	MongoCollection<Document> clientUserCollection = clientBunexpdb.getCollection("app.users");

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String insertDocument(@QueryParam("firstname") String firstName, @QueryParam("lastname") String lastName,
			@QueryParam("username") String userName, @QueryParam("password") String password,
			@QueryParam("role") String role, @QueryParam("gender") String gender) throws Exception {
		try {

			Bson filter = new Document("first_name", firstName);
			Bson newValue = new Document("last_name", lastName);
			Bson updateOperationDocument = new Document("$set", newValue);
			clientUserCollection.updateOne(filter, updateOperationDocument);

			System.out.println(newValue.toString());

			Document returnMessage = new Document("messageId", 104).append("messageDescrption", "Update successfully ")
					.append("dateTime", new Date().getTime());

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
	public String documentversion() throws Exception {
		try {
			return "updatedocument class version : 0001.00.00";
		} catch (Exception e) {
			return e.toString();
		} finally {
			clientConnectBunexpdb.close();
		}
	}
}