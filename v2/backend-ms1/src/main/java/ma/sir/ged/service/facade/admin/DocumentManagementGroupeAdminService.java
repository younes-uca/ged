package ma.sir.ged.service.facade.admin;

import java.util.List;
import ma.sir.ged.bean.core.DocumentManagementGroupe;
import ma.sir.ged.dao.criteria.core.DocumentManagementGroupeCriteria;
import ma.sir.ged.dao.criteria.history.DocumentManagementGroupeHistoryCriteria;
import ma.sir.ged.zynerator.service.IService;


public interface DocumentManagementGroupeAdminService extends  IService<DocumentManagementGroupe,DocumentManagementGroupeCriteria, DocumentManagementGroupeHistoryCriteria>  {

    List<DocumentManagementGroupe> findByDocumentId(Long id);
    int deleteByDocumentId(Long id);
    List<DocumentManagementGroupe> findByGroupeId(Long id);
    int deleteByGroupeId(Long id);
    List<DocumentManagementGroupe> findByAcessManagementId(Long id);
    int deleteByAcessManagementId(Long id);



}
