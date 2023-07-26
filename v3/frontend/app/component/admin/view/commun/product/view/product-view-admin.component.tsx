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
import { InputSwitch } from 'primereact/inputswitch';
import {MultiSelect} from 'primereact/multiselect';
import  {ProductDto}  from 'app/controller/model/Product.model';

const View = ({visible,onClose,selectedItem}) => {

    const emptyItem = new ProductDto();
    const [item, setItem] = useState<ProductDto>(emptyItem);
    const [submitted, setSubmitted] = useState(false);
    const [activeIndex, setActiveIndex] = useState<number>(0);

    useEffect(() => {
        setItem(selectedItem ? { ...selectedItem } : { ...emptyItem });
    }, [selectedItem]);

    const onTabChange = (e: { index: number }) => {
        setActiveIndex(e.index);
    };

    const hideDialog = () => {
        setSubmitted(false);
        onClose();
    };

    const itemDialogFooter = ( <>
        <Button label="Cancel" icon="pi pi-times" text onClick={hideDialog} /> </>
    );

return(
<Dialog visible={visible} style={{width: '70vw'}} header="Product Details" modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog} >
<TabView activeIndex={activeIndex} onTabChange={onTabChange}>
<TabPanel header="Product">
    <div className="formgrid grid">

            <div className="field col-6">
                <label htmlFor="code">Code</label>
                <InputText id="code" value={selectedItem?.code} disabled   />
            </div>

            <div className="field col-6">
                <label htmlFor="reference">Reference</label>
                <InputText id="reference" value={selectedItem?.reference} disabled   />
            </div>

                <div className="field col-6">
                    <label htmlFor="purchaseCost">PurchaseCost</label>
                    <InputNumber id="purchaseCost" value={item.purchaseCost} disabled/>
                </div>

        </div>
</TabPanel>
</TabView>
</Dialog>
);
};
export default View;
