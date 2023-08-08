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
import {MultiSelect, MultiSelectChangeEvent} from 'primereact/multiselect';
import {MessageService} from 'app/zynerator/service/MessageService';

import {DocumentCategorieAgentService} from 'app/controller/service/agent/DocumentCategorieAgentService.service';
import  {DocumentCategorieDto}  from 'app/controller/model/DocumentCategorie.model';
import {DocumentCategorieCriteria} from "app/controller/criteria/DocumentCategorieCriteria.model";

import {FieldDto} from 'app/controller/model/Field.model';
import {FieldAgentService} from 'app/controller/service/agent/FieldAgentService.service';
import {DocumentCategorieFieldRuleDto} from 'app/controller/model/DocumentCategorieFieldRule.model';
import {DocumentCategorieFieldRuleAgentService} from 'app/controller/service/agent/DocumentCategorieFieldRuleAgentService.service';
import {DocumentCategorieFieldDto} from 'app/controller/model/DocumentCategorieField.model';
import {DocumentCategorieFieldAgentService} from 'app/controller/service/agent/DocumentCategorieFieldAgentService.service';
import {TFunction} from "i18next";
import {Toast} from "primereact/toast";
import useCreateHook from "app/component/zyhook/useCreate.hook";



type DocumentCategorieCreateAgentType = {
    visible: boolean,
    onClose: () => void,
    add: (item: DocumentCategorieDto) => void,
    showToast: React.Ref<Toast>,
    list: DocumentCategorieDto[],
    service: DocumentCategorieAgentService,
    t: TFunction
}
const Create: React.FC<DocumentCategorieCreateAgentType> = ({visible, onClose, add, showToast, list, service, t}) => {

    const emptyItem = new DocumentCategorieDto();
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
        } = useCreateHook<DocumentCategorieDto, DocumentCategorieCriteria>({list, emptyItem, onClose, add, showToast,service})

    const [fields, setFields] = useState<FieldDto[]>([]);
    const [documentCategorieFieldRules, setDocumentCategorieFieldRules] = useState<DocumentCategorieFieldRuleDto[]>([]);

    const [documentCategorieFields, setDocumentCategorieFields] = useState<DocumentCategorieFieldDto>(new DocumentCategorieFieldDto());

    const fieldAgentService = new FieldAgentService();
    const documentCategorieFieldRuleAgentService = new DocumentCategorieFieldRuleAgentService();
    const documentCategorieFieldAgentService = new DocumentCategorieFieldAgentService();

    useEffect(() => {

        fieldAgentService.getList().then(({data}) => setFields(data)).catch(error => console.log(error));
        documentCategorieFieldRuleAgentService.getList().then(({data}) => setDocumentCategorieFieldRules(data)).catch(error => console.log(error));


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



    const isFormValid = () => {
        let errorMessages = new Array<string>();
        if(item.code == '')
            errorMessages.push("code is required")
        if(item.libelle == '')
            errorMessages.push("libelle is required")
        return errorMessages.length == 0 ;
    }

    const itemDialogFooter = ( <>
        <Button label={t("cancel")} icon="pi pi-times" text onClick={hideDialog} />
        <Button label={t("save")} icon="pi pi-check" text onClick={saveItem} /> </>
    );

return(
        <Dialog visible={visible} style={{width: '70vw'}} header={t("documentCategorie.tabPan")} modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog} >
        <TabView activeIndex={activeIndex} onTabChange={onTabChange}>
            <TabPanel header={t("documentCategorie.tabPan")}>
                <div className="formgrid grid">
                    <div className="field col-6">
                        <label htmlFor="code">{t("documentCategorie.code")}</label>
                        <InputText id="code" value={item.code} onChange={(e) => onInputTextChange(e, 'code')} required autoFocus className={classNames({'p-invalid': submitted && !item.code})} />
                        {submitted && !item.code && <small className="p-invalid">Code is required.</small>}
                    </div>
                    <div className="field col-6">
                        <label htmlFor="libelle">{t("documentCategorie.libelle")}</label>
                        <InputText id="libelle" value={item.libelle} onChange={(e) => onInputTextChange(e, 'libelle')} required autoFocus className={classNames({'p-invalid': submitted && !item.libelle})} />
                        {submitted && !item.libelle && <small className="p-invalid">Libelle is required.</small>}
                    </div>
                </div>
            </TabPanel>
            <TabPanel header={t("documentCategorie.documentCategorieFields")}>
                        <div className="grid">
                            <div className="field col-5">
                                <label htmlFor="field">{t("documentCategorieField.field")}</label>
                                <Dropdown id="fieldDropdown" value={documentCategorieFields.field} options={fields} onChange={(e) => onDropdownChangeDocumentCategorieFields(e, 'field')}    placeholder={t("documentCategorieField.fieldPlaceHolder")} filter filterPlaceholder={t("documentCategorieField.fieldPlaceHolderFilter")}  optionLabel="libelle" />
                             </div>
                            <div className="field col-5">
                                <label htmlFor="documentCategorieFieldRule">{t("documentCategorieField.documentCategorieFieldRule")}</label>
                                <Dropdown id="documentCategorieFieldRuleDropdown" value={documentCategorieFields.documentCategorieFieldRule} options={documentCategorieFieldRules} onChange={(e) => onDropdownChangeDocumentCategorieFields(e, 'documentCategorieFieldRule')}    placeholder={t("documentCategorieField.documentCategorieFieldRulePlaceHolder")} filter filterPlaceholder={t("documentCategorieField.documentCategorieFieldRulePlaceHolderFilter")}  optionLabel="libelle" />
                             </div>
                            <div className="field col-1">
                                <Button icon="pi pi-plus" label="OK" className="mt-4" onClick={addDocumentCategorieFields} />
                            </div>
                        </div>
                    <div className="p-col">
                    <div className="card">
                    <DataTable value={item.documentCategorieFields} tableStyle={{minWidth: '50rem'}} dataKey="id">
                        <Column field="field.libelle" header={t("documentCategorieField.field")}></Column>
                        <Column field="documentCategorieFieldRule.libelle" header={t("documentCategorieField.documentCategorieFieldRule")}></Column>
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
