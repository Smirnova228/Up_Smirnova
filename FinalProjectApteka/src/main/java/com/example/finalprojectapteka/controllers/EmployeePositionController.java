package com.example.finalprojectapteka.controllers;

import com.example.finalprojectapteka.models.EmployeePosition;
import com.example.finalprojectapteka.repository.EmployeePositionRepository;
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
@PreAuthorize("hasAnyAuthority('EMPLOYEE','ADMIN')")
public class EmployeePositionController {
    @Autowired
    private EmployeePositionRepository employeePositionRepository;

    @GetMapping("/employeePosition")
    public String employeePositionMain(Model model) {
        Iterable<EmployeePosition> employeePositions = employeePositionRepository.findAll();
        model.addAttribute("employeePositions", employeePositions);
        return "employeePosition";
    }

    @GetMapping("/employeePosition/add")
    public String employeePositionAdd(@ModelAttribute("employeePositions") EmployeePosition employeePosition) {
        return "employeePosition-add";
    }

    @PostMapping("/employeePosition/add")
    public String employeePositionPostAdd(@ModelAttribute("employeePositions") @Valid EmployeePosition employeePosition, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "employeePosition-add";
        }
        employeePositionRepository.save(employeePosition);
        return "redirect:/employeePosition";
    }

    @GetMapping("/employeePosition/{id}/edit")
    public  String employeePositionDetails(@PathVariable(value = "id") long id, Model model)
    {
        EmployeePosition employeePosition = employeePositionRepository.findById(id).orElseThrow();
        model.addAttribute("employeePosition",employeePosition);
        return "employeePosition-edit";
    }

    @PostMapping ("/employeePosition/{id}/edit")
    public  String employeeUpdate(@ModelAttribute("employeePosition") @Valid EmployeePosition employeePosition,
                                  BindingResult bindingResult,
                                  @PathVariable(value = "id") long id)
    {
        if(bindingResult.hasErrors())
            return "employeePosition-edit";
        employeePositionRepository.save(employeePosition);
        return "redirect:/employeePosition";
    }

    @GetMapping("/employeePosition/{id}/remove")
    public  String employeePositionDelete(@PathVariable(value = "id") long id, Model model)
    {
        EmployeePosition employeePosition = employeePositionRepository.findById(id).orElseThrow();
        employeePositionRepository.delete(employeePosition);
        return "redirect:/employeePosition";
    }
}
