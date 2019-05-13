package system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PartsController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView allParts() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("parts");
        return modelAndView;
    }
    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public ModelAndView partsEdit() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("partsEdit");
        return modelAndView;

    }
}
