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

import {ClientService} from 'app/controller/service/Client.service';
import {ClientDto}  from 'app/controller/model/Client.model';
import {ClientCriteria} from 'app/controller/criteria/ClientCriteria.model';

import {ClientCategoryDto} from 'app/controller/model/ClientCategory.model';
import {ClientCategoryService} from 'app/controller/service/ClientCategory.service';

import Edit from '../edit/client-edit-admin.component';
import Create from '../create/client-create-admin.component';
import View from '../view/client-view-admin.component';

const List = () => {

    const emptyItem = new ClientDto();
    const [items, setItems] = useState<ClientDto[]>([]);
    const [deleteItemDialog, setDeleteItemDialog] = useState(false);
    const [deleteItemsDialog, setDeleteItemsDialog] = useState(false);
    const [item, setItem] = useState<ClientDto>(emptyItem);
    const [selectedItems, setSelectedItems] = useState<ClientDto[]>([]);
    const [globalFilter, setGlobalFilter] = useState('');
    const [showCreateDialog, setShowCreateDialog] = useState<boolean>(false);
    const [showEditDialog, setShowEditDialog] = useState<boolean>(false);
    const [showViewDialog, setShowViewDialog] = useState<boolean>(false);
    const [selectedItem, setSelectedItem] = useState<ClientDto | null>(null);
    const [rows, setRows] = useState<number>(10);
    const [totalRecords, setTotalRecords] = useState(0);
    const [criteria, setCriteria] = useState(new ClientCriteria());
    const [first, setFirst] = useState(0);
    const toast = useRef<Toast>();
    const dt = useRef<DataTable<ClientDto[]>>();
    const [findByCriteriaShow, setFindByCriteriaShow] = useState(false);
    const [isSearchTriggered, setIsSearchTriggered] = useState(false);

    const [clientCategorys, setClientCategorys] = useState<ClientCategoryDto[]>([]);
    type ClientCategoryResponse = AxiosResponse<ClientCategoryDto[]>;

    const showSearch = () => { setFindByCriteriaShow(!findByCriteriaShow); };

    const handleValidateClick = () => {fetchItems(criteria)};

    const handleCancelClick = () => {
        setCriteria(new ClientCriteria());
        fetchItems(new ClientCriteria());
        setIsSearchTriggered(false);
    };

    useEffect(() => {
           const fetchData = async () => {
            try {
                const [clientCategorysResponse ] = await Promise.all<ClientCategoryResponse>([
                    ClientCategoryService.getList(),
                ]);
                setClientCategorys(clientCategorysResponse.data);
            } catch (error) {
                console.error(error);
            }
        };
        fetchData();
        fetchItems(criteria);
    }, []);

    const fetchItems = async (criteria) => {
        try {
            const response = await ClientService.findPaginatedByCriteria(criteria);
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

    const showEditModal = (item: ClientDto) => {
        setSelectedItem(item);
        setShowEditDialog(true);
    };

    const showViewModal = (item: ClientDto) => {
        setSelectedItem(item);
        setShowViewDialog(true);
    };

    const add = (item) => {
        setItems([...items, item]);
    };

    const update = (updatedItem: ClientDto) => {
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

    const confirmDeleteItem = (item: ClientDto) => {
        setSelectedItem(item);
        setDeleteItemDialog(true);
    };

    const deleteItem = async () => {
        try{
            await ClientService.delete(selectedItem?.id);
            setDeleteItemDialog(false);
            setItem(emptyItem);
            let _items = items.filter((val) => val.id !== selectedItem?.id);
            setItems(_items);
            MessageService.showToast(toast, { severity: 'success', summary: 'Successful', detail: 'Client Deleted', life: 3000 });
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
        await ClientService.deleteList(selectedItems);
        let _items = items.filter((val) => !selectedItems.includes(val));
        setItems(_items);
        setDeleteItemsDialog(false);
        setSelectedItems(null);
        MessageService.showToast(toast, { severity: 'success', summary: 'Successful', detail: 'Clients Deleted', life: 3000 });
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

    const actionBodyTemplate = (rowData: ClientDto) => {
       return ( <>
           <Button icon="pi pi-pencil" rounded severity="success" className="mr-1" onClick={() => showEditModal(rowData)} />
           <Button icon="pi pi-trash" rounded  severity="danger" className="mr-1"  onClick={() => confirmDeleteItem(rowData)} />
           <Button icon="pi pi-eye" rounded severity="info" className="mr-1" onClick={() => showViewModal(rowData)} /> </>
       );
    };

    const header = (
        <div className="flex flex-column md:flex-row md:justify-content-between md:align-items-center">
        <h5 className="m-0">Manage clients</h5>
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
                                <InputText id="1" value={criteria.fullName} onChange={(e) => setCriteria({ ...criteria, fullName: e.target.value })} />
                                <label htmlFor="1">FullName</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <InputText id="2" value={criteria.email} onChange={(e) => setCriteria({ ...criteria, email: e.target.value })} />
                                <label htmlFor="2">Email</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <Calendar id="3-1" value={criteria.dateRegistrationFrom} onChange={(e) => setCriteria({ ...criteria, dateRegistrationFrom: e.value as Date })} dateFormat="dd-MM-yy" />
                                <label htmlFor="3-1">DateRegistration Min</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <Calendar id="3-2" value={criteria.dateRegistrationTo} onChange={(e) => setCriteria({ ...criteria, dateRegistrationTo: e.value as Date })} dateFormat="dd-MM-yy" />
                                <label htmlFor="3-2">DateRegistration Max</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <InputNumber id="4-1" value={criteria.nombreEnfantMin} onChange={(e) => setCriteria({ ...criteria, nombreEnfantMin: e.value })} mode="decimal" />
                                <label htmlFor="4-1">NombreEnfant Min</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <InputNumber id="4-2" value={criteria.nombreEnfantMax} onChange={(e) => setCriteria({ ...criteria, nombreEnfantMax: e.value })} mode="decimal" />
                                <label htmlFor="4-2">NombreEnfant Max</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <Dropdown id="5" value={criteria.clientCategory} options={clientCategorys} onChange={(e) => setCriteria({ ...criteria, clientCategory: e.target.value })} optionLabel="reference" filter showClear placeholder="ClientCategory" />
                            </span>
                        </div>
                        <div style={{ marginTop : '1rem', display: 'flex', justifyContent: 'flex-end' }} >
                            <Button label="Validate" icon="pi pi-sort-amount-down" className="p-button-info mr-2" onClick={handleValidateClick} />
                            <Button label="Cancel" className="p-button-secondary mr-2"  icon="pi pi-times" onClick={handleCancelClick} />
                        </div>
                    </div>
                </Card>
                )}
                <DataTable ref={dt} value={items} selection={selectedItems} onSelectionChange={(e) => setSelectedItems(e.value as ClientDto[])} dataKey="id" className="datatable-responsive" globalFilter={globalFilter} header={header} responsiveLayout="scroll" >
                    <Column selectionMode="multiple" headerStyle={{ width: '4rem' }}> </Column>
                    
                    <Column field="fullName" header="FullName" sortable></Column>
                    
                    
                    <Column field="email" header="Email" sortable></Column>
                    
                    
                    <Column field="dateRegistration | date :'dd/MM/yyyy HH:mm'" header="DateRegistration" sortable></Column>
                    
                    
                    <Column field="nombreEnfant" header="NombreEnfant" sortable></Column>
                    
                    
                    <Column field="clientCategory.reference" header="ClientCategory" sortable></Column>
                    
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
                    {item && (<span>Are you sure you want to delete client <b>{item.id}</b>?</span>)}
                    </div>
                </Dialog>
                <Dialog visible={deleteItemsDialog} style={{width: '450px'}} header="Confirm" modal footer={deleteItemsDialogFooter} onHide={hideDeleteItemsDialog} >
                    <div className="flex align-items-center justify-content-center">
                    <i className="pi pi-exclamation-triangle mr-3" style={{fontSize: '2rem'}} />
                    {item && <span>Are you sure you want to delete the selected clients?</span>}
                    </div>
                </Dialog>
            </div>
        </div>
    </div>
);
};
export default List;

