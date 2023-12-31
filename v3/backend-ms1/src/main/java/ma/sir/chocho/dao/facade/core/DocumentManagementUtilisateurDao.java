package ma.sir.chocho.dao.facade.core;

import ma.sir.chocho.zynerator.repository.AbstractRepository;
import ma.sir.chocho.bean.core.DocumentManagementUtilisateur;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DocumentManagementUtilisateurDao extends AbstractRepository<DocumentManagementUtilisateur,Long>  {

    List<DocumentManagementUtilisateur> findByDocumentId(Long id);
    int deleteByDocumentId(Long id);
    List<DocumentManagementUtilisateur> findByUtilisateurId(Long id);
    int deleteByUtilisateurId(Long id);
    List<DocumentManagementUtilisateur> findByAcessManagementId(Long id);
    int deleteByAcessManagementId(Long id);

}
