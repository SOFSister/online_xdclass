package net.xdclass.online_xdclass;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.lang.Assert;
import net.xdclass.online_xdclass.model.entity.User;
import net.xdclass.online_xdclass.utils.JWTUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OnlineXdclassApplicationTests {

	@Test
	public void testGeneJwt(){

		User user = new User();
		user.setName("xxx");
		user.setPhone("111111111");
		user.setId(66);
		user.setHeadImg("png");

		String token = JWTUtils.geneJsonWebToken(user);

		System.out.println(token);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Claims claims = JWTUtils.checkJWT(token);

		System.out.println(claims.get("name"));
	}

}
