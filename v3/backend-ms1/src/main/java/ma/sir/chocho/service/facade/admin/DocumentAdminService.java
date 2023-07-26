package ma.sir.chocho.service.facade.admin;

import java.util.List;
import ma.sir.chocho.bean.core.Document;
import ma.sir.chocho.dao.criteria.core.DocumentCriteria;
import ma.sir.chocho.dao.criteria.history.DocumentHistoryCriteria;
import ma.sir.chocho.zynerator.service.IService;


public interface DocumentAdminService extends  IService<Document,DocumentCriteria, DocumentHistoryCriteria>  {

    List<Document> findByDocumentTypeId(Long id);
    int deleteByDocumentTypeId(Long id);
    List<Document> findByUtilisateurId(Long id);
    int deleteByUtilisateurId(Long id);
    List<Document> findByEntiteAdministrativeId(Long id);
    int deleteByEntiteAdministrativeId(Long id);



}
