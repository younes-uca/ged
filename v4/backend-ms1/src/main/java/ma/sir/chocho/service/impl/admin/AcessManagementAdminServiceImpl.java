package ma.sir.chocho.service.impl.admin;

import ma.sir.chocho.bean.core.AcessManagement;
import ma.sir.chocho.bean.history.AcessManagementHistory;
import ma.sir.chocho.dao.criteria.core.AcessManagementCriteria;
import ma.sir.chocho.dao.criteria.history.AcessManagementHistoryCriteria;
import ma.sir.chocho.dao.facade.core.AcessManagementDao;
import ma.sir.chocho.dao.facade.history.AcessManagementHistoryDao;
import ma.sir.chocho.dao.specification.core.AcessManagementSpecification;
import ma.sir.chocho.service.facade.admin.AcessManagementAdminService;
import ma.sir.chocho.zynerator.service.AbstractServiceImpl;
import ma.sir.chocho.zynerator.util.ListUtil;
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