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

import {MessageService} from 'app/zynerator/service/MessageService';

import {DocumentPartageUtilisateurAdminService} from 'app/controller/service/admin/DocumentPartageUtilisateurAdminService.service';
import {DocumentPartageUtilisateurDto}  from 'app/controller/model/DocumentPartageUtilisateur.model';
import {DocumentPartageUtilisateurCriteria} from 'app/controller/criteria/DocumentPartageUtilisateurCriteria.model';

import {AccessShareDto} from 'app/controller/model/AccessShare.model';
import {AccessShareAdminService} from 'app/controller/service/admin/AccessShareAdminService.service';
import {DocumentDto} from 'app/controller/model/Document.model';
import {DocumentAdminService} from 'app/controller/service/admin/DocumentAdminService.service';
import {UtilisateurDto} from 'app/controller/model/Utilisateur.model';
import {UtilisateurAdminService} from 'app/controller/service/admin/UtilisateurAdminService.service';

import Edit from '../edit/document-partage-utilisateur-edit-admin.component';
import Create from '../create/document-partage-utilisateur-create-admin.component';
import View from '../view/document-partage-utilisateur-view-admin.component';

const List = () => {

    const emptyItem = new DocumentPartageUtilisateurDto();
    const [items, setItems] = useState<DocumentPartageUtilisateurDto[]>([]);
    const [deleteItemDialog, setDeleteItemDialog] = useState(false);
    const [deleteItemsDialog, setDeleteItemsDialog] = useState(false);
    const [item, setItem] = useState<DocumentPartageUtilisateurDto>(emptyItem);
    const [selectedItems, setSelectedItems] = useState<DocumentPartageUtilisateurDto[]>([]);
    const [globalFilter, setGlobalFilter] = useState('');
    const [showCreateDialog, setShowCreateDialog] = useState<boolean>(false);
    const [showEditDialog, setShowEditDialog] = useState<boolean>(false);
    const [showViewDialog, setShowViewDialog] = useState<boolean>(false);
    const [selectedItem, setSelectedItem] = useState<DocumentPartageUtilisateurDto | null>(null);
    const [rows, setRows] = useState<number>(10);
    const [totalRecords, setTotalRecords] = useState(0);
    const [criteria, setCriteria] = useState(new DocumentPartageUtilisateurCriteria());
    const [first, setFirst] = useState(0);
    const toast = useRef<Toast>();
    const dt = useRef<DataTable<DocumentPartageUtilisateurDto[]>>();
    const [findByCriteriaShow, setFindByCriteriaShow] = useState(false);
    const [isSearchTriggered, setIsSearchTriggered] = useState(false);

    const [accessShares, setAccessShares] = useState<AccessShareDto[]>([]);
    type AccessShareResponse = AxiosResponse<AccessShareDto[]>;
    const [documents, setDocuments] = useState<DocumentDto[]>([]);
    type DocumentResponse = AxiosResponse<DocumentDto[]>;
    const [utilisateurs, setUtilisateurs] = useState<UtilisateurDto[]>([]);
    type UtilisateurResponse = AxiosResponse<UtilisateurDto[]>;

    const showSearch = () => { setFindByCriteriaShow(!findByCriteriaShow); };

    const handleValidateClick = () => {fetchItems(criteria)};

    const handleCancelClick = () => {
        setCriteria(new DocumentPartageUtilisateurCriteria());
        fetchItems(new DocumentPartageUtilisateurCriteria());
        setIsSearchTriggered(false);
    };

    useEffect(() => {
           const fetchData = async () => {
            try {
                const [utilisateursResponse ,documentsResponse ,accessSharesResponse ] = await Promise.all<UtilisateurResponse,DocumentResponse,AccessShareResponse>([
                    DocumentAdminService.getList(),
                ]);
                setUtilisateurs(utilisateursResponse.data);
                setDocuments(documentsResponse.data);
                setAccessShares(accessSharesResponse.data);
            } catch (error) {
                console.error(error);
            }
        };
        fetchData();
        fetchItems(criteria);
    }, []);

    const fetchItems = async (criteria) => {
        try {
            const response = await DocumentPartageUtilisateurAdminService.findPaginatedByCriteria(criteria);
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

    const showEditModal = (item: DocumentPartageUtilisateurDto) => {
        setSelectedItem(item);
        setShowEditDialog(true);
    };

    const showViewModal = (item: DocumentPartageUtilisateurDto) => {
        setSelectedItem(item);
        setShowViewDialog(true);
    };

    const add = (item) => {
        setItems([...items, item]);
    };

    const update = (updatedItem: DocumentPartageUtilisateurDto) => {
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

    const confirmDeleteItem = (item: DocumentPartageUtilisateurDto) => {
        setSelectedItem(item);
        setDeleteItemDialog(true);
    };


    const deleteItem = async () => {
        try{
            await DocumentPartageUtilisateurAdminService.delete(selectedItem?.id);
            setDeleteItemDialog(false);
            setItem(emptyItem);
            let _items = items.filter((val) => val.id !== selectedItem?.id);
            setItems(_items);
            MessageService.showSuccess(toast, 'DocumentPartageUtilisateur Deleted');
        } catch (error) {
            MessageService.showError(toast, 'DocumentPartageUtilisateur Deletion Prob');
        }
    };

    const exportCSV = () => {
        dt.current?.exportCSV();
    };

    const confirmDeleteSelected = () => {
        setDeleteItemsDialog(true);
    };

    const deleteSelectedItems = async () => {
        await DocumentPartageUtilisateurAdminService.deleteList(selectedItems);
        let _items = items.filter((val) => !selectedItems.includes(val));
        setItems(_items);
        setDeleteItemsDialog(false);
        setSelectedItems(null);
        MessageService.showSuccess(toast, 'DocumentPartageUtilisateurs Deleted');
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

    const actionBodyTemplate = (rowData: DocumentPartageUtilisateurDto) => {
       return ( <>
           <Button icon="pi pi-pencil" rounded severity="success" className="mr-1" onClick={() => showEditModal(rowData)} />
           <Button icon="pi pi-trash" rounded  severity="danger" className="mr-1"  onClick={() => confirmDeleteItem(rowData)} />
           <Button icon="pi pi-eye" rounded severity="info" className="mr-1" onClick={() => showViewModal(rowData)} /> </>
       );
    };

    const header = (
        <div className="flex flex-column md:flex-row md:justify-content-between md:align-items-center">
        <h5 className="m-0">Manage document partage utilisateurs</h5>
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
                                <Dropdown id="1" value={criteria.document} options={documents} onChange={(e) => setCriteria({ ...criteria, document: e.target.value })} optionLabel="reference" filter showClear placeholder="Document" />
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <Dropdown id="2" value={criteria.utilisateur} options={utilisateurs} onChange={(e) => setCriteria({ ...criteria, utilisateur: e.target.value })} optionLabel="nom" filter showClear placeholder="Utilisateur" />
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <Calendar id="3-1" value={criteria.dateShareFrom} onChange={(e) => setCriteria({ ...criteria, dateShareFrom: e.value as Date })} dateFormat="dd-MM-yy" />
                                <label htmlFor="3-1">Date share Min</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <Calendar id="3-2" value={criteria.dateShareTo} onChange={(e) => setCriteria({ ...criteria, dateShareTo: e.value as Date })} dateFormat="dd-MM-yy" />
                                <label htmlFor="3-2">Date share Max</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <Dropdown id="4" value={criteria.accessShare} options={accessShares} onChange={(e) => setCriteria({ ...criteria, accessShare: e.target.value })} optionLabel="libelle" filter showClear placeholder="AccessShare" />
                            </span>
                        </div>
                        <div style={{ marginTop : '1rem', display: 'flex', justifyContent: 'flex-end' }} >
                            <Button label="Validate" icon="pi pi-sort-amount-down" className="p-button-info mr-2" onClick={handleValidateClick} />
                            <Button label="Cancel" className="p-button-secondary mr-2"  icon="pi pi-times" onClick={handleCancelClick} />
                        </div>
                    </div>
                </Card>
                )}
                <DataTable ref={dt} value={items} selection={selectedItems} onSelectionChange={(e) => setSelectedItems(e.value as DocumentPartageUtilisateurDto[])} dataKey="id" className="datatable-responsive" globalFilter={globalFilter} header={header} responsiveLayout="scroll" >
                    <Column selectionMode="multiple" headerStyle={{ width: '4rem' }}> </Column>
                    
                    <Column field="document.reference" header="Document" sortable ></Column>
                    
                    
                    <Column field="utilisateur.nom" header="Utilisateur" sortable ></Column>
                    
                    
                    <Column field="dateShare | date :'dd/MM/yyyy HH:mm'" header="Date share" sortable></Column>
                    
                    
                    <Column field="accessShare.libelle" header="Access share" sortable ></Column>
                    
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
                    {item && (<span>Are you sure you want to delete document partage utilisateur <b>{item.id}</b>?</span>)}
                    </div>
                </Dialog>
                <Dialog visible={deleteItemsDialog} style={{width: '450px'}} header="Confirm" modal footer={deleteItemsDialogFooter} onHide={hideDeleteItemsDialog} >
                    <div className="flex align-items-center justify-content-center">
                    <i className="pi pi-exclamation-triangle mr-3" style={{fontSize: '2rem'}} />
                    {item && <span>Are you sure you want to delete the selected document partage utilisateurs?</span>}
                    </div>
                </Dialog>
            </div>
        </div>
    </div>
);
};
export default List;

