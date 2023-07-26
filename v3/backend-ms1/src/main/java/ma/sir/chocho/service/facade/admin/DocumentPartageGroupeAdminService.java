package ma.sir.chocho.service.facade.admin;

import java.util.List;
import ma.sir.chocho.bean.core.DocumentPartageGroupe;
import ma.sir.chocho.dao.criteria.core.DocumentPartageGroupeCriteria;
import ma.sir.chocho.dao.criteria.history.DocumentPartageGroupeHistoryCriteria;
import ma.sir.chocho.zynerator.service.IService;


public interface DocumentPartageGroupeAdminService extends  IService<DocumentPartageGroupe,DocumentPartageGroupeCriteria, DocumentPartageGroupeHistoryCriteria>  {

    List<DocumentPartageGroupe> findByDocumentId(Long id);
    int deleteByDocumentId(Long id);
    List<DocumentPartageGroupe> findByGroupeId(Long id);
    int deleteByGroupeId(Long id);
    List<DocumentPartageGroupe> findByAcessShareId(Long id);
    int deleteByAcessShareId(Long id);



}
