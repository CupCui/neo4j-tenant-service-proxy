package top.cupcupcui.neo4j.tenant.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.util.UriComponentsBuilder;
import springfox.documentation.OperationNameGenerator;
import springfox.documentation.PathProvider;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.DefaultPathProvider;
import springfox.documentation.spring.web.paths.Paths;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 *
 */
@Configuration
@EnableSwagger2WebMvc
public class Swagger2ApiConfig {

    @Bean
    public Docket createOpenApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("Neo4j Tenant API").apiInfo(apiOpenInfo()).select()
        //为当前包路径
        .apis(RequestHandlerSelectors.basePackage("top.cupcupcui.neo4j.tenant.web.controller")).paths(PathSelectors.any()).build();
    }

	//构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiOpenInfo() {
        return new ApiInfoBuilder()
        //页面标题
        .title("Neo4j Tenant RESTful API")
        //创建人
        .contact(new Contact("Neo4j Tenant", "", ""))
        //版本号
        .version("1.0")
        //描述
        .description("供外部系统调用").build();
    }

    @Value("${server.servlet.context-path}")
	private String servletContextPath;
	/**
	 * 重写 PathProvider ,解决 context-path 重复问题
	 * @return
	 */
	@Bean
	public PathProvider pathProvider() {
		return new DefaultPathProvider() {
			@Override
			public String getOperationPath(String operationPath) {
				if(null==servletContextPath || servletContextPath.trim().length()==0){
					servletContextPath = "/";
				}
				operationPath = operationPath.replaceFirst(servletContextPath, "/");
				UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath("/");
				return Paths.removeAdjacentForwardSlashes(uriComponentsBuilder.path(operationPath).build().toString());
			}

			@Override
			public String getResourceListingPath(String groupName, String apiDeclaration) {
				apiDeclaration = super.getResourceListingPath(groupName, apiDeclaration);
				return apiDeclaration;
			}
		};
	}


	@Bean
	@Primary
	public OperationNameGenerator operationNameGenerator() {
		return prefix -> prefix;
	}

}
