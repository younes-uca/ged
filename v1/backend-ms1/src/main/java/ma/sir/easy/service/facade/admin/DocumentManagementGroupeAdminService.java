package ma.sir.easy.service.facade.admin;

import java.util.List;
import ma.sir.easy.bean.core.DocumentManagementGroupe;
import ma.sir.easy.dao.criteria.core.DocumentManagementGroupeCriteria;
import ma.sir.easy.dao.criteria.history.DocumentManagementGroupeHistoryCriteria;
import ma.sir.easy.zynerator.service.IService;


public interface DocumentManagementGroupeAdminService extends  IService<DocumentManagementGroupe,DocumentManagementGroupeCriteria, DocumentManagementGroupeHistoryCriteria>  {

    List<DocumentManagementGroupe> findByDocumentId(Long id);
    int deleteByDocumentId(Long id);
    List<DocumentManagementGroupe> findByGroupeId(Long id);
    int deleteByGroupeId(Long id);
    List<DocumentManagementGroupe> findByAcessManagementId(Long id);
    int deleteByAcessManagementId(Long id);



}
