package spring.training.personal.petclinic.controllers;

import spring.training.personal.petclinic.model.Vet;
import spring.training.personal.petclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(final VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets.html", "/vets/index", "/vets/index.html"})
    public String listVets(Model model) {
        model.addAttribute("vets", vetService.findAll());

        return "vets/vetList";
    }

    // the @ResponseBody basically says "format the return value as a ResponseBody head"
    @GetMapping("/api/vets")
    public @ResponseBody Set<Vet> getVetsJson() {

        return vetService.findAll();
    }
}
