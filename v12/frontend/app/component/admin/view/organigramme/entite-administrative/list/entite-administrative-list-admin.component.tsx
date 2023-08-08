import {Button} from 'primereact/button';
import {Column} from 'primereact/column';


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


import {EntiteAdministrativeAdminService} from 'app/controller/service/admin/EntiteAdministrativeAdminService.service';
import {EntiteAdministrativeDto}  from 'app/controller/model/EntiteAdministrative.model';
import {EntiteAdministrativeCriteria} from 'app/controller/criteria/EntiteAdministrativeCriteria.model';

import {UtilisateurDto} from 'app/controller/model/Utilisateur.model';
import {UtilisateurAdminService} from 'app/controller/service/admin/UtilisateurAdminService.service';
import {EntiteAdministrativeTypeDto} from 'app/controller/model/EntiteAdministrativeType.model';
import {EntiteAdministrativeTypeAdminService} from 'app/controller/service/admin/EntiteAdministrativeTypeAdminService.service';

import { useTranslation } from 'react-i18next';

import Edit from '../edit/entite-administrative-edit-admin.component';
import Create from '../create/entite-administrative-create-admin.component';
import View from '../view/entite-administrative-view-admin.component';


const List = () => {

    const { t } = useTranslation();

    const emptyItem = new EntiteAdministrativeDto();
    const emptyCriteria = new EntiteAdministrativeCriteria();
    const service = new EntiteAdministrativeAdminService();


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
    } = useListHook<EntiteAdministrativeDto, EntiteAdministrativeCriteria>({ emptyItem, emptyCriteria,service, t})



    const [utilisateurs, setUtilisateurs] = useState<UtilisateurDto[]>([]);
    const [entiteAdministrativeTypes, setEntiteAdministrativeTypes] = useState<EntiteAdministrativeTypeDto[]>([]);

    const utilisateurAdminService = new UtilisateurAdminService();
    const entiteAdministrativeTypeAdminService = new EntiteAdministrativeTypeAdminService();

    useEffect(() => {

        utilisateurAdminService.getList().then(({data}) => setUtilisateurs(data)).catch(error => console.log(error));
        entiteAdministrativeTypeAdminService.getList().then(({data}) => setEntiteAdministrativeTypes(data)).catch(error => console.log(error));
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
                                <InputText id="1" value={criteria.code} onChange={(e) => setCriteria({ ...criteria, code: e.target.value })} />
                                <label htmlFor="1">{t("entiteAdministrative.code")}</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <InputText id="2" value={criteria.codeEntiteAdminParent} onChange={(e) => setCriteria({ ...criteria, codeEntiteAdminParent: e.target.value })} />
                                <label htmlFor="2">{t("entiteAdministrative.codeEntiteAdminParent")}</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <InputText id="3" value={criteria.referenceGed} onChange={(e) => setCriteria({ ...criteria, referenceGed: e.target.value })} />
                                <label htmlFor="3">{t("entiteAdministrative.referenceGed")}</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <InputText id="4" value={criteria.description} onChange={(e) => setCriteria({ ...criteria, description: e.target.value })} />
                                <label htmlFor="4">{t("entiteAdministrative.description")}</label>
                            </span>
                            <span className="p-float-label mr-3 align-search-items mt-4">
                                <InputText id="5" value={criteria.libelle} onChange={(e) => setCriteria({ ...criteria, libelle: e.target.value })} />
                                <label htmlFor="5">{t("entiteAdministrative.libelle")}</label>
                            </span>
                            <span className="mr-3 align-search-items mt-4">
                                <Dropdown id="6" value={criteria.utilisateur} options={utilisateurs} onChange={(e) => setCriteria({ ...criteria, utilisateur: e.target.value })} optionLabel="nom" filter showClear placeholder={t("entiteAdministrative.utilisateurPlaceHolder")} filterPlaceholder={t("entiteAdministrative.utilisateurPlaceHolderFilter")} />
                            </span>
                            <span className="mr-3 align-search-items mt-4">
                                <Dropdown id="7" value={criteria.entiteAdministrativeType} options={entiteAdministrativeTypes} onChange={(e) => setCriteria({ ...criteria, entiteAdministrativeType: e.target.value })} optionLabel="libelle" filter showClear placeholder={t("entiteAdministrative.entiteAdministrativeTypePlaceHolder")} filterPlaceholder={t("entiteAdministrative.entiteAdministrativeTypePlaceHolderFilter")} />
                            </span>
                        </div>
                        <div style={{ marginTop : '1rem', display: 'flex', justifyContent: 'flex-end' }} >
                            <Button label={t("validate")} icon="pi pi-sort-amount-down" className="p-button-info mr-2" onClick={handleValidateClick} />
                            <Button label={t("cancel")} className="p-button-secondary mr-2"  icon="pi pi-times" onClick={handleCancelClick} />
                        </div>
                    </div>
                </Card>
                )}
                <DataTable ref={dt} value={items} selection={selectedItems} onSelectionChange={(e) => setSelectedItems(e.value as EntiteAdministrativeDto[])} dataKey="id" className="datatable-responsive" globalFilter={globalFilter} header={header} responsiveLayout="scroll" >
                    <Column selectionMode="multiple" headerStyle={{ width: '4rem' }}> </Column>
                    
                    <Column field="code" header={t("entiteAdministrative.code")} sortable></Column>
                    
                    
                    <Column field="codeEntiteAdminParent" header={t("entiteAdministrative.codeEntiteAdminParent")} sortable></Column>
                    
                    
                    <Column field="referenceGed" header={t("entiteAdministrative.referenceGed")} sortable></Column>
                    
                    
                    <Column field="libelle" header={t("entiteAdministrative.libelle")} sortable></Column>
                    
                    
                    <Column field="utilisateur.nom" header={t("entiteAdministrative.utilisateur")} sortable ></Column>
                    
                    
                    <Column field="entiteAdministrativeType.libelle" header={t("entiteAdministrative.entiteAdministrativeType")} sortable ></Column>
                    
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
                    {item && (<span>{t("deleteEntiteAdministrativeConfirmationMessage")} <b>{item.libelle}</b>?</span>)}
                    </div>
                </Dialog>

            </div>
        </div>
    </div>
);
};
export default List;

