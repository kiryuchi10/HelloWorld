package himedia.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

public class LoggingFilter extends HttpServlet implements Filter {
	private static Logger logger= Logger.getLogger(EncodingFilter.class.getSimpleName());
	private static String encoding ="UTF-8";
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
	}

	
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		PrintWriter out =resp.getWriter();
		out.println("<h6>LoggingFilter 작동전</h6>");
		
		//요청 정보를 로그로 출력
		//ServletRequest->HttpServletRequest 캐스팅 URI 정보
		HttpServletRequest httpRequest =(HttpServletRequest) req;
		logger.info(("들어오는 요청의 URI: ") + httpRequest.getRequestURI());
		chain.doFilter(req, resp);
		
		//응답이 돌아온 이후 응답 상태를 출력하고 로깅
		out.println("<h6>LogginFilter 동작 후</h6>");
		logger.info("출력되는 응답의 상태: "+resp.getContentType());
		}


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

}
