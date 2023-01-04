package top.cupcupcui.neo4j.tenant.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import top.cupcupcui.neo4j.tenant.domain.PersonDao;

/**
 * @author: cuiguanghao
 * @Date: 2023/1/4 17:31
 * @Description:
 */
public interface Neo4jBaseQueryRepository extends PagingAndSortingRepository<PersonDao, String> {

	@Query("MATCH (n:Person {name: {name}}) RETURN n")
	PersonDao getPersonByName(@Param("name") String name);

}
