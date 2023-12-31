package  ma.sir.ana.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ana.bean.core.DocumentState;
import ma.sir.ana.bean.history.DocumentStateHistory;
import ma.sir.ana.dao.criteria.core.DocumentStateCriteria;
import ma.sir.ana.dao.criteria.history.DocumentStateHistoryCriteria;
import ma.sir.ana.service.facade.admin.DocumentStateAdminService;
import ma.sir.ana.ws.converter.DocumentStateConverter;
import ma.sir.ana.ws.dto.DocumentStateDto;
import ma.sir.ana.zynerator.controller.AbstractController;
import ma.sir.ana.zynerator.dto.AuditEntityDto;
import ma.sir.ana.zynerator.util.PaginatedList;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.sir.ana.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.sir.ana.zynerator.dto.FileTempDto;

@Api("Manages documentState services")
@RestController
@RequestMapping("/api/admin/documentState/")
public class DocumentStateRestAdmin  extends AbstractController<DocumentState, DocumentStateDto, DocumentStateHistory, DocumentStateCriteria, DocumentStateHistoryCriteria, DocumentStateAdminService, DocumentStateConverter> {



    @ApiOperation("upload one documentState")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple documentStates")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all documentStates")
    @GetMapping("")
    public ResponseEntity<List<DocumentStateDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all documentStates")
    @GetMapping("optimized")
    public ResponseEntity<List<DocumentStateDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a documentState by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DocumentStateDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  documentState")
    @PostMapping("")
    public ResponseEntity<DocumentStateDto> save(@RequestBody DocumentStateDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  documentState")
    @PutMapping("")
    public ResponseEntity<DocumentStateDto> update(@RequestBody DocumentStateDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of documentState")
    @PostMapping("multiple")
    public ResponseEntity<List<DocumentStateDto>> delete(@RequestBody List<DocumentStateDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified documentState")
    @DeleteMapping("")
    public ResponseEntity<DocumentStateDto> delete(@RequestBody DocumentStateDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified documentState")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple documentStates by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds documentStates by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DocumentStateDto>> findByCriteria(@RequestBody DocumentStateCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated documentStates by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DocumentStateCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports documentStates by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody DocumentStateCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets documentState data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DocumentStateCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets documentState history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets documentState paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody DocumentStateHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports documentState history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody DocumentStateHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets documentState history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody DocumentStateHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public DocumentStateRestAdmin (DocumentStateAdminService service, DocumentStateConverter converter) {
        super(service, converter);
    }


}