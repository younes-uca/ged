package ma.sir.ged.service.impl.admin;

import ma.sir.ged.bean.core.EntiteAdministrative;
import ma.sir.ged.bean.history.EntiteAdministrativeHistory;
import ma.sir.ged.dao.criteria.core.EntiteAdministrativeCriteria;
import ma.sir.ged.dao.criteria.history.EntiteAdministrativeHistoryCriteria;
import ma.sir.ged.dao.facade.core.EntiteAdministrativeDao;
import ma.sir.ged.dao.facade.history.EntiteAdministrativeHistoryDao;
import ma.sir.ged.dao.specification.core.EntiteAdministrativeSpecification;
import ma.sir.ged.service.facade.admin.EntiteAdministrativeAdminService;
import ma.sir.ged.service.impl.open.MinIOServiceImpl;
import ma.sir.ged.zynerator.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ged.service.facade.admin.EntiteAdministrativeTypeAdminService;
import ma.sir.ged.service.facade.admin.UtilisateurAdminService;

@Service
public class EntiteAdministrativeAdminServiceImpl extends AbstractServiceImpl<EntiteAdministrative, EntiteAdministrativeHistory, EntiteAdministrativeCriteria, EntiteAdministrativeHistoryCriteria, EntiteAdministrativeDao,
        EntiteAdministrativeHistoryDao> implements EntiteAdministrativeAdminService {


    public EntiteAdministrative findByReferenceEntity(EntiteAdministrative t) {
        return dao.findByCode(t.getCode());
    }

    public List<EntiteAdministrative> findByUtilisateurId(Long id) {
        return dao.findByUtilisateurId(id);
    }

    public int deleteByUtilisateurId(Long id) {
        return dao.deleteByUtilisateurId(id);
    }

    public List<EntiteAdministrative> findByEntiteAdministrativeTypeId(Long id) {
        return dao.findByEntiteAdministrativeTypeId(id);
    }

    public int deleteByEntiteAdministrativeTypeId(Long id) {
        return dao.deleteByEntiteAdministrativeTypeId(id);
    }

    @Override
    public EntiteAdministrative create(EntiteAdministrative entiteAdministrative) {
        if (dao.findByCode(entiteAdministrative.getCode()) != null) return null;
        else {
            entiteAdministrativeHierarchy(entiteAdministrative, "ged");
            return super.create(entiteAdministrative);
        }
    }

    public void entiteAdministrativeHierarchy(EntiteAdministrative entity, String bucket) {
        if (entity != null) {
            createFoldersRecursively(entity, bucket);
        }
    }

    private void createFoldersRecursively(EntiteAdministrative entity, String bucketName) {
        if (entity != null) {

            EntiteAdministrative parentEntity = dao.findByCode(entity.getCodeEntiteAdminParent());
            if (parentEntity != null) {
                // Recurse to the parent entity to create folders
                createFoldersRecursively(parentEntity, bucketName);
            }

            String folderPath = constructFolderPath(entity);

            boolean folderExists = minIOService.checkFolderExistsInBucket(folderPath, bucketName);

            if (!folderExists) {
                minIOService.createFolderInBucket(folderPath, bucketName);
            }
        }
    }

    private String constructFolderPath(EntiteAdministrative entity) {
        StringBuilder pathBuilder = new StringBuilder(entity.getReferenceGed());
        EntiteAdministrative parentEntity = dao.findByCode(entity.getCodeEntiteAdminParent());

        while (parentEntity != null) {
            pathBuilder.insert(0, parentEntity.getReferenceGed() + "/");
            parentEntity = dao.findByCode(parentEntity.getCodeEntiteAdminParent());
        }
        return pathBuilder.toString();
    }

    public void configure() {
        super.configure(EntiteAdministrative.class, EntiteAdministrativeHistory.class, EntiteAdministrativeHistoryCriteria.class, EntiteAdministrativeSpecification.class);
    }

    @Autowired
    private EntiteAdministrativeTypeAdminService entiteAdministrativeTypeService;
    @Autowired
    private UtilisateurAdminService utilisateurService;

    @Autowired
    private MinIOServiceImpl minIOService;

    public EntiteAdministrativeAdminServiceImpl(EntiteAdministrativeDao dao, EntiteAdministrativeHistoryDao historyDao) {
        super(dao, historyDao);
    }

}