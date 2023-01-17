package com.Shop.Controller;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * 세션 관리
 */
@Component
public class SessionManager {
    public static final String SESSION_COOKIE_NAME = "SessionManager";
    private Map<String, Object> sessionStore = new ConcurrentHashMap<>();
    /**
     * 세션 생성
     */
    public void createSession(Object value, HttpServletResponse response) {
        //세션 id를 생성하고, 값을 세션에 저장
        String sessionId = UUID.randomUUID().toString();
//      세션을 생성할때마다 map 에 하나씩 저장한다.
        sessionStore.put(sessionId, value);
        //쿠키 생성
        Cookie mySessionCookie = new Cookie(SESSION_COOKIE_NAME, sessionId);
        response.addCookie(mySessionCookie);
    }
    /**
     * 세션 조회
     */
    public Object getSession(HttpServletRequest request) {
//    	사용자의 요청정보에서 쿠키를 찾는메소드도 있네. 키값으로 지정한 값으로 쿠키를 찾는다.
//    	findCookie(요청객체, 키값);
//    	아니 이거 아래에 작성한 커스텀 메소드네.
        Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
        if (sessionCookie == null) {
            return null;
        }
//      요청객체에 쿠키가 있다면 해당 쿠키에서 값(세션id)을 가져오고, 해당 값을 키로 가지는 세션을 찾아서 반환한다. 
        return sessionStore.get(sessionCookie.getValue());
    }
    /**
     * 세션 만료
     */
    public void expire(HttpServletRequest request) {
        Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
        if (sessionCookie != null) {
            sessionStore.remove(sessionCookie.getValue());
        }
    }
    private Cookie findCookie(HttpServletRequest request, String cookieName) {
        if (request.getCookies() == null) {
            return null;
        }
        return Arrays.stream(request.getCookies())
                .filter(cookie -> cookie.getName().equals(cookieName))
                .findAny()
                .orElse(null);
    }
}