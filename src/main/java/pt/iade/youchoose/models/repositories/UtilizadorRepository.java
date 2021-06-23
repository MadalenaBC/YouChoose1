package pt.iade.youchoose.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pt.iade.youchoose.models.Utilizador;

public interface UtilizadorRepository extends CrudRepository<Utilizador,Integer> {
    Iterable<Utilizador> findByNameContaining(String text);
    Iterable<Utilizador> findByEscalaoId(int id);
    
    @Query(value="SELECT ut_id AS id, ut_nome AS Nome, "+
    "ut_surname AS Apelido, "+
    "ut_genero AS Genero, "+
    "ut_danasc AS Data Nascimento"
    ,nativeQuery=true)   
    Utilizador FindCompanyId( int utilizadorId);
}
    
    
    