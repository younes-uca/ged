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

import {AccessShareDto} from 'app/controller/model/AccessShare.model';
import {AccessShareAdminService} from 'app/controller/service/admin/AccessShareAdminService.service';
import {DocumentStateDto} from 'app/controller/model/DocumentState.model';
import {DocumentStateAdminService} from 'app/controller/service/admin/DocumentStateAdminService.service';
import {DocumentIndexElementDto} from 'app/controller/model/DocumentIndexElement.model';
import {DocumentIndexElementAdminService} from 'app/controller/service/admin/DocumentIndexElementAdminService.service';
import {GroupeDto} from 'app/controller/model/Groupe.model';
import {GroupeAdminService} from 'app/controller/service/admin/GroupeAdminService.service';
import {UtilisateurDto} from 'app/controller/model/Utilisateur.model';
import {UtilisateurAdminService} from 'app/controller/service/admin/UtilisateurAdminService.service';
import {DocumentPartageUtilisateurDto} from 'app/controller/model/DocumentPartageUtilisateur.model';
import {DocumentPartageUtilisateurAdminService} from 'app/controller/service/admin/DocumentPartageUtilisateurAdminService.service';
import {EntiteAdministrativeDto} from 'app/controller/model/EntiteAdministrative.model';
import {EntiteAdministrativeAdminService} from 'app/controller/service/admin/EntiteAdministrativeAdminService.service';
import {DocumentTypeDto} from 'app/controller/model/DocumentType.model';
import {DocumentTypeAdminService} from 'app/controller/service/admin/DocumentTypeAdminService.service';
import {DocumentPartageGroupeDto} from 'app/controller/model/DocumentPartageGroupe.model';
import {DocumentPartageGroupeAdminService} from 'app/controller/service/admin/DocumentPartageGroupeAdminService.service';
import {DocumentTagDto} from 'app/controller/model/DocumentTag.model';
import {DocumentTagAdminService} from 'app/controller/service/admin/DocumentTagAdminService.service';
import {DocumentCategorieDto} from 'app/controller/model/DocumentCategorie.model';
import {DocumentCategorieAdminService} from 'app/controller/service/admin/DocumentCategorieAdminService.service';
import {TagDto} from 'app/controller/model/Tag.model';
import {TagAdminService} from 'app/controller/service/admin/TagAdminService.service';
import {DocumentIndexElementStateDto} from 'app/controller/model/DocumentIndexElementState.model';
import {DocumentIndexElementStateAdminService} from 'app/controller/service/admin/DocumentIndexElementStateAdminService.service';
import {IndexElementDto} from 'app/controller/model/IndexElement.model';
import {IndexElementAdminService} from 'app/controller/service/admin/IndexElementAdminService.service';
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


    const isFormValid = () => {
    let errorMessages = new Array<string>();
                if(item.reference == '')
                errorMessages.push("reference is required")
        return errorMessages.length == 0 ;
    }
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
        } = useEditHook<DocumentDto, DocumentCriteria>({list, selectedItem, onClose, update, showToast,service, t, isFormValid})


    const [utilisateurs, setUtilisateurs] = useState<UtilisateurDto[]>([]);
    const [entiteAdministratives, setEntiteAdministratives] = useState<EntiteAdministrativeDto[]>([]);
    const [groupes, setGroupes] = useState<GroupeDto[]>([]);
    const [documentIndexElementStates, setDocumentIndexElementStates] = useState<DocumentIndexElementStateDto[]>([]);
    const [documentTypes, setDocumentTypes] = useState<DocumentTypeDto[]>([]);
    const [accessShares, setAccessShares] = useState<AccessShareDto[]>([]);
    const [indexElements, setIndexElements] = useState<IndexElementDto[]>([]);
    const [tags, setTags] = useState<TagDto[]>([]);
    const [documentCategories, setDocumentCategories] = useState<DocumentCategorieDto[]>([]);
    const [documentStates, setDocumentStates] = useState<DocumentStateDto[]>([]);

    const [documentIndexElements, setDocumentIndexElements] = useState<DocumentIndexElementDto>(new DocumentIndexElementDto());
    const [documentPartageGroupes, setDocumentPartageGroupes] = useState<DocumentPartageGroupeDto>(new DocumentPartageGroupeDto());
    const [documentPartageUtilisateurs, setDocumentPartageUtilisateurs] = useState<DocumentPartageUtilisateurDto>(new DocumentPartageUtilisateurDto());
    const [documentTags, setDocumentTags] = useState<DocumentTagDto>(new DocumentTagDto());

    const accessShareAdminService = new AccessShareAdminService();
    const documentStateAdminService = new DocumentStateAdminService();
    const documentIndexElementAdminService = new DocumentIndexElementAdminService();
    const groupeAdminService = new GroupeAdminService();
    const utilisateurAdminService = new UtilisateurAdminService();
    const documentPartageUtilisateurAdminService = new DocumentPartageUtilisateurAdminService();
    const entiteAdministrativeAdminService = new EntiteAdministrativeAdminService();
    const documentTypeAdminService = new DocumentTypeAdminService();
    const documentPartageGroupeAdminService = new DocumentPartageGroupeAdminService();
    const documentTagAdminService = new DocumentTagAdminService();
    const documentCategorieAdminService = new DocumentCategorieAdminService();
    const tagAdminService = new TagAdminService();
    const documentIndexElementStateAdminService = new DocumentIndexElementStateAdminService();
    const indexElementAdminService = new IndexElementAdminService();

    useEffect(() => {
    documentTypeAdminService.getList().then(({data}) => setDocumentTypes(data)).catch(error => console.log(error));
    documentStateAdminService.getList().then(({data}) => setDocumentStates(data)).catch(error => console.log(error));
    documentCategorieAdminService.getList().then(({data}) => setDocumentCategories(data)).catch(error => console.log(error));
    utilisateurAdminService.getList().then(({data}) => setUtilisateurs(data)).catch(error => console.log(error));
    entiteAdministrativeAdminService.getList().then(({data}) => setEntiteAdministratives(data)).catch(error => console.log(error));


    indexElementAdminService.getList().then(({data}) => setIndexElements(data)).catch(error => console.log(error));
    documentIndexElementStateAdminService.getList().then(({data}) => setDocumentIndexElementStates(data)).catch(error => console.log(error));

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

    const addDocumentIndexElements = () => {
        setSubmitted(true);
        if( item.documentIndexElements == null )
        item.documentIndexElements = new Array<DocumentIndexElementDto>();
        let _item = documentIndexElements;
        if (!_item.id) {
            item.documentIndexElements.push(_item);
            MessageService.showSuccess(showToast, 'DocumentIndexElements Created');
            setItem((prevState :any) => ({...prevState, documentIndexElements: item.documentIndexElements }));
        } else {
            const updatedItems = item.documentIndexElements.map((item) => item.id === documentIndexElements.id ? {...documentIndexElements} : item);
            MessageService.showSuccess(showToast, 'DocumentIndexElements Updated');
            setItem((prevState :any) => ({ ...prevState, documentIndexElements: updatedItems}));
        }
        setDocumentIndexElements(new DocumentIndexElementDto());
    };

    const deleteDocumentIndexElements = (rowData: any) => {
        const updatedItems = item.documentIndexElements.filter((val) => val !== rowData);
        setItem((prevState ) => ({...prevState, documentIndexElements: updatedItems }));
        setDocumentIndexElements(new DocumentIndexElementDto());
        MessageService.showSuccess(showToast, 'DocumentItem Deleted');
    };

    const editDocumentIndexElements = (rowData: any) => {
        setActiveTab(0);
        setDocumentIndexElements(rowData);
    };

    const onInputNumerChangeDocumentIndexElements = (e: any, name: string) => {
        const val = e.value || 0;
        setDocumentIndexElements((prevDocumentIndexElements) => ({ ...prevDocumentIndexElements, [name]: val, }));
    };

    const onDropdownChangeDocumentIndexElements = (e: any, field: string) => {
        setDocumentIndexElements((prevState) => ({ ...prevState, [field]: e.value}));
    };


    const onMultiSelectChangeDocumentIndexElements = (e: any, field: string) => {
        if (e && e.value && Array.isArray(e.value)) {
            const selectedValues = e.value.map(option => option && option.value);
            setDocumentIndexElements(prevState => ({ ...prevState, [field]: selectedValues, }));
        }
    };

    const onBooleanInputChangeDocumentIndexElements = (e: any, name: string) => {
        const val = e.value;
        setDocumentIndexElements((prevItem) => ({ ...prevItem, [name]: val, }));
    };

    const onInputDateChangeDocumentIndexElements = (e: CalendarChangeEvent, name: string) => {
        const val = e.value || '';
        setDocumentIndexElements({ ...documentIndexElements, [name]:val})
    };

    const onInputTextChangeDocumentIndexElements = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, name: string) => {
        const val = (e.target && e.target.value) || '';
        setDocumentIndexElements({ ...documentIndexElements, [name]:val})
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

    const itemDialogFooter = ( <>
        <Button label="Cancel" icon="pi pi-times" text onClick={hideDialog} />
        <Button label="Save" icon="pi pi-check" onClick={editItem} /> </>
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
                        <label htmlFor="annee">{t("document.annee")}</label>
                        <InputNumber id="annee" value={item ? item.annee : 0} onChange={(e) => onInputNumerChange(e, 'annee')}/>
                    </div>
                    <div className="field col-6">
                        <label htmlFor="semstre">{t("document.semstre")}</label>
                        <InputNumber id="semstre" value={item ? item.semstre : 0} onChange={(e) => onInputNumerChange(e, 'semstre')}/>
                    </div>
                    <div className="field col-6">
                        <label htmlFor="mois">{t("document.mois")}</label>
                        <InputNumber id="mois" value={item ? item.mois : 0} onChange={(e) => onInputNumerChange(e, 'mois')}/>
                    </div>
                    <div className="field col-6">
                        <label htmlFor="jour">{t("document.jour")}</label>
                        <InputNumber id="jour" value={item ? item.jour : 0} onChange={(e) => onInputNumerChange(e, 'jour')}/>
                    </div>
                    <div className="field col-6">
                        <label htmlFor="content">{t("document.content")}</label>
                        <InputText id="content" value={item ? item.content : ''} onChange={(e) => onInputTextChange(e, 'content')} required autoFocus className={classNames({'p-invalid': submitted && !item.content})} />
                        {submitted && !item.content && <small className="p-invalid">Content is required.</small>}
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
            <TabPanel header={t("document.documentIndexElements")}>
                <TabView activeIndex={activeTab} onTabChange={(e) => setActiveTab(e.index)}>
                    <TabPanel header="Creation">
                        <div className="grid">
                            <div className="field col-6">
                                <label htmlFor="indexElement">{t("documentIndexElement.indexElement")}</label>
                                <Dropdown id="indexElementDropdown" value={documentIndexElements.indexElement} options={indexElements} onChange={(e) => onDropdownChangeDocumentIndexElements(e, 'indexElement')} placeholder="Sélectionnez un indexElement" filter  filterPlaceholder="Rechercher un indexElement"  optionLabel="libelle" />
                            </div>
                            <div className="field col-6">
                                <label htmlFor="value">{t("documentIndexElement.value")}</label>
                                <InputText id="value" value={documentIndexElements.value} onChange={(e) => onInputTextChangeDocumentIndexElements(e, 'value')} required autoFocus className={classNames({'p-invalid': submitted && !item.documentIndexElements})}/>
                            </div>
                            <div className="field col-6">
                                <label htmlFor="documentIndexElementState">{t("documentIndexElement.documentIndexElementState")}</label>
                                <Dropdown id="documentIndexElementStateDropdown" value={documentIndexElements.documentIndexElementState} options={documentIndexElementStates} onChange={(e) => onDropdownChangeDocumentIndexElements(e, 'documentIndexElementState')} placeholder="Sélectionnez un documentIndexElementState" filter  filterPlaceholder="Rechercher un documentIndexElementState"  optionLabel="libelle" />
                            </div>
                            <div className="field col-1">
                                <Button icon="pi pi-plus" label="OK" className="mt-4" onClick={addDocumentIndexElements} />
                            </div>
                        </div>
                    </TabPanel>
                    <TabPanel header="Liste">
                        <div className="card">
                            <DataTable value={item.documentIndexElements} tableStyle={{minWidth: '50rem'}} dataKey="id">
                                <Column field="indexElement.libelle" header={t("documentIndexElement.indexElement")}></Column>
                                <Column field="value" header={t("documentIndexElement.value")} ></Column>
                                <Column field="documentIndexElementState.libelle" header={t("documentIndexElement.documentIndexElementState")}></Column>
                                <Column header="Actions" body={(rowData) => (
                                    <div>
                                        <Button icon="pi pi-times" rounded severity="warning" className="mr-2 p-button-danger" onClick={()=> deleteDocumentIndexElements(rowData)} />
                                        <Button icon="pi pi-pencil" rounded severity="success" className="mr-2" onClick={()=> editDocumentIndexElements(rowData)} />
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


