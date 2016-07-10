package me.zacharyjia.fuckexcel.common;

import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zachary on 16/7/10.
 */
public class FuckDispatcherServlet extends DispatcherServlet {

    private String encoding;

    @Override
    public void init(ServletConfig config) throws ServletException {
        encoding = config.getInitParameter("encoding");
        super.init(config);
    }

    @Override
    protected void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding(encoding);
        super.doService(request, response);
    }

}
