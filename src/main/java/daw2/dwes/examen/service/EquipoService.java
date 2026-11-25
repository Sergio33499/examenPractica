package daw2.dwes.examen.service;

import daw2.dwes.examen.dto.EquipoDTO;
import daw2.dwes.examen.model.Equipo;
import daw2.dwes.examen.model.Liga;
import daw2.dwes.examen.repository.EquipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {
    private final EquipoRepository equipoRepository;


    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    public Equipo save(EquipoDTO equipoDTO){
        Equipo equipo = new Equipo();
        equipo.setNombre(equipoDTO.getNombre());
        equipo.setFechaFundacion(equipoDTO.getFechaFundacion());
        equipo.setLiga(equipoDTO.getLiga());
        return equipoRepository.save(equipo);
    }

    public List<Equipo> findAll(){
        return equipoRepository.findAll();
    }

    public boolean existeEquipo(Long id){
        if (equipoRepository.existsById(id)){
            return true;
        }
        return false;
    }
}
