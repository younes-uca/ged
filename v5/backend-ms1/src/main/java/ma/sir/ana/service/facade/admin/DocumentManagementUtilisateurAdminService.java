package ma.sir.ana.service.facade.admin;

import java.util.List;
import ma.sir.ana.bean.core.DocumentManagementUtilisateur;
import ma.sir.ana.dao.criteria.core.DocumentManagementUtilisateurCriteria;
import ma.sir.ana.dao.criteria.history.DocumentManagementUtilisateurHistoryCriteria;
import ma.sir.ana.zynerator.service.IService;


public interface DocumentManagementUtilisateurAdminService extends  IService<DocumentManagementUtilisateur,DocumentManagementUtilisateurCriteria, DocumentManagementUtilisateurHistoryCriteria>  {

    List<DocumentManagementUtilisateur> findByDocumentId(Long id);
    int deleteByDocumentId(Long id);
    List<DocumentManagementUtilisateur> findByUtilisateurId(Long id);
    int deleteByUtilisateurId(Long id);
    List<DocumentManagementUtilisateur> findByAcessManagementId(Long id);
    int deleteByAcessManagementId(Long id);



}
