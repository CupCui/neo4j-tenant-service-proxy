package top.cupcupcui.neo4j.tenant.config;


import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.PathProvider;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 *
 */
@Configuration
@EnableSwagger2WebMvc
public class Swagger2ApiConfig {

	private static final String DESCRIPTION = "My application description";

	private static final String TITLE = " My service title";

	private static final String API_VERSION = "1.0";

	@Value("${server.servlet.context-path}")
	private String contextPath;

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(TITLE).description(DESCRIPTION).version(API_VERSION).build();
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).pathProvider(new PathProvider() {
			@Override
			public String getOperationPath(String operationPath) {
				return operationPath.replace(contextPath, StringUtils.EMPTY);
			}

			@Override
			public String getResourceListingPath(String groupName, String apiDeclaration) {
				return null;
			}
		}).select().apis(RequestHandlerSelectors.withClassAnnotation(Api.class)).build().apiInfo(apiInfo());
	}

	@Bean
	public UiConfiguration uiConfig() {
		return UiConfigurationBuilder.builder().displayRequestDuration(true).validatorUrl(StringUtils.EMPTY).build();
	}

}
