package  ma.sir.ged.dao.specification.core;

import ma.sir.ged.zynerator.specification.AbstractSpecification;
import ma.sir.ged.dao.criteria.core.PurchaseTagCriteria;
import ma.sir.ged.bean.core.PurchaseTag;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PurchaseTagSpecification extends  AbstractSpecification<PurchaseTagCriteria, PurchaseTag>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateFk("purchase","id", criteria.getPurchase()==null?null:criteria.getPurchase().getId());
        addPredicateFk("purchase","id", criteria.getPurchases());
        addPredicateFk("purchase","reference", criteria.getPurchase()==null?null:criteria.getPurchase().getReference());
        addPredicateFk("tag","id", criteria.getTag()==null?null:criteria.getTag().getId());
        addPredicateFk("tag","id", criteria.getTags());
        addPredicateFk("tag","code", criteria.getTag()==null?null:criteria.getTag().getCode());
    }

    public PurchaseTagSpecification(PurchaseTagCriteria criteria) {
        super(criteria);
    }

    public PurchaseTagSpecification(PurchaseTagCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}