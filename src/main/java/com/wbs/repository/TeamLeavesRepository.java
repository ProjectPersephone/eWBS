package com.wbs.repository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import com.wbs.domain.TeamLeaves;

@Repository
public class TeamLeavesRepository {
	
		@Autowired
		private MongoTemplate mongoTemplate;

		public void save(TeamLeaves teamLeaves ) {
			System.out.println("TeamLeaves :" + teamLeaves);
			mongoTemplate.save(teamLeaves);
		}
		
		/*public TeamLeaves findProject(String projectName) {
			Query query = new Query(Criteria.where("projectName").is(projectName));
			return mongoTemplate.findOne(query, TeamLeaves.class);
		}*/
		
		public List<TeamLeaves> findAllTeamLeaves() {
			return mongoTemplate.findAll(TeamLeaves.class);
		}

}
