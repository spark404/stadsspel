package net.strocamp.stadsspel.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
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
        for (Cookie cookie : cookies) {
            if ("team".equals(cookie.getName())) {
                teamcode = cookie.getValue();
            }
        }
        LOG.info("{} - Action {}{}", req.getHeader("X-Forwarded-For"), req.getRequestURI(), teamcode != null ? " "+teamcode : "");

        chain.doFilter(req, res);
    }
}
