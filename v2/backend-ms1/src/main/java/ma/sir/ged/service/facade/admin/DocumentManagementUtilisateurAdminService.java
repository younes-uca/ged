package ma.sir.ged.service.facade.admin;

import java.util.List;
import ma.sir.ged.bean.core.DocumentManagementUtilisateur;
import ma.sir.ged.dao.criteria.core.DocumentManagementUtilisateurCriteria;
import ma.sir.ged.dao.criteria.history.DocumentManagementUtilisateurHistoryCriteria;
import ma.sir.ged.zynerator.service.IService;


public interface DocumentManagementUtilisateurAdminService extends  IService<DocumentManagementUtilisateur,DocumentManagementUtilisateurCriteria, DocumentManagementUtilisateurHistoryCriteria>  {

    List<DocumentManagementUtilisateur> findByDocumentId(Long id);
    int deleteByDocumentId(Long id);
    List<DocumentManagementUtilisateur> findByUtilisateurId(Long id);
    int deleteByUtilisateurId(Long id);
    List<DocumentManagementUtilisateur> findByAcessManagementId(Long id);
    int deleteByAcessManagementId(Long id);



}
