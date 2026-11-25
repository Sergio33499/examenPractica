package daw2.dwes.examen.controller;

import daw2.dwes.examen.dto.JugadorDTO;
import daw2.dwes.examen.service.EquipoService;
import daw2.dwes.examen.service.JugadorService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jugadores")
public class JugadorController {
    private final JugadorService jugadorService;
    private final EquipoService equipoService;

    public JugadorController(JugadorService jugadorService, EquipoService equipoService) {
        this.jugadorService = jugadorService;
        this.equipoService = equipoService;
    }

    @GetMapping("/crear")
    public String mostrarFormulario(Model model){
        JugadorDTO jugadorDTO = new JugadorDTO();
        model.addAttribute("jugador", jugadorDTO);
        model.addAttribute("equipos", equipoService.findAll());
        return "crearJugador";
    }

    @PostMapping("/crear")
    public String crearJugador(@Valid @ModelAttribute("jugador") JugadorDTO jugadorDTO, BindingResult bindingResult, Model model){

        if (jugadorService.existeDni(jugadorDTO.getDni())) {
            bindingResult.rejectValue("dni", "dniDuplicado", "Ya existe un jugador con este DNI");
        }

        if (!equipoService.existeEquipo(jugadorDTO.getEquipoId())) {
            bindingResult.rejectValue("equipoId", "equipoInexistente", "El equipo seleccionado no existe");
        }

        if (!bindingResult.hasFieldErrors("equipoId") && !equipoService.existeEquipo(jugadorDTO.getEquipoId())) {
            bindingResult.rejectValue("equipoId", "equipoInexistente", "El equipo seleccionado no existe");
        }


        if (bindingResult.hasErrors()){
            model.addAttribute("equipos", equipoService.findAll());
            return "crearJugador";
        }else{
            jugadorService.save(jugadorDTO);
            return "redirect:/";
        }
    }
}
