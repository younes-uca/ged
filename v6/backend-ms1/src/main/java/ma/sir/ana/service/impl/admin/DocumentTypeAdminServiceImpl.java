package ma.sir.ana.service.impl.admin;

import ma.sir.ana.bean.core.DocumentType;
import ma.sir.ana.bean.history.DocumentTypeHistory;
import ma.sir.ana.dao.criteria.core.DocumentTypeCriteria;
import ma.sir.ana.dao.criteria.history.DocumentTypeHistoryCriteria;
import ma.sir.ana.dao.facade.core.DocumentTypeDao;
import ma.sir.ana.dao.facade.history.DocumentTypeHistoryDao;
import ma.sir.ana.dao.specification.core.DocumentTypeSpecification;
import ma.sir.ana.service.facade.admin.DocumentTypeAdminService;
import ma.sir.ana.zynerator.service.AbstractServiceImpl;
import ma.sir.ana.zynerator.util.ListUtil;
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