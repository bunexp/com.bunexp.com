package com.bunexp.pro.db;

import java.net.UnknownHostException;
import java.util.Date;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Path("/insertdoc")
public class doInsertDocument {
	MongoClient clientTestdb = new MongoClient( "localhost" , 27017 );
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String insertDocument(){
		try {
			MongoDatabase db = clientTestdb.getDatabase("testdb");
			MongoCollection<Document> coll = db.getCollection("user");

			Document doc = new Document("first_name", "Abril").append("last_name", "Linares").append("gender", "Male")
					.append("insertedTime", new Date().getTime());

			// doc.remove("_id"); // remove the _id key
			coll.insertOne(doc); // second insert
			//System.out.println(doc.toJson());
			 
			return "Inserted successfully for Abril" + new Date().getTime();

		} catch (Exception e) {
			return e.getMessage();
		} finally {
			clientTestdb.close();
			// return "returning Finallyes and no";
		}

	}
}
