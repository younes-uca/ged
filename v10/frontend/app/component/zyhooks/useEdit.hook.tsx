import React, {useState} from "react";
import {CalendarChangeEvent} from "primereact/calendar";
import {InputNumberChangeEvent} from "primereact/inputnumber";
import {MultiSelectChangeEvent} from "primereact/multiselect";
import {DropdownChangeEvent} from "primereact/dropdown";
import {format, parse} from "date-fns";
import {BaseDto} from "app/zynerator/dto/BaseDto.model";
import {Toast} from "primereact/toast";
import AbstractService from "../../zynerator/service/AbstractService";
import {BaseCriteria} from "../../zynerator/criteria/BaseCriteria.model";
import {MessageService} from "../../zynerator/service/MessageService";

type EditHookType<T extends BaseDto, C extends BaseCriteria> = {
    list: T[],
    emptyItem: T,
    onClose: () => void,
    //prepare: () => void,
    update: (item: T) => void,
    //  isFormValid: () => boolean,
    showToast: React.Ref<Toast>,
    service: AbstractService<T, C>,
}
const useEditHook = <T extends BaseDto, C extends BaseCriteria>({list, emptyItem, onClose, update, showToast, service}: EditHookType<T, C>) => {

    const [items, setItems] = useState<T[]>(list);
    const [item, setItem] = useState<T>(emptyItem);
    const [submitted, setSubmitted] = useState(false);
    const [activeIndex, setActiveIndex] = useState<number>(0);
    const [activeTab, setActiveTab] = useState(0);

    const editItem = async () => {
        setSubmitted(true);
        if (true) {
            // prepare();
            service.update(item).then(({data}) => {
                update(data);
                MessageService.showSuccess(showToast, 'Document Created');
                onClose();
                setSubmitted(false);
            });
        }
    };


    const onInputTextChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, name: string) => {
        const value = (e.target && e.target.value) || '';
        setItem({...item, [name]: value});
    };

    const onInputDateChange = (e: CalendarChangeEvent, name: string) => {
        const value = (e.value) || '';
        setItem({...item, [name]: value});
    };

    const onInputNumerChange = (e: InputNumberChangeEvent, name: string) => {
        const val = e.value === null ? null : +e.value;
        setItem((prevItem) => ({...prevItem, [name]: val,}));
    };

    const onMultiSelectChange = (e: MultiSelectChangeEvent, field: string) => {
        if (e && e.value) {
            setItem(prevState => ({...prevState, [field]: e.value,}));
        }
    };

    const onBooleanInputChange = (e: any, name: string) => {
        const val = e.value;
        setItem((prevItem) => ({...prevItem, [name]: val,}));
    };
    const onDropdownChange = (e: DropdownChangeEvent, field: string) => {
        setItem((prevState) => ({...prevState, [field]: e.value}));
    };

    const onTabChange = (e: { index: number }) => {
        setActiveIndex(e.index);
    };

    const hideDialog = () => {
        setSubmitted(false);
        onClose();
    };

    const formateDate = (field: string) => {
        return (rowData: any) => {
            if (rowData[field]) {
                return format(new Date(rowData[field]), "dd/MM/yyyy");
            }
        };
    };

    const parseToIsoFormat = (date: Date) => {
        return parse(date.toISOString(), "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", new Date())
    };

    const adaptDate = (field: null | Date) => {
        return field == null ? null : new Date(field)
    };


    return {
        formateDate,
        parseToIsoFormat,
        adaptDate,
        onInputTextChange,
        onInputDateChange,
        onInputNumerChange,
        onMultiSelectChange,
        onBooleanInputChange,
        onTabChange,
        hideDialog,
        editItem
    }
};

export default useEditHook;