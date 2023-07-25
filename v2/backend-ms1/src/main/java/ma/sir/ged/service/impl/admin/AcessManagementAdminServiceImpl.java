package ma.sir.ged.service.impl.admin;

import ma.sir.ged.bean.core.AcessManagement;
import ma.sir.ged.bean.history.AcessManagementHistory;
import ma.sir.ged.dao.criteria.core.AcessManagementCriteria;
import ma.sir.ged.dao.criteria.history.AcessManagementHistoryCriteria;
import ma.sir.ged.dao.facade.core.AcessManagementDao;
import ma.sir.ged.dao.facade.history.AcessManagementHistoryDao;
import ma.sir.ged.dao.specification.core.AcessManagementSpecification;
import ma.sir.ged.service.facade.admin.AcessManagementAdminService;
import ma.sir.ged.zynerator.service.AbstractServiceImpl;
import ma.sir.ged.zynerator.util.ListUtil;
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