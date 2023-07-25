package ma.sir.easy.service.impl.admin;

import ma.sir.easy.bean.core.DocumentType;
import ma.sir.easy.bean.history.DocumentTypeHistory;
import ma.sir.easy.dao.criteria.core.DocumentTypeCriteria;
import ma.sir.easy.dao.criteria.history.DocumentTypeHistoryCriteria;
import ma.sir.easy.dao.facade.core.DocumentTypeDao;
import ma.sir.easy.dao.facade.history.DocumentTypeHistoryDao;
import ma.sir.easy.dao.specification.core.DocumentTypeSpecification;
import ma.sir.easy.service.facade.admin.DocumentTypeAdminService;
import ma.sir.easy.zynerator.service.AbstractServiceImpl;
import ma.sir.easy.zynerator.util.ListUtil;
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