package com.person.hg.demo.filter;

import com.suncreate.session.SessionManager;
import com.suncreate.session.StoreHttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Component
public class SessionFilter implements Filter {
    private String[] IGNORE_SUFFIX = new String[]{".png", ".jpg", ".jpeg", ".gif", ".css", ".js", ".xml"};
    private Set<String> interceptUrlSet = new HashSet();
    private static final Logger logger = Logger.getLogger(SessionFilter.class);

    @Autowired
    private SessionManager sessionManager;


    @Value("${filter.session.ignoreSuffix}")
    private String ignoreSuffix;

    @Value("${filter.session.interceptUrl}")
    private String interceptUrl;

    public SessionFilter() {
    }

    public void init(FilterConfig filterConfig) {
        if (this.interceptUrlSet.isEmpty()) {
            this.interceptUrlSet.add("/**/demo/**");
        }else {
            setInterceptUrl(interceptUrl);
        }

        // 设置忽略的静态文件访问文件类型
        if (null != this.ignoreSuffix) {
            this.setIgnoreSuffix(ignoreSuffix);
        }

    }


    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        if (!this.shouldFilter(request)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (!this.isIntercept(request)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpServletResponse response = (HttpServletResponse)servletResponse;
            String sessionId = this.sessionManager.getRequestedSessionId(request);
            if (sessionId != null && sessionId.length() > 0) {
                StoreHttpSession session = this.sessionManager.loadSession(sessionId);
                if (session != null) {
                    this.sessionManager.updateSession(session, request, response);
                    if (logger.isDebugEnabled()) {
                        logger.debug("Update session id=" + session.getId());
                    }
                }
            }

            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    private boolean shouldFilter(HttpServletRequest request) {
        String uri = request.getRequestURI().toLowerCase();
        String[] var6;
        int var5 = (var6 = this.IGNORE_SUFFIX).length;

        for(int var4 = 0; var4 < var5; ++var4) {
            String suffix = var6[var4];
            if (uri.endsWith(suffix)) {
                return false;
            }
        }

        return true;
    }

    public void setIgnoreSuffix(String ignoreSuffix) {
        if (ignoreSuffix != null && ignoreSuffix.length() > 0) {
            if (ignoreSuffix.contains(",")) {
                String[] ignoreSuffixs = ignoreSuffix.split(",");
                this.IGNORE_SUFFIX = new String[ignoreSuffixs.length];

                for(int i = 0; i < ignoreSuffixs.length; ++i) {
                    String suffix = ignoreSuffixs[i].toLowerCase();
                    this.IGNORE_SUFFIX[i] = suffix.toLowerCase();
                }
            } else {
                this.IGNORE_SUFFIX = new String[]{ignoreSuffix.toLowerCase()};
            }
        }

    }

    public void setInterceptUrl(String interceptUrl) {
        String[] exclusionArray = interceptUrl.split(",");
        if (exclusionArray != null && exclusionArray.length > 0) {
            this.interceptUrlSet = new HashSet();
            String[] var6 = exclusionArray;
            int var5 = exclusionArray.length;

            for(int var4 = 0; var4 < var5; ++var4) {
                String exclusionUrl = var6[var4];
                if (exclusionUrl != null && exclusionUrl.trim().length() > 0) {
                    this.interceptUrlSet.add(exclusionUrl.trim());
                }
            }
        }

    }

    private boolean isIntercept(HttpServletRequest request) throws IOException, ServletException {
        PathMatcher matcher = new AntPathMatcher();
        if (this.interceptUrlSet == null) {
            return false;
        } else {
            String requestPath = request.getRequestURI();
            Iterator iterator = this.interceptUrlSet.iterator();

            while(iterator.hasNext()) {
                String passedPath = (String)iterator.next();
                boolean flag = matcher.match(passedPath, requestPath);
                if (flag) {
                    return true;
                }
            }

            return false;
        }
    }

    public void destroy() {
    }
}
