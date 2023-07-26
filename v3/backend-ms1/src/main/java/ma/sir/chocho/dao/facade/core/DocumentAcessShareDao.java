package ma.sir.chocho.dao.facade.core;

import ma.sir.chocho.zynerator.repository.AbstractRepository;
import ma.sir.chocho.bean.core.DocumentAcessShare;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DocumentAcessShareDao extends AbstractRepository<DocumentAcessShare,Long>  {

    List<DocumentAcessShare> findByDocumentId(Long id);
    int deleteByDocumentId(Long id);
    List<DocumentAcessShare> findByAcessShareId(Long id);
    int deleteByAcessShareId(Long id);

}
