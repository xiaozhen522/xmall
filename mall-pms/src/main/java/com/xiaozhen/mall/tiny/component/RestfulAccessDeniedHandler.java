package com.xiaozhen.mall.tiny.component;

import cn.hutool.json.JSONUtil;
import com.xiaozhen.mall.tiny.common.api.CommontResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description : 当用户没有访问权限时的处理器，用于返回JSON格式的处理结果；
 * @create time:2021/10/25
 * @Author : XiaoZhen
 **/
@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(CommontResult.forbidden(e.getMessage())));
        response.getWriter().flush();
    }
}
