package com.xiaozhen.mall.tiny.component;

import cn.hutool.json.JSONUtil;
import com.xiaozhen.mall.tiny.common.api.CommontResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description : 当未登录或token失效时,返回JSON格式的结果
 * @create time:2021/10/25
 * @Author : XiaoZhen
 **/
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(CommontResult.unauthorized(e.getMessage())));
        response.getWriter().flush();
    }
}
