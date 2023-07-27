package ma.sir.ana.service.facade.admin;

import java.util.List;
import ma.sir.ana.bean.core.Tag;
import ma.sir.ana.dao.criteria.core.TagCriteria;
import ma.sir.ana.dao.criteria.history.TagHistoryCriteria;
import ma.sir.ana.zynerator.service.IService;


public interface TagAdminService extends  IService<Tag,TagCriteria, TagHistoryCriteria>  {




}
