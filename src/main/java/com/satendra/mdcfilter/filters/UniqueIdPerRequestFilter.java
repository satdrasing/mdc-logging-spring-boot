package com.satendra.mdcfilter.filters;


import com.satendra.mdcfilter.constants.CommonConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
public class UniqueIdPerRequestFilter  implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(UniqueIdPerRequestFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //do nothing
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String uniqueId = UUID.randomUUID().toString();
        uniqueId = StringUtils.replace(uniqueId,"-","");
        MDC.put(CommonConstants.UNIQUES_ID, uniqueId);
        ((HttpServletResponse)servletResponse).setHeader("X-Request-ID",uniqueId);
        logger.info("unique id generated {}", uniqueId );
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        // do nothing now
    }
}
