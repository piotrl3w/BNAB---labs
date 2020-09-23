package pl.arsonproject.bnabd.bnabd.config;

import pl.arsonproject.bnabd.bnabd.service.dto.UserDto;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException  {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        UserDto dto = (UserDto) req.getSession().getAttribute("user");
        String requestUri = req.getRequestURI();

        if (
                dto != null ||
                        requestUri.endsWith(".css") ||
                        requestUri.endsWith(".jpg") ||
                        requestUri.endsWith(".png") ||
                        requestUri.endsWith("login") ||
                        requestUri.endsWith("register")
        ) {
            filterChain.doFilter(req, resp);
        } else {
            resp.sendRedirect(resp.encodeRedirectURL("login"));
        }
    }

    @Override
    public void destroy() {

    }
}