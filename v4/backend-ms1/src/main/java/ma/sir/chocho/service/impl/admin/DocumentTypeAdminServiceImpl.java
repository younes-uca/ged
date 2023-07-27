package ma.sir.chocho.service.impl.admin;

import ma.sir.chocho.bean.core.DocumentType;
import ma.sir.chocho.bean.history.DocumentTypeHistory;
import ma.sir.chocho.dao.criteria.core.DocumentTypeCriteria;
import ma.sir.chocho.dao.criteria.history.DocumentTypeHistoryCriteria;
import ma.sir.chocho.dao.facade.core.DocumentTypeDao;
import ma.sir.chocho.dao.facade.history.DocumentTypeHistoryDao;
import ma.sir.chocho.dao.specification.core.DocumentTypeSpecification;
import ma.sir.chocho.service.facade.admin.DocumentTypeAdminService;
import ma.sir.chocho.zynerator.service.AbstractServiceImpl;
import ma.sir.chocho.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;







import java.util.List;
@Service
public class DocumentTypeAdminServiceImpl extends AbstractServiceImpl<DocumentType,DocumentTypeHistory, DocumentTypeCriteria, DocumentTypeHistoryCriteria, DocumentTypeDao,
DocumentTypeHistoryDao> implements DocumentTypeAdminService {



    public DocumentType findByReferenceEntity(DocumentType t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(DocumentType.class,DocumentTypeHistory.class, DocumentTypeHistoryCriteria.class, DocumentTypeSpecification.class);
    }


    public DocumentTypeAdminServiceImpl(DocumentTypeDao dao, DocumentTypeHistoryDao historyDao) {
        super(dao, historyDao);
    }

}