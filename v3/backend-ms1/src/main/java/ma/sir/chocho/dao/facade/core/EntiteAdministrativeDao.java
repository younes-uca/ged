package ma.sir.chocho.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.chocho.zynerator.repository.AbstractRepository;
import ma.sir.chocho.bean.core.EntiteAdministrative;
import org.springframework.stereotype.Repository;
import ma.sir.chocho.bean.core.EntiteAdministrative;
import java.util.List;


@Repository
public interface EntiteAdministrativeDao extends AbstractRepository<EntiteAdministrative,Long>  {
    EntiteAdministrative findByCode(String code);
    int deleteByCode(String code);

    List<EntiteAdministrative> findByUtilisateurId(Long id);
    int deleteByUtilisateurId(Long id);

    @Query("SELECT NEW EntiteAdministrative(item.id,item.libelle) FROM EntiteAdministrative item")
    List<EntiteAdministrative> findAllOptimized();
}
