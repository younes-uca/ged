package ma.sir.chocho.service.facade.admin;

import java.util.List;
import ma.sir.chocho.bean.core.DocumentAcessShare;
import ma.sir.chocho.dao.criteria.core.DocumentAcessShareCriteria;
import ma.sir.chocho.dao.criteria.history.DocumentAcessShareHistoryCriteria;
import ma.sir.chocho.zynerator.service.IService;


public interface DocumentAcessShareAdminService extends  IService<DocumentAcessShare,DocumentAcessShareCriteria, DocumentAcessShareHistoryCriteria>  {

    List<DocumentAcessShare> findByDocumentId(Long id);
    int deleteByDocumentId(Long id);
    List<DocumentAcessShare> findByAcessShareId(Long id);
    int deleteByAcessShareId(Long id);



}
