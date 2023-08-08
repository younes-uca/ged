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
import { FileUpload, FileUploadHandlerEvent } from 'primereact/fileupload';

import {DocumentAdminService} from 'app/controller/service/admin/DocumentAdminService.service';
import  {DocumentDto}  from 'app/controller/model/Document.model';
import {TFunction} from "i18next";
import {Toast} from "primereact/toast";

import {DocumentFieldStateDto} from 'app/controller/model/DocumentFieldState.model';
import {DocumentFieldStateAdminService} from 'app/controller/service/admin/DocumentFieldStateAdminService.service';
import {DocumentStateDto} from 'app/controller/model/DocumentState.model';
import {DocumentStateAdminService} from 'app/controller/service/admin/DocumentStateAdminService.service';
import {DocumentFieldDto} from 'app/controller/model/DocumentField.model';
import {DocumentFieldAdminService} from 'app/controller/service/admin/DocumentFieldAdminService.service';
import {FieldDto} from 'app/controller/model/Field.model';
import {FieldAdminService} from 'app/controller/service/admin/FieldAdminService.service';
import {AccessShareDto} from 'app/controller/model/AccessShare.model';
import {AccessShareAdminService} from 'app/controller/service/admin/AccessShareAdminService.service';
import {TagDto} from 'app/controller/model/Tag.model';
import {TagAdminService} from 'app/controller/service/admin/TagAdminService.service';
import {GroupeDto} from 'app/controller/model/Groupe.model';
import {GroupeAdminService} from 'app/controller/service/admin/GroupeAdminService.service';
import {EntiteAdministrativeDto} from 'app/controller/model/EntiteAdministrative.model';
import {EntiteAdministrativeAdminService} from 'app/controller/service/admin/EntiteAdministrativeAdminService.service';
import {DocumentPartageGroupeDto} from 'app/controller/model/DocumentPartageGroupe.model';
import {DocumentPartageGroupeAdminService} from 'app/controller/service/admin/DocumentPartageGroupeAdminService.service';
import {DocumentTypeDto} from 'app/controller/model/DocumentType.model';
import {DocumentTypeAdminService} from 'app/controller/service/admin/DocumentTypeAdminService.service';
import {DocumentCategorieDto} from 'app/controller/model/DocumentCategorie.model';
import {DocumentCategorieAdminService} from 'app/controller/service/admin/DocumentCategorieAdminService.service';
import {DocumentPartageUtilisateurDto} from 'app/controller/model/DocumentPartageUtilisateur.model';
import {DocumentPartageUtilisateurAdminService} from 'app/controller/service/admin/DocumentPartageUtilisateurAdminService.service';
import {UtilisateurDto} from 'app/controller/model/Utilisateur.model';
import {UtilisateurAdminService} from 'app/controller/service/admin/UtilisateurAdminService.service';
import {DocumentTagDto} from 'app/controller/model/DocumentTag.model';
import {DocumentTagAdminService} from 'app/controller/service/admin/DocumentTagAdminService.service';
import {DocumentCriteria} from "app/controller/criteria/DocumentCriteria.model";
import useEditHook from "app/component/zyhook/useEdit.hook";


type DocumentEditAdminType = {
    visible: boolean,
    onClose: () => void,
    showToast: React.Ref<Toast>,
    selectedItem: DocumentDto
    update: (item: DocumentDto) => void,
    list: DocumentDto[],
    service: DocumentAdminService,
    t: TFunction
}
const Edit: React.FC<DocumentEditAdminType> = ({visible, onClose, showToast, selectedItem, update, list, service, t}) => {

    const emptyItem = new DocumentDto();

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
        } = useEditHook<DocumentDto, DocumentCriteria>({list, emptyItem, onClose, update, showToast,service})


    const [utilisateurs, setUtilisateurs] = useState<UtilisateurDto[]>([]);
    const [entiteAdministratives, setEntiteAdministratives] = useState<EntiteAdministrativeDto[]>([]);
    const [groupes, setGroupes] = useState<GroupeDto[]>([]);
    const [fields, setFields] = useState<FieldDto[]>([]);
    const [documentFieldStates, setDocumentFieldStates] = useState<DocumentFieldStateDto[]>([]);
    const [documentTypes, setDocumentTypes] = useState<DocumentTypeDto[]>([]);
    const [accessShares, setAccessShares] = useState<AccessShareDto[]>([]);
    const [tags, setTags] = useState<TagDto[]>([]);
    const [documentCategories, setDocumentCategories] = useState<DocumentCategorieDto[]>([]);
    const [documentStates, setDocumentStates] = useState<DocumentStateDto[]>([]);

    const [documentFields, setDocumentFields] = useState<DocumentFieldDto>(new DocumentFieldDto());
    const [documentPartageGroupes, setDocumentPartageGroupes] = useState<DocumentPartageGroupeDto>(new DocumentPartageGroupeDto());
    const [documentPartageUtilisateurs, setDocumentPartageUtilisateurs] = useState<DocumentPartageUtilisateurDto>(new DocumentPartageUtilisateurDto());
    const [documentTags, setDocumentTags] = useState<DocumentTagDto>(new DocumentTagDto());

    const documentFieldStateAdminService = new DocumentFieldStateAdminService();
    const documentStateAdminService = new DocumentStateAdminService();
    const documentFieldAdminService = new DocumentFieldAdminService();
    const fieldAdminService = new FieldAdminService();
    const accessShareAdminService = new AccessShareAdminService();
    const tagAdminService = new TagAdminService();
    const groupeAdminService = new GroupeAdminService();
    const entiteAdministrativeAdminService = new EntiteAdministrativeAdminService();
    const documentPartageGroupeAdminService = new DocumentPartageGroupeAdminService();
    const documentTypeAdminService = new DocumentTypeAdminService();
    const documentCategorieAdminService = new DocumentCategorieAdminService();
    const documentPartageUtilisateurAdminService = new DocumentPartageUtilisateurAdminService();
    const utilisateurAdminService = new UtilisateurAdminService();
    const documentTagAdminService = new DocumentTagAdminService();

    useEffect(() => {
    documentTypeAdminService.getList().then(({data}) => setDocumentTypes(data)).catch(error => console.log(error));
    documentStateAdminService.getList().then(({data}) => setDocumentStates(data)).catch(error => console.log(error));
    documentCategorieAdminService.getList().then(({data}) => setDocumentCategories(data)).catch(error => console.log(error));
    utilisateurAdminService.getList().then(({data}) => setUtilisateurs(data)).catch(error => console.log(error));
    entiteAdministrativeAdminService.getList().then(({data}) => setEntiteAdministratives(data)).catch(error => console.log(error));


    fieldAdminService.getList().then(({data}) => setFields(data)).catch(error => console.log(error));
    documentFieldStateAdminService.getList().then(({data}) => setDocumentFieldStates(data)).catch(error => console.log(error));

    groupeAdminService.getList().then(({data}) => setGroupes(data)).catch(error => console.log(error));
    accessShareAdminService.getList().then(({data}) => setAccessShares(data)).catch(error => console.log(error));

    utilisateurAdminService.getList().then(({data}) => setUtilisateurs(data)).catch(error => console.log(error));
    accessShareAdminService.getList().then(({data}) => setAccessShares(data)).catch(error => console.log(error));
    tagAdminService.getList().then(({data}) => {
        const DocumentTags = data?.map(prepareDocumentTag)
        setDocumentTags(documentTags)
    })

        }, []);



    const prepareDocumentTag = (tag: TagDto) => {
        const documentTag = new DocumentTagDto();
        documentTag.tag = tag;
        return documentTag;
    }


    const onUpload = (event:any) => {
    service.uploadAndOcr(event);
    }

    const addDocumentFields = () => {
        setSubmitted(true);
        if( item.documentFields == null )
        item.documentFields = new Array<DocumentFieldDto>();
        let _item = documentFields;
        if (!_item.id) {
            item.documentFields.push(_item);
            MessageService.showSuccess(showToast, 'DocumentFields Created');
            setItem((prevState :any) => ({...prevState, documentFields: item.documentFields }));
        } else {
            const updatedItems = item.documentFields.map((item) => item.id === documentFields.id ? {...documentFields} : item);
            MessageService.showSuccess(showToast, 'DocumentFields Updated');
            setItem((prevState :any) => ({ ...prevState, documentFields: updatedItems}));
        }
        setDocumentFields(new DocumentFieldDto());
    };

    const deleteDocumentFields = (rowData: any) => {
        const updatedItems = item.documentFields.filter((val) => val !== rowData);
        setItem((prevState ) => ({...prevState, documentFields: updatedItems }));
        setDocumentFields(new DocumentFieldDto());
        MessageService.showSuccess(showToast, 'DocumentItem Deleted');
    };

    const editDocumentFields = (rowData: any) => {
        setActiveTab(0);
        setDocumentFields(rowData);
    };

    const onInputNumerChangeDocumentFields = (e: any, name: string) => {
        const val = e.value || 0;
        setDocumentFields((prevDocumentFields) => ({ ...prevDocumentFields, [name]: val, }));
    };

    const onDropdownChangeDocumentFields = (e: any, field: string) => {
        setDocumentFields((prevState) => ({ ...prevState, [field]: e.value}));
    };


    const onMultiSelectChangeDocumentFields = (e: any, field: string) => {
        if (e && e.value && Array.isArray(e.value)) {
            const selectedValues = e.value.map(option => option && option.value);
            setDocumentFields(prevState => ({ ...prevState, [field]: selectedValues, }));
        }
    };

    const onBooleanInputChangeDocumentFields = (e: any, name: string) => {
        const val = e.value;
        setDocumentFields((prevItem) => ({ ...prevItem, [name]: val, }));
    };

    const onInputDateChangeDocumentFields = (e: CalendarChangeEvent, name: string) => {
        const val = e.value || '';
        setDocumentFields({ ...documentFields, [name]:val})
    };

    const onInputTextChangeDocumentFields = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, name: string) => {
        const val = (e.target && e.target.value) || '';
        setDocumentFields({ ...documentFields, [name]:val})
    };
    const addDocumentPartageGroupes = () => {
        setSubmitted(true);
        if( item.documentPartageGroupes == null )
        item.documentPartageGroupes = new Array<DocumentPartageGroupeDto>();
        let _item = documentPartageGroupes;
        if (!_item.id) {
            item.documentPartageGroupes.push(_item);
            MessageService.showSuccess(showToast, 'DocumentPartageGroupes Created');
            setItem((prevState :any) => ({...prevState, documentPartageGroupes: item.documentPartageGroupes }));
        } else {
            const updatedItems = item.documentPartageGroupes.map((item) => item.id === documentPartageGroupes.id ? {...documentPartageGroupes} : item);
            MessageService.showSuccess(showToast, 'DocumentPartageGroupes Updated');
            setItem((prevState :any) => ({ ...prevState, documentPartageGroupes: updatedItems}));
        }
        setDocumentPartageGroupes(new DocumentPartageGroupeDto());
    };

    const deleteDocumentPartageGroupes = (rowData: any) => {
        const updatedItems = item.documentPartageGroupes.filter((val) => val !== rowData);
        setItem((prevState ) => ({...prevState, documentPartageGroupes: updatedItems }));
        setDocumentPartageGroupes(new DocumentPartageGroupeDto());
        MessageService.showSuccess(showToast, 'DocumentItem Deleted');
    };

    const editDocumentPartageGroupes = (rowData: any) => {
        setActiveTab(0);
        setDocumentPartageGroupes(rowData);
    };

    const onInputNumerChangeDocumentPartageGroupes = (e: any, name: string) => {
        const val = e.value || 0;
        setDocumentPartageGroupes((prevDocumentPartageGroupes) => ({ ...prevDocumentPartageGroupes, [name]: val, }));
    };

    const onDropdownChangeDocumentPartageGroupes = (e: any, field: string) => {
        setDocumentPartageGroupes((prevState) => ({ ...prevState, [field]: e.value}));
    };


    const onMultiSelectChangeDocumentPartageGroupes = (e: any, field: string) => {
        if (e && e.value && Array.isArray(e.value)) {
            const selectedValues = e.value.map(option => option && option.value);
            setDocumentPartageGroupes(prevState => ({ ...prevState, [field]: selectedValues, }));
        }
    };

    const onBooleanInputChangeDocumentPartageGroupes = (e: any, name: string) => {
        const val = e.value;
        setDocumentPartageGroupes((prevItem) => ({ ...prevItem, [name]: val, }));
    };

    const onInputDateChangeDocumentPartageGroupes = (e: CalendarChangeEvent, name: string) => {
        const val = e.value || '';
        setDocumentPartageGroupes({ ...documentPartageGroupes, [name]:val})
    };

    const onInputTextChangeDocumentPartageGroupes = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, name: string) => {
        const val = (e.target && e.target.value) || '';
        setDocumentPartageGroupes({ ...documentPartageGroupes, [name]:val})
    };
    const addDocumentPartageUtilisateurs = () => {
        setSubmitted(true);
        if( item.documentPartageUtilisateurs == null )
        item.documentPartageUtilisateurs = new Array<DocumentPartageUtilisateurDto>();
        let _item = documentPartageUtilisateurs;
        if (!_item.id) {
            item.documentPartageUtilisateurs.push(_item);
            MessageService.showSuccess(showToast, 'DocumentPartageUtilisateurs Created');
            setItem((prevState :any) => ({...prevState, documentPartageUtilisateurs: item.documentPartageUtilisateurs }));
        } else {
            const updatedItems = item.documentPartageUtilisateurs.map((item) => item.id === documentPartageUtilisateurs.id ? {...documentPartageUtilisateurs} : item);
            MessageService.showSuccess(showToast, 'DocumentPartageUtilisateurs Updated');
            setItem((prevState :any) => ({ ...prevState, documentPartageUtilisateurs: updatedItems}));
        }
        setDocumentPartageUtilisateurs(new DocumentPartageUtilisateurDto());
    };

    const deleteDocumentPartageUtilisateurs = (rowData: any) => {
        const updatedItems = item.documentPartageUtilisateurs.filter((val) => val !== rowData);
        setItem((prevState ) => ({...prevState, documentPartageUtilisateurs: updatedItems }));
        setDocumentPartageUtilisateurs(new DocumentPartageUtilisateurDto());
        MessageService.showSuccess(showToast, 'DocumentItem Deleted');
    };

    const editDocumentPartageUtilisateurs = (rowData: any) => {
        setActiveTab(0);
        setDocumentPartageUtilisateurs(rowData);
    };

    const onInputNumerChangeDocumentPartageUtilisateurs = (e: any, name: string) => {
        const val = e.value || 0;
        setDocumentPartageUtilisateurs((prevDocumentPartageUtilisateurs) => ({ ...prevDocumentPartageUtilisateurs, [name]: val, }));
    };

    const onDropdownChangeDocumentPartageUtilisateurs = (e: any, field: string) => {
        setDocumentPartageUtilisateurs((prevState) => ({ ...prevState, [field]: e.value}));
    };


    const onMultiSelectChangeDocumentPartageUtilisateurs = (e: any, field: string) => {
        if (e && e.value && Array.isArray(e.value)) {
            const selectedValues = e.value.map(option => option && option.value);
            setDocumentPartageUtilisateurs(prevState => ({ ...prevState, [field]: selectedValues, }));
        }
    };

    const onBooleanInputChangeDocumentPartageUtilisateurs = (e: any, name: string) => {
        const val = e.value;
        setDocumentPartageUtilisateurs((prevItem) => ({ ...prevItem, [name]: val, }));
    };

    const onInputDateChangeDocumentPartageUtilisateurs = (e: CalendarChangeEvent, name: string) => {
        const val = e.value || '';
        setDocumentPartageUtilisateurs({ ...documentPartageUtilisateurs, [name]:val})
    };

    const onInputTextChangeDocumentPartageUtilisateurs = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, name: string) => {
        const val = (e.target && e.target.value) || '';
        setDocumentPartageUtilisateurs({ ...documentPartageUtilisateurs, [name]:val})
    };


    const isFormValid = () => {
        let errorMessages = new Array<string>();
        if(item.reference == '')
        errorMessages.push("reference is required")
        return errorMessages.length == 0 ;
    }


    const itemDialogFooter = ( <>
        <Button label="Cancel" icon="pi pi-times" text onClick={hideDialog} />
        <Button label="Save" icon="pi pi-check" text onClick={editItem} /> </>
    );



    return(
    <Dialog visible={visible} style={{width: '70vw'}} header={t("document.tabPan")} modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog}>
        <TabView activeIndex={activeIndex} onTabChange={onTabChange}>
            <TabPanel header={t("document.tabPan")}>
                <div className="formgrid grid">
                    <div className="field col-6">
                        <label htmlFor="reference">{t("document.reference")}</label>
                        <InputText id="reference" value={item ? item.reference : ''} onChange={(e) => onInputTextChange(e, 'reference')} required autoFocus className={classNames({'p-invalid': submitted && !item.reference})} />
                        {submitted && !item.reference && <small className="p-invalid">Reference is required.</small>}
                    </div>
                        <div className="field col-6">
                            <FileUpload accept=".pdf,.jpg,.png" chooseLabel="Choose File" uploadLabel="Upload" customUpload uploadHandler={onUpload}/>
                        </div>
                    <div className="field col-6">
                        <label htmlFor="uploadDate">{t("document.uploadDate")}</label>
                        <Calendar id="uploadDate" value={adaptDate(item?.uploadDate)} onChange={(e) => onInputDateChange(e, 'uploadDate')} dateFormat="dd/mm/yy" showIcon={true} />
                    </div>
                    <div className="field col-6">
                        <label htmlFor="dateLastUpdate">{t("document.dateLastUpdate")}</label>
                        <Calendar id="dateLastUpdate" value={adaptDate(item?.dateLastUpdate)} onChange={(e) => onInputDateChange(e, 'dateLastUpdate')} dateFormat="dd/mm/yy" showIcon={true} />
                    </div>
                    <div className="field col-6">
                        <label htmlFor="content">{t("document.content")}</label>
                        <InputText id="content" value={item ? item.content : ''} onChange={(e) => onInputTextChange(e, 'content')} required autoFocus className={classNames({'p-invalid': submitted && !item.content})} />
                        {submitted && !item.content && <small className="p-invalid">Content is required.</small>}
                    </div>
                    <div className="field col-6">
                        <div  className="label-inputswitch">
                            <label htmlFor="folder">{t("document.folder")}</label>
                            <span className="p-float-label">
                                <InputSwitch  id="folder" checked={item.folder} onChange={(e) => onBooleanInputChange(e, 'folder')} />
                            </span>
                        </div>
                    </div>
                    <div className="field col-6">
                        <label htmlFor="size">{t("document.size")}</label>
                        <InputNumber id="size" value={item ? item.size : 0} onChange={(e) => onInputNumerChange(e, 'size')}/>
                    </div>
                    <div className="field col-6">
                        <label htmlFor="documentType">{t("document.documentType")}</label>
                        <Dropdown  id="documentTypeDropdown"  value={item ? item.documentType : ''} options={documentTypes} onChange={(e) => onDropdownChange(e, 'documentType')}   placeholder="Sélectionnez un documentType" filter filterPlaceholder="Rechercher un documentType" optionLabel="libelle" />
                    </div>
                    <div className="field col-6">
                        <label htmlFor="documentState">{t("document.documentState")}</label>
                        <Dropdown  id="documentStateDropdown"  value={item ? item.documentState : ''} options={documentStates} onChange={(e) => onDropdownChange(e, 'documentState')}   placeholder="Sélectionnez un documentState" filter filterPlaceholder="Rechercher un documentState" optionLabel="libelle" />
                    </div>
                    <div className="field col-6">
                        <label htmlFor="documentCategorie">{t("document.documentCategorie")}</label>
                        <Dropdown  id="documentCategorieDropdown"  value={item ? item.documentCategorie : ''} options={documentCategories} onChange={(e) => onDropdownChange(e, 'documentCategorie')}   placeholder="Sélectionnez un documentCategorie" filter filterPlaceholder="Rechercher un documentCategorie" optionLabel="libelle" />
                    </div>
                    <div className="field col-6">
                        <label htmlFor="description">{t("document.description")}</label>
                        <span className="p-float-label">
                            <InputTextarea id="description" value={item ? item.description : ''} onChange={(e) => onInputTextChange(e, 'description')} rows={5} cols={30}/>
                        </span>
                    </div>
                    <div className="field col-6">
                        <label htmlFor="utilisateur">{t("document.utilisateur")}</label>
                        <Dropdown  id="utilisateurDropdown"  value={item ? item.utilisateur : ''} options={utilisateurs} onChange={(e) => onDropdownChange(e, 'utilisateur')}   placeholder="Sélectionnez un utilisateur" filter filterPlaceholder="Rechercher un utilisateur" optionLabel="nom" />
                    </div>
                    <div className="field col-6">
                        <div  className="label-inputswitch">
                            <label htmlFor="archive">{t("document.archive")}</label>
                            <span className="p-float-label">
                                <InputSwitch  id="archive" checked={item.archive} onChange={(e) => onBooleanInputChange(e, 'archive')} />
                            </span>
                        </div>
                    </div>
                    <div className="field col-6">
                        <div  className="label-inputswitch">
                            <label htmlFor="versionne">{t("document.versionne")}</label>
                            <span className="p-float-label">
                                <InputSwitch  id="versionne" checked={item.versionne} onChange={(e) => onBooleanInputChange(e, 'versionne')} />
                            </span>
                        </div>
                    </div>
                    <div className="field col-6">
                        <label htmlFor="entiteAdministrative">{t("document.entiteAdministrative")}</label>
                        <Dropdown  id="entiteAdministrativeDropdown"  value={item ? item.entiteAdministrative : ''} options={entiteAdministratives} onChange={(e) => onDropdownChange(e, 'entiteAdministrative')}   placeholder="Sélectionnez un entiteAdministrative" filter filterPlaceholder="Rechercher un entiteAdministrative" optionLabel="libelle" />
                    </div>
                    <div className="field col-6">
                        <label htmlFor="documentTags">{t("documentTag.tag")}</label>
                        {/*
                        <MultiSelect value={item ? item.documentTags : ''} options={documentTags}  optionLabel="tag.libelle" display="chip" placeholder="Select tag"  maxSelectedLabels={3}  onChange={(e) => onMultiSelectChange(e, 'documentTags')} />
                        */}
                    </div>
                </div>
            </TabPanel>
            <TabPanel header={t("document.documentFields")}>
                <TabView activeIndex={activeTab} onTabChange={(e) => setActiveTab(e.index)}>
                    <TabPanel header="Creation">
                        <div className="grid">
                            <div className="field col-6">
                                <label htmlFor="field">{t("documentField.field")}</label>
                                <Dropdown id="fieldDropdown" value={documentFields.field} options={fields} onChange={(e) => onDropdownChangeDocumentFields(e, 'field')} placeholder="Sélectionnez un field" filter  filterPlaceholder="Rechercher un field"  optionLabel="libelle" />
                            </div>
                            <div className="field col-6">
                                <label htmlFor="value">{t("documentField.value")}</label>
                                <InputText id="value" value={documentFields.value} onChange={(e) => onInputTextChangeDocumentFields(e, 'value')} required autoFocus className={classNames({'p-invalid': submitted && !item.documentFields})}/>
                            </div>
                            <div className="field col-6">
                                <label htmlFor="documentFieldState">{t("documentField.documentFieldState")}</label>
                                <Dropdown id="documentFieldStateDropdown" value={documentFields.documentFieldState} options={documentFieldStates} onChange={(e) => onDropdownChangeDocumentFields(e, 'documentFieldState')} placeholder="Sélectionnez un documentFieldState" filter  filterPlaceholder="Rechercher un documentFieldState"  optionLabel="libelle" />
                            </div>
                            <div className="field col-1">
                                <Button icon="pi pi-plus" label="OK" className="mt-4" onClick={addDocumentFields} />
                            </div>
                        </div>
                    </TabPanel>
                    <TabPanel header="Liste">
                        <div className="card">
                            <DataTable value={item.documentFields} tableStyle={{minWidth: '50rem'}} dataKey="id">
                                <Column field="field.libelle" header={t("documentField.field")}></Column>
                                <Column field="value" header={t("documentField.value")} ></Column>
                                <Column field="documentFieldState.libelle" header={t("documentField.documentFieldState")}></Column>
                                <Column header="Actions" body={(rowData) => (
                                    <div>
                                        <Button icon="pi pi-times" rounded severity="warning" className="mr-2 p-button-danger" onClick={()=> deleteDocumentFields(rowData)} />
                                        <Button icon="pi pi-pencil" rounded severity="success" className="mr-2" onClick={()=> editDocumentFields(rowData)} />
                                    </div>
                                )}></Column>
                            </DataTable>
                        </div>
                    </TabPanel>
                </TabView>
            </TabPanel>
            <TabPanel header={t("document.documentPartageGroupes")}>
                <TabView activeIndex={activeTab} onTabChange={(e) => setActiveTab(e.index)}>
                    <TabPanel header="Creation">
                        <div className="grid">
                            <div className="field col-6">
                                <label htmlFor="groupe">{t("documentPartageGroupe.groupe")}</label>
                                <Dropdown id="groupeDropdown" value={documentPartageGroupes.groupe} options={groupes} onChange={(e) => onDropdownChangeDocumentPartageGroupes(e, 'groupe')} placeholder="Sélectionnez un groupe" filter  filterPlaceholder="Rechercher un groupe"  optionLabel="libelle" />
                            </div>
                            <div className="field col-6">
                                <label htmlFor="dateShare">{t("documentPartageGroupe.dateShare")}</label>
                                <Calendar id="dateShare" value={adaptDate(documentPartageGroupes?.dateShare)}  onChange={(e) => onInputDateChangeDocumentPartageGroupes(e, 'dateShare')} dateFormat="dd/mm/yy" showIcon={true}  />
                            </div>
                            <div className="field col-6">
                                <label htmlFor="accessShare">{t("documentPartageGroupe.accessShare")}</label>
                                <Dropdown id="accessShareDropdown" value={documentPartageGroupes.accessShare} options={accessShares} onChange={(e) => onDropdownChangeDocumentPartageGroupes(e, 'accessShare')} placeholder="Sélectionnez un accessShare" filter  filterPlaceholder="Rechercher un accessShare"  optionLabel="libelle" />
                            </div>
                            <div className="field col-1">
                                <Button icon="pi pi-plus" label="OK" className="mt-4" onClick={addDocumentPartageGroupes} />
                            </div>
                        </div>
                    </TabPanel>
                    <TabPanel header="Liste">
                        <div className="card">
                            <DataTable value={item.documentPartageGroupes} tableStyle={{minWidth: '50rem'}} dataKey="id">
                                <Column field="groupe.libelle" header={t("documentPartageGroupe.groupe")}></Column>
                                <Column field="dateShare" header={t("documentPartageGroupe.dateShare")} body={formateDate("dateShare")}></Column>
                                <Column field="accessShare.libelle" header={t("documentPartageGroupe.accessShare")}></Column>
                                <Column header="Actions" body={(rowData) => (
                                    <div>
                                        <Button icon="pi pi-times" rounded severity="warning" className="mr-2 p-button-danger" onClick={()=> deleteDocumentPartageGroupes(rowData)} />
                                        <Button icon="pi pi-pencil" rounded severity="success" className="mr-2" onClick={()=> editDocumentPartageGroupes(rowData)} />
                                    </div>
                                )}></Column>
                            </DataTable>
                        </div>
                    </TabPanel>
                </TabView>
            </TabPanel>
            <TabPanel header={t("document.documentPartageUtilisateurs")}>
                <TabView activeIndex={activeTab} onTabChange={(e) => setActiveTab(e.index)}>
                    <TabPanel header="Creation">
                        <div className="grid">
                            <div className="field col-6">
                                <label htmlFor="utilisateur">{t("documentPartageUtilisateur.utilisateur")}</label>
                                <Dropdown id="utilisateurDropdown" value={documentPartageUtilisateurs.utilisateur} options={utilisateurs} onChange={(e) => onDropdownChangeDocumentPartageUtilisateurs(e, 'utilisateur')} placeholder="Sélectionnez un utilisateur" filter  filterPlaceholder="Rechercher un utilisateur"  optionLabel="nom" />
                            </div>
                            <div className="field col-6">
                                <label htmlFor="dateShare">{t("documentPartageUtilisateur.dateShare")}</label>
                                <Calendar id="dateShare" value={adaptDate(documentPartageUtilisateurs?.dateShare)}  onChange={(e) => onInputDateChangeDocumentPartageUtilisateurs(e, 'dateShare')} dateFormat="dd/mm/yy" showIcon={true}  />
                            </div>
                            <div className="field col-6">
                                <label htmlFor="accessShare">{t("documentPartageUtilisateur.accessShare")}</label>
                                <Dropdown id="accessShareDropdown" value={documentPartageUtilisateurs.accessShare} options={accessShares} onChange={(e) => onDropdownChangeDocumentPartageUtilisateurs(e, 'accessShare')} placeholder="Sélectionnez un accessShare" filter  filterPlaceholder="Rechercher un accessShare"  optionLabel="libelle" />
                            </div>
                            <div className="field col-1">
                                <Button icon="pi pi-plus" label="OK" className="mt-4" onClick={addDocumentPartageUtilisateurs} />
                            </div>
                        </div>
                    </TabPanel>
                    <TabPanel header="Liste">
                        <div className="card">
                            <DataTable value={item.documentPartageUtilisateurs} tableStyle={{minWidth: '50rem'}} dataKey="id">
                                <Column field="utilisateur.nom" header={t("documentPartageUtilisateur.utilisateur")}></Column>
                                <Column field="dateShare" header={t("documentPartageUtilisateur.dateShare")} body={formateDate("dateShare")}></Column>
                                <Column field="accessShare.libelle" header={t("documentPartageUtilisateur.accessShare")}></Column>
                                <Column header="Actions" body={(rowData) => (
                                    <div>
                                        <Button icon="pi pi-times" rounded severity="warning" className="mr-2 p-button-danger" onClick={()=> deleteDocumentPartageUtilisateurs(rowData)} />
                                        <Button icon="pi pi-pencil" rounded severity="success" className="mr-2" onClick={()=> editDocumentPartageUtilisateurs(rowData)} />
                                    </div>
                                )}></Column>
                            </DataTable>
                        </div>
                    </TabPanel>
                </TabView>
            </TabPanel>
        </TabView>
    </Dialog>
);
};
export default Edit;


