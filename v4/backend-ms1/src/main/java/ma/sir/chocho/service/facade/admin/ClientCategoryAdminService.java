package ma.sir.chocho.service.facade.admin;

import java.util.List;
import ma.sir.chocho.bean.core.ClientCategory;
import ma.sir.chocho.dao.criteria.core.ClientCategoryCriteria;
import ma.sir.chocho.dao.criteria.history.ClientCategoryHistoryCriteria;
import ma.sir.chocho.zynerator.service.IService;


public interface ClientCategoryAdminService extends  IService<ClientCategory,ClientCategoryCriteria, ClientCategoryHistoryCriteria>  {




}
