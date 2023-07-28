package ma.sir.ana.service.impl.admin;

import ma.sir.ana.bean.core.DocumentField;
import ma.sir.ana.bean.history.DocumentFieldHistory;
import ma.sir.ana.dao.criteria.core.DocumentFieldCriteria;
import ma.sir.ana.dao.criteria.history.DocumentFieldHistoryCriteria;
import ma.sir.ana.dao.facade.core.DocumentFieldDao;
import ma.sir.ana.dao.facade.history.DocumentFieldHistoryDao;
import ma.sir.ana.dao.specification.core.DocumentFieldSpecification;
import ma.sir.ana.service.facade.admin.DocumentFieldAdminService;
import ma.sir.ana.zynerator.service.AbstractServiceImpl;
import ma.sir.ana.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ana.service.facade.admin.FieldAdminService ;
import ma.sir.ana.service.facade.admin.DocumentAdminService ;
import ma.sir.ana.service.facade.admin.DocumentFieldStateAdminService ;



import java.util.List;
@Service
public class DocumentFieldAdminServiceImpl extends AbstractServiceImpl<DocumentField,DocumentFieldHistory, DocumentFieldCriteria, DocumentFieldHistoryCriteria, DocumentFieldDao,
DocumentFieldHistoryDao> implements DocumentFieldAdminService {




    public List<DocumentField> findByFieldId(Long id){
        return dao.findByFieldId(id);
    }
    public int deleteByFieldId(Long id){
        return dao.deleteByFieldId(id);
    }
    public List<DocumentField> findByDocumentId(Long id){
        return dao.findByDocumentId(id);
    }
    public int deleteByDocumentId(Long id){
        return dao.deleteByDocumentId(id);
    }
    public List<DocumentField> findByDocumentFieldStateId(Long id){
        return dao.findByDocumentFieldStateId(id);
    }
    public int deleteByDocumentFieldStateId(Long id){
        return dao.deleteByDocumentFieldStateId(id);
    }




    public void configure() {
        super.configure(DocumentField.class,DocumentFieldHistory.class, DocumentFieldHistoryCriteria.class, DocumentFieldSpecification.class);
    }

    @Autowired
    private FieldAdminService fieldService ;
    @Autowired
    private DocumentAdminService documentService ;
    @Autowired
    private DocumentFieldStateAdminService documentFieldStateService ;

    public DocumentFieldAdminServiceImpl(DocumentFieldDao dao, DocumentFieldHistoryDao historyDao) {
        super(dao, historyDao);
    }

}