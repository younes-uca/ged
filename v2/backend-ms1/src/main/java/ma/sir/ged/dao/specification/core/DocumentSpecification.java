package  ma.sir.ged.dao.specification.core;

import ma.sir.ged.zynerator.specification.AbstractSpecification;
import ma.sir.ged.dao.criteria.core.DocumentCriteria;
import ma.sir.ged.bean.core.Document;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DocumentSpecification extends  AbstractSpecification<DocumentCriteria, Document>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("uploadDate", criteria.getUploadDate(), criteria.getUploadDateFrom(), criteria.getUploadDateTo());
        addPredicate("dateLastUpdate", criteria.getDateLastUpdate(), criteria.getDateLastUpdateFrom(), criteria.getDateLastUpdateTo());
        addPredicate("content", criteria.getContent(),criteria.getContentLike());
        addPredicateBigDecimal("size", criteria.getSize(), criteria.getSizeMin(), criteria.getSizeMax());
        addPredicateBool("archive", criteria.getArchive());
        addPredicateBool("versionne", criteria.getVersionne());
        addPredicateFk("documentType","id", criteria.getDocumentType()==null?null:criteria.getDocumentType().getId());
        addPredicateFk("documentType","id", criteria.getDocumentTypes());
        addPredicateFk("documentType","code", criteria.getDocumentType()==null?null:criteria.getDocumentType().getCode());
        addPredicateFk("utilisateur","id", criteria.getUtilisateur()==null?null:criteria.getUtilisateur().getId());
        addPredicateFk("utilisateur","id", criteria.getUtilisateurs());
        addPredicateFk("utilisateur","email", criteria.getUtilisateur()==null?null:criteria.getUtilisateur().getEmail());
        addPredicateFk("entiteAdministrative","id", criteria.getEntiteAdministrative()==null?null:criteria.getEntiteAdministrative().getId());
        addPredicateFk("entiteAdministrative","id", criteria.getEntiteAdministratives());
        addPredicateFk("entiteAdministrative","code", criteria.getEntiteAdministrative()==null?null:criteria.getEntiteAdministrative().getCode());
    }

    public DocumentSpecification(DocumentCriteria criteria) {
        super(criteria);
    }

    public DocumentSpecification(DocumentCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
