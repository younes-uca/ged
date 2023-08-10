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
        formateDate,
        deleteSelectedItems,
        deleteItemsDialog,
        deleteItemsDialogFooter,
        hideDeleteItemsDialog
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
                <Card title={t("search")} className="mb-5">
                        <div className="grid">
                            <div className="flex flex-column col-3">
                                <label className="mb-1"  htmlFor="1">{t("document.reference")}</label>
                                <InputText id="1" value={criteria.reference} onChange={(e) => setCriteria({ ...criteria, reference: e.target.value })} />
                            </div>
                            <div className="flex flex-column col-3">
                                <label className="mb-1"  htmlFor="3-1">{t("document.uploadDateMin")}</label>
                                <Calendar id="3-1" value={criteria.uploadDateFrom} onChange={(e) => setCriteria({ ...criteria, uploadDateFrom: e.value as Date })} dateFormat="dd-MM-yy" showIcon={true} />
                            </div>
                            <div className="flex flex-column col-3">
                                <label className="mb-1"  htmlFor="3-2">{t("document.uploadDateMax")}</label>
                                <Calendar id="3-2" value={criteria.uploadDateTo} onChange={(e) => setCriteria({ ...criteria, uploadDateTo: e.value as Date })} dateFormat="dd-MM-yy" showIcon={true} />
                            </div>
                            <div className="flex flex-column col-3">
                                <label className="mb-1"  htmlFor="4-1">{t("document.anneeMin")}</label>
                                <InputNumber id="4-1" value={criteria.anneeMin} onChange={(e) => setCriteria({ ...criteria, anneeMin: e.value })} mode="decimal" />
                            </div>
                            <div className="flex flex-column col-3">
                                <label className="mb-1"  htmlFor="4-2">{t("document.anneeMax")}  </label>
                                <InputNumber id="4-2" value={criteria.anneeMax} onChange={(e) => setCriteria({ ...criteria, anneeMax: e.value })} mode="decimal" />
                            </div>
                            <div className="flex flex-column col-3">
                                <label className="mb-1"  htmlFor="5-1">{t("document.semstreMin")}</label>
                                <InputNumber id="5-1" value={criteria.semstreMin} onChange={(e) => setCriteria({ ...criteria, semstreMin: e.value })} mode="decimal" />
                            </div>
                            <div className="flex flex-column col-3">
                                <label className="mb-1"  htmlFor="5-2">{t("document.semstreMax")}  </label>
                                <InputNumber id="5-2" value={criteria.semstreMax} onChange={(e) => setCriteria({ ...criteria, semstreMax: e.value })} mode="decimal" />
                            </div>
                            <div className="flex flex-column col-3">
                                <label className="mb-1"  htmlFor="6-1">{t("document.moisMin")}</label>
                                <InputNumber id="6-1" value={criteria.moisMin} onChange={(e) => setCriteria({ ...criteria, moisMin: e.value })} mode="decimal" />
                            </div>
                            <div className="flex flex-column col-3">
                                <label className="mb-1"  htmlFor="6-2">{t("document.moisMax")}  </label>
                                <InputNumber id="6-2" value={criteria.moisMax} onChange={(e) => setCriteria({ ...criteria, moisMax: e.value })} mode="decimal" />
                            </div>
                            <div className="flex flex-column col-3">
                                <label className="mb-1"  htmlFor="7-1">{t("document.jourMin")}</label>
                                <InputNumber id="7-1" value={criteria.jourMin} onChange={(e) => setCriteria({ ...criteria, jourMin: e.value })} mode="decimal" />
                            </div>
                            <div className="flex flex-column col-3">
                                <label className="mb-1"  htmlFor="7-2">{t("document.jourMax")}  </label>
                                <InputNumber id="7-2" value={criteria.jourMax} onChange={(e) => setCriteria({ ...criteria, jourMax: e.value })} mode="decimal" />
                            </div>
                            <div className="flex flex-column col-3">
                                <label className="mb-1"  htmlFor="8">{t("document.content")}</label>
                                <InputText id="8" value={criteria.content} onChange={(e) => setCriteria({ ...criteria, content: e.target.value })} />
                            </div>
                            <div className="flex flex-column col-3">
                                <label className="mb-1"  htmlFor="9-1">{t("document.sizeMin")}</label>
                                <InputNumber id="9-1" value={criteria.sizeMin} onChange={(e) => setCriteria({ ...criteria, sizeMin: e.value })} mode="decimal" />
                            </div>
                            <div className="flex flex-column col-3">
                                <label className="mb-1"  htmlFor="9-2">{t("document.sizeMax")}  </label>
                                <InputNumber id="9-2" value={criteria.sizeMax} onChange={(e) => setCriteria({ ...criteria, sizeMax: e.value })} mode="decimal" />
                            </div>
                            <div className="flex flex-column col-3">
                                <label className="mb-1"  htmlFor="10">{t("document.documentTypePlaceHolder")}</label>
                                <Dropdown id="10" value={criteria.documentType} options={documentTypes} onChange={(e) => setCriteria({ ...criteria, documentType: e.target.value })} optionLabel="libelle" filter showClear/>
                            </div>
                            <div className="flex flex-column col-3">
                                <label className="mb-1"  htmlFor="11">{t("document.documentStatePlaceHolder")}</label>
                                <Dropdown id="11" value={criteria.documentState} options={documentStates} onChange={(e) => setCriteria({ ...criteria, documentState: e.target.value })} optionLabel="libelle" filter showClear/>
                            </div>
                            <div className="flex flex-column col-3">
                                <label className="mb-1"  htmlFor="12">{t("document.documentCategoriePlaceHolder")}</label>
                                <Dropdown id="12" value={criteria.documentCategorie} options={documentCategories} onChange={(e) => setCriteria({ ...criteria, documentCategorie: e.target.value })} optionLabel="libelle" filter showClear/>
                            </div>
                            <div className="flex flex-column col-3">
                                <label className="mb-1"  htmlFor="14">{t("document.description")}</label>
                                <InputText id="14" value={criteria.description} onChange={(e) => setCriteria({ ...criteria, description: e.target.value })} />
                            </div>
                            <div className="flex flex-column col-3">
                                <label className="mb-1"  htmlFor="15">{t("document.utilisateurPlaceHolder")}</label>
                                <Dropdown id="15" value={criteria.utilisateur} options={utilisateurs} onChange={(e) => setCriteria({ ...criteria, utilisateur: e.target.value })} optionLabel="nom" filter showClear/>
                            </div>
                            <div className="flex flex-column col-3">
                                <label className="mb-1"  htmlFor="18">{t("document.entiteAdministrativePlaceHolder")}</label>
                                <Dropdown id="18" value={criteria.entiteAdministrative} options={entiteAdministratives} onChange={(e) => setCriteria({ ...criteria, entiteAdministrative: e.target.value })} optionLabel="libelle" filter showClear/>
                            </div>
                        </div>
                        <div style={{ marginTop : '1rem', display: 'flex', justifyContent: 'flex-end' }} >
                            <Button label={t("validate")} icon="pi pi-sort-amount-down" className="p-button-info mr-2" onClick={handleValidateClick} />
                            <Button label={t("cancel")} className="p-button-secondary mr-2"  icon="pi pi-times" onClick={handleCancelClick} />
                        </div>
                </Card>
                )}
                <DataTable ref={dt} value={items} selection={selectedItems} onSelectionChange={(e) => setSelectedItems(e.value as DocumentDto[])} dataKey="id" className="datatable-responsive" globalFilter={globalFilter} header={header} responsiveLayout="scroll" >
                    <Column selectionMode="multiple" headerStyle={{ width: '4rem' }}> </Column>
                    
                    <Column field="reference" header={t("document.reference")} sortable></Column>
                    
                    
                    <Column field="referenceGed" header={t("document.referenceGed")} sortable></Column>
                    
                    
                    <Column field="uploadDate" header={t("document.uploadDate")} sortable body={formateDate("uploadDate")}></Column>
                    
                    
                    <Column field="annee" header={t("document.annee")} sortable></Column>
                    
                    
                    <Column field="semstre" header={t("document.semstre")} sortable></Column>
                    
                    
                    <Column field="mois" header={t("document.mois")} sortable></Column>
                    
                    
                    <Column field="jour" header={t("document.jour")} sortable></Column>
                    
                    
                    <Column field="content" header={t("document.content")} sortable></Column>
                    
                    
                    <Column field="size" header={t("document.size")} sortable></Column>
                    
                     {/* 
                    <Column field="documentType.libelle" header={t("document.documentType")} sortable ></Column>
                     */} 
                     {/* 
                    <Column field="documentState.libelle" header={t("document.documentState")} sortable body={(rowData)=>statusBodyTemplate(rowData.documentState?.libelle,rowData.documentState?.style)}></Column>
                     */} 
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

            <Dialog visible={deleteItemsDialog} style={{ width: '450px' }} header="Confirm" modal footer={deleteItemsDialogFooter} onHide={hideDeleteItemsDialog} >
                <div className="flex align-items-center justify-content-center">
                    <i className="pi pi-exclamation-triangle mr-3" style={{ fontSize: '2rem' }} />
                    {item && <span>Are you sure you want to delete the selected elements?</span>}
                </div>
            </Dialog>

            </div>
        </div>
    </div>
);
};
export default List;

