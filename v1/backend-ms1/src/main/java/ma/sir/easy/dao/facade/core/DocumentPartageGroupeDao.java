package ma.sir.easy.dao.facade.core;

import ma.sir.easy.zynerator.repository.AbstractRepository;
import ma.sir.easy.bean.core.DocumentPartageGroupe;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DocumentPartageGroupeDao extends AbstractRepository<DocumentPartageGroupe,Long>  {

    List<DocumentPartageGroupe> findByDocumentId(Long id);
    int deleteByDocumentId(Long id);
    List<DocumentPartageGroupe> findByGroupeId(Long id);
    int deleteByGroupeId(Long id);
    List<DocumentPartageGroupe> findByAcessShareId(Long id);
    int deleteByAcessShareId(Long id);

}
