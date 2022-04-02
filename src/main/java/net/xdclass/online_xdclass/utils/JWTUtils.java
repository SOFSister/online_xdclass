package net.xdclass.online_xdclass.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.xdclass.online_xdclass.model.entity.User;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Soft_Sister
 * @version : 1.0
 * @Project : online_xdclass
 * @Package : net.xdclass.online_xdclass.utils
 * @ClassName : JWTUtils.java
 * @createTime : 2022/3/6 17:39
 * @Email : 874280179@qq.com
 * @Description :JWT工具类
 * 注意点：
 * 1、生成的token，是可以通过base64进行解密出明文信息
 * 2、base64进行解密出明文信息，修改再进行编码，则会解密失败
 * 3、无法作废已颁布的token，除非改密钥
 */
public class JWTUtils {

    /**
     * 过期时间 一周
     */
    private static final long EXPIRE = 60000 * 60 * 24 * 7;//过期时间 一周

    /**
     * 加密密钥
     */
    private static final String SECRET = "xdclass.net168";

    /**
     * 令牌前缀
     */
    private static final String TOKEN_PREFIX = "xdclass";


    /**
     * subject
     */
    private static final String SUBJECT = "xdclass";

    /**
     * 根据用户信息生成令牌
     * @param user
     * @return
     */
    public static String geneJsonWebToken(User user){

        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("head_img",user.getHeadImg())
                .claim("id",user.getId())
                .claim("name",user.getName())
                .setIssuedAt(new Date())//设置创建时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))//设置过期时间
                .signWith(SignatureAlgorithm.HS256,SECRET)//设置加密方法和密钥
                .compact();

        token = TOKEN_PREFIX + token;

        return token;
    }

    /**
     * 校验token的方法
     * @param token
     * @return
     */
    public static Claims checkJWT(String token){

        try {

            final Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX,"")).getBody();

            return claims;

        }catch (Exception e){
            return null;
        }

    }

}
