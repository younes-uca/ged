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

import  {DocumentCategorieFieldRuleDto}  from 'app/controller/model/DocumentCategorieFieldRule.model';

type DocumentCategorieFieldRuleViewAdminType = {
    visible: boolean,
    onClose: () => void,
    selectedItem: DocumentCategorieFieldRuleDto,
    t: TFunction
}

const View: React.FC<DocumentCategorieFieldRuleViewAdminType> = ({visible,onClose,selectedItem, t}) => {

    const {
    onTabChange,
    hideDialog,
    itemDialogFooter,
    formateDate,
    parse,
    parseToIsoFormat,
    adaptDate,
    activeIndex
    } = useViewHook<DocumentCategorieFieldRuleDto>({selectedItem, onClose})


        return(
<Dialog visible={visible} style={{width: '70vw'}} header={t("documentCategorieFieldRule.tabPan")} modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog} >
<TabView activeIndex={activeIndex} onTabChange={onTabChange}>
<TabPanel header={t("documentCategorieFieldRule.tabPan")}>
    <div className="formgrid grid">

            <div className="field col-6">
                <label htmlFor="code">{t("documentCategorieFieldRule.code")}</label>
                <InputText id="code" value={selectedItem?.code} disabled   />
            </div>

            <div className="field col-6">
                <label htmlFor="libelle">{t("documentCategorieFieldRule.libelle")}</label>
                <InputText id="libelle" value={selectedItem?.libelle} disabled   />
            </div>

            <div className="field col-6">
                <label htmlFor="expresion">{t("documentCategorieFieldRule.expresion")}</label>
                <InputText id="expresion" value={selectedItem?.expresion} disabled   />
            </div>

        </div>
</TabPanel>
</TabView>
</Dialog>
);
};
export default View;
