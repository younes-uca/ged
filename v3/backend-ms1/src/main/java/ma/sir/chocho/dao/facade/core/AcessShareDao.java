package ma.sir.chocho.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.chocho.zynerator.repository.AbstractRepository;
import ma.sir.chocho.bean.core.AcessShare;
import org.springframework.stereotype.Repository;
import ma.sir.chocho.bean.core.AcessShare;
import java.util.List;


@Repository
public interface AcessShareDao extends AbstractRepository<AcessShare,Long>  {
    AcessShare findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW AcessShare(item.id,item.libelle) FROM AcessShare item")
    List<AcessShare> findAllOptimized();
}
