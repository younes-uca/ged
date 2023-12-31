import {Button} from 'primereact/button';
import {Column} from 'primereact/column';
import {Dropdown, DropdownChangeEvent} from 'primereact/dropdown';
import {TabView, TabPanel} from 'primereact/tabview';
import {Dialog} from 'primereact/dialog';
import {InputNumber, InputNumberChangeEvent} from 'primereact/inputnumber';
import {InputText} from 'primereact/inputtext';
import {classNames} from 'primereact/utils';
import { InputTextarea } from 'primereact/inputtextarea';
import React, {useEffect, useState} from 'react';
import {Calendar, CalendarChangeEvent} from 'primereact/calendar';
import { format } from 'date-fns';
import { parse } from 'date-fns';
import { InputSwitch } from 'primereact/inputswitch';
import {MultiSelect, MultiSelectChangeEvent} from 'primereact/multiselect';

import {MessageService} from 'app/zynerator/service/MessageService';

import {EntiteAdministrativeTypeAdminService} from 'app/controller/service/admin/EntiteAdministrativeTypeAdminService.service';
import  {EntiteAdministrativeTypeDto}  from 'app/controller/model/EntiteAdministrativeType.model';
import {TFunction} from "i18next";
import {Toast} from "primereact/toast";

import {EntiteAdministrativeTypeCriteria} from "app/controller/criteria/EntiteAdministrativeTypeCriteria.model";
import useEditHook from "app/component/zyhook/useEdit.hook";


type EntiteAdministrativeTypeEditAdminType = {
    visible: boolean,
    onClose: () => void,
    showToast: React.Ref<Toast>,
    selectedItem: EntiteAdministrativeTypeDto
    update: (item: EntiteAdministrativeTypeDto) => void,
    list: EntiteAdministrativeTypeDto[],
    service: EntiteAdministrativeTypeAdminService,
    t: TFunction
}
const Edit: React.FC<EntiteAdministrativeTypeEditAdminType> = ({visible, onClose, showToast, selectedItem, update, list, service, t}) => {

    const emptyItem = new EntiteAdministrativeTypeDto();

    const {
        item,
        setItem,
        submitted,
        setSubmitted,
        activeIndex,
        setActiveIndex,
        activeTab,
        setActiveTab,
        onInputTextChange,
        onInputDateChange,
        onInputNumerChange,
        onMultiSelectChange,
        onBooleanInputChange,
        onDropdownChange,
        onTabChange,
        hideDialog,
        editItem,
        formateDate,
        parseToIsoFormat,
        adaptDate
        } = useEditHook<EntiteAdministrativeTypeDto, EntiteAdministrativeTypeCriteria>({list, emptyItem, onClose, update, showToast,service})





    useEffect(() => {

        }, []);








    const isFormValid = () => {
        let errorMessages = new Array<string>();
        if(item.code == '')
        errorMessages.push("code is required")
        if(item.libelle == '')
        errorMessages.push("libelle is required")
        return errorMessages.length == 0 ;
    }


    const itemDialogFooter = ( <>
        <Button label="Cancel" icon="pi pi-times" text onClick={hideDialog} />
        <Button label="Save" icon="pi pi-check" text onClick={editItem} /> </>
    );



    return(
    <Dialog visible={visible} style={{width: '70vw'}} header={t("entiteAdministrativeType.tabPan")} modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog}>
        <TabView activeIndex={activeIndex} onTabChange={onTabChange}>
            <TabPanel header={t("entiteAdministrativeType.tabPan")}>
                <div className="formgrid grid">
                    <div className="field col-6">
                        <label htmlFor="code">{t("entiteAdministrativeType.code")}</label>
                        <InputText id="code" value={item ? item.code : ''} onChange={(e) => onInputTextChange(e, 'code')} required autoFocus className={classNames({'p-invalid': submitted && !item.code})} />
                        {submitted && !item.code && <small className="p-invalid">Code is required.</small>}
                    </div>
                    <div className="field col-6">
                        <label htmlFor="libelle">{t("entiteAdministrativeType.libelle")}</label>
                        <InputText id="libelle" value={item ? item.libelle : ''} onChange={(e) => onInputTextChange(e, 'libelle')} required autoFocus className={classNames({'p-invalid': submitted && !item.libelle})} />
                        {submitted && !item.libelle && <small className="p-invalid">Libelle is required.</small>}
                    </div>
                </div>
            </TabPanel>
        </TabView>
    </Dialog>
);
};
export default Edit;


