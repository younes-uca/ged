package ma.sir.ged.dao.facade.core;

import ma.sir.ged.zynerator.repository.AbstractRepository;
import ma.sir.ged.bean.core.DocumentManagementGroupe;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DocumentManagementGroupeDao extends AbstractRepository<DocumentManagementGroupe,Long>  {

    List<DocumentManagementGroupe> findByDocumentId(Long id);
    int deleteByDocumentId(Long id);
    List<DocumentManagementGroupe> findByGroupeId(Long id);
    int deleteByGroupeId(Long id);
    List<DocumentManagementGroupe> findByAcessManagementId(Long id);
    int deleteByAcessManagementId(Long id);

}
