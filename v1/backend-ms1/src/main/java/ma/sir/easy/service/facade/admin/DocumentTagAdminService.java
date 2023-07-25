package ma.sir.easy.service.facade.admin;

import java.util.List;
import ma.sir.easy.bean.core.DocumentTag;
import ma.sir.easy.dao.criteria.core.DocumentTagCriteria;
import ma.sir.easy.dao.criteria.history.DocumentTagHistoryCriteria;
import ma.sir.easy.zynerator.service.IService;


public interface DocumentTagAdminService extends  IService<DocumentTag,DocumentTagCriteria, DocumentTagHistoryCriteria>  {

    List<DocumentTag> findByDocumentId(Long id);
    int deleteByDocumentId(Long id);
    List<DocumentTag> findByTagId(Long id);
    int deleteByTagId(Long id);



}
