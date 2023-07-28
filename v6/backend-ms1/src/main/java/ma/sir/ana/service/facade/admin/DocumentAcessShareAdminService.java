package ma.sir.ana.service.facade.admin;

import java.util.List;
import ma.sir.ana.bean.core.DocumentAcessShare;
import ma.sir.ana.dao.criteria.core.DocumentAcessShareCriteria;
import ma.sir.ana.dao.criteria.history.DocumentAcessShareHistoryCriteria;
import ma.sir.ana.zynerator.service.IService;


public interface DocumentAcessShareAdminService extends  IService<DocumentAcessShare,DocumentAcessShareCriteria, DocumentAcessShareHistoryCriteria>  {

    List<DocumentAcessShare> findByDocumentId(Long id);
    int deleteByDocumentId(Long id);
    List<DocumentAcessShare> findByAcessShareId(Long id);
    int deleteByAcessShareId(Long id);



}
