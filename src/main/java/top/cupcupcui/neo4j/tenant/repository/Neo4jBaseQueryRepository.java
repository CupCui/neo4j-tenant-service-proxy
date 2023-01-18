package top.cupcupcui.neo4j.tenant.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import top.cupcupcui.neo4j.tenant.domain.Person;

/**
 * @author: cuiguanghao
 * @Date: 2023/1/4 17:31
 * @Description:
 */
@Repository
public interface Neo4jBaseQueryRepository extends PagingAndSortingRepository<Person, String> {

	@Query("MATCH (n:Person) WHERE n.name = {name} RETURN n limit 1")
	Person getPersonByName(@Param("name") String name);

}
