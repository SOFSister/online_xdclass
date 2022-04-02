package net.xdclass.online_xdclass.controller;

import net.xdclass.online_xdclass.model.entity.VideoOrder;
import net.xdclass.online_xdclass.model.request.VideoOrderRequest;
import net.xdclass.online_xdclass.service.VideoOrderService;
import net.xdclass.online_xdclass.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Soft_Sister
 * @version : 1.0
 * @Project : online_xdclass
 * @Package : net.xdclass.online_xdclass.controller
 * @ClassName : VideoOrderController.java
 * @createTime : 2022/3/8 14:07
 * @Email : 874280179@qq.com
 * @Description :
 */
@RestController
@RequestMapping("api/v1/pri/order")
public class VideoOrderController {

    @Autowired
    private VideoOrderService videoOrderService;

    /**
     * 下单接口
     * @return
     */
    @PostMapping("save")
    public JsonData saveOrder(@RequestBody VideoOrderRequest videoOrderRequest, HttpServletRequest request){

        System.out.println("save我进来了");
        Integer userId = (Integer) request.getAttribute("user_id");

        int rows = videoOrderService.save(userId,videoOrderRequest.getVideoId());

        return rows == 0 ? JsonData.buildError("下单失败") : JsonData.buildSuccess();
    }

    @GetMapping("list")
    public JsonData listOrder(HttpServletRequest request){

        int userId = (int) request.getAttribute("user_id");

        List<VideoOrder> videoOrderList = videoOrderService.listOrderByUserId(userId);

        return JsonData.buildSuccess(videoOrderList);

    }

}
