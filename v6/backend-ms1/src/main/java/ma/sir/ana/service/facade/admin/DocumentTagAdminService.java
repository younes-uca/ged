package ma.sir.ana.service.facade.admin;

import java.util.List;
import ma.sir.ana.bean.core.DocumentTag;
import ma.sir.ana.dao.criteria.core.DocumentTagCriteria;
import ma.sir.ana.dao.criteria.history.DocumentTagHistoryCriteria;
import ma.sir.ana.zynerator.service.IService;


public interface DocumentTagAdminService extends  IService<DocumentTag,DocumentTagCriteria, DocumentTagHistoryCriteria>  {

    List<DocumentTag> findByDocumentId(Long id);
    int deleteByDocumentId(Long id);
    List<DocumentTag> findByTagId(Long id);
    int deleteByTagId(Long id);



}
