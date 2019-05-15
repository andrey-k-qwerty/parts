package system.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import system.model.Part;
import system.service.PartService;
import system.service.PartServiceImpl;

@Controller
public class PartsController {
 //   private final Logger logger = LoggerFactory.getLogger(PartsController.class);
    private PartService partService = new PartServiceImpl() ;


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView allParts() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("parts",partService.allParts());
        modelAndView.setViewName("parts");
        return modelAndView;
    }
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    //аннотация @PathVariable указывает на то, что данный параметр (int id)получается из адресной
    // строки. Чтобы указать место этого параметра в адресной строке используется конструкция {id}
    // (кстати, если имя переменной совпадает, как в данном случае, то в скобках это можно не
    // указывать, а написать просто @PathVariable int id).
    public ModelAndView pageEdit(@PathVariable("id") int id) {
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

    @GetMapping(value = "/add")
    public ModelAndView partAdd() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("part", new Part());
        modelAndView.setViewName("partsEdit");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView partAdd(@ModelAttribute("part")Part part) {
        ModelAndView modelAndView = new ModelAndView();
        partService.add(part);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteFilm(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Part part = partService.getPartById(id);
        partService.delete(part);
        return modelAndView;
    }

}
