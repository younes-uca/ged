package ma.sir.chocho.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.chocho.zynerator.repository.AbstractRepository;
import ma.sir.chocho.bean.core.Groupe;
import org.springframework.stereotype.Repository;
import ma.sir.chocho.bean.core.Groupe;
import java.util.List;


@Repository
public interface GroupeDao extends AbstractRepository<Groupe,Long>  {
    Groupe findByCode(String code);
    int deleteByCode(String code);

    List<Groupe> findByUtilisateurId(Long id);
    int deleteByUtilisateurId(Long id);

    @Query("SELECT NEW Groupe(item.id,item.libelle) FROM Groupe item")
    List<Groupe> findAllOptimized();
}
