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
import {format, parse} from 'date-fns';
import {InputNumberChangeEvent} from 'primereact/inputnumber';
import { InputSwitch } from 'primereact/inputswitch';
import {MultiSelect, MultiSelectChangeEvent} from 'primereact/multiselect';

import {MessageService} from 'app/zynerator/service/MessageService';

import {DocumentAdminService} from 'app/controller/service/admin/DocumentAdminService.service';
import  {DocumentDto}  from 'app/controller/model/Document.model';

import {UtilisateurDto} from 'app/controller/model/Utilisateur.model';
import {UtilisateurAdminService} from 'app/controller/service/admin/UtilisateurAdminService.service';
import {DocumentPartageGroupeDto} from 'app/controller/model/DocumentPartageGroupe.model';
import {DocumentPartageGroupeAdminService} from 'app/controller/service/admin/DocumentPartageGroupeAdminService.service';
import {DocumentStateDto} from 'app/controller/model/DocumentState.model';
import {DocumentStateAdminService} from 'app/controller/service/admin/DocumentStateAdminService.service';
import {DocumentTagDto} from 'app/controller/model/DocumentTag.model';
import {DocumentTagAdminService} from 'app/controller/service/admin/DocumentTagAdminService.service';
import {DocumentFieldStateDto} from 'app/controller/model/DocumentFieldState.model';
import {DocumentFieldStateAdminService} from 'app/controller/service/admin/DocumentFieldStateAdminService.service';
import {EntiteAdministrativeDto} from 'app/controller/model/EntiteAdministrative.model';
import {EntiteAdministrativeAdminService} from 'app/controller/service/admin/EntiteAdministrativeAdminService.service';
import {DocumentPartageUtilisateurDto} from 'app/controller/model/DocumentPartageUtilisateur.model';
import {DocumentPartageUtilisateurAdminService} from 'app/controller/service/admin/DocumentPartageUtilisateurAdminService.service';
import {TagDto} from 'app/controller/model/Tag.model';
import {TagAdminService} from 'app/controller/service/admin/TagAdminService.service';
import {FieldDto} from 'app/controller/model/Field.model';
import {FieldAdminService} from 'app/controller/service/admin/FieldAdminService.service';
import {DocumentCategorieDto} from 'app/controller/model/DocumentCategorie.model';
import {DocumentCategorieAdminService} from 'app/controller/service/admin/DocumentCategorieAdminService.service';
import {DocumentTypeDto} from 'app/controller/model/DocumentType.model';
import {DocumentTypeAdminService} from 'app/controller/service/admin/DocumentTypeAdminService.service';
import {AccessShareDto} from 'app/controller/model/AccessShare.model';
import {AccessShareAdminService} from 'app/controller/service/admin/AccessShareAdminService.service';
import {GroupeDto} from 'app/controller/model/Groupe.model';
import {GroupeAdminService} from 'app/controller/service/admin/GroupeAdminService.service';
import {DocumentFieldDto} from 'app/controller/model/DocumentField.model';
import {DocumentFieldAdminService} from 'app/controller/service/admin/DocumentFieldAdminService.service';
const Edit = ({visible, onClose, showToast, selectedItem, update, t}) => {

    const emptyItem = new DocumentDto();
    const [submitted, setSubmitted] = useState(false);
    const [activeIndex, setActiveIndex] = useState<number>(0);
    const [activeTab, setActiveTab] = useState(0);
    const [item, setItem] = useState<DocumentDto>( emptyItem);
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

    type UtilisateurResponse = AxiosResponse<UtilisateurDto[]>;
    type DocumentPartageGroupeResponse = AxiosResponse<DocumentPartageGroupeDto[]>;
    type DocumentStateResponse = AxiosResponse<DocumentStateDto[]>;
    type DocumentTagResponse = AxiosResponse<DocumentTagDto[]>;
    type DocumentFieldStateResponse = AxiosResponse<DocumentFieldStateDto[]>;
    type EntiteAdministrativeResponse = AxiosResponse<EntiteAdministrativeDto[]>;
    type DocumentPartageUtilisateurResponse = AxiosResponse<DocumentPartageUtilisateurDto[]>;
    type TagResponse = AxiosResponse<TagDto[]>;
    type FieldResponse = AxiosResponse<FieldDto[]>;
    type DocumentCategorieResponse = AxiosResponse<DocumentCategorieDto[]>;
    type DocumentTypeResponse = AxiosResponse<DocumentTypeDto[]>;
    type AccessShareResponse = AxiosResponse<AccessShareDto[]>;
    type GroupeResponse = AxiosResponse<GroupeDto[]>;
    type DocumentFieldResponse = AxiosResponse<DocumentFieldDto[]>;

    const [documentFields, setDocumentFields] = useState<DocumentFieldDto>(new DocumentFieldDto());
    const [documentPartageGroupes, setDocumentPartageGroupes] = useState<DocumentPartageGroupeDto>(new DocumentPartageGroupeDto());
    const [documentPartageUtilisateurs, setDocumentPartageUtilisateurs] = useState<DocumentPartageUtilisateurDto>(new DocumentPartageUtilisateurDto());
    const [documentTags, setDocumentTags] = useState<DocumentTagDto[]>([] as DocumentTagDto[]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const [utilisateursResponse ,entiteAdministrativesResponse ,groupesResponse ,fieldsResponse ,documentFieldStatesResponse ,documentTypesResponse ,accessSharesResponse ,tagsResponse ,documentCategoriesResponse ,documentStatesResponse ] = await Promise.all<UtilisateurResponse,EntiteAdministrativeResponse,GroupeResponse,FieldResponse,DocumentFieldStateResponse,DocumentTypeResponse,AccessShareResponse,TagResponse,DocumentCategorieResponse,DocumentStateResponse>([
                    UtilisateurAdminService.getList(),
                    EntiteAdministrativeAdminService.getList(),
                    GroupeAdminService.getList(),
                    FieldAdminService.getList(),
                    DocumentFieldStateAdminService.getList(),
                    DocumentTypeAdminService.getList(),
                    AccessShareAdminService.getList(),
                    DocumentCategorieAdminService.getList(),
                    DocumentStateAdminService.getList(),
                ]);
                setUtilisateurs(utilisateursResponse.data);
                setEntiteAdministratives(entiteAdministrativesResponse.data);
                setGroupes(groupesResponse.data);
                setFields(fieldsResponse.data);
                setDocumentFieldStates(documentFieldStatesResponse.data);
                setDocumentTypes(documentTypesResponse.data);
                setAccessShares(accessSharesResponse.data);
                setDocumentCategories(documentCategoriesResponse.data);
                setDocumentStates(documentStatesResponse.data);
            } catch (error) {
                console.error(error);
            }
            TagAdminService.getList().then(({data}) => {
                const documentTags = data?.map(prepareDocumentTag);
                console.log(documentTags)
                setDocumentTags(documentTags)
            })
        };
    fetchData();
    setItem(selectedItem ? { ...selectedItem } : { ...emptyItem });
    }, []);

    const prepareDocumentTag = (tag: TagDto) => {
        const documentTag = new DocumentTagDto();
        documentTag.tag = tag;
        return documentTag;
    }


    const onDropdownChange = (e, field) => {
        setItem((prevState) => ({ ...prevState, [field]: e.value, }));
    };

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

    const deleteDocumentFields = (rowData) => {
        const updatedItems = item.documentFields.filter((val) => val !== rowData);
        setItem((prevState ) => ({...prevState, documentFields: updatedItems }));
        setDocumentFields(new DocumentFieldDto());
        MessageService.showSuccess(showToast, 'DocumentItem Deleted');
    };

    const editDocumentFields = (rowData) => {
        setActiveTab(0);
        setDocumentFields(rowData);
    };

    const onInputNumerChangeDocumentFields = (e, name) => {
        const val = e.value || 0;
        setDocumentFields((prevDocumentFields) => ({ ...prevDocumentFields, [name]: val, }));
    };

    const onDropdownChangeDocumentFields = (e, field) => {
        setDocumentFields((prevState) => ({ ...prevState, [field]: e.value}));
    };


    const onMultiSelectChangeDocumentFields = (e, field) => {
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
        const val = e.value || ''; // Utilisez e.value au lieu de e.target.value
        let _item = { ...documentFields};
        _item[`${name}`] = val;
        setDocumentFields(_item);
    };


    const onInputTextChangeDocumentFields = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, name: string) => {
        const val = (e.target && e.target.value) || '';
        let _item = {...documentFields};
        _item[`${name}`] = val;
        setDocumentFields(_item);
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

    const deleteDocumentPartageGroupes = (rowData) => {
        const updatedItems = item.documentPartageGroupes.filter((val) => val !== rowData);
        setItem((prevState ) => ({...prevState, documentPartageGroupes: updatedItems }));
        setDocumentPartageGroupes(new DocumentPartageGroupeDto());
        MessageService.showSuccess(showToast, 'DocumentItem Deleted');
    };

    const editDocumentPartageGroupes = (rowData) => {
        setActiveTab(0);
        setDocumentPartageGroupes(rowData);
    };

    const onInputNumerChangeDocumentPartageGroupes = (e, name) => {
        const val = e.value || 0;
        setDocumentPartageGroupes((prevDocumentPartageGroupes) => ({ ...prevDocumentPartageGroupes, [name]: val, }));
    };

    const onDropdownChangeDocumentPartageGroupes = (e, field) => {
        setDocumentPartageGroupes((prevState) => ({ ...prevState, [field]: e.value}));
    };


    const onMultiSelectChangeDocumentPartageGroupes = (e, field) => {
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
        const val = e.value || ''; // Utilisez e.value au lieu de e.target.value
        let _item = { ...documentPartageGroupes};
        _item[`${name}`] = val;
        setDocumentPartageGroupes(_item);
    };


    const onInputTextChangeDocumentPartageGroupes = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, name: string) => {
        const val = (e.target && e.target.value) || '';
        let _item = {...documentPartageGroupes};
        _item[`${name}`] = val;
        setDocumentPartageGroupes(_item);
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

    const deleteDocumentPartageUtilisateurs = (rowData) => {
        const updatedItems = item.documentPartageUtilisateurs.filter((val) => val !== rowData);
        setItem((prevState ) => ({...prevState, documentPartageUtilisateurs: updatedItems }));
        setDocumentPartageUtilisateurs(new DocumentPartageUtilisateurDto());
        MessageService.showSuccess(showToast, 'DocumentItem Deleted');
    };

    const editDocumentPartageUtilisateurs = (rowData) => {
        setActiveTab(0);
        setDocumentPartageUtilisateurs(rowData);
    };

    const onInputNumerChangeDocumentPartageUtilisateurs = (e, name) => {
        const val = e.value || 0;
        setDocumentPartageUtilisateurs((prevDocumentPartageUtilisateurs) => ({ ...prevDocumentPartageUtilisateurs, [name]: val, }));
    };

    const onDropdownChangeDocumentPartageUtilisateurs = (e, field) => {
        setDocumentPartageUtilisateurs((prevState) => ({ ...prevState, [field]: e.value}));
    };


    const onMultiSelectChangeDocumentPartageUtilisateurs = (e, field) => {
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
        const val = e.value || ''; // Utilisez e.value au lieu de e.target.value
        let _item = { ...documentPartageUtilisateurs};
        _item[`${name}`] = val;
        setDocumentPartageUtilisateurs(_item);
    };


    const onInputTextChangeDocumentPartageUtilisateurs = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, name: string) => {
        const val = (e.target && e.target.value) || '';
        let _item = {...documentPartageUtilisateurs};
        _item[`${name}`] = val;
        setDocumentPartageUtilisateurs(_item);
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
        if(item.reference == '')
        errorMessages.push("reference is required")
        return errorMessages.length == 0 ;
    }
    const parseToIsoFormat =(date:Date) => {
        return parse(item.dateLastUpdate.toISOString(),"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", new Date())
    }
    const editItem = async () => {
        setSubmitted(true);
        if (isFormValid()) {
            item.dateLastUpdate = parseToIsoFormat(item.dateLastUpdate);
            const response = await DocumentAdminService.update(item);
            update(response.data);
            MessageService.showSuccess(showToast, 'Document Updated');
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

    const onMultiSelectChange = (e: MultiSelectChangeEvent, field: string) => {
        if (e && e.value) {
            setItem(prevState => ({...prevState, [field]: e.value,}));
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


    const adaptDate = (field: null | Date) => {
           return field == null? null: new Date(field)
    };


    return(
    <Dialog visible={visible} style={{width: '70vw'}} header={t("documentTabPan")} modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog}>
        <TabView activeIndex={activeIndex} onTabChange={onTabChange}>
            <TabPanel header={t("documentTabPan")}>
                <div className="formgrid grid">
                    <div className="field col-6">
                        <label htmlFor="reference">{t("documentReference")}</label>
                        <InputText id="reference" value={item ? item.reference : ''} onChange={(e) => onInputTextChange(e, 'reference')} required autoFocus className={classNames({'p-invalid': submitted && !item.reference})} />
                        {submitted && !item.reference && <small className="p-invalid">Reference is required.</small>}
                    </div>
                    <div className="field col-6">
                        <label htmlFor="uploadDate">{t("documentUploadDate")}</label>
                        <Calendar id="uploadDate" value={item ? item.uploadDate : ''} onChange={(e) => onInputDateChange(e, 'uploadDate')} dateFormat="dd/mm/yy" showTime />
                    </div>
                    <div className="field col-6">
                        <label htmlFor="dateLastUpdate">{t("documentDateLastUpdate")}</label>
                        <Calendar id="dateLastUpdate" value={adaptDate(item?.dateLastUpdate)} onChange={(e) => onInputDateChange(e, 'dateLastUpdate')}  showIcon={true} />
                    </div>
                    <div className="field col-6">
                        <label htmlFor="content">{t("documentContent")}</label>
                        <InputText id="content" value={item ? item.content : ''} onChange={(e) => onInputTextChange(e, 'content')} required autoFocus className={classNames({'p-invalid': submitted && !item.content})} />
                        {submitted && !item.content && <small className="p-invalid">Content is required.</small>}
                    </div>
                    <div className="field col-6">
                        <div  className="label-inputswitch">
                            <label htmlFor="folder">{t("documentFolder")}</label>
                            <span className="p-float-label">
                                <InputSwitch  id="folder" checked={item ? item.folder : ''} onChange={(e) => onBooleanInputChange(e, 'folder')} />
                            </span>
                        </div>
                    </div>
                    <div className="field col-6">
                        <label htmlFor="size">{t("documentSize")}</label>
                        <InputNumber id="size" value={item ? item.size : 0} onChange={(e) => onInputNumerChange(e, 'size')}/>
                    </div>
                    <div className="field col-6">
                        <label htmlFor="documentType">{t("documentDocumentType")}</label>
                        <Dropdown  id="documentTypeDropdown"  value={item ? item.documentType : ''} options={documentTypes} onChange={(e) => onDropdownChange(e, 'documentType')}   placeholder="Sélectionnez un documentType" filter filterPlaceholder="Rechercher un documentType" optionLabel="libelle" />
                    </div>
                    <div className="field col-6">
                        <label htmlFor="documentState">{t("documentDocumentState")}</label>
                        <Dropdown  id="documentStateDropdown"  value={item ? item.documentState : ''} options={documentStates} onChange={(e) => onDropdownChange(e, 'documentState')}   placeholder="Sélectionnez un documentState" filter filterPlaceholder="Rechercher un documentState" optionLabel="libelle" />
                    </div>
                    <div className="field col-6">
                        <label htmlFor="documentCategorie">{t("documentDocumentCategorie")}</label>
                        <Dropdown  id="documentCategorieDropdown"  value={item ? item.documentCategorie : ''} options={documentCategories} onChange={(e) => onDropdownChange(e, 'documentCategorie')}   placeholder="Sélectionnez un documentCategorie" filter filterPlaceholder="Rechercher un documentCategorie" optionLabel="libelle" />
                    </div>
                    <div className="field col-6">
                        <label htmlFor="description">{t("documentDescription")}</label>
                        <span className="p-float-label">
                            <InputTextarea id="description" value={item ? item.description : ''} onChange={(e) => onInputTextChange(e, 'description')} rows={5} cols={30}/>
                        </span>
                    </div>
                    <div className="field col-6">
                        <label htmlFor="utilisateur">{t("documentUtilisateur")}</label>
                        <Dropdown  id="utilisateurDropdown"  value={item ? item.utilisateur : ''} options={utilisateurs} onChange={(e) => onDropdownChange(e, 'utilisateur')}   placeholder="Sélectionnez un utilisateur" filter filterPlaceholder="Rechercher un utilisateur" optionLabel="nom" />
                    </div>
                    <div className="field col-6">
                        <div  className="label-inputswitch">
                            <label htmlFor="archive">{t("documentArchive")}</label>
                            <span className="p-float-label">
                                <InputSwitch  id="archive" checked={item ? item.archive : ''} onChange={(e) => onBooleanInputChange(e, 'archive')} />
                            </span>
                        </div>
                    </div>
                    <div className="field col-6">
                        <div  className="label-inputswitch">
                            <label htmlFor="versionne">{t("documentVersionne")}</label>
                            <span className="p-float-label">
                                <InputSwitch  id="versionne" checked={item ? item.versionne : ''} onChange={(e) => onBooleanInputChange(e, 'versionne')} />
                            </span>
                        </div>
                    </div>
                    <div className="field col-6">
                        <label htmlFor="entiteAdministrative">{t("documentEntiteAdministrative")}</label>
                        <Dropdown  id="entiteAdministrativeDropdown"  value={item ? item.entiteAdministrative : ''} options={entiteAdministratives} onChange={(e) => onDropdownChange(e, 'entiteAdministrative')}   placeholder="Sélectionnez un entiteAdministrative" filter filterPlaceholder="Rechercher un entiteAdministrative" optionLabel="libelle" />
                    </div>
                   { <div className="field col-6">
                        <label htmlFor="documentTags">{t("documentTagTag")}</label>


                       <MultiSelect value={item.documentTags} options={documentTags} optionLabel="tag.libelle"
                                    display="chip" placeholder={t("documentDocumentTagsPlaceHolder")}
                                    maxSelectedLabels={3}
                                    onChange={(e) => onMultiSelectChange(e, 'documentTags')}/>

                    </div>}
                </div>
            </TabPanel>
            <TabPanel header={t("documentDocumentFields")}>
                <TabView activeIndex={activeTab} onTabChange={(e) => setActiveTab(e.index)}>
                    <TabPanel header="Creation">
                        <div className="grid">
                            <div className="field col-6">
                                <label htmlFor="field">{t("documentFieldField")}</label>
                                <Dropdown id="fieldDropdown" value={documentFields.field} options={fields} onChange={(e) => onDropdownChangeDocumentFields(e, 'field')} placeholder="Sélectionnez un field" filter  filterPlaceholder="Rechercher un field"  optionLabel="libelle" />
                            </div>
                            <div className="field col-6">
                                <label htmlFor="value">{t("documentFieldValue")}</label>
                                <InputText id="value" value={documentFields.value} onChange={(e) => onInputTextChangeDocumentFields(e, 'value')} required autoFocus className={classNames({'p-invalid': submitted && !item.documentFields})}/>
                            </div>
                            <div className="field col-6">
                                <label htmlFor="documentFieldState">{t("documentFieldDocumentFieldState")}</label>
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
                                <Column field="field.libelle" header={t("documentFieldField")}></Column>
                                <Column field="value" header={t("documentFieldValue")}></Column>
                                <Column field="documentFieldState.libelle" header={t("documentFieldDocumentFieldState")}></Column>
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
            <TabPanel header={t("documentDocumentPartageGroupes")}>
                <TabView activeIndex={activeTab} onTabChange={(e) => setActiveTab(e.index)}>
                    <TabPanel header="Creation">
                        <div className="grid">
                            <div className="field col-6">
                                <label htmlFor="groupe">{t("documentPartageGroupeGroupe")}</label>
                                <Dropdown id="groupeDropdown" value={documentPartageGroupes.groupe} options={groupes} onChange={(e) => onDropdownChangeDocumentPartageGroupes(e, 'groupe')} placeholder="Sélectionnez un groupe" filter  filterPlaceholder="Rechercher un groupe"  optionLabel="libelle" />
                            </div>
                            <div className="field col-6">
                                <label htmlFor="dateShare">{t("documentPartageGroupeDateShare")}</label>
                                <Calendar id="dateShare" value={documentPartageGroupes?.dateShare}  onChange={(e) => onInputDateChangeDocumentPartageGroupes(e, 'dateShare')} dateFormat="dd/mm/yy" showTime  />
                            </div>
                            <div className="field col-6">
                                <label htmlFor="accessShare">{t("documentPartageGroupeAccessShare")}</label>
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
                                <Column field="groupe.libelle" header={t("documentPartageGroupeGroupe")}></Column>
                                <Column field="dateShare" header={t("documentPartageGroupeDateShare")}></Column>
                                <Column field="accessShare.libelle" header={t("documentPartageGroupeAccessShare")}></Column>
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
            <TabPanel header={t("documentDocumentPartageUtilisateurs")}>
                <TabView activeIndex={activeTab} onTabChange={(e) => setActiveTab(e.index)}>
                    <TabPanel header="Creation">
                        <div className="grid">
                            <div className="field col-6">
                                <label htmlFor="utilisateur">{t("documentPartageUtilisateurUtilisateur")}</label>
                                <Dropdown id="utilisateurDropdown" value={documentPartageUtilisateurs.utilisateur} options={utilisateurs} onChange={(e) => onDropdownChangeDocumentPartageUtilisateurs(e, 'utilisateur')} placeholder="Sélectionnez un utilisateur" filter  filterPlaceholder="Rechercher un utilisateur"  optionLabel="nom" />
                            </div>
                            <div className="field col-6">
                                <label htmlFor="dateShare">{t("documentPartageUtilisateurDateShare")}</label>
                                <Calendar id="dateShare" value={documentPartageUtilisateurs?.dateShare}  onChange={(e) => onInputDateChangeDocumentPartageUtilisateurs(e, 'dateShare')} dateFormat="dd/mm/yy" showTime  />
                            </div>
                            <div className="field col-6">
                                <label htmlFor="accessShare">{t("documentPartageUtilisateurAccessShare")}</label>
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
                                <Column field="utilisateur.nom" header={t("documentPartageUtilisateurUtilisateur")}></Column>
                                <Column field="dateShare" header={t("documentPartageUtilisateurDateShare")}></Column>
                                <Column field="accessShare.libelle" header={t("documentPartageUtilisateurAccessShare")}></Column>
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


