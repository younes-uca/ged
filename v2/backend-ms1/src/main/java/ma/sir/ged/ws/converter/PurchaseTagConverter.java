package  ma.sir.ged.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.ged.bean.core.Purchase;

import ma.sir.ged.zynerator.util.StringUtil;
import ma.sir.ged.zynerator.converter.AbstractConverter;
import ma.sir.ged.zynerator.util.DateUtil;
import ma.sir.ged.bean.history.PurchaseTagHistory;
import ma.sir.ged.bean.core.PurchaseTag;
import ma.sir.ged.ws.dto.PurchaseTagDto;

@Component
public class PurchaseTagConverter extends AbstractConverter<PurchaseTag, PurchaseTagDto, PurchaseTagHistory> {

    @Autowired
    private TagConverter tagConverter ;
    @Autowired
    private PurchaseConverter purchaseConverter ;
    private boolean purchase;
    private boolean tag;

    public  PurchaseTagConverter(){
        super(PurchaseTag.class, PurchaseTagDto.class, PurchaseTagHistory.class);
    }

    @Override
    public PurchaseTag toItem(PurchaseTagDto dto) {
        if (dto == null) {
            return null;
        } else {
        PurchaseTag item = new PurchaseTag();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(dto.getPurchase() != null && dto.getPurchase().getId() != null){
                item.setPurchase(new Purchase());
                item.getPurchase().setId(dto.getPurchase().getId());
            }

            if(this.tag && dto.getTag()!=null &&  dto.getTag().getId() != null)
                item.setTag(tagConverter.toItem(dto.getTag())) ;



        return item;
        }
    }

    @Override
    public PurchaseTagDto toDto(PurchaseTag item) {
        if (item == null) {
            return null;
        } else {
            PurchaseTagDto dto = new PurchaseTagDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
        if(this.purchase && item.getPurchase()!=null) {
            dto.setPurchase(purchaseConverter.toDto(item.getPurchase())) ;
        }
        if(this.tag && item.getTag()!=null) {
            dto.setTag(tagConverter.toDto(item.getTag())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.purchase = value;
        this.tag = value;
    }


    public TagConverter getTagConverter(){
        return this.tagConverter;
    }
    public void setTagConverter(TagConverter tagConverter ){
        this.tagConverter = tagConverter;
    }
    public PurchaseConverter getPurchaseConverter(){
        return this.purchaseConverter;
    }
    public void setPurchaseConverter(PurchaseConverter purchaseConverter ){
        this.purchaseConverter = purchaseConverter;
    }
    public boolean  isPurchase(){
        return this.purchase;
    }
    public void  setPurchase(boolean purchase){
        this.purchase = purchase;
    }
    public boolean  isTag(){
        return this.tag;
    }
    public void  setTag(boolean tag){
        this.tag = tag;
    }
}
