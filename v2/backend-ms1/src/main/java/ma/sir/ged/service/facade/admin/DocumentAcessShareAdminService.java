package ma.sir.ged.service.facade.admin;

import java.util.List;
import ma.sir.ged.bean.core.DocumentAcessShare;
import ma.sir.ged.dao.criteria.core.DocumentAcessShareCriteria;
import ma.sir.ged.dao.criteria.history.DocumentAcessShareHistoryCriteria;
import ma.sir.ged.zynerator.service.IService;


public interface DocumentAcessShareAdminService extends  IService<DocumentAcessShare,DocumentAcessShareCriteria, DocumentAcessShareHistoryCriteria>  {

    List<DocumentAcessShare> findByDocumentId(Long id);
    int deleteByDocumentId(Long id);
    List<DocumentAcessShare> findByAcessShareId(Long id);
    int deleteByAcessShareId(Long id);



}
