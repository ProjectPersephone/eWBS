package com.wbs.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.wbs.domain.Counter;

@Repository
public class CounterRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public int getNextSequence(String collectionName) {
		Query query = new Query(Criteria.where("_id").is(collectionName));
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);
		Update update = new Update();
		update.inc("sequence", 1);

		Counter counter = mongoTemplate.findAndModify(query, update, options, Counter.class);
		if (counter == null) {
			counter = new Counter();
			counter.setId(collectionName);
			counter.setSequence(100);
			mongoTemplate.insert(counter);
		}
		return counter.getSequence();
	}
}
