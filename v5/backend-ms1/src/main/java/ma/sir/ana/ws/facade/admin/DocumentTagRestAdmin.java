package  ma.sir.ana.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ana.bean.core.DocumentTag;
import ma.sir.ana.bean.history.DocumentTagHistory;
import ma.sir.ana.dao.criteria.core.DocumentTagCriteria;
import ma.sir.ana.dao.criteria.history.DocumentTagHistoryCriteria;
import ma.sir.ana.service.facade.admin.DocumentTagAdminService;
import ma.sir.ana.ws.converter.DocumentTagConverter;
import ma.sir.ana.ws.dto.DocumentTagDto;
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

@Api("Manages documentTag services")
@RestController
@RequestMapping("/api/admin/documentTag/")
public class DocumentTagRestAdmin  extends AbstractController<DocumentTag, DocumentTagDto, DocumentTagHistory, DocumentTagCriteria, DocumentTagHistoryCriteria, DocumentTagAdminService, DocumentTagConverter> {



    @ApiOperation("upload one documentTag")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple documentTags")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all documentTags")
    @GetMapping("")
    public ResponseEntity<List<DocumentTagDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a documentTag by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DocumentTagDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  documentTag")
    @PostMapping("")
    public ResponseEntity<DocumentTagDto> save(@RequestBody DocumentTagDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  documentTag")
    @PutMapping("")
    public ResponseEntity<DocumentTagDto> update(@RequestBody DocumentTagDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of documentTag")
    @PostMapping("multiple")
    public ResponseEntity<List<DocumentTagDto>> delete(@RequestBody List<DocumentTagDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified documentTag")
    @DeleteMapping("")
    public ResponseEntity<DocumentTagDto> delete(@RequestBody DocumentTagDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified documentTag")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple documentTags by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by document id")
    @GetMapping("document/id/{id}")
    public List<DocumentTag> findByDocumentId(@PathVariable Long id){
        return service.findByDocumentId(id);
    }
    @ApiOperation("delete by document id")
    @DeleteMapping("document/id/{id}")
    public int deleteByDocumentId(@PathVariable Long id){
        return service.deleteByDocumentId(id);
    }
    @ApiOperation("find by tag id")
    @GetMapping("tag/id/{id}")
    public List<DocumentTag> findByTagId(@PathVariable Long id){
        return service.findByTagId(id);
    }
    @ApiOperation("delete by tag id")
    @DeleteMapping("tag/id/{id}")
    public int deleteByTagId(@PathVariable Long id){
        return service.deleteByTagId(id);
    }
    @ApiOperation("Finds documentTags by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DocumentTagDto>> findByCriteria(@RequestBody DocumentTagCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated documentTags by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DocumentTagCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports documentTags by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody DocumentTagCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets documentTag data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DocumentTagCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets documentTag history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets documentTag paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody DocumentTagHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports documentTag history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody DocumentTagHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets documentTag history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody DocumentTagHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public DocumentTagRestAdmin (DocumentTagAdminService service, DocumentTagConverter converter) {
        super(service, converter);
    }


}