package net.strocamp.stadsspel.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ActionLoggingFilter extends OncePerRequestFilter {
    private static final Logger LOG = LoggerFactory.getLogger(ActionLoggingFilter.class);

    @Override
    public void doFilterInternal(HttpServletRequest req, HttpServletResponse res,
                         FilterChain chain) throws IOException, ServletException {

        Cookie[] cookies = req.getCookies();
        String teamcode = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("team".equals(cookie.getName())) {
                    teamcode = cookie.getValue();
                }
            }
        }
        if (!req.getRequestURI().startsWith("/css") && !req.getRequestURI().startsWith("/js") && !req.getRequestURI().startsWith("/fonts")) {
            LOG.info("{} - Action {}{}", req.getHeader("X-Forwarded-For"), req.getRequestURI(), teamcode != null ? " - "+teamcode : " - anonymous");
        }

        chain.doFilter(req, res);
    }
}
