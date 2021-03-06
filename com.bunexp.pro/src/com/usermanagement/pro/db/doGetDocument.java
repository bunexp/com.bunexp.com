package com.usermanagement.pro.db;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;

import java.util.ArrayList;
import java.util.List;

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

import com.mongodb.util.JSON;


@Path("/getdocument")
public class doGetDocument {

	List<Document> resultRecordSet;
	MongoClient clientConnectBunexpdb = new MongoClient("localhost", 27017);
	MongoDatabase clientBunexpdb = clientConnectBunexpdb.getDatabase("bunexp");
	MongoCollection<Document> clientUserCollection = clientBunexpdb.getCollection("app.users");
	@GET
	@Produces(MediaType.APPLICATION_JSON)
			//(MediaType.TEXT_HTML)	
	public String mongoFind(@QueryParam("firstname") String firstName) throws Exception  {
		try {			
			
			Bson filter = and(eq("first_name", firstName)); // , gt("userId", 10), lt("userId", 90));
			Bson projection = fields(include("_id"
					,"first_name"
					, "last_name"
					,"credential.user_name"
					,"credential.password"
					,"gender"
					,"insertedTime"));
					//,"insertedTime"), excludeId());
			resultRecordSet = clientUserCollection
					.find(filter)
					.projection(projection)
					.into(new ArrayList<Document>());

			return JSON.serialize(resultRecordSet);
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
			return "getdocument class version : 0001.00.00";
		} catch (Exception e) {
			return e.toString();
		} finally {
			clientConnectBunexpdb.close();
		}
	}
}