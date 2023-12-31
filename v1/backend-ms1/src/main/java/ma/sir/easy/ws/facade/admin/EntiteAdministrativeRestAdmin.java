package  ma.sir.easy.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easy.bean.core.EntiteAdministrative;
import ma.sir.easy.bean.history.EntiteAdministrativeHistory;
import ma.sir.easy.dao.criteria.core.EntiteAdministrativeCriteria;
import ma.sir.easy.dao.criteria.history.EntiteAdministrativeHistoryCriteria;
import ma.sir.easy.service.facade.admin.EntiteAdministrativeAdminService;
import ma.sir.easy.ws.converter.EntiteAdministrativeConverter;
import ma.sir.easy.ws.dto.EntiteAdministrativeDto;
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

@Api("Manages entiteAdministrative services")
@RestController
@RequestMapping("/api/admin/entiteAdministrative/")
public class EntiteAdministrativeRestAdmin  extends AbstractController<EntiteAdministrative, EntiteAdministrativeDto, EntiteAdministrativeHistory, EntiteAdministrativeCriteria, EntiteAdministrativeHistoryCriteria, EntiteAdministrativeAdminService, EntiteAdministrativeConverter> {



    @ApiOperation("upload one entiteAdministrative")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple entiteAdministratives")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all entiteAdministratives")
    @GetMapping("")
    public ResponseEntity<List<EntiteAdministrativeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all entiteAdministratives")
    @GetMapping("optimized")
    public ResponseEntity<List<EntiteAdministrativeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a entiteAdministrative by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EntiteAdministrativeDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  entiteAdministrative")
    @PostMapping("")
    public ResponseEntity<EntiteAdministrativeDto> save(@RequestBody EntiteAdministrativeDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  entiteAdministrative")
    @PutMapping("")
    public ResponseEntity<EntiteAdministrativeDto> update(@RequestBody EntiteAdministrativeDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of entiteAdministrative")
    @PostMapping("multiple")
    public ResponseEntity<List<EntiteAdministrativeDto>> delete(@RequestBody List<EntiteAdministrativeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified entiteAdministrative")
    @DeleteMapping("")
    public ResponseEntity<EntiteAdministrativeDto> delete(@RequestBody EntiteAdministrativeDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified entiteAdministrative")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple entiteAdministratives by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by utilisateur id")
    @GetMapping("utilisateur/id/{id}")
    public List<EntiteAdministrative> findByUtilisateurId(@PathVariable Long id){
        return service.findByUtilisateurId(id);
    }
    @ApiOperation("delete by utilisateur id")
    @DeleteMapping("utilisateur/id/{id}")
    public int deleteByUtilisateurId(@PathVariable Long id){
        return service.deleteByUtilisateurId(id);
    }
    @ApiOperation("Finds entiteAdministratives by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EntiteAdministrativeDto>> findByCriteria(@RequestBody EntiteAdministrativeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated entiteAdministratives by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EntiteAdministrativeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports entiteAdministratives by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EntiteAdministrativeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets entiteAdministrative data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EntiteAdministrativeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets entiteAdministrative history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets entiteAdministrative paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody EntiteAdministrativeHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports entiteAdministrative history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody EntiteAdministrativeHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets entiteAdministrative history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody EntiteAdministrativeHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public EntiteAdministrativeRestAdmin (EntiteAdministrativeAdminService service, EntiteAdministrativeConverter converter) {
        super(service, converter);
    }


}