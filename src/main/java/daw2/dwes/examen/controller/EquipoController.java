package daw2.dwes.examen.controller;

import daw2.dwes.examen.dto.EquipoDTO;
import daw2.dwes.examen.model.Liga;
import daw2.dwes.examen.service.EquipoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/equipos")
public class EquipoController {

    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping("/crear")
    public String mostrarFormulario(Model model){
        EquipoDTO equipoDTO = new EquipoDTO();
        model.addAttribute("equipo", equipoDTO);
        model.addAttribute("ligas", Liga.values());
        return "crearEquipo";
    }

    @PostMapping("/crear")
    public String crearEquipo(@Valid @ModelAttribute("equipo") EquipoDTO equipoDTO, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()){
            model.addAttribute("ligas", Liga.values());
            return "crearEquipo";
        }else{
            equipoService.save(equipoDTO);
            return "redirect:/";
        }
    }
}
