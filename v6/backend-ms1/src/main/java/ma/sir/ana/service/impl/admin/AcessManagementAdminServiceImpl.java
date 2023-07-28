package ma.sir.ana.service.impl.admin;

import ma.sir.ana.bean.core.AcessManagement;
import ma.sir.ana.bean.history.AcessManagementHistory;
import ma.sir.ana.dao.criteria.core.AcessManagementCriteria;
import ma.sir.ana.dao.criteria.history.AcessManagementHistoryCriteria;
import ma.sir.ana.dao.facade.core.AcessManagementDao;
import ma.sir.ana.dao.facade.history.AcessManagementHistoryDao;
import ma.sir.ana.dao.specification.core.AcessManagementSpecification;
import ma.sir.ana.service.facade.admin.AcessManagementAdminService;
import ma.sir.ana.zynerator.service.AbstractServiceImpl;
import ma.sir.ana.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;







import java.util.List;
@Service
public class AcessManagementAdminServiceImpl extends AbstractServiceImpl<AcessManagement,AcessManagementHistory, AcessManagementCriteria, AcessManagementHistoryCriteria, AcessManagementDao,
AcessManagementHistoryDao> implements AcessManagementAdminService {



    public AcessManagement findByReferenceEntity(AcessManagement t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(AcessManagement.class,AcessManagementHistory.class, AcessManagementHistoryCriteria.class, AcessManagementSpecification.class);
    }


    public AcessManagementAdminServiceImpl(AcessManagementDao dao, AcessManagementHistoryDao historyDao) {
        super(dao, historyDao);
    }

}