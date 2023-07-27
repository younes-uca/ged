package ma.sir.ana.dao.facade.core;

import ma.sir.ana.zynerator.repository.AbstractRepository;
import ma.sir.ana.bean.core.DocumentAcessShare;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DocumentAcessShareDao extends AbstractRepository<DocumentAcessShare,Long>  {

    List<DocumentAcessShare> findByDocumentId(Long id);
    int deleteByDocumentId(Long id);
    List<DocumentAcessShare> findByAcessShareId(Long id);
    int deleteByAcessShareId(Long id);

}
