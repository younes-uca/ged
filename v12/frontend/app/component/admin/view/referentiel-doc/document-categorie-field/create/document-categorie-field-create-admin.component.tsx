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

import {DocumentCategorieFieldAdminService} from 'app/controller/service/admin/DocumentCategorieFieldAdminService.service';
import  {DocumentCategorieFieldDto}  from 'app/controller/model/DocumentCategorieField.model';
import {DocumentCategorieFieldCriteria} from "app/controller/criteria/DocumentCategorieFieldCriteria.model";

import {FieldDto} from 'app/controller/model/Field.model';
import {FieldAdminService} from 'app/controller/service/admin/FieldAdminService.service';
import {DocumentCategorieDto} from 'app/controller/model/DocumentCategorie.model';
import {DocumentCategorieAdminService} from 'app/controller/service/admin/DocumentCategorieAdminService.service';
import {DocumentCategorieFieldRuleDto} from 'app/controller/model/DocumentCategorieFieldRule.model';
import {DocumentCategorieFieldRuleAdminService} from 'app/controller/service/admin/DocumentCategorieFieldRuleAdminService.service';
import {TFunction} from "i18next";
import {Toast} from "primereact/toast";
import useCreateHook from "app/component/zyhook/useCreate.hook";



type DocumentCategorieFieldCreateAdminType = {
    visible: boolean,
    onClose: () => void,
    add: (item: DocumentCategorieFieldDto) => void,
    showToast: React.Ref<Toast>,
    list: DocumentCategorieFieldDto[],
    service: DocumentCategorieFieldAdminService,
    t: TFunction
}
const Create: React.FC<DocumentCategorieFieldCreateAdminType> = ({visible, onClose, add, showToast, list, service, t}) => {

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
            onTabChange,
            onDropdownChange,
            hideDialog,
            saveItem,
            formateDate
        } = useCreateHook<DocumentCategorieFieldDto, DocumentCategorieFieldCriteria>({list, emptyItem, onClose, add, showToast,service})

    const [fields, setFields] = useState<FieldDto[]>([]);
    const [documentCategorieFieldRules, setDocumentCategorieFieldRules] = useState<DocumentCategorieFieldRuleDto[]>([]);
    const [documentCategories, setDocumentCategories] = useState<DocumentCategorieDto[]>([]);


    const fieldAdminService = new FieldAdminService();
    const documentCategorieAdminService = new DocumentCategorieAdminService();
    const documentCategorieFieldRuleAdminService = new DocumentCategorieFieldRuleAdminService();

    useEffect(() => {
        fieldAdminService.getList().then(({data}) => setFields(data)).catch(error => console.log(error));
        documentCategorieAdminService.getList().then(({data}) => setDocumentCategories(data)).catch(error => console.log(error));
        documentCategorieFieldRuleAdminService.getList().then(({data}) => setDocumentCategorieFieldRules(data)).catch(error => console.log(error));
    }, []);







    const isFormValid = () => {
        let errorMessages = new Array<string>();
        return errorMessages.length == 0 ;
    }

    const itemDialogFooter = ( <>
        <Button label={t("cancel")} icon="pi pi-times" text onClick={hideDialog} />
        <Button label={t("save")} icon="pi pi-check" text onClick={saveItem} /> </>
    );

return(
        <Dialog visible={visible} style={{width: '70vw'}} header={t("documentCategorieField.tabPan")} modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog} >
        <TabView activeIndex={activeIndex} onTabChange={onTabChange}>
            <TabPanel header={t("documentCategorieField.tabPan")}>
                <div className="formgrid grid">
                    <div className="field col-5">
                        <label htmlFor="field">{t("documentCategorieField.field")}</label>
                        <Dropdown  id="fieldDropdown"  value={item.field} options={fields} onChange={(e) => onDropdownChange(e, 'field')}   placeholder={t("documentCategorieField.fieldPlaceHolder")} filter filterPlaceholder={t("documentCategorieField.fieldPlaceHolderFilter")} optionLabel="libelle" />
                    </div>
                    <div className="field col-5">
                        <label htmlFor="documentCategorie">{t("documentCategorieField.documentCategorie")}</label>
                        <Dropdown  id="documentCategorieDropdown"  value={item.documentCategorie} options={documentCategories} onChange={(e) => onDropdownChange(e, 'documentCategorie')}   placeholder={t("documentCategorieField.documentCategoriePlaceHolder")} filter filterPlaceholder={t("documentCategorieField.documentCategoriePlaceHolderFilter")} optionLabel="libelle" />
                    </div>
                    <div className="field col-5">
                        <label htmlFor="documentCategorieFieldRule">{t("documentCategorieField.documentCategorieFieldRule")}</label>
                        <Dropdown  id="documentCategorieFieldRuleDropdown"  value={item.documentCategorieFieldRule} options={documentCategorieFieldRules} onChange={(e) => onDropdownChange(e, 'documentCategorieFieldRule')}   placeholder={t("documentCategorieField.documentCategorieFieldRulePlaceHolder")} filter filterPlaceholder={t("documentCategorieField.documentCategorieFieldRulePlaceHolderFilter")} optionLabel="libelle" />
                    </div>
                </div>
            </TabPanel>
        </TabView>
    </Dialog>
);
};
export default Create;
