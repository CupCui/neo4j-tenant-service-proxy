package top.cupcupcui.neo4j.tenant.dao.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.cupcupcui.neo4j.tenant.dao.INeo4jBaseQueryDao;
import top.cupcupcui.neo4j.tenant.domain.Person;
import top.cupcupcui.neo4j.tenant.repository.Neo4jBaseQueryRepository;

/**
 * @author: cuiguanghao
 * @Date: 2023/1/4 17:03
 * @Description:
 */
@Component
public class Neo4jBaseQueryDaoImpl implements INeo4jBaseQueryDao {

	@Autowired
	private Neo4jBaseQueryRepository neo4jQueryRepo;

	@Override
	public String getPersonByName(String name) {
		Person person = neo4jQueryRepo.getPersonByName(name);
		return JSONObject.toJSONString(person);
	}
}
