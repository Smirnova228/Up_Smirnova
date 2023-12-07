package com.example.finalprojectapteka.controllers;

import com.example.finalprojectapteka.models.Point;
import com.example.finalprojectapteka.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class PointController {
    @Autowired
    private PointRepository pointRepository;

    @GetMapping("/point")
    public String pointMain(Model model) {
        Iterable<Point> stores = pointRepository.findAll();
        model.addAttribute("points", stores);
        return "point";
    }

    @GetMapping("/point/add")
    public String pointAdd(@ModelAttribute("points") Point point) {
        return "point-add";
    }

    @PostMapping("/point/add")
    public String pointPostAdd(@ModelAttribute("stores") @Valid Point point, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "point-add";
        }
        pointRepository.save(point);
        return "redirect:/point";
    }

    @GetMapping("/point/{id}/edit")
    public String pointDetails(@PathVariable(value = "id") long id, Model model) {
        Point point = pointRepository.findById(id).orElseThrow();
        model.addAttribute("point", point);
        return "point-edit";
    }

    @PostMapping ("/point/{id}/edit")
    public  String pointUpdate(@ModelAttribute("point") @Valid Point point,
                                 BindingResult bindingResult,
                                 @PathVariable(value = "id") long id)
    {
        if(bindingResult.hasErrors())
            return "point-edit";
        pointRepository.save(point);
        return "redirect:/point";
    }

    @GetMapping("/point/{id}/remove")
    public  String pointDelete(@PathVariable(value = "id") long id, Model model)
    {
        Point point = pointRepository.findById(id).orElseThrow();
        pointRepository.delete(point);
        return "redirect:/point";
    }
}
