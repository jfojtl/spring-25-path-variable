package com.ysoft.web;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.HttpServletBean;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by jfojtl on 04/11/14.
 */
public class PathVariableWebArgumentResolver implements WebArgumentResolver {

    private final Spring3AntPathMatcher pathMatcher;

    public PathVariableWebArgumentResolver(Spring3AntPathMatcher pathMatcher) {
        this.pathMatcher = pathMatcher;
    }

    public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) throws Exception {
        for (Object parameterAnnotation : methodParameter.getParameterAnnotations()) {
            if(parameterAnnotation instanceof PathVariable) {
                String path = ((HttpServletRequest)webRequest.getNativeRequest()).getPathInfo();
                String uriTemplate = methodParameter.getMethod().getAnnotation(RequestMapping.class).value()[0];
                Map<String, String> uriVariables = pathMatcher.extractUriTemplateVariables(uriTemplate, path);
                return uriVariables.get(methodParameter.getParameterName());
            }
        }

        return UNRESOLVED;
    }
}
