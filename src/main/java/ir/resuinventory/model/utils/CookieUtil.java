package ir.resuinventory.model.utils;

import jakarta.servlet.http.Cookie;

public class CookieUtil {

    private static CookieUtil cookieUtil = new CookieUtil();

    private CookieUtil() {
    }

    public static CookieUtil getCookieUtil() {
        return cookieUtil;
    }

    public String getCookieValue(Cookie[] cookies, String cookieName)
    {
        String cookieValue = "";
        Cookie cookie;
        if (cookies != null)
        {
            for (int i = 0; i < cookies.length; i++)
            {
                cookie = cookies[i];
                if (cookieName.equals(cookie.getName()))
                {
                    cookieValue = cookie.getValue();
                }
            }
        }
        return cookieValue;
    }
}
