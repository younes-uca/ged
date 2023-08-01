import {Button} from 'primereact/button';
import {Column} from 'primereact/column';
import 'primereact/resources/themes/saga-blue/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';
import {Tag} from 'primereact/tag';

import {DataTable} from 'primereact/datatable';
import {Dialog} from 'primereact/dialog';
import {FileUpload} from 'primereact/fileupload';
import {InputText} from 'primereact/inputtext';
import {Toast} from 'primereact/toast';
import {Toolbar} from 'primereact/toolbar';
import React, {useEffect, useRef, useState} from 'react';
import { Paginator } from 'primereact/paginator';
import {Card} from 'primereact/card';
import {Calendar} from 'primereact/calendar';
import {InputNumber} from 'primereact/inputnumber';
import {Dropdown} from 'primereact/dropdown';
import {AxiosResponse} from 'axios';

import {MessageService} from 'app/zynerator/service/MessageService';

import {DocumentAdminService} from 'app/controller/service/admin/DocumentAdminService.service';
import {DocumentDto}  from 'app/controller/model/Document.model';
import {DocumentCriteria} from 'app/controller/criteria/DocumentCriteria.model';

import {DocumentTypeDto} from 'app/controller/model/DocumentType.model';
import {DocumentTypeAdminService} from 'app/controller/service/admin/DocumentTypeAdminService.service';
import {DocumentFieldStateDto} from 'app/controller/model/DocumentFieldState.model';
import {DocumentFieldStateAdminService} from 'app/controller/service/admin/DocumentFieldStateAdminService.service';
import {DocumentFieldDto} from 'app/controller/model/DocumentField.model';
import {DocumentFieldAdminService} from 'app/controller/service/admin/DocumentFieldAdminService.service';
import {DocumentPartageUtilisateurDto} from 'app/controller/model/DocumentPartageUtilisateur.model';
import {DocumentPartageUtilisateurAdminService} from 'app/controller/service/admin/DocumentPartageUtilisateurAdminService.service';
import {AccessShareDto} from 'app/controller/model/AccessShare.model';
import {AccessShareAdminService} from 'app/controller/service/admin/AccessShareAdminService.service';
import {DocumentCategorieDto} from 'app/controller/model/DocumentCategorie.model';
import {DocumentCategorieAdminService} from 'app/controller/service/admin/DocumentCategorieAdminService.service';
import {DocumentPartageGroupeDto} from 'app/controller/model/DocumentPartageGroupe.model';
import {DocumentPartageGroupeAdminService} from 'app/controller/service/admin/DocumentPartageGroupeAdminService.service';
import {GroupeDto} from 'app/controller/model/Groupe.model';
import {GroupeAdminService} from 'app/controller/service/admin/GroupeAdminService.service';
import {DocumentStateDto} from 'app/controller/model/DocumentState.model';
import {DocumentStateAdminService} from 'app/controller/service/admin/DocumentStateAdminService.service';
import {FieldDto} from 'app/controller/model/Field.model';
import {FieldAdminService} from 'app/controller/service/admin/FieldAdminService.service';
import {EntiteAdministrativeDto} from 'app/controller/model/EntiteAdministrative.model';
import {EntiteAdministrativeAdminService} from 'app/controller/service/admin/EntiteAdministrativeAdminService.service';
import {UtilisateurDto} from 'app/controller/model/Utilisateur.model';
import {UtilisateurAdminService} from 'app/controller/service/admin/UtilisateurAdminService.service';

import { useTranslation } from 'react-i18next';

import Edit from '../edit/document-edit-admin.component';
import Create from '../create/document-create-admin.component';
import View from '../view/document-view-admin.component';

const List = () => {

    const { t } = useTranslation();

    const emptyItem = new DocumentDto();
    const [items, setItems] = useState<DocumentDto[]>([]);
    const [deleteItemDialog, setDeleteItemDialog] = useState(false);
    const [deleteItemsDialog, setDeleteItemsDialog] = useState(false);
    const [item, setItem] = useState<DocumentDto>(emptyItem);
    const [selectedItems, setSelectedItems] = useState<DocumentDto[]>([]);
    const [globalFilter, setGlobalFilter] = useState('');
    const [showCreateDialog, setShowCreateDialog] = useState<boolean>(false);
    const [showEditDialog, setShowEditDialog] = useState<boolean>(false);
    const [showViewDialog, setShowViewDialog] = useState<boolean>(false);
    const [selectedItem, setSelectedItem] = useState<DocumentDto | null>(null);
    const [rows, setRows] = useState<number>(10);
    const [totalRecords, setTotalRecords] = useState(0);
    const [criteria, setCriteria] = useState(new DocumentCriteria());
    const [first, setFirst] = useState(0);
    const toast = useRef<Toast>();
    const dt = useRef<DataTable<DocumentDto[]>>();
    const [findByCriteriaShow, setFindByCriteriaShow] = useState(false);
    const [isSearchTriggered, setIsSearchTriggered] = useState(false);

    const [documentTypes, setDocumentTypes] = useState<DocumentTypeDto[]>([]);
    type DocumentTypeResponse = AxiosResponse<DocumentTypeDto[]>;
    const [documentFieldStates, setDocumentFieldStates] = useState<DocumentFieldStateDto[]>([]);
    type DocumentFieldStateResponse = AxiosResponse<DocumentFieldStateDto[]>;
    const [documentFields, setDocumentFields] = useState<DocumentFieldDto[]>([]);
    type DocumentFieldResponse = AxiosResponse<DocumentFieldDto[]>;
    const [documentPartageUtilisateurs, setDocumentPartageUtilisateurs] = useState<DocumentPartageUtilisateurDto[]>([]);
    type DocumentPartageUtilisateurResponse = AxiosResponse<DocumentPartageUtilisateurDto[]>;
    const [accessShares, setAccessShares] = useState<AccessShareDto[]>([]);
    type AccessShareResponse = AxiosResponse<AccessShareDto[]>;
    const [documentCategories, setDocumentCategories] = useState<DocumentCategorieDto[]>([]);
    type DocumentCategorieResponse = AxiosResponse<DocumentCategorieDto[]>;
    const [documentPartageGroupes, setDocumentPartageGroupes] = useState<DocumentPartageGroupeDto[]>([]);
    type DocumentPartageGroupeResponse = AxiosResponse<DocumentPartageGroupeDto[]>;
    const [groupes, setGroupes] = useState<GroupeDto[]>([]);
    type GroupeResponse = AxiosResponse<GroupeDto[]>;
    const [documentStates, setDocumentStates] = useState<DocumentStateDto[]>([]);
    type DocumentStateResponse = AxiosResponse<DocumentStateDto[]>;
    const [fields, setFields] = useState<FieldDto[]>([]);
    type FieldResponse = AxiosResponse<FieldDto[]>;
    const [entiteAdministratives, setEntiteAdministratives] = useState<EntiteAdministrativeDto[]>([]);
    type EntiteAdministrativeResponse = AxiosResponse<EntiteAdministrativeDto[]>;
    const [utilisateurs, setUtilisateurs] = useState<UtilisateurDto[]>([]);
    type UtilisateurResponse = AxiosResponse<UtilisateurDto[]>;

    const showSearch = () => { setFindByCriteriaShow(!findByCriteriaShow); };

    const handleValidateClick = () => {fetchItems(criteria)};

    const handleCancelClick = () => {
        setCriteria(new DocumentCriteria());
        fetchItems(new DocumentCriteria());
        setIsSearchTriggered(false);
    };

    useEffect(() => {
           const fetchData = async () => {
            try {
                const [utilisateursResponse ,entiteAdministrativesResponse ,groupesResponse ,fieldsResponse ,documentFieldStatesResponse ,documentTypesResponse ,accessSharesResponse ,documentCategoriesResponse ,documentStatesResponse ] = await Promise.all<UtilisateurResponse,EntiteAdministrativeResponse,GroupeResponse,FieldResponse,DocumentFieldStateResponse,DocumentTypeResponse,AccessShareResponse,DocumentCategorieResponse,DocumentStateResponse>([
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
        };
        fetchData();
        fetchItems(criteria);
    }, []);

    const fetchItems = async (criteria) => {
        try {
            const response = await DocumentAdminService.findPaginatedByCriteria(criteria);
            const paginatedItems = response.data;
            setTotalRecords(paginatedItems.dataSize);
            setItems(paginatedItems.list);
        } catch (error) {
            console.log(error);
        }
    };

    const onPage = (event) => {
        const updatedCriteria = { ...criteria, page: event.page,maxResults: event.rows };
        setCriteria(updatedCriteria);
        setFirst(event.first);
        fetchItems(updatedCriteria);
    };

    const showCreateModal = (): void => {
        setShowCreateDialog(true);
    };

    const showEditModal = (item: DocumentDto) => {
        setSelectedItem(item);
        setShowEditDialog(true);
    };

    const showViewModal = (item: DocumentDto) => {
        setSelectedItem(item);
        setShowViewDialog(true);
    };

    const add = (item) => {
        setItems([...items, item]);
    };

    const update = (updatedItem: DocumentDto) => {
        const updatedList = items.map((item) => {
            if (item.id === updatedItem.id) { return updatedItem; }
            return item;
        });
        setItems(updatedList);
    };

   const hideDeleteItemDialog = () => {
        setDeleteItemDialog(false);
   };

   const hideDeleteItemsDialog = () => {
        setDeleteItemsDialog(false);
   };

    const confirmDeleteItem = (item: DocumentDto) => {
        setSelectedItem(item);
        setDeleteItemDialog(true);
    };

        const statusBodyTemplate = (val,style) => {
        return <Tag value={val} severity={style} />;
    };

    const deleteItem = async () => {
        try{
            await DocumentAdminService.delete(selectedItem?.id);
            setDeleteItemDialog(false);
            setItem(emptyItem);
            let _items = items.filter((val) => val.id !== selectedItem?.id);
            setItems(_items);
            MessageService.showSuccess(toast, 'Document Deleted');
        } catch (error) {
            MessageService.showError(toast, 'Document Deletion Prob');
        }
    };

    const exportCSV = () => {
        dt.current?.exportCSV();
    };

    const confirmDeleteSelected = () => {
        setDeleteItemsDialog(true);
    };

    const deleteSelectedItems = async () => {
        await DocumentAdminService.deleteList(selectedItems);
        let _items = items.filter((val) => !selectedItems.includes(val));
        setItems(_items);
        setDeleteItemsDialog(false);
        setSelectedItems(null);
        MessageService.showSuccess(toast, 'Documents Deleted');
    };

   const leftToolbarTemplate = () => {
       return (
           <React.Fragment>
               <div className="my-2">
                   <Button label="New" icon="pi pi-plus" severity="success" className=" mr-2" onClick={ showCreateModal} />
                   <Button label="Delete" icon="pi pi-trash" severity="danger" className=" mr-2" onClick={confirmDeleteSelected} disabled={!selectedItems || !selectedItems.length} />
                   <Button label="Search" icon={`pi pi-${findByCriteriaShow ? 'angle-down' : 'angle-right'}`} className=" mr-2" severity="warning" onClick={showSearch} />
               </div>
           </React.Fragment>
       );
   };

    const CustomBooleanCell = ({ value }) => {
        return value ? <i className="pi pi-check-circle" style={{ color: 'green' }}></i> : <i className="pi pi-times-circle" style={{ color: 'red' }}></i>;
    };
   const rightToolbarTemplate = () => {
       return (
           <React.Fragment>
               <FileUpload mode="basic" accept="image/*" maxFileSize={1000000} chooseLabel="Import" className="mr-2 inline-block" />
               <Button label="Export" icon="pi pi-upload" severity="help" onClick={exportCSV} />
           </React.Fragment>
       );
   };

    const actionBodyTemplate = (rowData: DocumentDto) => {
       return ( <>
           <Button icon="pi pi-pencil" rounded severity="success" className="mr-1" onClick={() => showEditModal(rowData)} />
           <Button icon="pi pi-trash" rounded  severity="danger" className="mr-1"  onClick={() => confirmDeleteItem(rowData)} />
           <Button icon="pi pi-eye" rounded severity="info" className="mr-1" onClick={() => showViewModal(rowData)} /> </>
       );
    };

    const header = (
        <div className="flex flex-column md:flex-row md:justify-content-between md:align-items-center">
        <h5 className="m-0">Manage documents</h5>
        <span className="block mt-2 md:mt-0 p-input-icon-left"><i className="pi pi-search" />
        <InputText type="search" onInput={(e) => setGlobalFilter(e.currentTarget.value)} placeholder="Search..." /> </span>
        </div>
    );

    const deleteItemDialogFooter = ( <>
        <Button label="No" icon="pi pi-times" text onClick={hideDeleteItemDialog} />
        <Button label="Yes" icon="pi pi-check" text onClick={deleteItem} /> </>
    );

    const deleteItemsDialogFooter = ( <>
        <Button label="No" icon="pi pi-times" text onClick={hideDeleteItemsDialog} />
        <Button label="Yes" icon="pi pi-check" text onClick={deleteSelectedItems} /> </>
    );



                return (
    <div className="grid crud-demo">
        <div className="col-12">
            <div className="card">
                <Toast ref={toast} />
                <Toolbar className="mb-4" left={leftToolbarTemplate} right={rightToolbarTemplate}></Toolbar>
                {findByCriteriaShow && (
                <Card>
                    <div className="search-container">
                        <div className="grid">
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <InputText id="1" value={criteria.reference} onChange={(e) => setCriteria({ ...criteria, reference: e.target.value })} />
                                <label htmlFor="1">{t("documentReference")}</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <Calendar id="2-1" value={criteria.uploadDateFrom} onChange={(e) => setCriteria({ ...criteria, uploadDateFrom: e.value as Date })} dateFormat="dd-MM-yy" />
                                <label htmlFor="2-1">{t("documentUploadDate")} Min</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <Calendar id="2-2" value={criteria.uploadDateTo} onChange={(e) => setCriteria({ ...criteria, uploadDateTo: e.value as Date })} dateFormat="dd-MM-yy" />
                                <label htmlFor="2-2">{t("documentUploadDate")} Max</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <Calendar id="3-1" value={criteria.dateLastUpdateFrom} onChange={(e) => setCriteria({ ...criteria, dateLastUpdateFrom: e.value as Date })} dateFormat="dd-MM-yy" />
                                <label htmlFor="3-1">{t("documentDateLastUpdate")} Min</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <Calendar id="3-2" value={criteria.dateLastUpdateTo} onChange={(e) => setCriteria({ ...criteria, dateLastUpdateTo: e.value as Date })} dateFormat="dd-MM-yy" />
                                <label htmlFor="3-2">{t("documentDateLastUpdate")} Max</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <InputText id="4" value={criteria.content} onChange={(e) => setCriteria({ ...criteria, content: e.target.value })} />
                                <label htmlFor="4">{t("documentContent")}</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <InputNumber id="6-1" value={criteria.sizeMin} onChange={(e) => setCriteria({ ...criteria, sizeMin: e.value })} mode="decimal" />
                                <label htmlFor="6-1">{t("documentSize")} Min</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <InputNumber id="6-2" value={criteria.sizeMax} onChange={(e) => setCriteria({ ...criteria, sizeMax: e.value })} mode="decimal" />
                                <label htmlFor="6-2">{t("documentSize")} Max</label>
                            </span>
                            <span className="mr-3 align-search-items mt-4">
                                <Dropdown id="7" value={criteria.documentType} options={documentTypes} onChange={(e) => setCriteria({ ...criteria, documentType: e.target.value })} optionLabel="libelle" filter showClear placeholder="DocumentType" filterPlaceholder="DocumentType"/>
                            </span>
                            <span className="mr-3 align-search-items mt-4">
                                <Dropdown id="8" value={criteria.documentState} options={documentStates} onChange={(e) => setCriteria({ ...criteria, documentState: e.target.value })} optionLabel="libelle" filter showClear placeholder="DocumentState" filterPlaceholder="DocumentState"/>
                            </span>
                            <span className="mr-3 align-search-items mt-4">
                                <Dropdown id="9" value={criteria.documentCategorie} options={documentCategories} onChange={(e) => setCriteria({ ...criteria, documentCategorie: e.target.value })} optionLabel="libelle" filter showClear placeholder="DocumentCategorie" filterPlaceholder="DocumentCategorie"/>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <InputText id="11" value={criteria.description} onChange={(e) => setCriteria({ ...criteria, description: e.target.value })} />
                                <label htmlFor="11">{t("documentDescription")}</label>
                            </span>
                            <span className="mr-3 align-search-items mt-4">
                                <Dropdown id="12" value={criteria.utilisateur} options={utilisateurs} onChange={(e) => setCriteria({ ...criteria, utilisateur: e.target.value })} optionLabel="nom" filter showClear placeholder="Utilisateur" filterPlaceholder="Utilisateur"/>
                            </span>
                            <span className="mr-3 align-search-items mt-4">
                                <Dropdown id="15" value={criteria.entiteAdministrative} options={entiteAdministratives} onChange={(e) => setCriteria({ ...criteria, entiteAdministrative: e.target.value })} optionLabel="libelle" filter showClear placeholder="EntiteAdministrative" filterPlaceholder="EntiteAdministrative"/>
                            </span>
                        </div>
                        <div style={{ marginTop : '1rem', display: 'flex', justifyContent: 'flex-end' }} >
                            <Button label="Validate" icon="pi pi-sort-amount-down" className="p-button-info mr-2" onClick={handleValidateClick} />
                            <Button label="Cancel" className="p-button-secondary mr-2"  icon="pi pi-times" onClick={handleCancelClick} />
                        </div>
                    </div>
                </Card>
                )}
                <DataTable ref={dt} value={items} selection={selectedItems} onSelectionChange={(e) => setSelectedItems(e.value as DocumentDto[])} dataKey="id" className="datatable-responsive" globalFilter={globalFilter} header={header} responsiveLayout="scroll" >
                    <Column selectionMode="multiple" headerStyle={{ width: '4rem' }}> </Column>
                    
                    <Column field="reference" header={t("documentReference")} sortable></Column>
                    
                    
                    <Column field="uploadDate | date :'dd/MM/yyyy HH:mm'" header={t("documentUploadDate")} sortable></Column>
                    
                    
                    <Column field="dateLastUpdate | date :'dd/MM/yyyy HH:mm'" header={t("documentDateLastUpdate")} sortable></Column>
                    
                    
                    <Column field="content" header={t("documentContent")} sortable></Column>
                    
                    
                    <Column field="folder" header={t("documentFolder")} body={CustomBooleanCell} sortable></Column>
                    
                    
                    <Column field="size" header={t("documentSize")} sortable></Column>
                    
                    
                    <Column field="documentType.libelle" header={t("documentDocumentType")} sortable ></Column>
                    
                    
                    <Column field="documentState.libelle" header={t("documentDocumentState")} sortable body={(rowData)=>statusBodyTemplate(rowData.documentState?.libelle,rowData.documentState?.style)}></Column>
                    
                    
                    <Column field="documentCategorie.libelle" header={t("documentDocumentCategorie")} sortable ></Column>
                    
                     {/* 
                    <Column field="utilisateur.nom" header={t("documentUtilisateur")} sortable ></Column>
                     */} 
                     {/* 
                    <Column field="archive" header={t("documentArchive")} body={CustomBooleanCell} sortable></Column>
                     */} 
                     {/* 
                    <Column field="versionne" header={t("documentVersionne")} body={CustomBooleanCell} sortable></Column>
                     */} 
                     {/* 
                    <Column field="entiteAdministrative.libelle" header={t("documentEntiteAdministrative")} sortable ></Column>
                     */} 
                    <Column header="Actions" body={actionBodyTemplate}></Column>
                </DataTable>
                <div className="p-d-flex p-ai-center p-jc-between">
                    <Paginator onPageChange={onPage} first={first} rows={rows} totalRecords={totalRecords} />
                </div>
                {showCreateDialog && <Create visible={showCreateDialog} onClose={() => setShowCreateDialog(false)} add={add} showToast={toast} list={items}  t={t} />}
                {showEditDialog && <Edit  visible={showEditDialog} onClose={() =>  { setShowEditDialog(false); setSelectedItem(null); }} showToast={toast} selectedItem={selectedItem} update={update}   t={t} />}
                {showViewDialog && <View visible={showViewDialog} onClose={() =>  { setShowViewDialog(false); setSelectedItem(null); }} selectedItem={selectedItem}   t={t} />}
                <Dialog visible={deleteItemDialog} style={{width: '450px'}} header="Confirm" modal footer={deleteItemDialogFooter} onHide={hideDeleteItemDialog}>
                    <div className="flex align-items-center justify-content-center">
                    <i className="pi pi-exclamation-triangle mr-3" style={{fontSize: '2rem'}}/>
                    {item && (<span>Are you sure you want to delete document <b>{item.id}</b>?</span>)}
                    </div>
                </Dialog>
                <Dialog visible={deleteItemsDialog} style={{width: '450px'}} header="Confirm" modal footer={deleteItemsDialogFooter} onHide={hideDeleteItemsDialog} >
                    <div className="flex align-items-center justify-content-center">
                    <i className="pi pi-exclamation-triangle mr-3" style={{fontSize: '2rem'}} />
                    {item && <span>Are you sure you want to delete the selected documents?</span>}
                    </div>
                </Dialog>
            </div>
        </div>
    </div>
);
};
export default List;

