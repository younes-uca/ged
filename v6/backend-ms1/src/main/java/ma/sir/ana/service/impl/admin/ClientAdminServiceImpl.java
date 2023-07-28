package ma.sir.ana.service.impl.admin;

import ma.sir.ana.bean.core.Client;
import ma.sir.ana.bean.history.ClientHistory;
import ma.sir.ana.dao.criteria.core.ClientCriteria;
import ma.sir.ana.dao.criteria.history.ClientHistoryCriteria;
import ma.sir.ana.dao.facade.core.ClientDao;
import ma.sir.ana.dao.facade.history.ClientHistoryDao;
import ma.sir.ana.dao.specification.core.ClientSpecification;
import ma.sir.ana.service.facade.admin.ClientAdminService;
import ma.sir.ana.zynerator.service.AbstractServiceImpl;
import ma.sir.ana.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ana.service.facade.admin.ClientCategoryAdminService ;



import java.util.List;
@Service
public class ClientAdminServiceImpl extends AbstractServiceImpl<Client,ClientHistory, ClientCriteria, ClientHistoryCriteria, ClientDao,
ClientHistoryDao> implements ClientAdminService {



    public Client findByReferenceEntity(Client t){
        return  dao.findByEmail(t.getEmail());
    }

    public List<Client> findByClientCategoryId(Long id){
        return dao.findByClientCategoryId(id);
    }
    public int deleteByClientCategoryId(Long id){
        return dao.deleteByClientCategoryId(id);
    }




    public void configure() {
        super.configure(Client.class,ClientHistory.class, ClientHistoryCriteria.class, ClientSpecification.class);
    }

    @Autowired
    private ClientCategoryAdminService clientCategoryService ;

    public ClientAdminServiceImpl(ClientDao dao, ClientHistoryDao historyDao) {
        super(dao, historyDao);
    }

}