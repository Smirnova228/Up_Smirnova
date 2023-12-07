package com.example.finalprojectapteka.controllers;

import com.example.finalprojectapteka.models.TypeMedicine;
import com.example.finalprojectapteka.repository.TypeMedicineRepository;
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
public class TypeMedicineController {
    @Autowired
    private TypeMedicineRepository typeMedicineRepository;

    @GetMapping("/typeMedicine")
    public String typeMedicineMain(Model model) {
        Iterable<TypeMedicine> typeMedicines = typeMedicineRepository.findAll();
        model.addAttribute("typeMedicines", typeMedicines);
        return "typeMedicine";
    }

    @GetMapping("/typeMedicine/add")
    public String typeMedicineAdd(@ModelAttribute("typeMedicines") TypeMedicine typeMedicine) {
        return "typeMedicine-add";
    }

    @PostMapping("/typeMedicine/add")
    public String productPostAdd(@ModelAttribute("typeProducts") @Valid TypeMedicine typeMedicine, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "typeMedicine-add";
        }
        typeMedicineRepository.save(typeMedicine);
        return "redirect:/typeMedicine";
    }

    @GetMapping("/typeMedicine/{id}/edit")
    public String typeMedicineDetails(@PathVariable(value = "id") long id, Model model) {
        TypeMedicine typeMedicine = typeMedicineRepository.findById(id).orElseThrow();
        model.addAttribute("typeMedicine", typeMedicine);
        return "typeMedicine-edit";
    }

    @PostMapping ("/typeMedicine/{id}/edit")
    public  String productUpdate(@ModelAttribute("typeMedicine") @Valid TypeMedicine typeMedicine,
                                 BindingResult bindingResult,
                                 @PathVariable(value = "id") long id)
    {
        if(bindingResult.hasErrors())
            return "typeMedicine-edit";
        typeMedicineRepository.save(typeMedicine);
        return "redirect:/typeMedicine";
    }

    @GetMapping("/typeMedicine/{id}/remove")
    public  String typeMedicineDelete(@PathVariable(value = "id") long id, Model model)
    {
        TypeMedicine typeMedicine = typeMedicineRepository.findById(id).orElseThrow();
        typeMedicineRepository.delete(typeMedicine);
        return "redirect:/typeMedicine";
    }
}
