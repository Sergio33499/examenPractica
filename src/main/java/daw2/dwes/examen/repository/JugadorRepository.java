package daw2.dwes.examen.repository;

import daw2.dwes.examen.model.Equipo;
import daw2.dwes.examen.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, String> {

}
