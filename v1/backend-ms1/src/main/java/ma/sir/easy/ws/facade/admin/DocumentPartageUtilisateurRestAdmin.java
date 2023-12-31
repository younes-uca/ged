package  ma.sir.easy.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easy.bean.core.DocumentPartageUtilisateur;
import ma.sir.easy.bean.history.DocumentPartageUtilisateurHistory;
import ma.sir.easy.dao.criteria.core.DocumentPartageUtilisateurCriteria;
import ma.sir.easy.dao.criteria.history.DocumentPartageUtilisateurHistoryCriteria;
import ma.sir.easy.service.facade.admin.DocumentPartageUtilisateurAdminService;
import ma.sir.easy.ws.converter.DocumentPartageUtilisateurConverter;
import ma.sir.easy.ws.dto.DocumentPartageUtilisateurDto;
import ma.sir.easy.zynerator.controller.AbstractController;
import ma.sir.easy.zynerator.dto.AuditEntityDto;
import ma.sir.easy.zynerator.util.PaginatedList;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.sir.easy.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.sir.easy.zynerator.dto.FileTempDto;

@Api("Manages documentPartageUtilisateur services")
@RestController
@RequestMapping("/api/admin/documentPartageUtilisateur/")
public class DocumentPartageUtilisateurRestAdmin  extends AbstractController<DocumentPartageUtilisateur, DocumentPartageUtilisateurDto, DocumentPartageUtilisateurHistory, DocumentPartageUtilisateurCriteria, DocumentPartageUtilisateurHistoryCriteria, DocumentPartageUtilisateurAdminService, DocumentPartageUtilisateurConverter> {



    @ApiOperation("upload one documentPartageUtilisateur")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple documentPartageUtilisateurs")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all documentPartageUtilisateurs")
    @GetMapping("")
    public ResponseEntity<List<DocumentPartageUtilisateurDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a documentPartageUtilisateur by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DocumentPartageUtilisateurDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  documentPartageUtilisateur")
    @PostMapping("")
    public ResponseEntity<DocumentPartageUtilisateurDto> save(@RequestBody DocumentPartageUtilisateurDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  documentPartageUtilisateur")
    @PutMapping("")
    public ResponseEntity<DocumentPartageUtilisateurDto> update(@RequestBody DocumentPartageUtilisateurDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of documentPartageUtilisateur")
    @PostMapping("multiple")
    public ResponseEntity<List<DocumentPartageUtilisateurDto>> delete(@RequestBody List<DocumentPartageUtilisateurDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified documentPartageUtilisateur")
    @DeleteMapping("")
    public ResponseEntity<DocumentPartageUtilisateurDto> delete(@RequestBody DocumentPartageUtilisateurDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified documentPartageUtilisateur")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple documentPartageUtilisateurs by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by document id")
    @GetMapping("document/id/{id}")
    public List<DocumentPartageUtilisateur> findByDocumentId(@PathVariable Long id){
        return service.findByDocumentId(id);
    }
    @ApiOperation("delete by document id")
    @DeleteMapping("document/id/{id}")
    public int deleteByDocumentId(@PathVariable Long id){
        return service.deleteByDocumentId(id);
    }
    @ApiOperation("find by utilisateur id")
    @GetMapping("utilisateur/id/{id}")
    public List<DocumentPartageUtilisateur> findByUtilisateurId(@PathVariable Long id){
        return service.findByUtilisateurId(id);
    }
    @ApiOperation("delete by utilisateur id")
    @DeleteMapping("utilisateur/id/{id}")
    public int deleteByUtilisateurId(@PathVariable Long id){
        return service.deleteByUtilisateurId(id);
    }
    @ApiOperation("find by acessShare id")
    @GetMapping("acessShare/id/{id}")
    public List<DocumentPartageUtilisateur> findByAcessShareId(@PathVariable Long id){
        return service.findByAcessShareId(id);
    }
    @ApiOperation("delete by acessShare id")
    @DeleteMapping("acessShare/id/{id}")
    public int deleteByAcessShareId(@PathVariable Long id){
        return service.deleteByAcessShareId(id);
    }
    @ApiOperation("Finds documentPartageUtilisateurs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DocumentPartageUtilisateurDto>> findByCriteria(@RequestBody DocumentPartageUtilisateurCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated documentPartageUtilisateurs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DocumentPartageUtilisateurCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports documentPartageUtilisateurs by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody DocumentPartageUtilisateurCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets documentPartageUtilisateur data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DocumentPartageUtilisateurCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets documentPartageUtilisateur history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets documentPartageUtilisateur paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody DocumentPartageUtilisateurHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports documentPartageUtilisateur history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody DocumentPartageUtilisateurHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets documentPartageUtilisateur history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody DocumentPartageUtilisateurHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public DocumentPartageUtilisateurRestAdmin (DocumentPartageUtilisateurAdminService service, DocumentPartageUtilisateurConverter converter) {
        super(service, converter);
    }


}