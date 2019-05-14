package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import system.model.Part;
import system.service.PartService;
import system.service.PartServiceImpl;

@Controller
public class PartsController {

    private PartService partService = new PartServiceImpl() ;


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView allParts() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("parts",partService.allParts());
        modelAndView.setViewName("parts");
        return modelAndView;
    }
    @RequestMapping(value = "/edit{id}",method = RequestMethod.GET)
    public ModelAndView pageEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("part",partService.getPartById(id));
        modelAndView.setViewName("partsEdit");
        return modelAndView;

    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ModelAndView partsEdit(@ModelAttribute("part")Part part) {
        ModelAndView modelAndView = new ModelAndView();
        partService.update(part);
        modelAndView.setViewName("redirect:/");
        return modelAndView;

    }

}
