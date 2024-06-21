package com.cine.gestion.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cine.gestion.app.domain.IrCine;
import com.cine.gestion.app.repository.IrCineRepository;

@Controller
public class IrCineController {

    @Autowired
    private IrCineRepository iRepository;

    @GetMapping("/")
    public String vistaPrincipal() {
        return "vista_principal";
    }

    @GetMapping("/agregar-registro")
    public String MostrarFormularioCine(Model model) {
        model.addAttribute("irCine", new IrCine());
        return "add_registro";
    }

    @PostMapping("/agregar-registro")
    public String GuardarCine(@ModelAttribute("irCine") IrCine ircine) {
        iRepository.save(ircine);
        return "redirect:/registros_cine";
    }

    @GetMapping("/registros_cine")
    public String ListaDeCine(Model model) {
        List<IrCine> ircine = iRepository.findAll();
        model.addAttribute("cineListAttribute", ircine);
        return "registros_cine";
    }

    @GetMapping("/detalle-cine/{id}")
    public String DetalleCine(@PathVariable("id") Long id, Model model) {
        Optional<IrCine> ircineData = iRepository.findById(id);
        if (ircineData.isPresent()) {
            model.addAttribute("cineAttribute", ircineData.get());
            return "detalle_cine";

        }
        return "No encontrado";

    }

}
