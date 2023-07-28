package ma.sir.ana.service.facade.admin;

import java.util.List;
import ma.sir.ana.bean.core.DocumentField;
import ma.sir.ana.dao.criteria.core.DocumentFieldCriteria;
import ma.sir.ana.dao.criteria.history.DocumentFieldHistoryCriteria;
import ma.sir.ana.zynerator.service.IService;


public interface DocumentFieldAdminService extends  IService<DocumentField,DocumentFieldCriteria, DocumentFieldHistoryCriteria>  {

    List<DocumentField> findByFieldId(Long id);
    int deleteByFieldId(Long id);
    List<DocumentField> findByDocumentId(Long id);
    int deleteByDocumentId(Long id);
    List<DocumentField> findByDocumentFieldStateId(Long id);
    int deleteByDocumentFieldStateId(Long id);



}
