package com.wala.boott;

import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class BoottController {
    @Autowired
    private MongoTemplate mangoTemplate; //自动注入MongoTemplate
    
	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

	@RequestMapping(value = "/getrecords", method = RequestMethod.GET)
	@ResponseBody
	public void getrecords() {
		MongoDatabase dbc = mangoTemplate.getDb();
		MongoCollection<Document> users=dbc.getCollection("users");
        Document user=new Document();
        user.append("name", "jimmy");  
        user.append("age", "34");  
        Document address = new Document();  
        address.append("city", "bj");  
        address.append("street", "bq road");  
        address.append("mail", "ufpark 68#"); 
        user.append("address", address);  
        users.insertOne(user);
	}
}
