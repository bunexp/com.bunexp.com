package com.usermanagement.pro.db;

import java.util.Date;
import java.util.Map;

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

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)

	public String insertDocument(Map<String, Object> data) throws Exception {
		try {
			Document InsertedDoc = new Document(data);

			clientUserCollection.insertOne(InsertedDoc);

			Document returnMessage = new Document("messageId", 104)
					.append("messageDescrption", "Inserted successfully !!").append("dateTime", new Date().getTime());

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
	public String getdocumentversion() throws Exception {
		try {
			return "insertdocument class version : 0001.00.00";
		} catch (Exception e) {
			return e.toString();
		} finally {
			clientConnectBunexpdb.close();
		}
	}
}
