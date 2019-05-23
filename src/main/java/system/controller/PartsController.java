package system.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import system.model.Part;
import system.service.PartService;
import system.service.PartServiceImpl;

import java.util.List;

@Controller
public class PartsController {
    //   private final Logger logger = LoggerFactory.getLogger(PartsController.class);
    private final PartService partService;

    public PartsController(PartService partService) {
        this.partService = partService;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allParts() {
        ModelAndView modelAndView = new ModelAndView();
      //  modelAndView.addObject("parts", partService.allParts());
        modelAndView.addObject("count", partService.getCountNeed());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    //аннотация @PathVariable указывает на то, что данный параметр (int id)получается из адресной
    // строки. Чтобы указать место этого параметра в адресной строке используется конструкция {id}
    // (кстати, если имя переменной совпадает, как в данном случае, то в скобках это можно не
    // указывать, а написать просто @PathVariable int id).
    public ModelAndView pageEdit(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("part", partService.getPartById(id));
        modelAndView.setViewName("partsEdit");
        return modelAndView;

    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView partsEdit(@ModelAttribute("part") Part part) {
        ModelAndView modelAndView = new ModelAndView();
        partService.update(part);
        modelAndView.setViewName("redirect:/");
        return modelAndView;

    }

    @GetMapping(value = "/add")
    public ModelAndView partAdd() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("part", new Part());
        modelAndView.setViewName("partsEdit");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView partAdd(@ModelAttribute("part") Part part) {
        ModelAndView modelAndView = new ModelAndView();
        partService.add(part);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteFilm(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Part part = partService.getPartById(id);
        partService.delete(part);
        return modelAndView;
    }

    @RequestMapping(value = "/getpart")
    public @ResponseBody
    List<Part> getTodos(@ModelAttribute("part") Part part) {
        return partService.allParts();
    }

    @RequestMapping(value = "/test")
    public ModelAndView allPartsTest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("parts",partService.allParts());
        modelAndView.addObject("count",partService.getCountNeed());
        modelAndView.setViewName("parts");
        return modelAndView;
    }

}
