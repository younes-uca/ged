package ma.sir.ana.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ana.zynerator.repository.AbstractRepository;
import ma.sir.ana.bean.core.DocumentCategorie;
import org.springframework.stereotype.Repository;
import ma.sir.ana.bean.core.DocumentCategorie;
import java.util.List;


@Repository
public interface DocumentCategorieDao extends AbstractRepository<DocumentCategorie,Long>  {
    DocumentCategorie findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW DocumentCategorie(item.id,item.libelle) FROM DocumentCategorie item")
    List<DocumentCategorie> findAllOptimized();
}
