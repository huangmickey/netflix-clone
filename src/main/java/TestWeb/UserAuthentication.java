package TestWeb;

import javax.servlet.http.Cookie;

public class UserAuthentication {

    public static Cookie findCookie(Cookie[] cookies) {
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals("loginCookie")) {
                return cookie;
            }
        }
        return null;
    }

    public static boolean checkCookie(Cookie cookie) {
        return cookie != null;
    }
}
