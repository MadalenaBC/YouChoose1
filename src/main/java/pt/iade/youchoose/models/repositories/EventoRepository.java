package pt.iade.youchoose.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.youchoose.models.Evento;

public interface EventoRepository extends CrudRepository<Evento,Integer> {
    //Iterable<Evento> findByNameContaining(String text);
   // String QueryFindEvento = 
     //               "SELECT ev_id AS id, ev_nome AS Nome, "+
       //             "ev_data AS Data, ";
                
                    
    //@Query(value=QueryFindEvento,nativeQuery=true)
    //Iterable<EventoView> findAllEvento();   

    //@Query(value=QueryFindEvento+" Where ev_id = :id",nativeQuery=true)
    //Iterable<EventoView> findEventoById(@Param("id") int id);

} 


