package top.cupcupcui.neo4j.tenant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.cupcupcui.neo4j.tenant.dao.INeo4jBaseQueryDao;
import top.cupcupcui.neo4j.tenant.service.INeo4jBaseQueryService;

/**
 * @author: cuiguanghao
 * @Date: 2023/1/4 17:01
 * @Description:
 */
@Service
public class Neo4jBaseQueryServiceImpl implements INeo4jBaseQueryService {

	@Autowired
	private INeo4jBaseQueryDao neo4jQueryDao;

	@Override
	public String getPersonByName(String name) {
		return neo4jQueryDao.getPersonByName(name);
	}
}
