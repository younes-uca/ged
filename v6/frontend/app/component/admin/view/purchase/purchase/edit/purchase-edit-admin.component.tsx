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
import { format } from 'date-fns';
import {InputNumberChangeEvent} from 'primereact/inputnumber';
import { InputSwitch } from 'primereact/inputswitch';
import {MultiSelect} from 'primereact/multiselect';

import {MessageService} from 'app/zynerator/service/MessageService';

import {PurchaseAdminService} from 'app/controller/service/admin/PurchaseAdminService.service';
import  {PurchaseDto}  from 'app/controller/model/Purchase.model';

import {ProductDto} from 'app/controller/model/Product.model';
import {ProductAdminService} from 'app/controller/service/admin/ProductAdminService.service';
import {ClientDto} from 'app/controller/model/Client.model';
import {ClientAdminService} from 'app/controller/service/admin/ClientAdminService.service';
import {PurchaseItemDto} from 'app/controller/model/PurchaseItem.model';
import {PurchaseItemAdminService} from 'app/controller/service/admin/PurchaseItemAdminService.service';
import {PurchaseTagDto} from 'app/controller/model/PurchaseTag.model';
import {PurchaseTagAdminService} from 'app/controller/service/admin/PurchaseTagAdminService.service';
import {TagDto} from 'app/controller/model/Tag.model';
import {TagAdminService} from 'app/controller/service/admin/TagAdminService.service';
const Edit = ({visible, onClose, showToast, selectedItem, update}) => {

    const emptyItem = new PurchaseDto();
    const [submitted, setSubmitted] = useState(false);
    const [activeIndex, setActiveIndex] = useState<number>(0);
    const [activeTab, setActiveTab] = useState(0);
    const [item, setItem] = useState<PurchaseDto>( emptyItem);
    const [products, setProducts] = useState<ProductDto[]>([]);
    const [clients, setClients] = useState<ClientDto[]>([]);
    const [tags, setTags] = useState<TagDto[]>([]);

    type ProductResponse = AxiosResponse<ProductDto[]>;
    type ClientResponse = AxiosResponse<ClientDto[]>;
    type PurchaseItemResponse = AxiosResponse<PurchaseItemDto[]>;
    type PurchaseTagResponse = AxiosResponse<PurchaseTagDto[]>;
    type TagResponse = AxiosResponse<TagDto[]>;

    const [purchaseItems, setPurchaseItems] = useState<PurchaseItemDto>(new PurchaseItemDto());
    const [purchaseTags, setPurchaseTags] = useState<PurchaseTagDto>(new PurchaseTagDto());

    useEffect(() => {
        const fetchData = async () => {
            try {
                const [productsResponse ,clientsResponse ,tagsResponse ] = await Promise.all<ProductResponse,ClientResponse,TagResponse>([
                    ProductAdminService.getList(),
                    ClientAdminService.getList(),
                    TagAdminService.getList(),
                ]);
                setProducts(productsResponse.data);
                setClients(clientsResponse.data);
                setTags(tagsResponse.data);
            } catch (error) {
                console.error(error);
            }
        };
    fetchData();
    setItem(selectedItem ? { ...selectedItem } : { ...emptyItem });
    }, [selectedItem]);



    const onDropdownChange = (e, field) => {
        setItem((prevState) => ({ ...prevState, [field]: e.value, }));
    };

    const addPurchaseItems = () => {
        setSubmitted(true);
        if( item.purchaseItems == null )
        item.purchaseItems = new Array<PurchaseItemDto>();
        let _item = purchaseItems;
        if (!_item.id) {
            item.purchaseItems.push(_item);
            MessageService.showSuccess(showToast, 'PurchaseItems Created');
            setItem((prevState :any) => ({...prevState, purchaseItems: item.purchaseItems }));
        } else {
            const updatedItems = item.purchaseItems.map((item) => item.id === purchaseItems.id ? {...purchaseItems} : item);
            MessageService.showSuccess(showToast, 'PurchaseItems Updated');
            setItem((prevState :any) => ({ ...prevState, purchaseItems: updatedItems}));
        }
        setPurchaseItems(new PurchaseItemDto());
    };

    const deletePurchaseItems = (rowData) => {
        const updatedItems = item.purchaseItems.filter((val) => val !== rowData);
        setItem((prevState ) => ({...prevState, purchaseItems: updatedItems }));
        setPurchaseItems(new PurchaseItemDto());
        MessageService.showSuccess(showToast, 'PurchaseItem Deleted');
    };

    const editPurchaseItems = (rowData) => {
        setActiveTab(0);
        setPurchaseItems(rowData);
    };

    const onInputNumerChangePurchaseItems = (e, name) => {
        const val = e.value || 0;
        setPurchaseItems((prevPurchaseItems) => ({ ...prevPurchaseItems, [name]: val, }));
    };

    const onDropdownChangePurchaseItems = (e, field) => {
        setPurchaseItems((prevState) => ({ ...prevState, [field]: e.value}));
    };


    const onMultiSelectChangePurchaseItems = (e, field) => {
        if (e && e.value && Array.isArray(e.value)) {
            const selectedValues = e.value.map(option => option && option.value);
            setPurchaseItems(prevState => ({ ...prevState, [field]: selectedValues, }));
        }
    };

    const onBooleanInputChangePurchaseItems = (e: any, name: string) => {
        const val = e.value;
        setPurchaseItems((prevItem) => ({ ...prevItem, [name]: val, }));
    };

    const onInputDateChangePurchaseItems = (e: CalendarChangeEvent, name: string) => {
        const val = e.value || ''; // Utilisez e.value au lieu de e.target.value
        let _item = { ...purchaseItems};
        _item[`${name}`] = val;
        setPurchaseItems(_item);
    };


    const onInputTextChangePurchaseItems = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, name: string) => {
        const val = (e.target && e.target.value) || '';
        let _item = {...purchaseItems};
        _item[`${name}`] = val;
        setPurchaseItems(_item);
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
    const editItem = async () => {
        setSubmitted(true);
        if (isFormValid()) {
            const response = await PurchaseAdminService.update(item);
            update(response.data);
            MessageService.showSuccess(showToast, 'Purchase Updated');
            onClose();
            setItem(emptyItem);
            setSubmitted(false);
            setItem({...item, PurchaseItems: null, });
            setPurchaseItems(new PurchaseItemDto());
            setItem({...item, PurchaseTags: null, });
            setPurchaseTags(new PurchaseTagDto());
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

    const onMultiSelectChange = (e, field) => {
        if (e && e.value && Array.isArray(e.value)) {
            const selectedValues = e.value.map(option => option && option.value);
            setItem(prevState => ({ ...prevState, [field]: selectedValues, }));
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

return(
    <Dialog visible={visible} style={{width: '70vw'}} header="Purchase" modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog}>
        <TabView activeIndex={activeIndex} onTabChange={onTabChange}>
            <TabPanel header="Purchase">
                <div className="formgrid grid">
                    <div className="field col-6">
                        <label htmlFor="reference">Reference</label>
                        <InputText id="reference" value={item ? item.reference : ''} onChange={(e) => onInputTextChange(e, 'reference')} required autoFocus className={classNames({'p-invalid': submitted && !item.reference})} />
                        {submitted && !item.reference && <small className="p-invalid">Reference is required.</small>}
                    </div>
                    <div className="field col-6">
                        <label htmlFor="purchaseDate">PurchaseDate</label>
                        <Calendar id="purchaseDate" value={item ? item.purchaseDate : ''} onChange={(e) => onInputDateChange(e, 'purchaseDate')} dateFormat="dd/mm/yy" showTime />
                    </div>
                    <div className="field col-6">
                        <label htmlFor="image">Image</label>
                        <InputText id="image" value={item ? item.image : ''} onChange={(e) => onInputTextChange(e, 'image')} required autoFocus className={classNames({'p-invalid': submitted && !item.image})} />
                        {submitted && !item.image && <small className="p-invalid">Image is required.</small>}
                    </div>
                    <div className="field col-6">
                        <label htmlFor="total">Total</label>
                        <InputNumber id="total" value={item ? item.total : 0} onChange={(e) => onInputNumerChange(e, 'total')}/>
                    </div>
                    <div className="field col-6">
                        <label htmlFor="description">Description</label>
                        <span className="p-float-label">
                            <InputTextarea id="description" value={item ? item.description : ''} onChange={(e) => onInputTextChange(e, 'description')} rows={5} cols={30}/>
                        </span>
                    </div>
                    <div className="field col-6">
                        <label htmlFor="client">Client</label>
                        <Dropdown  id="clientDropdown"  value={item ? item.client : ''} options={clients} onChange={(e) => onDropdownChange(e, 'client')}   placeholder="Sélectionnez un client" filter filterPlaceholder="Rechercher un client" optionLabel="fullName" />
                    </div>
                    <div className="field col-6">
                        <label htmlFor="purchaseTags">Tag</label>
                       {/*
                        <MultiSelect value={item ? item.purchaseTags : ''} options={purchaseTags}  optionLabel="tag.libelle" display="chip" placeholder="Select tag"  maxSelectedLabels={3}  onChange={(e) => onMultiSelectChange(e, 'purchaseTags')} />
                    */}
                    </div>
                </div>
            </TabPanel>
            <TabPanel header="Purchase items">
                <TabView activeIndex={activeTab} onTabChange={(e) => setActiveTab(e.index)}>
                    <TabPanel header="Creation">
                        <div className="grid">
                            <div className="field col-6">
                                <label htmlFor="product">Product</label>
                                <Dropdown id="productDropdown" value={purchaseItems.product} options={products} onChange={(e) => onDropdownChangePurchaseItems(e, 'product')} placeholder="Sélectionnez un product" filter  filterPlaceholder="Rechercher un product"  optionLabel="reference" />
                            </div>
                            <div className="field col-6">
                                <label htmlFor="price">Price</label>
                                <InputNumber id="price" value={purchaseItems.price}  onValueChange={(e) => onInputNumerChangePurchaseItems(e, 'price')}/>
                            </div>
                            <div className="field col-6">
                                <label htmlFor="quantity">Quantity</label>
                                <InputNumber id="quantity" value={purchaseItems.quantity}  onValueChange={(e) => onInputNumerChangePurchaseItems(e, 'quantity')}/>
                            </div>
                            <div className="field col-1">
                                <Button icon="pi pi-plus" label="OK" className="mt-4" onClick={addPurchaseItems} />
                            </div>
                        </div>
                    </TabPanel>
                    <TabPanel header="Liste">
                        <div className="card">
                            <DataTable value={item.purchaseItems} tableStyle={{minWidth: '50rem'}} dataKey="id">
                                <Column field="product.reference" header="Product"></Column>
                                <Column field="price" header="Price"></Column>
                                <Column field="quantity" header="Quantity"></Column>
                                <Column header="Actions" body={(rowData) => (
                                    <div>
                                        <Button icon="pi pi-times" rounded severity="warning" className="mr-2 p-button-danger" onClick={()=> deletePurchaseItems(rowData)} />
                                        <Button icon="pi pi-pencil" rounded severity="success" className="mr-2" onClick={()=> editPurchaseItems(rowData)} />
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


