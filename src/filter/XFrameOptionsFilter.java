package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class XFrameOptionsFilter implements Filter{

	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

	        HttpServletResponse response = (HttpServletResponse) servletResponse;
	        response.addHeader("X-Frame-Options", "DENY");
//	        response.addHeader("X-Frame-Options", "SAMEORIGIN");
//	        response.addHeader("X-Frame-Options", "ALLOW-FROM http://localhost:8080");

	        filterChain.doFilter(servletRequest, response);
	}
	
	 @Override
	    public void init(FilterConfig filterConfig) {
	    }

	    @Override
	    public void destroy() {
	    }

}
