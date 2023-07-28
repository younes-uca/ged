package ma.sir.ana.service.impl.admin;

import ma.sir.ana.bean.core.DocumentCategorieFieldRule;
import ma.sir.ana.bean.history.DocumentCategorieFieldRuleHistory;
import ma.sir.ana.dao.criteria.core.DocumentCategorieFieldRuleCriteria;
import ma.sir.ana.dao.criteria.history.DocumentCategorieFieldRuleHistoryCriteria;
import ma.sir.ana.dao.facade.core.DocumentCategorieFieldRuleDao;
import ma.sir.ana.dao.facade.history.DocumentCategorieFieldRuleHistoryDao;
import ma.sir.ana.dao.specification.core.DocumentCategorieFieldRuleSpecification;
import ma.sir.ana.service.facade.admin.DocumentCategorieFieldRuleAdminService;
import ma.sir.ana.zynerator.service.AbstractServiceImpl;
import ma.sir.ana.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;







import java.util.List;
@Service
public class DocumentCategorieFieldRuleAdminServiceImpl extends AbstractServiceImpl<DocumentCategorieFieldRule,DocumentCategorieFieldRuleHistory, DocumentCategorieFieldRuleCriteria, DocumentCategorieFieldRuleHistoryCriteria, DocumentCategorieFieldRuleDao,
DocumentCategorieFieldRuleHistoryDao> implements DocumentCategorieFieldRuleAdminService {



    public DocumentCategorieFieldRule findByReferenceEntity(DocumentCategorieFieldRule t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(DocumentCategorieFieldRule.class,DocumentCategorieFieldRuleHistory.class, DocumentCategorieFieldRuleHistoryCriteria.class, DocumentCategorieFieldRuleSpecification.class);
    }


    public DocumentCategorieFieldRuleAdminServiceImpl(DocumentCategorieFieldRuleDao dao, DocumentCategorieFieldRuleHistoryDao historyDao) {
        super(dao, historyDao);
    }

}