package  ma.sir.chocho.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.chocho.zynerator.util.StringUtil;
import ma.sir.chocho.zynerator.converter.AbstractConverter;
import ma.sir.chocho.zynerator.util.DateUtil;
import ma.sir.chocho.bean.history.ProductHistory;
import ma.sir.chocho.bean.core.Product;
import ma.sir.chocho.ws.dto.ProductDto;

@Component
public class ProductConverter extends AbstractConverter<Product, ProductDto, ProductHistory> {


    public  ProductConverter(){
        super(Product.class, ProductDto.class, ProductHistory.class);
    }

    @Override
    public Product toItem(ProductDto dto) {
        if (dto == null) {
            return null;
        } else {
        Product item = new Product();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getPurchaseCost()))
                item.setPurchaseCost(dto.getPurchaseCost());


        return item;
        }
    }

    @Override
    public ProductDto toDto(Product item) {
        if (item == null) {
            return null;
        } else {
            ProductDto dto = new ProductDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(StringUtil.isNotEmpty(item.getPurchaseCost()))
                dto.setPurchaseCost(item.getPurchaseCost());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
