package ma.sir.chocho.service.facade.admin;

import java.util.List;
import ma.sir.chocho.bean.core.Client;
import ma.sir.chocho.dao.criteria.core.ClientCriteria;
import ma.sir.chocho.dao.criteria.history.ClientHistoryCriteria;
import ma.sir.chocho.zynerator.service.IService;


public interface ClientAdminService extends  IService<Client,ClientCriteria, ClientHistoryCriteria>  {

    List<Client> findByClientCategoryId(Long id);
    int deleteByClientCategoryId(Long id);



}
