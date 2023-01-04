package top.cupcupcui.neo4j.tenant.common.util.response;

import java.io.Serializable;

public class CodeMsg implements Serializable{

	private static final long serialVersionUID = -9059715439570343922L;

	private int code;

	private String msg;

	// 通用结果集
	public static final CodeMsg SUCCESS = new CodeMsg(0, "success");
	public static final CodeMsg SERVER_ERROR = new CodeMsg(1, "服务端异常");
    public static final CodeMsg ERROR_CODE_REQUEST_PARAM_IS_EMPTY = new CodeMsg(100001, "请求参数为空");
    public static final CodeMsg ERROR_CODE_ACCOUNT_PW_WRONG = new CodeMsg(100002, "账号或密码错误");
    public static final CodeMsg ERROR_CODE_ACCOUNT_NOT_EXIST = new CodeMsg(100003, "账号不存在");
    public static final CodeMsg ERROR_CODE_ACCOUNT_LOCKED = new CodeMsg(100004, "账号被锁定");
    public static final CodeMsg ERROR_CODE_ACCOUNT_LOGOFF = new CodeMsg(100005, "账号被注销");
    public static final CodeMsg ERROR_CODE_SAVE_DATA_ERROR = new CodeMsg(100006, "数据存储异常");
    public static final CodeMsg ERROR_CODE_UPDATE_DATA_ERROR = new CodeMsg(100007, "数据更新异常");
    public static final CodeMsg ERROR_CODE_DELETE_DATA_ERROR = new CodeMsg(100008, "数据删除异常");
    public static final CodeMsg ERROR_CODE_BUSINESS_DATA_ERROR = new CodeMsg(100009, "业务数据返回为空");
    public static final CodeMsg ERROR_CODE_QUERY_DATA_ERROR = new CodeMsg(100010, "ID已经存在");
    public static final CodeMsg ERROR_CODE_NO_PARAMS_ERROR = new CodeMsg(100011, "未取得参数");
    public static final CodeMsg ERROR_CODE_CHECK_PARAMS_ERROR = new CodeMsg(100012, "参数校验失败");
    public static final CodeMsg BIND_ERROR = new CodeMsg(100013, "参数校验异常：%s");
    
    // 配置信息库-资源类别视图
    public static final CodeMsg ERROR_CODE_RES_TYPE_VIEW_ERROR = new CodeMsg(400001, "pasm同步资源,不允许删除");

    // 作业平台异常结果集
    public static final CodeMsg ERROR_CODE_TASK_NAME_ERROR = new CodeMsg(200001, "作业名称已经存在");
    public static final CodeMsg ERROR_CODE_SCRIPT_NAME_ERROR = new CodeMsg(200002, "脚本名称已经存在");
    public static final CodeMsg ERROR_CODE_IS_NOT_CHINA_ERROR = new CodeMsg(20003, "脚本名称不能包含中文或-(中划线)");
    public static final CodeMsg ERROR_CODE_SCRIPT_PARAM_NAME_ERROR = new CodeMsg(20004, "参数名称不能包含中文或-(中划线)");

    // 自动发现平台异常结果集
    public static final CodeMsg ERROR_CODE_AUTO_FIND_ERROR = new CodeMsg(300001, "采集资源属性失败");
    public static final CodeMsg ERROR_CODE_AUTO_FIND_ACCOUNT_ERROR = new CodeMsg(300002, "用户名或密码错误");
    public static final CodeMsg ERROR_CODE_AUTO_FIND_ACCOUNTNULL_ERROR = new CodeMsg(300003, "用户名、密码返回为空,请手动输入!");

	public CodeMsg(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	
	public CodeMsg fillArgs(Object... args) {
		int cod = this.code;
		String message = String.format(this.msg, args);
		return new CodeMsg(cod, message);
	}
	
	// 数据字典导入 提示
	public static final String IMPORT_SUCCESS = "SUCCESS";
	public static final String IMPORT_REPEAT_COVER_SUCCESS = "COVERSUCCESS";
}
