package eu.righettod.poccsrf.servlet;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Simple ServiceServlet representing a backend service...
 */
@WebServlet("/backend/*")
public class ServiceServlet extends HttpServlet {

    /**
     * Logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(ServiceServlet.class);
    /**
     * {@inheritDoc}
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("req : {}", req.getQueryString());
        JSONObject data = new JSONObject();
        data.put("RequestURI", req.getRequestURI());
        data.put("Method", req.getMethod());
        data.put("QueryString", req.getQueryString());
        resp.setContentType("application/json");
        resp.getWriter().write(data.toJSONString());
    }

}
