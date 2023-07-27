package  ma.sir.chocho.dao.specification.history;

import ma.sir.chocho.zynerator.specification.AbstractHistorySpecification;
import ma.sir.chocho.dao.criteria.history.TagHistoryCriteria;
import ma.sir.chocho.bean.history.TagHistory;


public class TagHistorySpecification extends AbstractHistorySpecification<TagHistoryCriteria, TagHistory> {

    public TagHistorySpecification(TagHistoryCriteria criteria) {
        super(criteria);
    }

    public TagHistorySpecification(TagHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
