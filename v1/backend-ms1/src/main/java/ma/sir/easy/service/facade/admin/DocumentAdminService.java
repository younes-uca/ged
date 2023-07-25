package ma.sir.easy.service.facade.admin;

import java.util.List;
import ma.sir.easy.bean.core.Document;
import ma.sir.easy.dao.criteria.core.DocumentCriteria;
import ma.sir.easy.dao.criteria.history.DocumentHistoryCriteria;
import ma.sir.easy.zynerator.service.IService;


public interface DocumentAdminService extends  IService<Document,DocumentCriteria, DocumentHistoryCriteria>  {

    List<Document> findByDocumentTypeId(Long id);
    int deleteByDocumentTypeId(Long id);
    List<Document> findByUtilisateurId(Long id);
    int deleteByUtilisateurId(Long id);
    List<Document> findByEntiteAdministrativeId(Long id);
    int deleteByEntiteAdministrativeId(Long id);



}
