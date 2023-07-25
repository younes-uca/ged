package ma.sir.easy.service.facade.admin;

import java.util.List;
import ma.sir.easy.bean.core.DocumentPartageUtilisateur;
import ma.sir.easy.dao.criteria.core.DocumentPartageUtilisateurCriteria;
import ma.sir.easy.dao.criteria.history.DocumentPartageUtilisateurHistoryCriteria;
import ma.sir.easy.zynerator.service.IService;


public interface DocumentPartageUtilisateurAdminService extends  IService<DocumentPartageUtilisateur,DocumentPartageUtilisateurCriteria, DocumentPartageUtilisateurHistoryCriteria>  {

    List<DocumentPartageUtilisateur> findByDocumentId(Long id);
    int deleteByDocumentId(Long id);
    List<DocumentPartageUtilisateur> findByUtilisateurId(Long id);
    int deleteByUtilisateurId(Long id);
    List<DocumentPartageUtilisateur> findByAcessShareId(Long id);
    int deleteByAcessShareId(Long id);



}
