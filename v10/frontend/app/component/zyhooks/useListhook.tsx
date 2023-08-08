import React, {useRef, useState} from "react";
import {PaginatorPageChangeEvent} from "primereact/paginator";
import {Tag} from "primereact/tag";
import {BaseDto} from "../../zynerator/dto/BaseDto.model";
import {BaseCriteria} from "../../zynerator/criteria/BaseCriteria.model";
import {Toast} from "primereact/toast";
import {DataTable} from "primereact/datatable";
import AbstractService from "../../zynerator/service/AbstractService";
import {MessageService} from "../../zynerator/service/MessageService";
import {Button} from "primereact/button";
import {TFunction} from "i18next";

type ListHookType<T extends BaseDto, C extends BaseCriteria> = {
    emptyItem: T,
    emptyCriteria: C,
    service: AbstractService<T, C>,
    t: TFunction
}

const useListHook = <T extends BaseDto, C extends BaseCriteria>({emptyItem, emptyCriteria, service, t}: ListHookType<T, C>) => {

    const [items, setItems] = useState<T[]>([]);
    const [deleteItemDialog, setDeleteItemDialog] = useState(false);
    const [deleteItemsDialog, setDeleteItemsDialog] = useState(false);
    const [item, setItem] = useState<T>(emptyItem);
    const [selectedItems, setSelectedItems] = useState<T[]>([]);
    const [globalFilter, setGlobalFilter] = useState('');
    const [showCreateDialog, setShowCreateDialog] = useState<boolean>(false);
    const [showEditDialog, setShowEditDialog] = useState<boolean>(false);
    const [showViewDialog, setShowViewDialog] = useState<boolean>(false);
    const [selectedItem, setSelectedItem] = useState<T>(emptyItem);
    const [rows, setRows] = useState<number>(10);
    const [totalRecords, setTotalRecords] = useState(0);
    const [criteria, setCriteria] = useState(emptyCriteria);
    const [first, setFirst] = useState(0);
    const toast = useRef<Toast>(null);
    const dt = useRef<DataTable<T[]>>(null);
    const [findByCriteriaShow, setFindByCriteriaShow] = useState(false);
    const [isSearchTriggered, setIsSearchTriggered] = useState(false);


    const fetchItems = (criteria: C) => {
        service.findPaginatedByCriteria(criteria).then(({data}) => {
            setTotalRecords(data.dataSize);
            setItems(data.list);
        }).catch(error => console.log(error));
    };

    const handleCancelClick = () => {
        setCriteria(emptyCriteria);
        fetchItems(emptyCriteria);
        setIsSearchTriggered(false);
    };
    const showSearch = () => {
        setFindByCriteriaShow(!findByCriteriaShow);
    };
    const handleValidateClick = () => {
        fetchItems(criteria)
    };

    const onPage = (event: PaginatorPageChangeEvent) => {
        const updatedCriteria = {...criteria, page: event.page, maxResults: event.rows};
        setCriteria(updatedCriteria);
        setFirst(event.first);
        fetchItems(updatedCriteria);
    };


    const deleteItem = async () => {
        try {
            service.delete(selectedItem?.id);
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
        service.deleteList(selectedItems);
        let _items = items.filter((val) => !selectedItems.includes(val));
        setItems(_items);
        setDeleteItemsDialog(false);
        setSelectedItems([]);
        MessageService.showSuccess(toast, 'Documents Deleted');
    };

    const showCreateModal = (): void => {
        setShowCreateDialog(true);
    };

    const showEditModal = (item: T) => {
        setSelectedItem(item);
        setShowEditDialog(true);
    };

    const showViewModal = (item: T) => {
        setSelectedItem(item);
        setShowViewDialog(true);
    };

    const add = (item: T) => {
        setItems([...items, item]);
    };

    const update = (updatedItem: T) => {
        const updatedList = items.map((item) => {
            if (item.id === updatedItem.id) {
                return updatedItem;
            }
            return item;
        });
        setItems(updatedList);
    };

    const hideDeleteItemsDialog = () => {
        setDeleteItemsDialog(false);
    };


    const confirmDeleteItem = (item: T) => {
        setSelectedItem(item);
        setDeleteItemDialog(true);
    };

    const statusBodyTemplate = (val: string, style: any) => {
        return <Tag value={val} severity={style}/>;
    };

    const hideDeleteItemDialog = () => {
        setDeleteItemDialog(false);
    };

    const deleteItemDialogFooter = (<>
            <Button label={t("no")} icon="pi pi-times" text onClick={hideDeleteItemDialog}/>
            <Button label={t("yes")} icon="pi pi-check" text onClick={deleteItem}/>
        </>
    );


    return {
        items, showSearch, deleteItemDialog, item, selectedItems, setSelectedItems, hideDeleteItemDialog,
        globalFilter, setGlobalFilter, showCreateDialog, setShowCreateDialog, showEditDialog, setShowEditDialog, showViewDialog, setShowViewDialog,
        selectedItem, setSelectedItem, rows, totalRecords, criteria, setCriteria, first, fetchItems,
        toast, dt, findByCriteriaShow, handleCancelClick, confirmDeleteSelected, exportCSV, deleteItem, deleteItemDialogFooter,
        handleValidateClick, onPage, showCreateModal, showEditModal, showViewModal, add, update, confirmDeleteItem, statusBodyTemplate
    }
};

export default useListHook;