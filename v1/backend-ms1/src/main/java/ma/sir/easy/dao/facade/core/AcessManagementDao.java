package ma.sir.easy.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.easy.zynerator.repository.AbstractRepository;
import ma.sir.easy.bean.core.AcessManagement;
import org.springframework.stereotype.Repository;
import ma.sir.easy.bean.core.AcessManagement;
import java.util.List;


@Repository
public interface AcessManagementDao extends AbstractRepository<AcessManagement,Long>  {
    AcessManagement findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW AcessManagement(item.id,item.libelle) FROM AcessManagement item")
    List<AcessManagement> findAllOptimized();
}
