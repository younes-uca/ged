package ma.sir.chocho.service.facade.admin;

import java.util.List;
import ma.sir.chocho.bean.core.DocumentTag;
import ma.sir.chocho.dao.criteria.core.DocumentTagCriteria;
import ma.sir.chocho.dao.criteria.history.DocumentTagHistoryCriteria;
import ma.sir.chocho.zynerator.service.IService;


public interface DocumentTagAdminService extends  IService<DocumentTag,DocumentTagCriteria, DocumentTagHistoryCriteria>  {

    List<DocumentTag> findByDocumentId(Long id);
    int deleteByDocumentId(Long id);
    List<DocumentTag> findByTagId(Long id);
    int deleteByTagId(Long id);



}
