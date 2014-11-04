package com.ysoft.jobs;

import com.ysoft.web.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jfojtl on 04/11/14.
 */
@Controller
public class JobController {

    @RequestMapping(value = "/jobs/{id}", method = RequestMethod.GET)
    public void getJob(@PathVariable String id, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.print("obtained id from uri: " + id);
        writer.flush();
        writer.close();
    }
}
