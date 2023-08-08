import {Button} from 'primereact/button';
import {Column} from 'primereact/column';
import {Dropdown} from 'primereact/dropdown';
import {TabView, TabPanel} from 'primereact/tabview';
import {Dialog} from 'primereact/dialog';
import {InputNumber, InputNumberChangeEvent} from 'primereact/inputnumber';
import {InputText} from 'primereact/inputtext';
import {classNames} from 'primereact/utils';
import { InputTextarea } from 'primereact/inputtextarea';
import {AxiosResponse} from 'axios';
import React, {useEffect, useState} from 'react';
import {Calendar, CalendarChangeEvent} from 'primereact/calendar';
import { format } from 'date-fns';
import {InputNumberChangeEvent} from 'primereact/inputnumber';
import { InputSwitch } from 'primereact/inputswitch';
import {MultiSelect} from 'primereact/multiselect';

import {MessageService} from 'app/zynerator/service/MessageService';

import {DocumentCategorieFieldAdminService} from 'app/controller/service/admin/DocumentCategorieFieldAdminService.service';
import  {DocumentCategorieFieldDto}  from 'app/controller/model/DocumentCategorieField.model';

import {DocumentCategorieDto} from 'app/controller/model/DocumentCategorie.model';
import {DocumentCategorieAdminService} from 'app/controller/service/admin/DocumentCategorieAdminService.service';
import {DocumentCategorieFieldRuleDto} from 'app/controller/model/DocumentCategorieFieldRule.model';
import {DocumentCategorieFieldRuleAdminService} from 'app/controller/service/admin/DocumentCategorieFieldRuleAdminService.service';
import {FieldDto} from 'app/controller/model/Field.model';
import {FieldAdminService} from 'app/controller/service/admin/FieldAdminService.service';
const Edit = ({visible, onClose, showToast, selectedItem, update, t}) => {

    const emptyItem = new DocumentCategorieFieldDto();
    const [submitted, setSubmitted] = useState(false);
    const [activeIndex, setActiveIndex] = useState<number>(0);
    const [activeTab, setActiveTab] = useState(0);
    const [item, setItem] = useState<DocumentCategorieFieldDto>( emptyItem);
    const [fields, setFields] = useState<FieldDto[]>([]);
    const [documentCategorieFieldRules, setDocumentCategorieFieldRules] = useState<DocumentCategorieFieldRuleDto[]>([]);
    const [documentCategories, setDocumentCategories] = useState<DocumentCategorieDto[]>([]);

    type DocumentCategorieResponse = AxiosResponse<DocumentCategorieDto[]>;
    type DocumentCategorieFieldRuleResponse = AxiosResponse<DocumentCategorieFieldRuleDto[]>;
    type FieldResponse = AxiosResponse<FieldDto[]>;


    useEffect(() => {
        const fetchData = async () => {
            try {
                const [fieldsResponse ,documentCategorieFieldRulesResponse ,documentCategoriesResponse ] = await Promise.all<FieldResponse,DocumentCategorieFieldRuleResponse,DocumentCategorieResponse>([
                    FieldAdminService.getList(),
                    DocumentCategorieFieldRuleAdminService.getList(),
                    DocumentCategorieAdminService.getList(),
                ]);
                setFields(fieldsResponse.data);
                setDocumentCategorieFieldRules(documentCategorieFieldRulesResponse.data);
                setDocumentCategories(documentCategoriesResponse.data);
            } catch (error) {
                console.error(error);
            }
        };
    fetchData();
    setItem(selectedItem ? { ...selectedItem } : { ...emptyItem });
    }, [selectedItem]);



    const onDropdownChange = (e, field) => {
        setItem((prevState) => ({ ...prevState, [field]: e.value, }));
    };


    const onTabChange = (e: { index: number }) => {
        setActiveIndex(e.index);
    };

    const hideDialog = () => {
        setSubmitted(false);
        onClose();
    };

    const isFormValid = () => {
        let errorMessages = new Array<string>();
        return errorMessages.length == 0 ;
    }
    const editItem = async () => {
        setSubmitted(true);
        if (isFormValid()) {
            const response = await DocumentCategorieFieldAdminService.update(item);
            update(response.data);
            MessageService.showSuccess(showToast, 'DocumentCategorieField Updated');
            onClose();
            setItem(emptyItem);
            setSubmitted(false);
    }
};

    const onInputTextChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, name: string) => {
        const value = (e.target && e.target.value) || '';
        setItem({ ...item, [name]: value });
        };
    const onInputDateChange = (e: CalendarChangeEvent, name: string) => {
        const val = e.value || ''; // Utilisez e.value au lieu de e.target.value
        let _item = { ...item};
        _item[`${name}`] = val;
        setItem(_item);
    };

    const onInputNumerChange = (e: InputNumberChangeEvent, name: string) => {
        const val = e.value === null ? null : +e.value;
        setItem((prevItem) => ({ ...prevItem, [name]: val, }));
    };

    const onMultiSelectChange = (e, field) => {
        if (e && e.value && Array.isArray(e.value)) {
            const selectedValues = e.value.map(option => option && option.value);
            setItem(prevState => ({ ...prevState, [field]: selectedValues, }));
        }
    };

    const onBooleanInputChange = (e: any, name: string) => {
        const val = e.value;
        setItem((prevItem) => ({ ...prevItem, [name]: val, }));
    };

    const itemDialogFooter = ( <>
        <Button label="Cancel" icon="pi pi-times" text onClick={hideDialog} />
        <Button label="Save" icon="pi pi-check" text onClick={editItem} /> </>
    );

return(
    <Dialog visible={visible} style={{width: '70vw'}} header={t("documentCategorieFieldTabPan")} modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog}>
        <TabView activeIndex={activeIndex} onTabChange={onTabChange}>
            <TabPanel header={t("documentCategorieFieldTabPan")}>
                <div className="formgrid grid">
                    <div className="field col-6">
                        <label htmlFor="field">{t("documentCategorieFieldField")}</label>
                        <Dropdown  id="fieldDropdown"  value={item ? item.field : ''} options={fields} onChange={(e) => onDropdownChange(e, 'field')}   placeholder="Sélectionnez un field" filter filterPlaceholder="Rechercher un field" optionLabel="libelle" />
                    </div>
                    <div className="field col-6">
                        <label htmlFor="documentCategorie">{t("documentCategorieFieldDocumentCategorie")}</label>
                        <Dropdown  id="documentCategorieDropdown"  value={item ? item.documentCategorie : ''} options={documentCategories} onChange={(e) => onDropdownChange(e, 'documentCategorie')}   placeholder="Sélectionnez un documentCategorie" filter filterPlaceholder="Rechercher un documentCategorie" optionLabel="libelle" />
                    </div>
                    <div className="field col-6">
                        <label htmlFor="documentCategorieFieldRule">{t("documentCategorieFieldDocumentCategorieFieldRule")}</label>
                        <Dropdown  id="documentCategorieFieldRuleDropdown"  value={item ? item.documentCategorieFieldRule : ''} options={documentCategorieFieldRules} onChange={(e) => onDropdownChange(e, 'documentCategorieFieldRule')}   placeholder="Sélectionnez un documentCategorieFieldRule" filter filterPlaceholder="Rechercher un documentCategorieFieldRule" optionLabel="libelle" />
                    </div>
                </div>
            </TabPanel>
        </TabView>
    </Dialog>
);
};
export default Edit;


