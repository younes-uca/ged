package ma.sir.chocho.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.chocho.zynerator.repository.AbstractRepository;
import ma.sir.chocho.bean.core.AcessManagement;
import org.springframework.stereotype.Repository;
import ma.sir.chocho.bean.core.AcessManagement;
import java.util.List;


@Repository
public interface AcessManagementDao extends AbstractRepository<AcessManagement,Long>  {
    AcessManagement findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW AcessManagement(item.id,item.libelle) FROM AcessManagement item")
    List<AcessManagement> findAllOptimized();
}
