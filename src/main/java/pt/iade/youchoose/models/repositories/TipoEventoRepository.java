package pt.iade.youchoose.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.youchoose.models.TipoEvento;

public interface TipoEventoRepository extends CrudRepository <TipoEvento,Integer> {
    Iterable<TipoEvento> findByNameContaining(String text);

}