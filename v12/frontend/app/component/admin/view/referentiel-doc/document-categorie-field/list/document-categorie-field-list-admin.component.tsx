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


import {DocumentCategorieFieldAdminService} from 'app/controller/service/admin/DocumentCategorieFieldAdminService.service';
import {DocumentCategorieFieldDto}  from 'app/controller/model/DocumentCategorieField.model';
import {DocumentCategorieFieldCriteria} from 'app/controller/criteria/DocumentCategorieFieldCriteria.model';

import {FieldDto} from 'app/controller/model/Field.model';
import {FieldAdminService} from 'app/controller/service/admin/FieldAdminService.service';
import {DocumentCategorieDto} from 'app/controller/model/DocumentCategorie.model';
import {DocumentCategorieAdminService} from 'app/controller/service/admin/DocumentCategorieAdminService.service';
import {DocumentCategorieFieldRuleDto} from 'app/controller/model/DocumentCategorieFieldRule.model';
import {DocumentCategorieFieldRuleAdminService} from 'app/controller/service/admin/DocumentCategorieFieldRuleAdminService.service';

import { useTranslation } from 'react-i18next';

import Edit from '../edit/document-categorie-field-edit-admin.component';
import Create from '../create/document-categorie-field-create-admin.component';
import View from '../view/document-categorie-field-view-admin.component';


const List = () => {

    const { t } = useTranslation();

    const emptyItem = new DocumentCategorieFieldDto();
    const emptyCriteria = new DocumentCategorieFieldCriteria();
    const service = new DocumentCategorieFieldAdminService();


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
    } = useListHook<DocumentCategorieFieldDto, DocumentCategorieFieldCriteria>({ emptyItem, emptyCriteria,service, t})



    const [fields, setFields] = useState<FieldDto[]>([]);
    const [documentCategories, setDocumentCategories] = useState<DocumentCategorieDto[]>([]);
    const [documentCategorieFieldRules, setDocumentCategorieFieldRules] = useState<DocumentCategorieFieldRuleDto[]>([]);

    const fieldAdminService = new FieldAdminService();
    const documentCategorieAdminService = new DocumentCategorieAdminService();
    const documentCategorieFieldRuleAdminService = new DocumentCategorieFieldRuleAdminService();

    useEffect(() => {

        fieldAdminService.getList().then(({data}) => setFields(data)).catch(error => console.log(error));
        documentCategorieAdminService.getList().then(({data}) => setDocumentCategories(data)).catch(error => console.log(error));
        documentCategorieFieldRuleAdminService.getList().then(({data}) => setDocumentCategorieFieldRules(data)).catch(error => console.log(error));
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
                            <span className="mr-3 align-search-items mt-4">
                                <Dropdown id="1" value={criteria.field} options={fields} onChange={(e) => setCriteria({ ...criteria, field: e.target.value })} optionLabel="libelle" filter showClear placeholder={t("documentCategorieField.fieldPlaceHolder")} filterPlaceholder={t("documentCategorieField.fieldPlaceHolderFilter")} />
                            </span>
                            <span className="mr-3 align-search-items mt-4">
                                <Dropdown id="2" value={criteria.documentCategorie} options={documentCategories} onChange={(e) => setCriteria({ ...criteria, documentCategorie: e.target.value })} optionLabel="libelle" filter showClear placeholder={t("documentCategorieField.documentCategoriePlaceHolder")} filterPlaceholder={t("documentCategorieField.documentCategoriePlaceHolderFilter")} />
                            </span>
                            <span className="mr-3 align-search-items mt-4">
                                <Dropdown id="3" value={criteria.documentCategorieFieldRule} options={documentCategorieFieldRules} onChange={(e) => setCriteria({ ...criteria, documentCategorieFieldRule: e.target.value })} optionLabel="libelle" filter showClear placeholder={t("documentCategorieField.documentCategorieFieldRulePlaceHolder")} filterPlaceholder={t("documentCategorieField.documentCategorieFieldRulePlaceHolderFilter")} />
                            </span>
                        </div>
                        <div style={{ marginTop : '1rem', display: 'flex', justifyContent: 'flex-end' }} >
                            <Button label={t("validate")} icon="pi pi-sort-amount-down" className="p-button-info mr-2" onClick={handleValidateClick} />
                            <Button label={t("cancel")} className="p-button-secondary mr-2"  icon="pi pi-times" onClick={handleCancelClick} />
                        </div>
                    </div>
                </Card>
                )}
                <DataTable ref={dt} value={items} selection={selectedItems} onSelectionChange={(e) => setSelectedItems(e.value as DocumentCategorieFieldDto[])} dataKey="id" className="datatable-responsive" globalFilter={globalFilter} header={header} responsiveLayout="scroll" >
                    <Column selectionMode="multiple" headerStyle={{ width: '4rem' }}> </Column>
                    
                    <Column field="field.libelle" header={t("documentCategorieField.field")} sortable ></Column>
                    
                    
                    <Column field="documentCategorie.libelle" header={t("documentCategorieField.documentCategorie")} sortable ></Column>
                    
                    
                    <Column field="documentCategorieFieldRule.libelle" header={t("documentCategorieField.documentCategorieFieldRule")} sortable ></Column>
                    
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
                    {item && (<span>{t("deleteDocumentCategorieFieldConfirmationMessage")} <b>{item.id}</b>?</span>)}
                    </div>
                </Dialog>

            </div>
        </div>
    </div>
);
};
export default List;

