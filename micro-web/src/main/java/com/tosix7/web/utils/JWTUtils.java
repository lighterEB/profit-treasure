package com.tosix7.web.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.crypto.SecretKey;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * jwt工具类
 */
public class JWTUtils {

    // 过期时间(毫秒)
    private static final long EXPIRE_TIME = 60 * 60 * 1000;

    // 动态生成密钥的算法
    public static final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);


    /**
     * 生成token
     *
     * @param claims 传送的map
     * @return
     */
    public static String generate(Map<String, Object> claims) {
        Date current = new Date();

        // 过期时间
        Date expired = new Date(System.currentTimeMillis() + EXPIRE_TIME);

        // 头部信息
        Map<String, Object> header = new HashMap<>(2);
        header.put("type", "jwt");

        return Jwts.builder().setHeader(header)
                .setClaims(claims)
                .setIssuedAt(current)
                .setExpiration(expired)
                .signWith(key)
                .compact();
    }

    /**
     * 生成token
     *
     * @param header 头部信息
     * @param claims 传送的消息map
     * @return
     */
    public static String generate(Map<String, Object> header, Map<String, Object> claims) {
        Date current = new Date();

        // 过期时间
        Date expired = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        return Jwts.builder().setHeader(header)
                .setClaims(claims)
                .setIssuedAt(current)
                .setExpiration(expired)
                .signWith(key)
                .compact();
    }

    /**
     * 验证token签名有效性
     *
     * @param token
     * @return
     */

    public static boolean isSigned(String token) {
        JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
        return jwtParser.isSigned(token);
    }

    /**
     * 验证token是否正确
     *
     * @param token
     * @return
     */
    public static boolean verify(String token) {
        try {
            if (isSigned(token)) {
                JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
                jwtParser.parseClaimsJws(token);
                return true;
            } else {
                return false;
            }
        } catch (JwtException e) {
            return false;
        }
    }

    /**
     * 获取payload部分内容（即需要传递的信息）
     *
     * @param token 获取如userId: getClaim(token).get("userId")
     * @return
     */

    public static Claims getClaims(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }

    /**
     * 获取头部信息map
     * 使用：getHeader(token).get("type")
     * @param token
     * @return
     */

    public static JwsHeader<?> getHeader(String token) {
        JwsHeader<?> header = null;
        try {
            header = (JwsHeader<?>) Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getHeader();
        }catch (Exception e){
            e.printStackTrace();
        }
        return header;
    }

    /**
     * 获取jwt发布时间
     */
    public static Date getIssuedAt(String token) {
        return getClaims(token).getIssuedAt();
    }

    /**
     * 获取jwt失效时间
     */
    public static Date getExpiredAt(String token) {
        return getClaims(token).getExpiration();
    }

    public static boolean isExpired(String token) {
        try {
            final Date expiration = getExpiredAt(token);
            return expiration.before(new Date());
        }catch (ExpiredJwtException expiredJwtException) {
            return true;
        }
    }

    public static String getHeaderByBase64(String token) {
        String header = null;
        if (isSigned(token)) {
            try {
                byte [] header_byte = Base64.getDecoder().decode(token.split("\\.")[0]);
                header = new String(header_byte);
            }catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return header;
    }

    public static String getPayloadByBase64(String token) {
        String payload = null;
        if (isSigned(token)) {
            try{
                byte[] payload_byte = Base64.getDecoder().decode(token.split("\\.")[1]);
                payload = new String(payload_byte);
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
        return payload;
    }

    public static void main(String[] args) {
        //用户自定义信息claims
        Map<String,Object> map = new HashMap<>();
        map.put("userId","test122");
        map.put("money",200);


        String token =  generate(map);
        System.out.println(token);

        System.out.println("claim:" + getClaims(token).get("userId"));
        System.out.println("header:" + getHeader(token));
        //    System.out.println(getIssuedAt(token));
        Claims claims=getClaims(token);

        //  System.out.println(getHeaderByBase64(token));
        System.out.println(getPayloadByBase64(token));

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy‐MM‐dd hh:mm:ss");
        System.out.println("签发时间:"+sdf.format(claims.getIssuedAt()));
        System.out.println("过期时间:"+sdf.format(claims.getExpiration()));
        System.out.println("当前时间:"+sdf.format(new Date()) );
    }
}
