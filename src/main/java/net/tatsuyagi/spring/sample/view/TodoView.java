package net.tatsuyagi.spring.sample.view;

import org.springframework.web.servlet.ModelAndView;

public class TodoView extends ModelAndView {
    
    public TodoView() {
        setViewName("todo");
    }
}
