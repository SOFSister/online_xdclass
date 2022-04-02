package net.xdclass.online_xdclass.exception;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Soft_Sister
 * @version : 1.0
 * @Project : online_xdclass
 * @Package : net.xdclass.online_xdclass.exception
 * @ClassName : XDException.java
 * @createTime : 2022/3/5 21:12
 * @Email : 874280179@qq.com
 * @Description :自定义异常类
 */
public class XDException extends RuntimeException{

    private Integer code;

    private String msg;

    public XDException(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
