package top.cupcupcui.neo4j.tenant.common.util.response;

public class Result<T> {

	private int code;
	private String msg;
	private T data;

	public Result() {
		super();
	}
	
	public Result(int code, String msg, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	/**
	 * 成功时候调用
	 * @param data
	 * @return
	 */
	public static <T> Result<T> success(T data){
		return new Result<T>(data);
	}

	public Result(T data) {
		this.code = 0;
		this.msg = "success";
		this.data = data;
	}

	/**
	 * 异常时候调用
	 * @param cm
	 * @return
	 */
	public static <T> Result<T> error(CodeMsg cm){
		return new Result<T>(cm);
	}
	
	/**
	 * 异常时候调用--自定义异常信息
	 * @param errMsg 异常信息
	 * @return
	 */
	public static <T> Result<T> error(String errMsg){
		return new Result<T>(errMsg);
	}

	public Result(String errMsg) {
		this.code = 1;
		this.msg = errMsg;
	}
	
	
	public Result(CodeMsg cm) {
		if (null == cm) {
			return;
		}
		this.code = cm.getCode();
		this.msg = cm.getMsg();
	}
	

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public T getData() {
		return data;
	}

	/**添加setter方法*/
	public void setCode(int code) {
		this.code = code;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
