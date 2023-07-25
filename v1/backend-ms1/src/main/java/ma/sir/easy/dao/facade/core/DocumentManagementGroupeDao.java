package ma.sir.easy.dao.facade.core;

import ma.sir.easy.zynerator.repository.AbstractRepository;
import ma.sir.easy.bean.core.DocumentManagementGroupe;
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
