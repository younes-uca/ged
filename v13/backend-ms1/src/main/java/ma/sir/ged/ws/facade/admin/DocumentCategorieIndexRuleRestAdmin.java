package  ma.sir.ged.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ged.bean.core.DocumentCategorieIndexRule;
import ma.sir.ged.bean.history.DocumentCategorieIndexRuleHistory;
import ma.sir.ged.dao.criteria.core.DocumentCategorieIndexRuleCriteria;
import ma.sir.ged.dao.criteria.history.DocumentCategorieIndexRuleHistoryCriteria;
import ma.sir.ged.service.facade.admin.DocumentCategorieIndexRuleAdminService;
import ma.sir.ged.ws.converter.DocumentCategorieIndexRuleConverter;
import ma.sir.ged.ws.dto.DocumentCategorieIndexRuleDto;
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

@Api("Manages documentCategorieIndexRule services")
@RestController
@RequestMapping("/api/admin/documentCategorieIndexRule/")
public class DocumentCategorieIndexRuleRestAdmin  extends AbstractController<DocumentCategorieIndexRule, DocumentCategorieIndexRuleDto, DocumentCategorieIndexRuleHistory, DocumentCategorieIndexRuleCriteria, DocumentCategorieIndexRuleHistoryCriteria, DocumentCategorieIndexRuleAdminService, DocumentCategorieIndexRuleConverter> {



    @ApiOperation("upload one documentCategorieIndexRule")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple documentCategorieIndexRules")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all documentCategorieIndexRules")
    @GetMapping("")
    public ResponseEntity<List<DocumentCategorieIndexRuleDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all documentCategorieIndexRules")
    @GetMapping("optimized")
    public ResponseEntity<List<DocumentCategorieIndexRuleDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a documentCategorieIndexRule by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DocumentCategorieIndexRuleDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  documentCategorieIndexRule")
    @PostMapping("")
    public ResponseEntity<DocumentCategorieIndexRuleDto> save(@RequestBody DocumentCategorieIndexRuleDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  documentCategorieIndexRule")
    @PutMapping("")
    public ResponseEntity<DocumentCategorieIndexRuleDto> update(@RequestBody DocumentCategorieIndexRuleDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of documentCategorieIndexRule")
    @PostMapping("multiple")
    public ResponseEntity<List<DocumentCategorieIndexRuleDto>> delete(@RequestBody List<DocumentCategorieIndexRuleDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified documentCategorieIndexRule")
    @DeleteMapping("")
    public ResponseEntity<DocumentCategorieIndexRuleDto> delete(@RequestBody DocumentCategorieIndexRuleDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified documentCategorieIndexRule")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple documentCategorieIndexRules by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds documentCategorieIndexRules by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DocumentCategorieIndexRuleDto>> findByCriteria(@RequestBody DocumentCategorieIndexRuleCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated documentCategorieIndexRules by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DocumentCategorieIndexRuleCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports documentCategorieIndexRules by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody DocumentCategorieIndexRuleCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets documentCategorieIndexRule data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DocumentCategorieIndexRuleCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets documentCategorieIndexRule history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets documentCategorieIndexRule paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody DocumentCategorieIndexRuleHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports documentCategorieIndexRule history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody DocumentCategorieIndexRuleHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets documentCategorieIndexRule history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody DocumentCategorieIndexRuleHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public DocumentCategorieIndexRuleRestAdmin (DocumentCategorieIndexRuleAdminService service, DocumentCategorieIndexRuleConverter converter) {
        super(service, converter);
    }


}