package ma.sir.easy.service.impl.admin;

import ma.sir.easy.bean.core.AcessManagement;
import ma.sir.easy.bean.history.AcessManagementHistory;
import ma.sir.easy.dao.criteria.core.AcessManagementCriteria;
import ma.sir.easy.dao.criteria.history.AcessManagementHistoryCriteria;
import ma.sir.easy.dao.facade.core.AcessManagementDao;
import ma.sir.easy.dao.facade.history.AcessManagementHistoryDao;
import ma.sir.easy.dao.specification.core.AcessManagementSpecification;
import ma.sir.easy.service.facade.admin.AcessManagementAdminService;
import ma.sir.easy.zynerator.service.AbstractServiceImpl;
import ma.sir.easy.zynerator.util.ListUtil;
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