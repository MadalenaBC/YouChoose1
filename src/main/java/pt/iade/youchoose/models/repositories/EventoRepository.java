package pt.iade.youchoose.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.youchoose.models.Evento;

public interface EventoRepository extends CrudRepository<Evento,Integer> {
  Iterable<Evento> findBytevid (Integer tipoeventoId);

} 


