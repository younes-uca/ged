package  ma.sir.chocho.dao.specification.core;

import ma.sir.chocho.zynerator.specification.AbstractSpecification;
import ma.sir.chocho.dao.criteria.core.DocumentTypeCriteria;
import ma.sir.chocho.bean.core.DocumentType;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DocumentTypeSpecification extends  AbstractSpecification<DocumentTypeCriteria, DocumentType>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public DocumentTypeSpecification(DocumentTypeCriteria criteria) {
        super(criteria);
    }

    public DocumentTypeSpecification(DocumentTypeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
