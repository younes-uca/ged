import {Button} from 'primereact/button';
import {Column} from 'primereact/column';
import {TabView, TabPanel} from 'primereact/tabview';
import {DataTable} from 'primereact/datatable';
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
import {MessageService} from 'app/zynerator/service/MessageService';

import {DocumentCategorieAgentService} from 'app/controller/service/agent/DocumentCategorieAgentService.service';
import  {DocumentCategorieDto}  from 'app/controller/model/DocumentCategorie.model';

import {DocumentCategorieFieldDto} from 'app/controller/model/DocumentCategorieField.model';
import {DocumentCategorieFieldAgentService} from 'app/controller/service/agent/DocumentCategorieFieldAgentService.service';
import {FieldDto} from 'app/controller/model/Field.model';
import {FieldAgentService} from 'app/controller/service/agent/FieldAgentService.service';
import {DocumentCategorieFieldRuleDto} from 'app/controller/model/DocumentCategorieFieldRule.model';
import {DocumentCategorieFieldRuleAgentService} from 'app/controller/service/agent/DocumentCategorieFieldRuleAgentService.service';
import {TFunction} from "i18next";
import {Toast} from "primereact/toast";

type DocumentCategorieCreateAgentType = {
    visible: boolean,
    onClose: () => void,
    add: (item: DocumentCategorieDto) => void,
    showToast: React.Ref<Toast>,
    list: DocumentCategorieDto[],
    t: TFunction
}
const Create: React.FC<DocumentCategorieCreateAgentType> = ({visible, onClose, add, showToast, list, t}) => {

    const emptyItem = new DocumentCategorieDto();
    const [items, setItems] = useState<DocumentCategorieDto[]>(list);
    const [item, setItem] = useState<DocumentCategorieDto>(emptyItem);
    const [submitted, setSubmitted] = useState(false);
    const [activeIndex, setActiveIndex] = useState<number>(0);
    const [activeTab, setActiveTab] = useState(0);


    const [fields, setFields] = useState<FieldDto[]>([]);
    const [documentCategorieFieldRules, setDocumentCategorieFieldRules] = useState<DocumentCategorieFieldRuleDto[]>([]);

    const [documentCategorieFields, setDocumentCategorieFields] = useState<DocumentCategorieFieldDto>(new DocumentCategorieFieldDto());

    useEffect(() => {



        FieldAgentService.getList().then(({data}) => setFields(data)).catch(error => console.log(error));
        DocumentCategorieFieldRuleAgentService.getList().then(({data}) => setDocumentCategorieFieldRules(data)).catch(error => console.log(error));


    }, []);




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
            MessageService.showSuccess(showToast,'DocumentCategorieFields Updated');
            setItem((prevState :any) => ({ ...prevState, documentCategorieFields: updatedItems}));
        }
        setDocumentCategorieFields(new DocumentCategorieFieldDto());
    };

    const deleteDocumentCategorieFields = (rowData: any) => {
        const updatedItems = item.documentCategorieFields.filter((val) => val !== rowData);
        setItem((prevState ) => ({...prevState,documentCategorieFields: updatedItems }));
        setDocumentCategorieFields(new DocumentCategorieFieldDto());
        MessageService.showSuccess(showToast, 'DocumentCategorieItem Deleted');
    };

    const editDocumentCategorieFields = (rowData: any) => {
         setActiveTab(0);
         setDocumentCategorieFields(rowData);

    };

    const onInputNumerChangeDocumentCategorieFields = (e: any, name: string) => {
         const val = e.value || 0;
         setDocumentCategorieFields((prevDocumentCategorieFields) => ({...prevDocumentCategorieFields, [name]: val, }));
    };
    const onDropdownChangeDocumentCategorieFields = (e: any, field: string) => {
        setDocumentCategorieFields((prevState) => ({ ...prevState, [field]: e.value}));
    };

    const onBooleanInputChangeDocumentCategorieFields = (e: InputSwitchChangeEvent, name: string) => {
       const val = e.value;
       setDocumentCategorieFields((prevItem) => ({ ...prevItem, [name]: val, }));
    };

    const onInputDateChangeDocumentCategorieFields = (e: CalendarChangeEvent, name: string) => {
        const val = e.value || '';
        setDocumentCategorieFields({ ...documentCategorieFields, [name]:val})
    };

    const onInputTextChangeDocumentCategorieFields = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, name: string) => {
        const val = (e.target && e.target.value) || '';
        setDocumentCategorieFields({ ...documentCategorieFields, [name]:val})
    };

    const onInputTextChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, name: string) => {
        const value = (e.target && e.target.value) || '';
        setItem({...item, [name]: value});
    };

    const onInputDateChange = (e: CalendarChangeEvent, name: string) => {
        const value = (e.value) || '';
        setItem({...item, [name]: value});
    };

    const onInputNumerChange = (e: InputNumberChangeEvent, name: string) => {
        const val = e.value === null ? null : +e.value;
        setItem((prevItem) => ({...prevItem, [name]: val,}));
    };

    const onMultiSelectChange = (e: MultiSelectChangeEvent, field: string) => {
        if (e && e.value) {
            setItem(prevState => ({...prevState, [field]: e.value,}));
        }
    };

    const onBooleanInputChange = (e: any, name: string) => {
        const val = e.value;
        setItem((prevItem) => ({...prevItem, [name]: val,}));
        };

    const onDropdownChange = (e: DropdownChangeEvent, field: string) => {
        setItem((prevState) => ({...prevState, [field]: e.value}));
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
    const saveItem = () => {
        setSubmitted(true);
        if (isFormValid()) {
            DocumentCategorieAgentService.save(item).then(({data}) =>{
                add(data);
                MessageService.showSuccess(showToast, 'Document categorie Created');
                onClose();
                setSubmitted(false);
                });
        }
    };

    const itemDialogFooter = ( <>
        <Button label={t("cancel")} icon="pi pi-times" text onClick={hideDialog} />
        <Button label={t("save")} icon="pi pi-check" text onClick={saveItem} /> </>
    );

return(
        <Dialog visible={visible} style={{width: '70vw'}} header={t("documentCategorieTabPan")} modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog} >
        <TabView activeIndex={activeIndex} onTabChange={onTabChange}>
            <TabPanel header={t("documentCategorieTabPan")}>
                <div className="formgrid grid">
                    <div className="field col-6">
                        <label htmlFor="code">{t("documentCategorieCode")}</label>
                        <InputText id="code" value={item.code} onChange={(e) => onInputTextChange(e, 'code')} required autoFocus className={classNames({'p-invalid': submitted && !item.code})} />
                        {submitted && !item.code && <small className="p-invalid">Code is required.</small>}
                    </div>
                    <div className="field col-6">
                        <label htmlFor="libelle">{t("documentCategorieLibelle")}</label>
                        <InputText id="libelle" value={item.libelle} onChange={(e) => onInputTextChange(e, 'libelle')} required autoFocus className={classNames({'p-invalid': submitted && !item.libelle})} />
                        {submitted && !item.libelle && <small className="p-invalid">Libelle is required.</small>}
                    </div>
                </div>
            </TabPanel>
            <TabPanel header={t("documentCategorieDocumentCategorieFields")}>
                        <div className="grid">
                            <div className="field col-5">
                                <label htmlFor="field">{t("documentCategorieFieldField")}</label>
                                <Dropdown id="fieldDropdown" value={documentCategorieFields.field} options={fields} onChange={(e) => onDropdownChangeDocumentCategorieFields(e, 'field')}    placeholder={t("documentCategorieFieldFieldPlaceHolder")} filter filterPlaceholder={t("documentCategorieFieldFieldPlaceHolderFilter")}  optionLabel="libelle" />
                             </div>
                            <div className="field col-5">
                                <label htmlFor="documentCategorieFieldRule">{t("documentCategorieFieldDocumentCategorieFieldRule")}</label>
                                <Dropdown id="documentCategorieFieldRuleDropdown" value={documentCategorieFields.documentCategorieFieldRule} options={documentCategorieFieldRules} onChange={(e) => onDropdownChangeDocumentCategorieFields(e, 'documentCategorieFieldRule')}    placeholder={t("documentCategorieFieldDocumentCategorieFieldRulePlaceHolder")} filter filterPlaceholder={t("documentCategorieFieldDocumentCategorieFieldRulePlaceHolderFilter")}  optionLabel="libelle" />
                             </div>
                            <div className="field col-1">
                                <Button icon="pi pi-plus" label="OK" className="mt-4" onClick={addDocumentCategorieFields} />
                            </div>
                        </div>
                    <div className="p-col">
                    <div className="card">
                    <DataTable value={item.documentCategorieFields} tableStyle={{minWidth: '50rem'}} dataKey="id">
                        <Column field="field.libelle" header={t("documentCategorieFieldField")}></Column>
                        <Column field="documentCategorieFieldRule.libelle" header={t("documentCategorieFieldDocumentCategorieFieldRule")}></Column>
                        <Column header={t("actions")} body={(rowData)=> (<div>
                        <Button icon="pi pi-times" rounded severity="warning" className="mr-2 p-button-danger" onClick={()=> deleteDocumentCategorieFields(rowData)} />
                        <Button icon="pi pi-pencil" rounded severity="success" className="mr-2" onClick={()=> editDocumentCategorieFields(rowData)} /> </div>)}></Column>
                    </DataTable>
                    </div>
                    </div>
            </TabPanel>
        </TabView>
    </Dialog>
);
};
export default Create;
