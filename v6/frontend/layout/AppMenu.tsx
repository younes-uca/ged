/* eslint-disable @next/next/no-img-element */

import AppMenuitem from '/layout/AppMenuitem';
import {MenuProvider} from '/layout/context/menucontext';
import {AppMenuItem} from '/types/types';
import {AuthService} from 'app/zynerator/security/Auth.service';
import React, {useEffect, useState} from 'react';


const AppMenu = () => {

    const [model,setModel] = useState<AppMenuItem[]>([] as AppMenuItem[]);
    const authService = new AuthService();
    const modelAdmin: AppMenuItem[] = [
        {
            label: 'Home',
            items: [{label: 'Dashboard', icon: 'pi pi-fw pi-home', to: '/dashboard'}]
        },


        {
            label: 'Pages',
            icon: 'pi pi-fw pi-briefcase',
            to: '',
            items: [

                {
                    label: 'Auth',
                    icon: 'pi pi-fw pi-user',
                    items: [
                        {
                            label: 'Error',
                            icon: 'pi pi-fw pi-times-circle',
                            to: '/auth/error'
                        },
                        {
                            label: 'Access Denied',
                            icon: 'pi pi-fw pi-lock',
                            to: '/auth/access'
                        }
                    ]
                },
                {
                    label: 'Product Management',
                    icon: 'pi pi-fw pi-plus-circle',
                    items: [
                      {
                      label: 'Liste product',
                     to: '/admin/view/commun/product/list'
                      },
                    ]
                    },
                {
                    label: 'Collaborator',
                    icon: 'pi pi-fw pi-plus-circle',
                    items: [
                      {
                      label: 'Liste tag',
                     to: '/admin/view/doc/tag/list'
                      },
                      {
                      label: 'Liste field',
                     to: '/admin/view/doc/field/list'
                      },
                      {
                      label: 'Liste document type',
                     to: '/admin/view/doc/document-type/list'
                      },
                      {
                      label: 'Liste document field',
                     to: '/admin/view/doc/document-field/list'
                      },
                      {
                      label: 'Liste document categorie field rule',
                     to: '/admin/view/doc/document-categorie-field-rule/list'
                      },
                      {
                      label: 'Liste document categorie field',
                     to: '/admin/view/doc/document-categorie-field/list'
                      },
                      {
                      label: 'Liste client category',
                     to: '/admin/view/commun/client-category/list'
                      },
                      {
                      label: 'Liste document state',
                     to: '/admin/view/doc/document-state/list'
                      },
                      {
                      label: 'Liste document categorie',
                     to: '/admin/view/doc/document-categorie/list'
                      },
                      {
                      label: 'Liste document field state',
                     to: '/admin/view/doc/document-field-state/list'
                      },
                      {
                      label: 'Liste client',
                     to: '/admin/view/commun/client/list'
                      },
                    ]
                    },
                {
                    label: 'Purchase Management',
                    icon: 'pi pi-fw pi-plus-circle',
                    items: [
                      {
                      label: 'Liste purchase',
                     to: '/admin/view/purchase/purchase/list'
                      },
                    ]
                    },
                {
                    label: 'Document Management',
                    icon: 'pi pi-fw pi-plus-circle',
                    items: [
                      {
                      label: 'Liste document',
                     to: '/admin/view/doc/document/list'
                      },
                    ]
                    },
                {
                    label: 'Referentiel',
                    icon: 'pi pi-fw pi-plus-circle',
                    items: [
                      {
                      label: 'Liste acess share',
                     to: '/admin/view/referetiel/acess-share/list'
                      },
                      {
                      label: 'Liste acess management',
                     to: '/admin/view/referetiel/acess-management/list'
                      },
                    ]
                    },
                {
                    label: 'User Management',
                    icon: 'pi pi-fw pi-plus-circle',
                    items: [
                      {
                      label: 'Liste groupe',
                     to: '/admin/view/user/groupe/list'
                      },
                      {
                      label: 'Liste utilisateur',
                     to: '/admin/view/user/utilisateur/list'
                      },
                      {
                      label: 'Liste entite administrative',
                     to: '/admin/view/user/entite-administrative/list'
                      },
                    ]
                    },
            ]
        },

    ];
    const modelAgent: AppMenuItem[] = [
        {
            label: 'Home',
            items: [{label: 'Dashboard', icon: 'pi pi-fw pi-home', to: '/dashboard'}]
        },


        {
            label: 'Pages',
            icon: 'pi pi-fw pi-briefcase',
            to: '',
            items: [

                {
                    label: 'Auth',
                    icon: 'pi pi-fw pi-user',
                    items: [
                        {
                            label: 'Error',
                            icon: 'pi pi-fw pi-times-circle',
                            to: '/auth/error'
                        },
                        {
                            label: 'Access Denied',
                            icon: 'pi pi-fw pi-lock',
                            to: '/auth/access'
                        }
                    ]
                },
                {
                    label: 'Collaborator',
                    icon: 'pi pi-fw pi-plus-circle',
                    items: [
                      {
                      label: 'Liste client category',
                     to: '/agent/view/commun/client-category/list'
                      },
                      {
                      label: 'Liste client',
                     to: '/agent/view/commun/client/list'
                      },
                    ]
                    },
            ]
        },

    ];

    useEffect(()=>{
        const roleConnectedUser = authService.getRoleConnectedUser();
        if(roleConnectedUser === 'ROLE_ADMIN'){
            setModel(modelAdmin)
        }
        if(roleConnectedUser === 'ROLE_AGENT'){
            setModel(modelAgent)
        }
    },[])

    return (
        <MenuProvider>
            <ul className="layout-menu">
                {model.map((item, i) => {
                    return !item?.seperator ? <AppMenuitem item={item} root={true} index={i} key={item.label}/> :
                        <li className="menu-separator"></li>;
                })}


            </ul>
        </MenuProvider>
    );
};


export default AppMenu;
