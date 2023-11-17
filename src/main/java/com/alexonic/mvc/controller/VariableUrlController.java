package com.alexonic.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VariableUrlController {
    @GetMapping("/course/{id}/{slug}")
    public String variable(@PathVariable(name = "id") Integer idEmZrem, ModelMap modelMap, @PathVariable String slug){
        System.out.println("id: " + idEmZrem);
        modelMap.addAttribute("idKey", idEmZrem);
        modelMap.addAttribute("slugKey", slug);
        return "/other/index";
    }

    @GetMapping("/course")
    public String requestParamPage(
            @RequestParam(name = "level") String level,
            @RequestParam String experience,
            String rap,
            Model md)
    {
        md.addAttribute("level", level);
        md.addAttribute("experience", experience);
        md.addAttribute("rap", rap);
        return "/other/test";
    }
}
