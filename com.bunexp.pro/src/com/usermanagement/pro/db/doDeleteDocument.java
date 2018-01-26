package com.usermanagement.pro.db;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.DBCollection;



@Path("/deletedocument")
public class doDeleteDocument {
	
	List<Document> resultRecordSet;
	MongoClient clientConnectBunexpdb = new MongoClient("localhost", 27017);
	MongoDatabase clientBunexpdb = clientConnectBunexpdb.getDatabase("bunexp");
	MongoCollection<Document> clientUserCollection = clientBunexpdb.getCollection("app.users");

	@GET
	@Produces(MediaType.TEXT_HTML)	
	public String mongoFind(@QueryParam("id") String id) throws Exception  {
		try {			
			clientUserCollection.deleteOne(new Document("_id", new ObjectId(id)));
			Document returnMessage = new Document (
					"messageId", 104)
					.append("messageDescrption", "Delete successfully ")
					.append("dateTime", new Date().getTime()
					);

			return returnMessage.toJson();
		} catch (Exception e) {
			return e.toString();
		} finally {
			clientConnectBunexpdb.close();
		}
	}
	
	@Path("/version")
	@GET
	@Produces(MediaType.TEXT_HTML)	
	public String getdocumentversion() throws Exception  {
		try {			
			return "deletedocument class version : 0001.00.00";
		} catch (Exception e) {
			return e.toString();
		} finally {
			clientConnectBunexpdb.close();
		}
	}
}
