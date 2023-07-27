package  ma.sir.ana.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ana.zynerator.util.StringUtil;
import ma.sir.ana.zynerator.converter.AbstractConverter;
import ma.sir.ana.zynerator.util.DateUtil;
import ma.sir.ana.bean.history.ClientHistory;
import ma.sir.ana.bean.core.Client;
import ma.sir.ana.ws.dto.ClientDto;

@Component
public class ClientConverter extends AbstractConverter<Client, ClientDto, ClientHistory> {

    @Autowired
    private ClientCategoryConverter clientCategoryConverter ;
    private boolean clientCategory;

    public  ClientConverter(){
        super(Client.class, ClientDto.class, ClientHistory.class);
    }

    @Override
    public Client toItem(ClientDto dto) {
        if (dto == null) {
            return null;
        } else {
        Client item = new Client();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getFullName()))
                item.setFullName(dto.getFullName());
            if(StringUtil.isNotEmpty(dto.getEmail()))
                item.setEmail(dto.getEmail());
            if(StringUtil.isNotEmpty(dto.getDateRegistration()))
                item.setDateRegistration(DateUtil.stringEnToDate(dto.getDateRegistration()));
            if(StringUtil.isNotEmpty(dto.getNombreEnfant()))
                item.setNombreEnfant(dto.getNombreEnfant());
            if(this.clientCategory && dto.getClientCategory()!=null &&  dto.getClientCategory().getId() != null)
                item.setClientCategory(clientCategoryConverter.toItem(dto.getClientCategory())) ;



        return item;
        }
    }

    @Override
    public ClientDto toDto(Client item) {
        if (item == null) {
            return null;
        } else {
            ClientDto dto = new ClientDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getFullName()))
                dto.setFullName(item.getFullName());
            if(StringUtil.isNotEmpty(item.getEmail()))
                dto.setEmail(item.getEmail());
            if(item.getDateRegistration()!=null)
                dto.setDateRegistration(DateUtil.dateTimeToString(item.getDateRegistration()));
            if(StringUtil.isNotEmpty(item.getNombreEnfant()))
                dto.setNombreEnfant(item.getNombreEnfant());
        if(this.clientCategory && item.getClientCategory()!=null) {
            dto.setClientCategory(clientCategoryConverter.toDto(item.getClientCategory())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.clientCategory = value;
    }


    public ClientCategoryConverter getClientCategoryConverter(){
        return this.clientCategoryConverter;
    }
    public void setClientCategoryConverter(ClientCategoryConverter clientCategoryConverter ){
        this.clientCategoryConverter = clientCategoryConverter;
    }
    public boolean  isClientCategory(){
        return this.clientCategory;
    }
    public void  setClientCategory(boolean clientCategory){
        this.clientCategory = clientCategory;
    }
}
