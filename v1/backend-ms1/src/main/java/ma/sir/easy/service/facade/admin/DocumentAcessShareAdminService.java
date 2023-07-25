package ma.sir.easy.service.facade.admin;

import java.util.List;
import ma.sir.easy.bean.core.DocumentAcessShare;
import ma.sir.easy.dao.criteria.core.DocumentAcessShareCriteria;
import ma.sir.easy.dao.criteria.history.DocumentAcessShareHistoryCriteria;
import ma.sir.easy.zynerator.service.IService;


public interface DocumentAcessShareAdminService extends  IService<DocumentAcessShare,DocumentAcessShareCriteria, DocumentAcessShareHistoryCriteria>  {

    List<DocumentAcessShare> findByDocumentId(Long id);
    int deleteByDocumentId(Long id);
    List<DocumentAcessShare> findByAcessShareId(Long id);
    int deleteByAcessShareId(Long id);



}
