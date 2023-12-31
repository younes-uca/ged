import {Button} from 'primereact/button';
import {Column} from 'primereact/column';
import {Dropdown} from 'primereact/dropdown';
import {TabView, TabPanel} from 'primereact/tabview';
import {DataTable} from 'primereact/datatable';
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

import {DocumentCategorieAdminService} from 'app/controller/service/admin/DocumentCategorieAdminService.service';
import  {DocumentCategorieDto}  from 'app/controller/model/DocumentCategorie.model';

import {DocumentCategorieFieldDto} from 'app/controller/model/DocumentCategorieField.model';
import {DocumentCategorieFieldAdminService} from 'app/controller/service/admin/DocumentCategorieFieldAdminService.service';
import {FieldDto} from 'app/controller/model/Field.model';
import {FieldAdminService} from 'app/controller/service/admin/FieldAdminService.service';
import {DocumentCategorieFieldRuleDto} from 'app/controller/model/DocumentCategorieFieldRule.model';
import {DocumentCategorieFieldRuleAdminService} from 'app/controller/service/admin/DocumentCategorieFieldRuleAdminService.service';
const Edit = ({visible, onClose, showToast, selectedItem, update}) => {

    const emptyItem = new DocumentCategorieDto();
    const [submitted, setSubmitted] = useState(false);
    const [activeIndex, setActiveIndex] = useState<number>(0);
    const [activeTab, setActiveTab] = useState(0);
    const [item, setItem] = useState<DocumentCategorieDto>( emptyItem);
    const [fields, setFields] = useState<FieldDto[]>([]);
    const [documentCategorieFieldRules, setDocumentCategorieFieldRules] = useState<DocumentCategorieFieldRuleDto[]>([]);

    type DocumentCategorieFieldResponse = AxiosResponse<DocumentCategorieFieldDto[]>;
    type FieldResponse = AxiosResponse<FieldDto[]>;
    type DocumentCategorieFieldRuleResponse = AxiosResponse<DocumentCategorieFieldRuleDto[]>;

    const [documentCategorieFields, setDocumentCategorieFields] = useState<DocumentCategorieFieldDto>(new DocumentCategorieFieldDto());

    useEffect(() => {
        const fetchData = async () => {
            try {
                const [fieldsResponse ,documentCategorieFieldRulesResponse ] = await Promise.all<FieldResponse,DocumentCategorieFieldRuleResponse>([
                    FieldAdminService.getList(),
                    DocumentCategorieFieldRuleAdminService.getList(),
                ]);
                setFields(fieldsResponse.data);
                setDocumentCategorieFieldRules(documentCategorieFieldRulesResponse.data);
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

    const addDocumentCategorieFields = () => {
        setSubmitted(true);
        if( item.documentCategorieFields == null )
        item.documentCategorieFields = new Array<DocumentCategorieFieldDto>();
        let _item = documentCategorieFields;
        if (!_item.id) {
            item.documentCategorieFields.push(_item);
            MessageService.showSuccess(showToast, 'DocumentCategorieFields Created');
            setItem((prevState :any) => ({...prevState, documentCategorieFields: item.documentCategorieFields }));
        } else {
            const updatedItems = item.documentCategorieFields.map((item) => item.id === documentCategorieFields.id ? {...documentCategorieFields} : item);
            MessageService.showSuccess(showToast, 'DocumentCategorieFields Updated');
            setItem((prevState :any) => ({ ...prevState, documentCategorieFields: updatedItems}));
        }
        setDocumentCategorieFields(new DocumentCategorieFieldDto());
    };

    const deleteDocumentCategorieFields = (rowData) => {
        const updatedItems = item.documentCategorieFields.filter((val) => val !== rowData);
        setItem((prevState ) => ({...prevState, documentCategorieFields: updatedItems }));
        setDocumentCategorieFields(new DocumentCategorieFieldDto());
        MessageService.showSuccess(showToast, 'DocumentCategorieItem Deleted');
    };

    const editDocumentCategorieFields = (rowData) => {
        setActiveTab(0);
        setDocumentCategorieFields(rowData);
    };

    const onInputNumerChangeDocumentCategorieFields = (e, name) => {
        const val = e.value || 0;
        setDocumentCategorieFields((prevDocumentCategorieFields) => ({ ...prevDocumentCategorieFields, [name]: val, }));
    };

    const onDropdownChangeDocumentCategorieFields = (e, field) => {
        setDocumentCategorieFields((prevState) => ({ ...prevState, [field]: e.value}));
    };


    const onMultiSelectChangeDocumentCategorieFields = (e, field) => {
        if (e && e.value && Array.isArray(e.value)) {
            const selectedValues = e.value.map(option => option && option.value);
            setDocumentCategorieFields(prevState => ({ ...prevState, [field]: selectedValues, }));
        }
    };

    const onBooleanInputChangeDocumentCategorieFields = (e: any, name: string) => {
        const val = e.value;
        setDocumentCategorieFields((prevItem) => ({ ...prevItem, [name]: val, }));
    };

    const onInputDateChangeDocumentCategorieFields = (e: CalendarChangeEvent, name: string) => {
        const val = e.value || ''; // Utilisez e.value au lieu de e.target.value
        let _item = { ...documentCategorieFields};
        _item[`${name}`] = val;
        setDocumentCategorieFields(_item);
    };


    const onInputTextChangeDocumentCategorieFields = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, name: string) => {
        const val = (e.target && e.target.value) || '';
        let _item = {...documentCategorieFields};
        _item[`${name}`] = val;
        setDocumentCategorieFields(_item);
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
        if(item.code == '')
        errorMessages.push("code is required")
        if(item.libelle == '')
        errorMessages.push("libelle is required")
        return errorMessages.length == 0 ;
    }
    const editItem = async () => {
        setSubmitted(true);
        if (isFormValid()) {
            const response = await DocumentCategorieAdminService.update(item);
            update(response.data);
            MessageService.showSuccess(showToast, 'DocumentCategorie Updated');
            onClose();
            setItem(emptyItem);
            setSubmitted(false);
            setItem({...item, DocumentCategorieFields: null, });
            setDocumentCategorieFields(new DocumentCategorieFieldDto());
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
    <Dialog visible={visible} style={{width: '70vw'}} header="DocumentCategorie" modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog}>
        <TabView activeIndex={activeIndex} onTabChange={onTabChange}>
            <TabPanel header="DocumentCategorie">
                <div className="formgrid grid">
                    <div className="field col-6">
                        <label htmlFor="code">Code</label>
                        <InputText id="code" value={item ? item.code : ''} onChange={(e) => onInputTextChange(e, 'code')} required autoFocus className={classNames({'p-invalid': submitted && !item.code})} />
                        {submitted && !item.code && <small className="p-invalid">Code is required.</small>}
                    </div>
                    <div className="field col-6">
                        <label htmlFor="libelle">Libelle</label>
                        <InputText id="libelle" value={item ? item.libelle : ''} onChange={(e) => onInputTextChange(e, 'libelle')} required autoFocus className={classNames({'p-invalid': submitted && !item.libelle})} />
                        {submitted && !item.libelle && <small className="p-invalid">Libelle is required.</small>}
                    </div>
                </div>
            </TabPanel>
            <TabPanel header="Document categorie fields">
                        <div className="grid">
                            <div className="field col-6">
                                <label htmlFor="field">Field</label>
                                <Dropdown id="fieldDropdown" value={documentCategorieFields.field} options={fields} onChange={(e) => onDropdownChangeDocumentCategorieFields(e, 'field')} placeholder="Sélectionnez un field" filter  filterPlaceholder="Rechercher un field"  optionLabel="libelle" />
                            </div>
                            <div className="field col-6">
                                <label htmlFor="documentCategorieFieldRule">Document categorie field rule</label>
                                <Dropdown id="documentCategorieFieldRuleDropdown" value={documentCategorieFields.documentCategorieFieldRule} options={documentCategorieFieldRules} onChange={(e) => onDropdownChangeDocumentCategorieFields(e, 'documentCategorieFieldRule')} placeholder="Sélectionnez un documentCategorieFieldRule" filter  filterPlaceholder="Rechercher un documentCategorieFieldRule"  optionLabel="libelle" />
                            </div>
                            <div className="field col-1">
                                <Button icon="pi pi-plus" label="OK" className="mt-4" onClick={addDocumentCategorieFields} />
                            </div>
                        </div>
                        <div class="p-col">
                        <div className="card">
                            <DataTable value={item.documentCategorieFields} tableStyle={{minWidth: '50rem'}} dataKey="id">
                                <Column field="field.libelle" header="Field"></Column>
                                <Column field="documentCategorieFieldRule.libelle" header="Document categorie field rule"></Column>
                                <Column header="Actions" body={(rowData) => (
                                    <div>
                                        <Button icon="pi pi-times" rounded severity="warning" className="mr-2 p-button-danger" onClick={()=> deleteDocumentCategorieFields(rowData)} />
                                        <Button icon="pi pi-pencil" rounded severity="success" className="mr-2" onClick={()=> editDocumentCategorieFields(rowData)} />
                                    </div>
                                )}></Column>
                            </DataTable>
                        </div>
                        </div>
            </TabPanel>
        </TabView>
    </Dialog>
);
};
export default Edit;


