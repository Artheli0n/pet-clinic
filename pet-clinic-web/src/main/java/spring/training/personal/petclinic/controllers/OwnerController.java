package spring.training.personal.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// adding a request mapping to prefix everything inside the class
@RequestMapping("/owners")
@Controller
public class OwnerController {

    @RequestMapping({"","/", "/index", "/index.html"})
    public String listOwners() {

        return "owners/index";
    }
}
