package ma.sir.ana.service.facade.admin;

import java.util.List;
import ma.sir.ana.bean.core.DocumentManagementGroupe;
import ma.sir.ana.dao.criteria.core.DocumentManagementGroupeCriteria;
import ma.sir.ana.dao.criteria.history.DocumentManagementGroupeHistoryCriteria;
import ma.sir.ana.zynerator.service.IService;


public interface DocumentManagementGroupeAdminService extends  IService<DocumentManagementGroupe,DocumentManagementGroupeCriteria, DocumentManagementGroupeHistoryCriteria>  {

    List<DocumentManagementGroupe> findByDocumentId(Long id);
    int deleteByDocumentId(Long id);
    List<DocumentManagementGroupe> findByGroupeId(Long id);
    int deleteByGroupeId(Long id);
    List<DocumentManagementGroupe> findByAcessManagementId(Long id);
    int deleteByAcessManagementId(Long id);



}
