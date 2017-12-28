package com.ednTiSolutions.springBoot.webApiWithMongo.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.ednTiSolutions.springBoot.webApiWithMongo.model.Guest;
import com.ednTiSolutions.springBoot.webApiWithMongo.model.Phone;
import com.ednTiSolutions.springBoot.webApiWithMongo.repository.CustomGuestRepository;
import com.mongodb.WriteResult;

public class NewGuestRepositoryImpl implements CustomGuestRepository {

	private MongoTemplate mongoTemplate;
	
	@Autowired
	public NewGuestRepositoryImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	@Override
	public int testUpdate(String docNumber, String name) {
		Query query = new Query(Criteria.where("docNumber").is(docNumber));
		Update update = new Update();
		update.set("name", name);
		
		WriteResult wr = mongoTemplate.updateFirst(query, update, Guest.class);		
		return wr != null ? wr.getN() : 0;
	}
	
	@Override
	public int testUpdate(String docNumber, Phone phone) {
		Query query = new Query(new Criteria().andOperator(
				Criteria.where("docNumber").is(docNumber),
				Criteria.where("phones").elemMatch(Criteria.where("number").is(phone.getNumber()))
		));

		Update update = new Update();		
		Phone ph = new Phone("66", "6666-6666");
		
		update.set("phones.$", ph);
		
		WriteResult wr = mongoTemplate.updateFirst(query, update, Guest.class);		
		return wr != null ? wr.getN() : 0;
	}

}
