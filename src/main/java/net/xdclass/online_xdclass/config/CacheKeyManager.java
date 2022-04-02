package net.xdclass.online_xdclass.config;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Soft_Sister
 * @version : 1.0
 * @Project : online_xdclass
 * @Package : net.xdclass.online_xdclass.config
 * @ClassName : CacheKeyManager.java
 * @createTime : 2022/3/9 0:45
 * @Email : 874280179@qq.com
 * @Description :缓存key管理类
 */
public class CacheKeyManager {

    /**
     * 首页轮播图缓存key
     */
    public static final String INDEX_BANNER_KEY = "index:banner:list";

    /**
     * 首页视频列表缓存key
     */
    public static final String INDEX_VIDEO_LIST = "index:video:list";

    /**
     * 视频详情缓存key
     */
    public static final String VIDEO_DETAIL = "video:detail:%s";

}
