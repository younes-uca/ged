package  ma.sir.ged.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ged.bean.core.AcessShare;
import ma.sir.ged.bean.history.AcessShareHistory;
import ma.sir.ged.dao.criteria.core.AcessShareCriteria;
import ma.sir.ged.dao.criteria.history.AcessShareHistoryCriteria;
import ma.sir.ged.service.facade.admin.AcessShareAdminService;
import ma.sir.ged.ws.converter.AcessShareConverter;
import ma.sir.ged.ws.dto.AcessShareDto;
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

@Api("Manages acessShare services")
@RestController
@RequestMapping("/api/admin/acessShare/")
public class AcessShareRestAdmin  extends AbstractController<AcessShare, AcessShareDto, AcessShareHistory, AcessShareCriteria, AcessShareHistoryCriteria, AcessShareAdminService, AcessShareConverter> {



    @ApiOperation("upload one acessShare")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple acessShares")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all acessShares")
    @GetMapping("")
    public ResponseEntity<List<AcessShareDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all acessShares")
    @GetMapping("optimized")
    public ResponseEntity<List<AcessShareDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a acessShare by id")
    @GetMapping("id/{id}")
    public ResponseEntity<AcessShareDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  acessShare")
    @PostMapping("")
    public ResponseEntity<AcessShareDto> save(@RequestBody AcessShareDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  acessShare")
    @PutMapping("")
    public ResponseEntity<AcessShareDto> update(@RequestBody AcessShareDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of acessShare")
    @PostMapping("multiple")
    public ResponseEntity<List<AcessShareDto>> delete(@RequestBody List<AcessShareDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified acessShare")
    @DeleteMapping("")
    public ResponseEntity<AcessShareDto> delete(@RequestBody AcessShareDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified acessShare")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple acessShares by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds acessShares by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<AcessShareDto>> findByCriteria(@RequestBody AcessShareCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated acessShares by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody AcessShareCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports acessShares by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody AcessShareCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets acessShare data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody AcessShareCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets acessShare history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets acessShare paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody AcessShareHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports acessShare history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody AcessShareHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets acessShare history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody AcessShareHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public AcessShareRestAdmin (AcessShareAdminService service, AcessShareConverter converter) {
        super(service, converter);
    }


}