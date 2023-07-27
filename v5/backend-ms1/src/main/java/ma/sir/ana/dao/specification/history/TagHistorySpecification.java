package  ma.sir.ana.dao.specification.history;

import ma.sir.ana.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ana.dao.criteria.history.TagHistoryCriteria;
import ma.sir.ana.bean.history.TagHistory;


public class TagHistorySpecification extends AbstractHistorySpecification<TagHistoryCriteria, TagHistory> {

    public TagHistorySpecification(TagHistoryCriteria criteria) {
        super(criteria);
    }

    public TagHistorySpecification(TagHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
