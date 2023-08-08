import {Button} from 'primereact/button';
import {Column} from 'primereact/column';

import {Tag} from 'primereact/tag';

import {DataTable} from 'primereact/datatable';
import {Dialog} from 'primereact/dialog';
import {FileUpload} from 'primereact/fileupload';
import {InputText} from 'primereact/inputtext';
import {Toast} from 'primereact/toast';
import {Toolbar} from 'primereact/toolbar';
import React, {useEffect, useRef, useState} from 'react';
import {Paginator, PaginatorPageChangeEvent} from 'primereact/paginator';
import {Card} from 'primereact/card';
import {Calendar} from 'primereact/calendar';
import {InputNumber} from 'primereact/inputnumber';
import {Dropdown} from 'primereact/dropdown';
import {format} from "date-fns";
import useListHook from "app/component/zyhook/useListhook";
import {MessageService} from 'app/zynerator/service/MessageService';


import {DocumentAdminService} from 'app/controller/service/admin/DocumentAdminService.service';
import {DocumentDto}  from 'app/controller/model/Document.model';
import {DocumentCriteria} from 'app/controller/criteria/DocumentCriteria.model';

import {DocumentTypeDto} from 'app/controller/model/DocumentType.model';
import {DocumentTypeAdminService} from 'app/controller/service/admin/DocumentTypeAdminService.service';
import {DocumentStateDto} from 'app/controller/model/DocumentState.model';
import {DocumentStateAdminService} from 'app/controller/service/admin/DocumentStateAdminService.service';
import {DocumentCategorieDto} from 'app/controller/model/DocumentCategorie.model';
import {DocumentCategorieAdminService} from 'app/controller/service/admin/DocumentCategorieAdminService.service';
import {UtilisateurDto} from 'app/controller/model/Utilisateur.model';
import {UtilisateurAdminService} from 'app/controller/service/admin/UtilisateurAdminService.service';
import {EntiteAdministrativeDto} from 'app/controller/model/EntiteAdministrative.model';
import {EntiteAdministrativeAdminService} from 'app/controller/service/admin/EntiteAdministrativeAdminService.service';

import { useTranslation } from 'react-i18next';

import Edit from '../edit/document-edit-admin.component';
import Create from '../create/document-create-admin.component';
import View from '../view/document-view-admin.component';


const List = () => {

    const { t } = useTranslation();

    const emptyItem = new DocumentDto();
    const emptyCriteria = new DocumentCriteria();
    const service = new DocumentAdminService();


    const {
        items,
        showSearch,
        deleteItemDialog,
        item,
        selectedItems,
        setSelectedItems,
        hideDeleteItemDialog,
        globalFilter,
        setGlobalFilter,
        showCreateDialog,
        setShowCreateDialog,
        showEditDialog,
        setShowEditDialog,
        showViewDialog,
        setShowViewDialog,
        selectedItem,
        setSelectedItem,
        rows,
        totalRecords,
        criteria,
        setCriteria,
        first,
        fetchItems,
        toast,
        dt,
        findByCriteriaShow,
        handleCancelClick,
        confirmDeleteSelected,
        exportCSV,
        deleteItem,
        deleteItemDialogFooter,
        leftToolbarTemplate,
        rightToolbarTemplate,
        actionBodyTemplate,
        header,
        CustomBooleanCell,
        handleValidateClick,
        onPage,
        showCreateModal,
        showEditModal,
        showViewModal,
        add,
        update,
        confirmDeleteItem,
        statusBodyTemplate,
        formateDate
    } = useListHook<DocumentDto, DocumentCriteria>({ emptyItem, emptyCriteria,service, t})



    const [documentTypes, setDocumentTypes] = useState<DocumentTypeDto[]>([]);
    const [documentStates, setDocumentStates] = useState<DocumentStateDto[]>([]);
    const [documentCategories, setDocumentCategories] = useState<DocumentCategorieDto[]>([]);
    const [utilisateurs, setUtilisateurs] = useState<UtilisateurDto[]>([]);
    const [entiteAdministratives, setEntiteAdministratives] = useState<EntiteAdministrativeDto[]>([]);

    const documentTypeAdminService = new DocumentTypeAdminService();
    const documentStateAdminService = new DocumentStateAdminService();
    const documentCategorieAdminService = new DocumentCategorieAdminService();
    const utilisateurAdminService = new UtilisateurAdminService();
    const entiteAdministrativeAdminService = new EntiteAdministrativeAdminService();

    useEffect(() => {

        documentTypeAdminService.getList().then(({data}) => setDocumentTypes(data)).catch(error => console.log(error));
        documentStateAdminService.getList().then(({data}) => setDocumentStates(data)).catch(error => console.log(error));
        documentCategorieAdminService.getList().then(({data}) => setDocumentCategories(data)).catch(error => console.log(error));
        utilisateurAdminService.getList().then(({data}) => setUtilisateurs(data)).catch(error => console.log(error));
        entiteAdministrativeAdminService.getList().then(({data}) => setEntiteAdministratives(data)).catch(error => console.log(error));
        fetchItems(criteria);
    }, []);

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
                                <label htmlFor="1">{t("document.reference")}</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <Calendar id="3-1" value={criteria.uploadDateFrom} onChange={(e) => setCriteria({ ...criteria, uploadDateFrom: e.value as Date })} dateFormat="dd-MM-yy" showIcon={true} />
                                <label htmlFor="3-1">{t("document.uploadDateMin")}</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <Calendar id="3-2" value={criteria.uploadDateTo} onChange={(e) => setCriteria({ ...criteria, uploadDateTo: e.value as Date })} dateFormat="dd-MM-yy" showIcon={true} />
                                <label htmlFor="3-2">{t("document.uploadDateMax")}</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <Calendar id="4-1" value={criteria.dateLastUpdateFrom} onChange={(e) => setCriteria({ ...criteria, dateLastUpdateFrom: e.value as Date })} dateFormat="dd-MM-yy" showIcon={true} />
                                <label htmlFor="4-1">{t("document.dateLastUpdateMin")}</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <Calendar id="4-2" value={criteria.dateLastUpdateTo} onChange={(e) => setCriteria({ ...criteria, dateLastUpdateTo: e.value as Date })} dateFormat="dd-MM-yy" showIcon={true} />
                                <label htmlFor="4-2">{t("document.dateLastUpdateMax")}</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <InputText id="5" value={criteria.content} onChange={(e) => setCriteria({ ...criteria, content: e.target.value })} />
                                <label htmlFor="5">{t("document.content")}</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <InputNumber id="7-1" value={criteria.sizeMin} onChange={(e) => setCriteria({ ...criteria, sizeMin: e.value })} mode="decimal" />
                                <label htmlFor="7-1">{t("document.sizeMin")}</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <InputNumber id="7-2" value={criteria.sizeMax} onChange={(e) => setCriteria({ ...criteria, sizeMax: e.value })} mode="decimal" />
                                <label htmlFor="7-2">{t("document.sizeMax")}  </label>
                            </span>
                            <span className="mr-3 align-search-items mt-4">
                                <Dropdown id="8" value={criteria.documentType} options={documentTypes} onChange={(e) => setCriteria({ ...criteria, documentType: e.target.value })} optionLabel="libelle" filter showClear placeholder={t("document.documentTypePlaceHolder")} filterPlaceholder={t("document.documentTypePlaceHolderFilter")} />
                            </span>
                            <span className="mr-3 align-search-items mt-4">
                                <Dropdown id="9" value={criteria.documentState} options={documentStates} onChange={(e) => setCriteria({ ...criteria, documentState: e.target.value })} optionLabel="libelle" filter showClear placeholder={t("document.documentStatePlaceHolder")} filterPlaceholder={t("document.documentStatePlaceHolderFilter")} />
                            </span>
                            <span className="mr-3 align-search-items mt-4">
                                <Dropdown id="10" value={criteria.documentCategorie} options={documentCategories} onChange={(e) => setCriteria({ ...criteria, documentCategorie: e.target.value })} optionLabel="libelle" filter showClear placeholder={t("document.documentCategoriePlaceHolder")} filterPlaceholder={t("document.documentCategoriePlaceHolderFilter")} />
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <InputText id="12" value={criteria.description} onChange={(e) => setCriteria({ ...criteria, description: e.target.value })} />
                                <label htmlFor="12">{t("document.description")}</label>
                            </span>
                            <span className="mr-3 align-search-items mt-4">
                                <Dropdown id="13" value={criteria.utilisateur} options={utilisateurs} onChange={(e) => setCriteria({ ...criteria, utilisateur: e.target.value })} optionLabel="nom" filter showClear placeholder={t("document.utilisateurPlaceHolder")} filterPlaceholder={t("document.utilisateurPlaceHolderFilter")} />
                            </span>
                            <span className="mr-3 align-search-items mt-4">
                                <Dropdown id="16" value={criteria.entiteAdministrative} options={entiteAdministratives} onChange={(e) => setCriteria({ ...criteria, entiteAdministrative: e.target.value })} optionLabel="libelle" filter showClear placeholder={t("document.entiteAdministrativePlaceHolder")} filterPlaceholder={t("document.entiteAdministrativePlaceHolderFilter")} />
                            </span>
                        </div>
                        <div style={{ marginTop : '1rem', display: 'flex', justifyContent: 'flex-end' }} >
                            <Button label={t("validate")} icon="pi pi-sort-amount-down" className="p-button-info mr-2" onClick={handleValidateClick} />
                            <Button label={t("cancel")} className="p-button-secondary mr-2"  icon="pi pi-times" onClick={handleCancelClick} />
                        </div>
                    </div>
                </Card>
                )}
                <DataTable ref={dt} value={items} selection={selectedItems} onSelectionChange={(e) => setSelectedItems(e.value as DocumentDto[])} dataKey="id" className="datatable-responsive" globalFilter={globalFilter} header={header} responsiveLayout="scroll" >
                    <Column selectionMode="multiple" headerStyle={{ width: '4rem' }}> </Column>
                    
                    <Column field="reference" header={t("document.reference")} sortable></Column>
                    
                    
                    <Column field="referenceGed" header={t("document.referenceGed")} sortable></Column>
                    
                    
                    <Column field="uploadDate" header={t("document.uploadDate")} sortable body={formateDate("uploadDate")}></Column>
                    
                    
                    <Column field="dateLastUpdate" header={t("document.dateLastUpdate")} sortable body={formateDate("dateLastUpdate")}></Column>
                    
                    
                    <Column field="content" header={t("document.content")} sortable></Column>
                    
                    
                    <Column field="folder" header={t("document.folder")} body={CustomBooleanCell("folder")} sortable></Column>
                    
                    
                    <Column field="size" header={t("document.size")} sortable></Column>
                    
                    
                    <Column field="documentType.libelle" header={t("document.documentType")} sortable ></Column>
                    
                    
                    <Column field="documentState.libelle" header={t("document.documentState")} sortable body={(rowData)=>statusBodyTemplate(rowData.documentState?.libelle,rowData.documentState?.style)}></Column>
                    
                     {/* 
                    <Column field="documentCategorie.libelle" header={t("document.documentCategorie")} sortable ></Column>
                     */} 
                     {/* 
                    <Column field="utilisateur.nom" header={t("document.utilisateur")} sortable ></Column>
                     */} 
                     {/* 
                    <Column field="archive" header={t("document.archive")} body={CustomBooleanCell("archive")} sortable></Column>
                     */} 
                     {/* 
                    <Column field="versionne" header={t("document.versionne")} body={CustomBooleanCell("versionne")} sortable></Column>
                     */} 
                     {/* 
                    <Column field="entiteAdministrative.libelle" header={t("document.entiteAdministrative")} sortable ></Column>
                     */} 
                    <Column header={t("actions")} body={actionBodyTemplate}></Column>
                </DataTable>
                <div className="p-d-flex p-ai-center p-jc-between">
                    <Paginator onPageChange={onPage} first={first} rows={rows} totalRecords={totalRecords} />
                </div>
                {showCreateDialog && <Create visible={showCreateDialog} onClose={() => setShowCreateDialog(false)} add={add} showToast={toast} list={items} service={service} t={t} />}

                {showEditDialog && <Edit  visible={showEditDialog} onClose={() =>  { setShowEditDialog(false); setSelectedItem(emptyItem); }} showToast={toast} selectedItem={selectedItem} update={update} list={items} service={service}   t={t} />}

                {showViewDialog && <View visible={showViewDialog} onClose={() =>  { setShowViewDialog(false); setSelectedItem(emptyItem); }} selectedItem={selectedItem}   t={t} />}
                <Dialog visible={deleteItemDialog} style={{width: '450px'}} header={t("confirm")} modal footer={deleteItemDialogFooter} onHide={hideDeleteItemDialog}>
                    <div className="flex align-items-center justify-content-center">
                    <i className="pi pi-exclamation-triangle mr-3" style={{fontSize: '2rem'}}/>
                    {item && (<span>{t("deleteDocumentConfirmationMessage")} <b>{item.reference}</b>?</span>)}
                    </div>
                </Dialog>

            </div>
        </div>
    </div>
);
};
export default List;

