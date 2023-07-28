package ma.sir.ana.service.impl.admin;

import ma.sir.ana.bean.core.ClientCategory;
import ma.sir.ana.bean.history.ClientCategoryHistory;
import ma.sir.ana.dao.criteria.core.ClientCategoryCriteria;
import ma.sir.ana.dao.criteria.history.ClientCategoryHistoryCriteria;
import ma.sir.ana.dao.facade.core.ClientCategoryDao;
import ma.sir.ana.dao.facade.history.ClientCategoryHistoryDao;
import ma.sir.ana.dao.specification.core.ClientCategorySpecification;
import ma.sir.ana.service.facade.admin.ClientCategoryAdminService;
import ma.sir.ana.zynerator.service.AbstractServiceImpl;
import ma.sir.ana.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;







import java.util.List;
@Service
public class ClientCategoryAdminServiceImpl extends AbstractServiceImpl<ClientCategory,ClientCategoryHistory, ClientCategoryCriteria, ClientCategoryHistoryCriteria, ClientCategoryDao,
ClientCategoryHistoryDao> implements ClientCategoryAdminService {



    public ClientCategory findByReferenceEntity(ClientCategory t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(ClientCategory.class,ClientCategoryHistory.class, ClientCategoryHistoryCriteria.class, ClientCategorySpecification.class);
    }


    public ClientCategoryAdminServiceImpl(ClientCategoryDao dao, ClientCategoryHistoryDao historyDao) {
        super(dao, historyDao);
    }

}