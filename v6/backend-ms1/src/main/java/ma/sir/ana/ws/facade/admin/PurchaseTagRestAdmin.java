package  ma.sir.ana.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.ana.bean.core.PurchaseTag;
import ma.sir.ana.bean.history.PurchaseTagHistory;
import ma.sir.ana.dao.criteria.core.PurchaseTagCriteria;
import ma.sir.ana.dao.criteria.history.PurchaseTagHistoryCriteria;
import ma.sir.ana.service.facade.admin.PurchaseTagAdminService;
import ma.sir.ana.ws.converter.PurchaseTagConverter;
import ma.sir.ana.ws.dto.PurchaseTagDto;
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

@Api("Manages purchaseTag services")
@RestController
@RequestMapping("/api/admin/purchaseTag/")
public class PurchaseTagRestAdmin  extends AbstractController<PurchaseTag, PurchaseTagDto, PurchaseTagHistory, PurchaseTagCriteria, PurchaseTagHistoryCriteria, PurchaseTagAdminService, PurchaseTagConverter> {



    @ApiOperation("upload one purchaseTag")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple purchaseTags")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all purchaseTags")
    @GetMapping("")
    public ResponseEntity<List<PurchaseTagDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a purchaseTag by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PurchaseTagDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  purchaseTag")
    @PostMapping("")
    public ResponseEntity<PurchaseTagDto> save(@RequestBody PurchaseTagDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  purchaseTag")
    @PutMapping("")
    public ResponseEntity<PurchaseTagDto> update(@RequestBody PurchaseTagDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of purchaseTag")
    @PostMapping("multiple")
    public ResponseEntity<List<PurchaseTagDto>> delete(@RequestBody List<PurchaseTagDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified purchaseTag")
    @DeleteMapping("")
    public ResponseEntity<PurchaseTagDto> delete(@RequestBody PurchaseTagDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified purchaseTag")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple purchaseTags by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by purchase id")
    @GetMapping("purchase/id/{id}")
    public List<PurchaseTag> findByPurchaseId(@PathVariable Long id){
        return service.findByPurchaseId(id);
    }
    @ApiOperation("delete by purchase id")
    @DeleteMapping("purchase/id/{id}")
    public int deleteByPurchaseId(@PathVariable Long id){
        return service.deleteByPurchaseId(id);
    }
    @ApiOperation("find by tag id")
    @GetMapping("tag/id/{id}")
    public List<PurchaseTag> findByTagId(@PathVariable Long id){
        return service.findByTagId(id);
    }
    @ApiOperation("delete by tag id")
    @DeleteMapping("tag/id/{id}")
    public int deleteByTagId(@PathVariable Long id){
        return service.deleteByTagId(id);
    }
    @ApiOperation("Finds purchaseTags by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PurchaseTagDto>> findByCriteria(@RequestBody PurchaseTagCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated purchaseTags by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PurchaseTagCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports purchaseTags by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PurchaseTagCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets purchaseTag data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PurchaseTagCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets purchaseTag history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets purchaseTag paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody PurchaseTagHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports purchaseTag history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody PurchaseTagHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets purchaseTag history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody PurchaseTagHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public PurchaseTagRestAdmin (PurchaseTagAdminService service, PurchaseTagConverter converter) {
        super(service, converter);
    }


}