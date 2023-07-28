package ma.sir.ana.service.impl.admin;

import ma.sir.ana.bean.core.DocumentFieldState;
import ma.sir.ana.bean.history.DocumentFieldStateHistory;
import ma.sir.ana.dao.criteria.core.DocumentFieldStateCriteria;
import ma.sir.ana.dao.criteria.history.DocumentFieldStateHistoryCriteria;
import ma.sir.ana.dao.facade.core.DocumentFieldStateDao;
import ma.sir.ana.dao.facade.history.DocumentFieldStateHistoryDao;
import ma.sir.ana.dao.specification.core.DocumentFieldStateSpecification;
import ma.sir.ana.service.facade.admin.DocumentFieldStateAdminService;
import ma.sir.ana.zynerator.service.AbstractServiceImpl;
import ma.sir.ana.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;







import java.util.List;
@Service
public class DocumentFieldStateAdminServiceImpl extends AbstractServiceImpl<DocumentFieldState,DocumentFieldStateHistory, DocumentFieldStateCriteria, DocumentFieldStateHistoryCriteria, DocumentFieldStateDao,
DocumentFieldStateHistoryDao> implements DocumentFieldStateAdminService {



    public DocumentFieldState findByReferenceEntity(DocumentFieldState t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(DocumentFieldState.class,DocumentFieldStateHistory.class, DocumentFieldStateHistoryCriteria.class, DocumentFieldStateSpecification.class);
    }


    public DocumentFieldStateAdminServiceImpl(DocumentFieldStateDao dao, DocumentFieldStateHistoryDao historyDao) {
        super(dao, historyDao);
    }

}