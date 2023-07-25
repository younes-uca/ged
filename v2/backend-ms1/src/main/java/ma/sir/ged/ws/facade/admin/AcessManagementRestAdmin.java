package  ma.sir.ged.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ged.bean.core.AcessManagement;
import ma.sir.ged.bean.history.AcessManagementHistory;
import ma.sir.ged.dao.criteria.core.AcessManagementCriteria;
import ma.sir.ged.dao.criteria.history.AcessManagementHistoryCriteria;
import ma.sir.ged.service.facade.admin.AcessManagementAdminService;
import ma.sir.ged.ws.converter.AcessManagementConverter;
import ma.sir.ged.ws.dto.AcessManagementDto;
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

@Api("Manages acessManagement services")
@RestController
@RequestMapping("/api/admin/acessManagement/")
public class AcessManagementRestAdmin  extends AbstractController<AcessManagement, AcessManagementDto, AcessManagementHistory, AcessManagementCriteria, AcessManagementHistoryCriteria, AcessManagementAdminService, AcessManagementConverter> {



    @ApiOperation("upload one acessManagement")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple acessManagements")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all acessManagements")
    @GetMapping("")
    public ResponseEntity<List<AcessManagementDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all acessManagements")
    @GetMapping("optimized")
    public ResponseEntity<List<AcessManagementDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a acessManagement by id")
    @GetMapping("id/{id}")
    public ResponseEntity<AcessManagementDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  acessManagement")
    @PostMapping("")
    public ResponseEntity<AcessManagementDto> save(@RequestBody AcessManagementDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  acessManagement")
    @PutMapping("")
    public ResponseEntity<AcessManagementDto> update(@RequestBody AcessManagementDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of acessManagement")
    @PostMapping("multiple")
    public ResponseEntity<List<AcessManagementDto>> delete(@RequestBody List<AcessManagementDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified acessManagement")
    @DeleteMapping("")
    public ResponseEntity<AcessManagementDto> delete(@RequestBody AcessManagementDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified acessManagement")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple acessManagements by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds acessManagements by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<AcessManagementDto>> findByCriteria(@RequestBody AcessManagementCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated acessManagements by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody AcessManagementCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports acessManagements by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody AcessManagementCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets acessManagement data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody AcessManagementCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets acessManagement history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets acessManagement paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody AcessManagementHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports acessManagement history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody AcessManagementHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets acessManagement history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody AcessManagementHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public AcessManagementRestAdmin (AcessManagementAdminService service, AcessManagementConverter converter) {
        super(service, converter);
    }


}