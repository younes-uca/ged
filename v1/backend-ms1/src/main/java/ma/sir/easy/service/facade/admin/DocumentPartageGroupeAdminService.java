package ma.sir.easy.service.facade.admin;

import java.util.List;
import ma.sir.easy.bean.core.DocumentPartageGroupe;
import ma.sir.easy.dao.criteria.core.DocumentPartageGroupeCriteria;
import ma.sir.easy.dao.criteria.history.DocumentPartageGroupeHistoryCriteria;
import ma.sir.easy.zynerator.service.IService;


public interface DocumentPartageGroupeAdminService extends  IService<DocumentPartageGroupe,DocumentPartageGroupeCriteria, DocumentPartageGroupeHistoryCriteria>  {

    List<DocumentPartageGroupe> findByDocumentId(Long id);
    int deleteByDocumentId(Long id);
    List<DocumentPartageGroupe> findByGroupeId(Long id);
    int deleteByGroupeId(Long id);
    List<DocumentPartageGroupe> findByAcessShareId(Long id);
    int deleteByAcessShareId(Long id);



}
