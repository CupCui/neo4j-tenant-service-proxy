package top.cupcupcui.neo4j.tenant.domain;

import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 * @author: cuiguanghao
 * @Date: 2023/1/4 17:49
 * @Description:
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NodeEntity
public class Person {

	@Id
	@GeneratedValue
	private Long id;

	@Property(name = "name")
	private String name;

	@Property(name = "born")
	private int born;

}
