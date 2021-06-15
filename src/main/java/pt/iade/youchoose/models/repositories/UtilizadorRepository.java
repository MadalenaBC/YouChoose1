package pt.iade.youchoose.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.youchoose.models.Utilizador;

public interface UtilizadorRepository extends CrudRepository<Utilizador,Integer> {
    Iterable<Utilizador> findByNameContaining(String text);
    Iterable<Utilizador> findByEscalaoId(int id);
   // QueryFindUtilizador = 
    //                "SELECT ut_id AS id, ut_nome AS Nome, "+
    //                "ut_surname AS Apelido, "+
    //                "ut_genero AS Genero, "+
    //                "ut_danasc AS Data Nascimento";
                    
    //@Query(value=QueryFindUtilizador,nativeQuery=true)
    //Iterable<UtilizadorView> findAllUtilizador();   

    //@Query(value=QueryFindUtilizador+" Where ut_id = :id",nativeQuery=true)
    //Iterable<UtilizadorView> findUtilizadorById(@Param("id") int id);

}