package daw2.dwes.examen.service;

import daw2.dwes.examen.dto.JugadorDTO;
import daw2.dwes.examen.model.Jugador;
import daw2.dwes.examen.repository.EquipoRepository;
import daw2.dwes.examen.repository.JugadorRepository;
import org.springframework.stereotype.Service;

@Service
public class JugadorService {
    private final JugadorRepository jugadorRepository;
    private final EquipoRepository equipoRepository;

    public JugadorService(JugadorRepository jugadorRepository, EquipoRepository equipoRepository) {
        this.jugadorRepository = jugadorRepository;
        this.equipoRepository = equipoRepository;
    }

    public Jugador save(JugadorDTO jugadorDTO){
        Jugador jugador = new Jugador();
        jugador.setDni(jugadorDTO.getDni());
        jugador.setNombre(jugadorDTO.getNombre());
        jugador.setSalario(jugadorDTO.getSalario());
        jugador.setDorsal(jugadorDTO.getDorsal());
        jugador.setEquipo(equipoRepository.findById(jugadorDTO.getEquipoId()).orElseThrow());
        return jugadorRepository.save(jugador);
    }

    public boolean existeDni(String dni){
        if (jugadorRepository.existsById(dni)){
            return true;
        }
        return false;
    }
}
