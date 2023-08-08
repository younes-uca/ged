import {Column} from 'primereact/column';
import {TabPanel, TabView} from 'primereact/tabview';
import {DataTable} from 'primereact/datatable';
import {Dialog} from 'primereact/dialog';
import {InputNumber} from 'primereact/inputnumber';
import {InputText} from 'primereact/inputtext';
import {InputTextarea} from 'primereact/inputtextarea';
import React from 'react';
import {Calendar} from 'primereact/calendar';
import {InputSwitch} from 'primereact/inputswitch';
import {TFunction} from "i18next";
import useViewHook from "app/component/zyhook/useViewhook";

import  {DocumentCategorieDto}  from 'app/controller/model/DocumentCategorie.model';

type DocumentCategorieViewAgentType = {
    visible: boolean,
    onClose: () => void,
    selectedItem: DocumentCategorieDto,
    t: TFunction
}

const View: React.FC<DocumentCategorieViewAgentType> = ({visible,onClose,selectedItem, t}) => {

    const {
    onTabChange,
    hideDialog,
    itemDialogFooter,
    formateDate,
    parse,
    parseToIsoFormat,
    adaptDate,
    activeIndex
    } = useViewHook<DocumentCategorieDto>({selectedItem, onClose})


        return(
<Dialog visible={visible} style={{width: '70vw'}} header={t("documentCategorie.tabPan")} modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog} >
<TabView activeIndex={activeIndex} onTabChange={onTabChange}>
<TabPanel header={t("documentCategorie.tabPan")}>
    <div className="formgrid grid">

            <div className="field col-6">
                <label htmlFor="code">{t("documentCategorie.code")}</label>
                <InputText id="code" value={selectedItem?.code} disabled   />
            </div>

            <div className="field col-6">
                <label htmlFor="libelle">{t("documentCategorie.libelle")}</label>
                <InputText id="libelle" value={selectedItem?.libelle} disabled   />
            </div>

        </div>
</TabPanel>
    <TabPanel header={t("documentCategorie.documentCategorieFields")}>
                <div className="card">
                    <DataTable value={selectedItem?.documentCategorieFields} tableStyle={{minWidth: '50rem'}} dataKey="id">
                                <Column field="field.libelle" header={t("documentCategorieField.field")}></Column>
                                <Column field="documentCategorieFieldRule.libelle" header={t("documentCategorieField.documentCategorieFieldRule")}></Column>
                    </DataTable>
                </div>
        </TabPanel>
</TabView>
</Dialog>
);
};
export default View;
