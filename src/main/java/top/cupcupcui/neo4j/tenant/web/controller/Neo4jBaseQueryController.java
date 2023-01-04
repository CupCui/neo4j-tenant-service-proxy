package top.cupcupcui.neo4j.tenant.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.cupcupcui.neo4j.tenant.common.util.response.Result;
import top.cupcupcui.neo4j.tenant.service.INeo4jBaseQueryService;

/**
 * @author: cuiguanghao
 * @Date: 2023/1/4 16:58
 * @Description:
 */
@Api(tags = "Redis查询资源接口")
@RestController
public class Neo4jBaseQueryController implements IOpenV01RestCtl {
	private static final Logger LOG = LoggerFactory.getLogger(Neo4jBaseQueryController.class);

	@Autowired
	private INeo4jBaseQueryService neo4jQuerySvs;

	/**
	 * 根据name查询资源
	 * @param name
	 * @return
	 */
	@ApiOperation(value = "根据name查询资源", notes = "根据name查询资源")
	@GetMapping(value = "/neo4j/person")
	@ResponseBody
	public Result<String> getPersonByName(@ApiParam(value = "name", required = true) @RequestParam("name") String name) {
		Result<String> resp = new Result<>();
		try {
			LOG.info("getPersonByName start");
			String result = neo4jQuerySvs.getPersonByName(name);
			LOG.info("getPersonByName end, result:{}", result);
			resp.setData(result);
			resp.setMsg("success");
		} catch (Exception e) {
			resp.setCode(1);
			resp.setMsg(e.toString());
			LOG.error("getPersonByName is fail! ", e);
		}
		return resp;

	}

}
