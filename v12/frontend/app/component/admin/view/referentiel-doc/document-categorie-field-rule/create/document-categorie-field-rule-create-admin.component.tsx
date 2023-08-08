import {Button} from 'primereact/button';
import {Column} from 'primereact/column';
import {TabView, TabPanel} from 'primereact/tabview';
import {Dialog} from 'primereact/dialog';
import {InputNumber, InputNumberChangeEvent} from 'primereact/inputnumber';
import {InputText} from 'primereact/inputtext';
import {classNames} from 'primereact/utils';
import { InputTextarea } from 'primereact/inputtextarea';
import React, {useEffect, useState} from 'react';
import {Calendar, CalendarChangeEvent} from 'primereact/calendar';
import { format } from 'date-fns';
import {InputSwitch, InputSwitchChangeEvent} from 'primereact/inputswitch';
import {Dropdown, DropdownChangeEvent} from 'primereact/dropdown';
import {MultiSelect, MultiSelectChangeEvent} from 'primereact/multiselect';
import {MessageService} from 'app/zynerator/service/MessageService';

import {DocumentCategorieFieldRuleAdminService} from 'app/controller/service/admin/DocumentCategorieFieldRuleAdminService.service';
import  {DocumentCategorieFieldRuleDto}  from 'app/controller/model/DocumentCategorieFieldRule.model';
import {DocumentCategorieFieldRuleCriteria} from "app/controller/criteria/DocumentCategorieFieldRuleCriteria.model";

import {TFunction} from "i18next";
import {Toast} from "primereact/toast";
import useCreateHook from "app/component/zyhook/useCreate.hook";



type DocumentCategorieFieldRuleCreateAdminType = {
    visible: boolean,
    onClose: () => void,
    add: (item: DocumentCategorieFieldRuleDto) => void,
    showToast: React.Ref<Toast>,
    list: DocumentCategorieFieldRuleDto[],
    service: DocumentCategorieFieldRuleAdminService,
    t: TFunction
}
const Create: React.FC<DocumentCategorieFieldRuleCreateAdminType> = ({visible, onClose, add, showToast, list, service, t}) => {

    const emptyItem = new DocumentCategorieFieldRuleDto();
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
            onTabChange,
            onDropdownChange,
            hideDialog,
            saveItem,
            formateDate
        } = useCreateHook<DocumentCategorieFieldRuleDto, DocumentCategorieFieldRuleCriteria>({list, emptyItem, onClose, add, showToast,service})




    useEffect(() => {
    }, []);







    const isFormValid = () => {
        let errorMessages = new Array<string>();
        if(item.code == '')
            errorMessages.push("code is required")
        if(item.libelle == '')
            errorMessages.push("libelle is required")
        if(item.expresion == '')
            errorMessages.push("expresion is required")
        return errorMessages.length == 0 ;
    }

    const itemDialogFooter = ( <>
        <Button label={t("cancel")} icon="pi pi-times" text onClick={hideDialog} />
        <Button label={t("save")} icon="pi pi-check" text onClick={saveItem} /> </>
    );

return(
        <Dialog visible={visible} style={{width: '70vw'}} header={t("documentCategorieFieldRule.tabPan")} modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog} >
        <TabView activeIndex={activeIndex} onTabChange={onTabChange}>
            <TabPanel header={t("documentCategorieFieldRule.tabPan")}>
                <div className="formgrid grid">
                    <div className="field col-6">
                        <label htmlFor="code">{t("documentCategorieFieldRule.code")}</label>
                        <InputText id="code" value={item.code} onChange={(e) => onInputTextChange(e, 'code')} required autoFocus className={classNames({'p-invalid': submitted && !item.code})} />
                        {submitted && !item.code && <small className="p-invalid">Code is required.</small>}
                    </div>
                    <div className="field col-6">
                        <label htmlFor="libelle">{t("documentCategorieFieldRule.libelle")}</label>
                        <InputText id="libelle" value={item.libelle} onChange={(e) => onInputTextChange(e, 'libelle')} required autoFocus className={classNames({'p-invalid': submitted && !item.libelle})} />
                        {submitted && !item.libelle && <small className="p-invalid">Libelle is required.</small>}
                    </div>
                    <div className="field col-6">
                        <label htmlFor="expresion">{t("documentCategorieFieldRule.expresion")}</label>
                        <InputText id="expresion" value={item.expresion} onChange={(e) => onInputTextChange(e, 'expresion')} required autoFocus className={classNames({'p-invalid': submitted && !item.expresion})} />
                        {submitted && !item.expresion && <small className="p-invalid">Expresion is required.</small>}
                    </div>
                </div>
            </TabPanel>
        </TabView>
    </Dialog>
);
};
export default Create;
