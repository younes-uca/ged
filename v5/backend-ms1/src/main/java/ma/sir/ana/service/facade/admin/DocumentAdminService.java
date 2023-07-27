package ma.sir.ana.service.facade.admin;

import java.util.List;
import ma.sir.ana.bean.core.Document;
import ma.sir.ana.dao.criteria.core.DocumentCriteria;
import ma.sir.ana.dao.criteria.history.DocumentHistoryCriteria;
import ma.sir.ana.zynerator.service.IService;


public interface DocumentAdminService extends  IService<Document,DocumentCriteria, DocumentHistoryCriteria>  {

    List<Document> findByDocumentTypeId(Long id);
    int deleteByDocumentTypeId(Long id);
    List<Document> findByUtilisateurId(Long id);
    int deleteByUtilisateurId(Long id);
    List<Document> findByEntiteAdministrativeId(Long id);
    int deleteByEntiteAdministrativeId(Long id);



}
