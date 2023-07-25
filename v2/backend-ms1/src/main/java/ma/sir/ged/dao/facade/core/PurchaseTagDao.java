package ma.sir.ged.dao.facade.core;

import ma.sir.ged.zynerator.repository.AbstractRepository;
import ma.sir.ged.bean.core.PurchaseTag;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PurchaseTagDao extends AbstractRepository<PurchaseTag,Long>  {

    List<PurchaseTag> findByPurchaseId(Long id);
    int deleteByPurchaseId(Long id);
    List<PurchaseTag> findByTagId(Long id);
    int deleteByTagId(Long id);

}
