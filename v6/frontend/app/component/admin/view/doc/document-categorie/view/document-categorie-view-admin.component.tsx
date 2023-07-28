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
import  {DocumentCategorieDto}  from 'app/controller/model/DocumentCategorie.model';

const View = ({visible,onClose,selectedItem}) => {

    const emptyItem = new DocumentCategorieDto();
    const [item, setItem] = useState<DocumentCategorieDto>(emptyItem);
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
<Dialog visible={visible} style={{width: '70vw'}} header="DocumentCategorie Details" modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog} >
<TabView activeIndex={activeIndex} onTabChange={onTabChange}>
<TabPanel header="DocumentCategorie">
    <div className="formgrid grid">

            <div className="field col-6">
                <label htmlFor="code">Code</label>
                <InputText id="code" value={selectedItem?.code} disabled   />
            </div>

            <div className="field col-6">
                <label htmlFor="libelle">Libelle</label>
                <InputText id="libelle" value={selectedItem?.libelle} disabled   />
            </div>

        </div>
</TabPanel>
    <TabPanel header="Document categorie fields">
                <div className="card">
                    <DataTable value={selectedItem?.documentCategorieFields} tableStyle={{minWidth: '50rem'}} dataKey="id">
                                <Column field="field.libelle" header="Field"></Column>
                                <Column field="documentCategorieFieldRule.libelle" header="Document categorie field rule"></Column>
                    </DataTable>
                </div>
        </TabPanel>
</TabView>
</Dialog>
);
};
export default View;
