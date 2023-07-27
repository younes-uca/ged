import {Button} from 'primereact/button';
import {Column} from 'primereact/column';
import 'primereact/resources/themes/saga-blue/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';
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

import {MessageService} from 'app/controller/service/MessageService';

import {DocumentService} from 'app/controller/service/Document.service';
import {DocumentDto}  from 'app/controller/model/Document.model';
import {DocumentCriteria} from 'app/controller/criteria/DocumentCriteria.model';

import {DocumentPartageGroupeDto} from 'app/controller/model/DocumentPartageGroupe.model';
import {DocumentPartageGroupeService} from 'app/controller/service/DocumentPartageGroupe.service';
import {DocumentPartageUtilisateurDto} from 'app/controller/model/DocumentPartageUtilisateur.model';
import {DocumentPartageUtilisateurService} from 'app/controller/service/DocumentPartageUtilisateur.service';
import {AcessShareDto} from 'app/controller/model/AcessShare.model';
import {AcessShareService} from 'app/controller/service/AcessShare.service';
import {UtilisateurDto} from 'app/controller/model/Utilisateur.model';
import {UtilisateurService} from 'app/controller/service/Utilisateur.service';
import {DocumentAcessShareDto} from 'app/controller/model/DocumentAcessShare.model';
import {DocumentAcessShareService} from 'app/controller/service/DocumentAcessShare.service';
import {DocumentTypeDto} from 'app/controller/model/DocumentType.model';
import {DocumentTypeService} from 'app/controller/service/DocumentType.service';
import {DocumentManagementUtilisateurDto} from 'app/controller/model/DocumentManagementUtilisateur.model';
import {DocumentManagementUtilisateurService} from 'app/controller/service/DocumentManagementUtilisateur.service';
import {DocumentManagementGroupeDto} from 'app/controller/model/DocumentManagementGroupe.model';
import {DocumentManagementGroupeService} from 'app/controller/service/DocumentManagementGroupe.service';
import {AcessManagementDto} from 'app/controller/model/AcessManagement.model';
import {AcessManagementService} from 'app/controller/service/AcessManagement.service';
import {DocumentTagDto} from 'app/controller/model/DocumentTag.model';
import {DocumentTagService} from 'app/controller/service/DocumentTag.service';
import {TagDto} from 'app/controller/model/Tag.model';
import {TagService} from 'app/controller/service/Tag.service';
import {GroupeDto} from 'app/controller/model/Groupe.model';
import {GroupeService} from 'app/controller/service/Groupe.service';
import {EntiteAdministrativeDto} from 'app/controller/model/EntiteAdministrative.model';
import {EntiteAdministrativeService} from 'app/controller/service/EntiteAdministrative.service';

import Edit from '../edit/document-edit-admin.component';
import Create from '../create/document-create-admin.component';
import View from '../view/document-view-admin.component';

const List = () => {

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

    const [documentPartageGroupes, setDocumentPartageGroupes] = useState<DocumentPartageGroupeDto[]>([]);
    type DocumentPartageGroupeResponse = AxiosResponse<DocumentPartageGroupeDto[]>;
    const [documentPartageUtilisateurs, setDocumentPartageUtilisateurs] = useState<DocumentPartageUtilisateurDto[]>([]);
    type DocumentPartageUtilisateurResponse = AxiosResponse<DocumentPartageUtilisateurDto[]>;
    const [acessShares, setAcessShares] = useState<AcessShareDto[]>([]);
    type AcessShareResponse = AxiosResponse<AcessShareDto[]>;
    const [utilisateurs, setUtilisateurs] = useState<UtilisateurDto[]>([]);
    type UtilisateurResponse = AxiosResponse<UtilisateurDto[]>;
    const [documentAcessShares, setDocumentAcessShares] = useState<DocumentAcessShareDto[]>([]);
    type DocumentAcessShareResponse = AxiosResponse<DocumentAcessShareDto[]>;
    const [documentTypes, setDocumentTypes] = useState<DocumentTypeDto[]>([]);
    type DocumentTypeResponse = AxiosResponse<DocumentTypeDto[]>;
    const [documentManagementUtilisateurs, setDocumentManagementUtilisateurs] = useState<DocumentManagementUtilisateurDto[]>([]);
    type DocumentManagementUtilisateurResponse = AxiosResponse<DocumentManagementUtilisateurDto[]>;
    const [documentManagementGroupes, setDocumentManagementGroupes] = useState<DocumentManagementGroupeDto[]>([]);
    type DocumentManagementGroupeResponse = AxiosResponse<DocumentManagementGroupeDto[]>;
    const [acessManagements, setAcessManagements] = useState<AcessManagementDto[]>([]);
    type AcessManagementResponse = AxiosResponse<AcessManagementDto[]>;
    const [documentTags, setDocumentTags] = useState<DocumentTagDto[]>([]);
    type DocumentTagResponse = AxiosResponse<DocumentTagDto[]>;
    const [tags, setTags] = useState<TagDto[]>([]);
    type TagResponse = AxiosResponse<TagDto[]>;
    const [groupes, setGroupes] = useState<GroupeDto[]>([]);
    type GroupeResponse = AxiosResponse<GroupeDto[]>;
    const [entiteAdministratives, setEntiteAdministratives] = useState<EntiteAdministrativeDto[]>([]);
    type EntiteAdministrativeResponse = AxiosResponse<EntiteAdministrativeDto[]>;

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
                const [utilisateursResponse ,entiteAdministrativesResponse ,groupesResponse ,documentTypesResponse ,tagsResponse ,acessManagementsResponse ,acessSharesResponse ] = await Promise.all<UtilisateurResponse,EntiteAdministrativeResponse,GroupeResponse,DocumentTypeResponse,TagResponse,AcessManagementResponse,AcessShareResponse>([
                    DocumentTypeService.getList(),
                    TagService.getList(),
                ]);
                setUtilisateurs(utilisateursResponse.data);
                setEntiteAdministratives(entiteAdministrativesResponse.data);
                setGroupes(groupesResponse.data);
                setDocumentTypes(documentTypesResponse.data);
                setTags(tagsResponse.data);
                setAcessManagements(acessManagementsResponse.data);
                setAcessShares(acessSharesResponse.data);
            } catch (error) {
                console.error(error);
            }
        };
        fetchData();
        fetchItems(criteria);
    }, []);

    const fetchItems = async (criteria) => {
        try {
            const response = await DocumentService.findPaginatedByCriteria(criteria);
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

    const deleteItem = async () => {
        try{
            await DocumentService.delete(selectedItem?.id);
            setDeleteItemDialog(false);
            setItem(emptyItem);
            let _items = items.filter((val) => val.id !== selectedItem?.id);
            setItems(_items);
            MessageService.showToast(toast, { severity: 'success', summary: 'Successful', detail: 'Document Deleted', life: 3000 });
        } catch (error) {
            console.log(error);
        }
    };

    const exportCSV = () => {
        dt.current?.exportCSV();
    };

    const confirmDeleteSelected = () => {
        setDeleteItemsDialog(true);
    };

    const deleteSelectedItems = async () => {
        await DocumentService.deleteList(selectedItems);
        let _items = items.filter((val) => !selectedItems.includes(val));
        setItems(_items);
        setDeleteItemsDialog(false);
        setSelectedItems(null);
        MessageService.showToast(toast, { severity: 'success', summary: 'Successful', detail: 'Documents Deleted', life: 3000 });
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
                                <label htmlFor="1">Reference</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <Calendar id="2-1" value={criteria.uploadDateFrom} onChange={(e) => setCriteria({ ...criteria, uploadDateFrom: e.value as Date })} dateFormat="dd-MM-yy" />
                                <label htmlFor="2-1">UploadDate Min</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <Calendar id="2-2" value={criteria.uploadDateTo} onChange={(e) => setCriteria({ ...criteria, uploadDateTo: e.value as Date })} dateFormat="dd-MM-yy" />
                                <label htmlFor="2-2">UploadDate Max</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <Calendar id="3-1" value={criteria.dateLastUpdateFrom} onChange={(e) => setCriteria({ ...criteria, dateLastUpdateFrom: e.value as Date })} dateFormat="dd-MM-yy" />
                                <label htmlFor="3-1">DateLastUpdate Min</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <Calendar id="3-2" value={criteria.dateLastUpdateTo} onChange={(e) => setCriteria({ ...criteria, dateLastUpdateTo: e.value as Date })} dateFormat="dd-MM-yy" />
                                <label htmlFor="3-2">DateLastUpdate Max</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <InputText id="4" value={criteria.content} onChange={(e) => setCriteria({ ...criteria, content: e.target.value })} />
                                <label htmlFor="4">Content</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <InputNumber id="5-1" value={criteria.sizeMin} onChange={(e) => setCriteria({ ...criteria, sizeMin: e.value })} mode="decimal" />
                                <label htmlFor="5-1">Size Min</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <InputNumber id="5-2" value={criteria.sizeMax} onChange={(e) => setCriteria({ ...criteria, sizeMax: e.value })} mode="decimal" />
                                <label htmlFor="5-2">Size Max</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <Dropdown id="6" value={criteria.documentType} options={documentTypes} onChange={(e) => setCriteria({ ...criteria, documentType: e.target.value })} optionLabel="libelle" filter showClear placeholder="DocumentType" />
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <InputText id="7" value={criteria.description} onChange={(e) => setCriteria({ ...criteria, description: e.target.value })} />
                                <label htmlFor="7">Description</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <Dropdown id="8" value={criteria.utilisateur} options={utilisateurs} onChange={(e) => setCriteria({ ...criteria, utilisateur: e.target.value })} optionLabel="name" filter showClear placeholder="Utilisateur" />
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <Dropdown id="11" value={criteria.entiteAdministrative} options={entiteAdministratives} onChange={(e) => setCriteria({ ...criteria, entiteAdministrative: e.target.value })} optionLabel="libelle" filter showClear placeholder="EntiteAdministrative" />
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
                    
                    <Column field="reference" header="Reference" sortable></Column>
                    
                    
                    <Column field="uploadDate | date :'dd/MM/yyyy HH:mm'" header="UploadDate" sortable></Column>
                    
                    
                    <Column field="dateLastUpdate | date :'dd/MM/yyyy HH:mm'" header="DateLastUpdate" sortable></Column>
                    
                    
                    <Column field="content" header="Content" sortable></Column>
                    
                    
                    <Column field="size" header="Size" sortable></Column>
                    
                    
                    <Column field="documentType.libelle" header="DocumentType" sortable></Column>
                    
                    
                    <Column field="utilisateur.name" header="Utilisateur" sortable></Column>
                    
                    
                    <Column field="archive" header="Archive" body={CustomBooleanCell} sortable></Column>
                    
                    
                    <Column field="versionne" header="Versionne" body={CustomBooleanCell} sortable></Column>
                    
                     {/* 
                    <Column field="entiteAdministrative.libelle" header="EntiteAdministrative" sortable></Column>
                     */} 
                    <Column header="Actions" body={actionBodyTemplate}></Column>
                </DataTable>
                <div className="p-d-flex p-ai-center p-jc-between">
                    <Paginator onPageChange={onPage} first={first} rows={rows} totalRecords={totalRecords} />
                </div>
                <Create visible={showCreateDialog} onClose={() => setShowCreateDialog(false)} add={add} showToast={toast} list={items} />
                <Edit  visible={showEditDialog} onClose={() =>  { setShowEditDialog(false); setSelectedItem(null); }} showToast={toast} selectedItem={selectedItem} update={update} />
                <View visible={showViewDialog} onClose={() =>  { setShowViewDialog(false); setSelectedItem(null); }} selectedItem={selectedItem} />
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

