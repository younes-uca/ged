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

import {UtilisateurAdminService} from 'app/controller/service/admin/UtilisateurAdminService.service';
import  {UtilisateurDto}  from 'app/controller/model/Utilisateur.model';
import {UtilisateurCriteria} from "app/controller/criteria/UtilisateurCriteria.model";

import {TFunction} from "i18next";
import {Toast} from "primereact/toast";
import useCreateHook from "app/component/zyhook/useCreate.hook";



type UtilisateurCreateAdminType = {
    visible: boolean,
    onClose: () => void,
    add: (item: UtilisateurDto) => void,
    showToast: React.Ref<Toast>,
    list: UtilisateurDto[],
    service: UtilisateurAdminService,
    t: TFunction
}
const Create: React.FC<UtilisateurCreateAdminType> = ({visible, onClose, add, showToast, list, service, t}) => {

    const emptyItem = new UtilisateurDto();
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
        } = useCreateHook<UtilisateurDto, UtilisateurCriteria>({list, emptyItem, onClose, add, showToast,service})




    useEffect(() => {
    }, []);







    const isFormValid = () => {
        let errorMessages = new Array<string>();
        if(item.email == '')
            errorMessages.push("email is required")
        if(item.nom == '')
            errorMessages.push("nom is required")
        return errorMessages.length == 0 ;
    }

    const itemDialogFooter = ( <>
        <Button label={t("cancel")} icon="pi pi-times" text onClick={hideDialog} />
        <Button label={t("save")} icon="pi pi-check" text onClick={saveItem} /> </>
    );

return(
        <Dialog visible={visible} style={{width: '70vw'}} header={t("utilisateur.tabPan")} modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog} >
        <TabView activeIndex={activeIndex} onTabChange={onTabChange}>
            <TabPanel header={t("utilisateur.tabPan")}>
                <div className="formgrid grid">
                    <div className="field col-6">
                        <label htmlFor="email">{t("utilisateur.email")}</label>
                        <InputText id="email" value={item.email} onChange={(e) => onInputTextChange(e, 'email')} required autoFocus className={classNames({'p-invalid': submitted && !item.email})} />
                        {submitted && !item.email && <small className="p-invalid">Email is required.</small>}
                    </div>
                    <div className="field col-6">
                        <label htmlFor="nom">{t("utilisateur.nom")}</label>
                        <InputText id="nom" value={item.nom} onChange={(e) => onInputTextChange(e, 'nom')} required autoFocus className={classNames({'p-invalid': submitted && !item.nom})} />
                        {submitted && !item.nom && <small className="p-invalid">Nom is required.</small>}
                    </div>
                    <div className="field col-6">
                        <label htmlFor="prenom">{t("utilisateur.prenom")}</label>
                        <InputText id="prenom" value={item.prenom} onChange={(e) => onInputTextChange(e, 'prenom')} required autoFocus className={classNames({'p-invalid': submitted && !item.prenom})} />
                        {submitted && !item.prenom && <small className="p-invalid">Prenom is required.</small>}
                    </div>
                </div>
            </TabPanel>
        </TabView>
    </Dialog>
);
};
export default Create;
