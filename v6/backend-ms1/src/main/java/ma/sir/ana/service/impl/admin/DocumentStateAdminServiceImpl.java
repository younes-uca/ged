package ma.sir.ana.service.impl.admin;

import ma.sir.ana.bean.core.DocumentState;
import ma.sir.ana.bean.history.DocumentStateHistory;
import ma.sir.ana.dao.criteria.core.DocumentStateCriteria;
import ma.sir.ana.dao.criteria.history.DocumentStateHistoryCriteria;
import ma.sir.ana.dao.facade.core.DocumentStateDao;
import ma.sir.ana.dao.facade.history.DocumentStateHistoryDao;
import ma.sir.ana.dao.specification.core.DocumentStateSpecification;
import ma.sir.ana.service.facade.admin.DocumentStateAdminService;
import ma.sir.ana.zynerator.service.AbstractServiceImpl;
import ma.sir.ana.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;







import java.util.List;
@Service
public class DocumentStateAdminServiceImpl extends AbstractServiceImpl<DocumentState,DocumentStateHistory, DocumentStateCriteria, DocumentStateHistoryCriteria, DocumentStateDao,
DocumentStateHistoryDao> implements DocumentStateAdminService {



    public DocumentState findByReferenceEntity(DocumentState t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(DocumentState.class,DocumentStateHistory.class, DocumentStateHistoryCriteria.class, DocumentStateSpecification.class);
    }


    public DocumentStateAdminServiceImpl(DocumentStateDao dao, DocumentStateHistoryDao historyDao) {
        super(dao, historyDao);
    }

}