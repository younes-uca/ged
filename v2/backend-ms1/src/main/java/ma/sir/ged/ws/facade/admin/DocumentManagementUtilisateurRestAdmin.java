package  ma.sir.ged.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ged.bean.core.DocumentManagementUtilisateur;
import ma.sir.ged.bean.history.DocumentManagementUtilisateurHistory;
import ma.sir.ged.dao.criteria.core.DocumentManagementUtilisateurCriteria;
import ma.sir.ged.dao.criteria.history.DocumentManagementUtilisateurHistoryCriteria;
import ma.sir.ged.service.facade.admin.DocumentManagementUtilisateurAdminService;
import ma.sir.ged.ws.converter.DocumentManagementUtilisateurConverter;
import ma.sir.ged.ws.dto.DocumentManagementUtilisateurDto;
import ma.sir.ged.zynerator.controller.AbstractController;
import ma.sir.ged.zynerator.dto.AuditEntityDto;
import ma.sir.ged.zynerator.util.PaginatedList;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.sir.ged.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.sir.ged.zynerator.dto.FileTempDto;

@Api("Manages documentManagementUtilisateur services")
@RestController
@RequestMapping("/api/admin/documentManagementUtilisateur/")
public class DocumentManagementUtilisateurRestAdmin  extends AbstractController<DocumentManagementUtilisateur, DocumentManagementUtilisateurDto, DocumentManagementUtilisateurHistory, DocumentManagementUtilisateurCriteria, DocumentManagementUtilisateurHistoryCriteria, DocumentManagementUtilisateurAdminService, DocumentManagementUtilisateurConverter> {



    @ApiOperation("upload one documentManagementUtilisateur")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple documentManagementUtilisateurs")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all documentManagementUtilisateurs")
    @GetMapping("")
    public ResponseEntity<List<DocumentManagementUtilisateurDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a documentManagementUtilisateur by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DocumentManagementUtilisateurDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  documentManagementUtilisateur")
    @PostMapping("")
    public ResponseEntity<DocumentManagementUtilisateurDto> save(@RequestBody DocumentManagementUtilisateurDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  documentManagementUtilisateur")
    @PutMapping("")
    public ResponseEntity<DocumentManagementUtilisateurDto> update(@RequestBody DocumentManagementUtilisateurDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of documentManagementUtilisateur")
    @PostMapping("multiple")
    public ResponseEntity<List<DocumentManagementUtilisateurDto>> delete(@RequestBody List<DocumentManagementUtilisateurDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified documentManagementUtilisateur")
    @DeleteMapping("")
    public ResponseEntity<DocumentManagementUtilisateurDto> delete(@RequestBody DocumentManagementUtilisateurDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified documentManagementUtilisateur")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple documentManagementUtilisateurs by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by document id")
    @GetMapping("document/id/{id}")
    public List<DocumentManagementUtilisateur> findByDocumentId(@PathVariable Long id){
        return service.findByDocumentId(id);
    }
    @ApiOperation("delete by document id")
    @DeleteMapping("document/id/{id}")
    public int deleteByDocumentId(@PathVariable Long id){
        return service.deleteByDocumentId(id);
    }
    @ApiOperation("find by utilisateur id")
    @GetMapping("utilisateur/id/{id}")
    public List<DocumentManagementUtilisateur> findByUtilisateurId(@PathVariable Long id){
        return service.findByUtilisateurId(id);
    }
    @ApiOperation("delete by utilisateur id")
    @DeleteMapping("utilisateur/id/{id}")
    public int deleteByUtilisateurId(@PathVariable Long id){
        return service.deleteByUtilisateurId(id);
    }
    @ApiOperation("find by acessManagement id")
    @GetMapping("acessManagement/id/{id}")
    public List<DocumentManagementUtilisateur> findByAcessManagementId(@PathVariable Long id){
        return service.findByAcessManagementId(id);
    }
    @ApiOperation("delete by acessManagement id")
    @DeleteMapping("acessManagement/id/{id}")
    public int deleteByAcessManagementId(@PathVariable Long id){
        return service.deleteByAcessManagementId(id);
    }
    @ApiOperation("Finds documentManagementUtilisateurs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DocumentManagementUtilisateurDto>> findByCriteria(@RequestBody DocumentManagementUtilisateurCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated documentManagementUtilisateurs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DocumentManagementUtilisateurCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports documentManagementUtilisateurs by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody DocumentManagementUtilisateurCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets documentManagementUtilisateur data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DocumentManagementUtilisateurCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets documentManagementUtilisateur history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets documentManagementUtilisateur paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody DocumentManagementUtilisateurHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports documentManagementUtilisateur history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody DocumentManagementUtilisateurHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets documentManagementUtilisateur history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody DocumentManagementUtilisateurHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public DocumentManagementUtilisateurRestAdmin (DocumentManagementUtilisateurAdminService service, DocumentManagementUtilisateurConverter converter) {
        super(service, converter);
    }


}