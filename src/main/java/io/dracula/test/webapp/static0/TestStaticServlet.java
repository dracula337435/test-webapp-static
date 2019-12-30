package io.dracula.test.webapp.static0;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author dk 
 */
public class TestStaticServlet extends HttpServlet {

    /**
     * 记录此类个数
     */
    private static int count = 0;

    /**
     * 记录这是第几个此类
     */
    private int current = 0;

    /**
     * 用于展示隔离
     */
    private static int i = 0;

    public TestStaticServlet(){
        count++;
        current = count;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("step") != null){
            i++;
        }
        resp.getOutputStream().print("current="+current+", static count="+count+", static i="+i);
//        super.doGet(req, resp);
    }
}
