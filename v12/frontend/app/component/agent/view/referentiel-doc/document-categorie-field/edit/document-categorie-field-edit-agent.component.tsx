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

import {DocumentCategorieFieldAgentService} from 'app/controller/service/agent/DocumentCategorieFieldAgentService.service';
import  {DocumentCategorieFieldDto}  from 'app/controller/model/DocumentCategorieField.model';
import {TFunction} from "i18next";
import {Toast} from "primereact/toast";

import {FieldDto} from 'app/controller/model/Field.model';
import {FieldAgentService} from 'app/controller/service/agent/FieldAgentService.service';
import {DocumentCategorieDto} from 'app/controller/model/DocumentCategorie.model';
import {DocumentCategorieAgentService} from 'app/controller/service/agent/DocumentCategorieAgentService.service';
import {DocumentCategorieFieldRuleDto} from 'app/controller/model/DocumentCategorieFieldRule.model';
import {DocumentCategorieFieldRuleAgentService} from 'app/controller/service/agent/DocumentCategorieFieldRuleAgentService.service';
import {DocumentCategorieFieldCriteria} from "app/controller/criteria/DocumentCategorieFieldCriteria.model";
import useEditHook from "app/component/zyhook/useEdit.hook";


type DocumentCategorieFieldEditAgentType = {
    visible: boolean,
    onClose: () => void,
    showToast: React.Ref<Toast>,
    selectedItem: DocumentCategorieFieldDto
    update: (item: DocumentCategorieFieldDto) => void,
    list: DocumentCategorieFieldDto[],
    service: DocumentCategorieFieldAgentService,
    t: TFunction
}
const Edit: React.FC<DocumentCategorieFieldEditAgentType> = ({visible, onClose, showToast, selectedItem, update, list, service, t}) => {

    const emptyItem = new DocumentCategorieFieldDto();

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
        } = useEditHook<DocumentCategorieFieldDto, DocumentCategorieFieldCriteria>({list, emptyItem, onClose, update, showToast,service})


    const [fields, setFields] = useState<FieldDto[]>([]);
    const [documentCategorieFieldRules, setDocumentCategorieFieldRules] = useState<DocumentCategorieFieldRuleDto[]>([]);
    const [documentCategories, setDocumentCategories] = useState<DocumentCategorieDto[]>([]);


    const fieldAgentService = new FieldAgentService();
    const documentCategorieAgentService = new DocumentCategorieAgentService();
    const documentCategorieFieldRuleAgentService = new DocumentCategorieFieldRuleAgentService();

    useEffect(() => {
    fieldAgentService.getList().then(({data}) => setFields(data)).catch(error => console.log(error));
    documentCategorieAgentService.getList().then(({data}) => setDocumentCategories(data)).catch(error => console.log(error));
    documentCategorieFieldRuleAgentService.getList().then(({data}) => setDocumentCategorieFieldRules(data)).catch(error => console.log(error));

        }, []);








    const isFormValid = () => {
        let errorMessages = new Array<string>();
        return errorMessages.length == 0 ;
    }


    const itemDialogFooter = ( <>
        <Button label="Cancel" icon="pi pi-times" text onClick={hideDialog} />
        <Button label="Save" icon="pi pi-check" text onClick={editItem} /> </>
    );



    return(
    <Dialog visible={visible} style={{width: '70vw'}} header={t("documentCategorieField.tabPan")} modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog}>
        <TabView activeIndex={activeIndex} onTabChange={onTabChange}>
            <TabPanel header={t("documentCategorieField.tabPan")}>
                <div className="formgrid grid">
                    <div className="field col-6">
                        <label htmlFor="field">{t("documentCategorieField.field")}</label>
                        <Dropdown  id="fieldDropdown"  value={item ? item.field : ''} options={fields} onChange={(e) => onDropdownChange(e, 'field')}   placeholder="Sélectionnez un field" filter filterPlaceholder="Rechercher un field" optionLabel="libelle" />
                    </div>
                    <div className="field col-6">
                        <label htmlFor="documentCategorie">{t("documentCategorieField.documentCategorie")}</label>
                        <Dropdown  id="documentCategorieDropdown"  value={item ? item.documentCategorie : ''} options={documentCategories} onChange={(e) => onDropdownChange(e, 'documentCategorie')}   placeholder="Sélectionnez un documentCategorie" filter filterPlaceholder="Rechercher un documentCategorie" optionLabel="libelle" />
                    </div>
                    <div className="field col-6">
                        <label htmlFor="documentCategorieFieldRule">{t("documentCategorieField.documentCategorieFieldRule")}</label>
                        <Dropdown  id="documentCategorieFieldRuleDropdown"  value={item ? item.documentCategorieFieldRule : ''} options={documentCategorieFieldRules} onChange={(e) => onDropdownChange(e, 'documentCategorieFieldRule')}   placeholder="Sélectionnez un documentCategorieFieldRule" filter filterPlaceholder="Rechercher un documentCategorieFieldRule" optionLabel="libelle" />
                    </div>
                </div>
            </TabPanel>
        </TabView>
    </Dialog>
);
};
export default Edit;


