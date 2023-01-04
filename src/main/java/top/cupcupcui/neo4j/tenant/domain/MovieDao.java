package top.cupcupcui.neo4j.tenant.domain;

import lombok.*;

/**
 * @author: cuiguanghao
 * @Date: 2023/1/4 17:32
 * @Description:
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class MovieDao {
	private String title;
	private String tagline;
	private int released;

}
