package com.example.demo.utils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * JWT生成token
 */

public class JwtUtils {

    private  final static  String  secret = "123456";

    /**
     * 生成jwt token
     * claims  传过来的用户实体map集合
     * @return
     */
    public static  String createJWT(Map<String,Object> claims){
        Date now = new Date();
        long e = 1000*60;
        //过期时间
        Date expireDate = new Date(now.getTime()+e);
        return Jwts.builder()
                .setHeaderParam("type","JWT")
                .setId(UUID.randomUUID().toString())//设置jti  是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
                .setClaims(claims)   //业务内需要存储的参数
                .setIssuedAt(now)           //iat: jwt的签发时间
                .setExpiration(expireDate) // exp: jwt的过期时间，这个过期时间必须要大于签发时间
                .setSubject(String.valueOf(claims.get("id"))) // jwt所面向的用户，也就是说是根据用户身份变动的字段   这里设置为用户id
                .setIssuer(String.valueOf(claims.get("userName"))) //签发者信息       这里设置为用户名
                .signWith(SignatureAlgorithm.HS512, secret) //设置签名使用的签名算法和签名使用的秘钥
                .compressWith(CompressionCodecs.GZIP)  //数据压缩方式
                .compact();
    }

    /**
     * 解析jwt 获取用户信息  也就是Claims信息
     * 如果超时或者没有返回null
     * @param token
     * @return
     */
    public static Claims getClaimByToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            return null;
        }
    }
}

