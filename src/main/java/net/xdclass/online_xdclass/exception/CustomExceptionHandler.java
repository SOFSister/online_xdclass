package net.xdclass.online_xdclass.exception;

import net.xdclass.online_xdclass.utils.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Soft_Sister
 * @version : 1.0
 * @Project : online_xdclass
 * @Package : net.xdclass.online_xdclass.exception
 * @ClassName : CutomExceptionHandler.java
 * @createTime : 2022/3/5 21:17
 * @Email : 874280179@qq.com
 * @Description :异常处理类
 */
@ControllerAdvice
public class CustomExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData handle(Exception e){

        logger.error("[ 系统异常 ]{}",e);

        if(e instanceof XDException){

            XDException xdException = (XDException) e;

            return JsonData.buildError(xdException.getCode(), xdException.getMsg());

        }else{

            return JsonData.buildError("全局异常，未知错误");

        }

    }


}
