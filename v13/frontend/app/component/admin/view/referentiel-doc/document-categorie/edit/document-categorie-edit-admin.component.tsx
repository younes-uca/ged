import {Button} from 'primereact/button';
import {Column} from 'primereact/column';
import {Dropdown, DropdownChangeEvent} from 'primereact/dropdown';
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
import { parse } from 'date-fns';
import { InputSwitch } from 'primereact/inputswitch';
import {MultiSelect, MultiSelectChangeEvent} from 'primereact/multiselect';

import {MessageService} from 'app/zynerator/service/MessageService';

import {DocumentCategorieAdminService} from 'app/controller/service/admin/DocumentCategorieAdminService.service';
import  {DocumentCategorieDto}  from 'app/controller/model/DocumentCategorie.model';
import {TFunction} from "i18next";
import {Toast} from "primereact/toast";

import {DocumentCategorieIndexDto} from 'app/controller/model/DocumentCategorieIndex.model';
import {DocumentCategorieIndexAdminService} from 'app/controller/service/admin/DocumentCategorieIndexAdminService.service';
import {IndexElementDto} from 'app/controller/model/IndexElement.model';
import {IndexElementAdminService} from 'app/controller/service/admin/IndexElementAdminService.service';
import {DocumentCategorieModelDto} from 'app/controller/model/DocumentCategorieModel.model';
import {DocumentCategorieModelAdminService} from 'app/controller/service/admin/DocumentCategorieModelAdminService.service';
import {DocumentCategorieIndexRuleDto} from 'app/controller/model/DocumentCategorieIndexRule.model';
import {DocumentCategorieIndexRuleAdminService} from 'app/controller/service/admin/DocumentCategorieIndexRuleAdminService.service';
import {DocumentCategorieCriteria} from "app/controller/criteria/DocumentCategorieCriteria.model";
import useEditHook from "app/component/zyhook/useEdit.hook";


type DocumentCategorieEditAdminType = {
    visible: boolean,
    onClose: () => void,
    showToast: React.Ref<Toast>,
    selectedItem: DocumentCategorieDto
    update: (item: DocumentCategorieDto) => void,
    list: DocumentCategorieDto[],
    service: DocumentCategorieAdminService,
    t: TFunction
}
const Edit: React.FC<DocumentCategorieEditAdminType> = ({visible, onClose, showToast, selectedItem, update, list, service, t}) => {


    const isFormValid = () => {
    let errorMessages = new Array<string>();
                if(item.code == '')
                errorMessages.push("code is required")
                if(item.libelle == '')
                errorMessages.push("libelle is required")
        return errorMessages.length == 0 ;
    }
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
        onDropdownChange,
        onTabChange,
        hideDialog,
        editItem,
        formateDate,
        parseToIsoFormat,
        adaptDate
        } = useEditHook<DocumentCategorieDto, DocumentCategorieCriteria>({list, selectedItem, onClose, update, showToast,service, t, isFormValid})


    const [indexElements, setIndexElements] = useState<IndexElementDto[]>([]);
    const [documentCategorieIndexRules, setDocumentCategorieIndexRules] = useState<DocumentCategorieIndexRuleDto[]>([]);

    const [documentCategorieIndexs, setDocumentCategorieIndexs] = useState<DocumentCategorieIndexDto>(new DocumentCategorieIndexDto());
    const [documentCategorieModels, setDocumentCategorieModels] = useState<DocumentCategorieModelDto>(new DocumentCategorieModelDto());

    const documentCategorieIndexAdminService = new DocumentCategorieIndexAdminService();
    const indexElementAdminService = new IndexElementAdminService();
    const documentCategorieModelAdminService = new DocumentCategorieModelAdminService();
    const documentCategorieIndexRuleAdminService = new DocumentCategorieIndexRuleAdminService();

    useEffect(() => {


    indexElementAdminService.getList().then(({data}) => setIndexElements(data)).catch(error => console.log(error));
    documentCategorieIndexRuleAdminService.getList().then(({data}) => setDocumentCategorieIndexRules(data)).catch(error => console.log(error));

        }, []);






    const addDocumentCategorieIndexs = () => {
        setSubmitted(true);
        if( item.documentCategorieIndexs == null )
        item.documentCategorieIndexs = new Array<DocumentCategorieIndexDto>();
        let _item = documentCategorieIndexs;
        if (!_item.id) {
            item.documentCategorieIndexs.push(_item);
            MessageService.showSuccess(showToast, 'DocumentCategorieIndexs Created');
            setItem((prevState :any) => ({...prevState, documentCategorieIndexs: item.documentCategorieIndexs }));
        } else {
            const updatedItems = item.documentCategorieIndexs.map((item) => item.id === documentCategorieIndexs.id ? {...documentCategorieIndexs} : item);
            MessageService.showSuccess(showToast, 'DocumentCategorieIndexs Updated');
            setItem((prevState :any) => ({ ...prevState, documentCategorieIndexs: updatedItems}));
        }
        setDocumentCategorieIndexs(new DocumentCategorieIndexDto());
    };

    const deleteDocumentCategorieIndexs = (rowData: any) => {
        const updatedItems = item.documentCategorieIndexs.filter((val) => val !== rowData);
        setItem((prevState ) => ({...prevState, documentCategorieIndexs: updatedItems }));
        setDocumentCategorieIndexs(new DocumentCategorieIndexDto());
        MessageService.showSuccess(showToast, 'DocumentCategorieItem Deleted');
    };

    const editDocumentCategorieIndexs = (rowData: any) => {
        setActiveTab(0);
        setDocumentCategorieIndexs(rowData);
    };

    const onInputNumerChangeDocumentCategorieIndexs = (e: any, name: string) => {
        const val = e.value || 0;
        setDocumentCategorieIndexs((prevDocumentCategorieIndexs) => ({ ...prevDocumentCategorieIndexs, [name]: val, }));
    };

    const onDropdownChangeDocumentCategorieIndexs = (e: any, field: string) => {
        setDocumentCategorieIndexs((prevState) => ({ ...prevState, [field]: e.value}));
    };


    const onMultiSelectChangeDocumentCategorieIndexs = (e: any, field: string) => {
        if (e && e.value && Array.isArray(e.value)) {
            const selectedValues = e.value.map(option => option && option.value);
            setDocumentCategorieIndexs(prevState => ({ ...prevState, [field]: selectedValues, }));
        }
    };

    const onBooleanInputChangeDocumentCategorieIndexs = (e: any, name: string) => {
        const val = e.value;
        setDocumentCategorieIndexs((prevItem) => ({ ...prevItem, [name]: val, }));
    };

    const onInputDateChangeDocumentCategorieIndexs = (e: CalendarChangeEvent, name: string) => {
        const val = e.value || '';
        setDocumentCategorieIndexs({ ...documentCategorieIndexs, [name]:val})
    };

    const onInputTextChangeDocumentCategorieIndexs = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, name: string) => {
        const val = (e.target && e.target.value) || '';
        setDocumentCategorieIndexs({ ...documentCategorieIndexs, [name]:val})
    };
    const addDocumentCategorieModels = () => {
        setSubmitted(true);
        if( item.documentCategorieModels == null )
        item.documentCategorieModels = new Array<DocumentCategorieModelDto>();
        let _item = documentCategorieModels;
        if (!_item.id) {
            item.documentCategorieModels.push(_item);
            MessageService.showSuccess(showToast, 'DocumentCategorieModels Created');
            setItem((prevState :any) => ({...prevState, documentCategorieModels: item.documentCategorieModels }));
        } else {
            const updatedItems = item.documentCategorieModels.map((item) => item.id === documentCategorieModels.id ? {...documentCategorieModels} : item);
            MessageService.showSuccess(showToast, 'DocumentCategorieModels Updated');
            setItem((prevState :any) => ({ ...prevState, documentCategorieModels: updatedItems}));
        }
        setDocumentCategorieModels(new DocumentCategorieModelDto());
    };

    const deleteDocumentCategorieModels = (rowData: any) => {
        const updatedItems = item.documentCategorieModels.filter((val) => val !== rowData);
        setItem((prevState ) => ({...prevState, documentCategorieModels: updatedItems }));
        setDocumentCategorieModels(new DocumentCategorieModelDto());
        MessageService.showSuccess(showToast, 'DocumentCategorieItem Deleted');
    };

    const editDocumentCategorieModels = (rowData: any) => {
        setActiveTab(0);
        setDocumentCategorieModels(rowData);
    };

    const onInputNumerChangeDocumentCategorieModels = (e: any, name: string) => {
        const val = e.value || 0;
        setDocumentCategorieModels((prevDocumentCategorieModels) => ({ ...prevDocumentCategorieModels, [name]: val, }));
    };

    const onDropdownChangeDocumentCategorieModels = (e: any, field: string) => {
        setDocumentCategorieModels((prevState) => ({ ...prevState, [field]: e.value}));
    };


    const onMultiSelectChangeDocumentCategorieModels = (e: any, field: string) => {
        if (e && e.value && Array.isArray(e.value)) {
            const selectedValues = e.value.map(option => option && option.value);
            setDocumentCategorieModels(prevState => ({ ...prevState, [field]: selectedValues, }));
        }
    };

    const onBooleanInputChangeDocumentCategorieModels = (e: any, name: string) => {
        const val = e.value;
        setDocumentCategorieModels((prevItem) => ({ ...prevItem, [name]: val, }));
    };

    const onInputDateChangeDocumentCategorieModels = (e: CalendarChangeEvent, name: string) => {
        const val = e.value || '';
        setDocumentCategorieModels({ ...documentCategorieModels, [name]:val})
    };

    const onInputTextChangeDocumentCategorieModels = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, name: string) => {
        const val = (e.target && e.target.value) || '';
        setDocumentCategorieModels({ ...documentCategorieModels, [name]:val})
    };

    const itemDialogFooter = ( <>
        <Button label="Cancel" icon="pi pi-times" text onClick={hideDialog} />
        <Button label="Save" icon="pi pi-check" onClick={editItem} /> </>
    );



    return(
    <Dialog visible={visible} style={{width: '70vw'}} header={t("documentCategorie.tabPan")} modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog}>
        <TabView activeIndex={activeIndex} onTabChange={onTabChange}>
            <TabPanel header={t("documentCategorie.tabPan")}>
                <div className="formgrid grid">
                    <div className="field col-6">
                        <label htmlFor="code">{t("documentCategorie.code")}</label>
                        <InputText id="code" value={item ? item.code : ''} onChange={(e) => onInputTextChange(e, 'code')} required autoFocus className={classNames({'p-invalid': submitted && !item.code})} />
                        {submitted && !item.code && <small className="p-invalid">Code is required.</small>}
                    </div>
                    <div className="field col-6">
                        <label htmlFor="libelle">{t("documentCategorie.libelle")}</label>
                        <InputText id="libelle" value={item ? item.libelle : ''} onChange={(e) => onInputTextChange(e, 'libelle')} required autoFocus className={classNames({'p-invalid': submitted && !item.libelle})} />
                        {submitted && !item.libelle && <small className="p-invalid">Libelle is required.</small>}
                    </div>
                </div>
            </TabPanel>
            <TabPanel header={t("documentCategorie.documentCategorieIndexs")}>
                        <div className="grid">
                            <div className="field col-6">
                                <label htmlFor="indexElement">{t("documentCategorieIndex.indexElement")}</label>
                                <Dropdown id="indexElementDropdown" value={documentCategorieIndexs.indexElement} options={indexElements} onChange={(e) => onDropdownChangeDocumentCategorieIndexs(e, 'indexElement')} placeholder="Sélectionnez un indexElement" filter  filterPlaceholder="Rechercher un indexElement"  optionLabel="libelle" />
                            </div>
                            <div className="field col-6">
                                <label htmlFor="documentCategorieIndexRule">{t("documentCategorieIndex.documentCategorieIndexRule")}</label>
                                <Dropdown id="documentCategorieIndexRuleDropdown" value={documentCategorieIndexs.documentCategorieIndexRule} options={documentCategorieIndexRules} onChange={(e) => onDropdownChangeDocumentCategorieIndexs(e, 'documentCategorieIndexRule')} placeholder="Sélectionnez un documentCategorieIndexRule" filter  filterPlaceholder="Rechercher un documentCategorieIndexRule"  optionLabel="libelle" />
                            </div>
                            <div className="field col-1">
                                <Button icon="pi pi-plus" label="OK" className="mt-4" onClick={addDocumentCategorieIndexs} />
                            </div>
                        </div>
                        <div className="p-col">
                        <div className="card">
                            <DataTable value={item.documentCategorieIndexs} tableStyle={{minWidth: '50rem'}} dataKey="id">
                                <Column field="indexElement.libelle" header={t("documentCategorieIndex.indexElement")}></Column>
                                <Column field="documentCategorieIndexRule.libelle" header={t("documentCategorieIndex.documentCategorieIndexRule")}></Column>
                                <Column header="Actions" body={(rowData) => (
                                    <div>
                                        <Button icon="pi pi-times" rounded severity="warning" className="mr-2 p-button-danger" onClick={()=> deleteDocumentCategorieIndexs(rowData)} />
                                        <Button icon="pi pi-pencil" rounded severity="success" className="mr-2" onClick={()=> editDocumentCategorieIndexs(rowData)} />
                                    </div>
                                )}></Column>
                            </DataTable>
                        </div>
                        </div>
            </TabPanel>
            <TabPanel header={t("documentCategorie.documentCategorieModels")}>
                        <div className="grid">
                            <div className="field col-6">
                                <label htmlFor="code">{t("documentCategorieModel.code")}</label>
                                <InputText id="code" value={documentCategorieModels.code} onChange={(e) => onInputTextChangeDocumentCategorieModels(e, 'code')} required autoFocus className={classNames({'p-invalid': submitted && !item.documentCategorieModels})}/>
                            </div>
                            <div className="field col-6">
                                <label htmlFor="libelle">{t("documentCategorieModel.libelle")}</label>
                                <InputText id="libelle" value={documentCategorieModels.libelle} onChange={(e) => onInputTextChangeDocumentCategorieModels(e, 'libelle')} required autoFocus className={classNames({'p-invalid': submitted && !item.documentCategorieModels})}/>
                            </div>
                            <div className="field col-1">
                                <Button icon="pi pi-plus" label="OK" className="mt-4" onClick={addDocumentCategorieModels} />
                            </div>
                        </div>
                        <div className="p-col">
                        <div className="card">
                            <DataTable value={item.documentCategorieModels} tableStyle={{minWidth: '50rem'}} dataKey="id">
                                <Column field="code" header={t("documentCategorieModel.code")} ></Column>
                                <Column field="libelle" header={t("documentCategorieModel.libelle")} ></Column>
                                <Column header="Actions" body={(rowData) => (
                                    <div>
                                        <Button icon="pi pi-times" rounded severity="warning" className="mr-2 p-button-danger" onClick={()=> deleteDocumentCategorieModels(rowData)} />
                                        <Button icon="pi pi-pencil" rounded severity="success" className="mr-2" onClick={()=> editDocumentCategorieModels(rowData)} />
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


