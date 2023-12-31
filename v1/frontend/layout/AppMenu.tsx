/* eslint-disable @next/next/no-img-element */

import React, {useContext} from 'react';
import AppMenuitem from '/layout/AppMenuitem';
import {LayoutContext} from '/layout/context/layoutcontext';
import {MenuProvider} from '/layout/context/menucontext';
import {AppMenuItem} from '/types/types';

const AppMenu = () => {
    const {layoutConfig} = useContext(LayoutContext);

    const model: AppMenuItem[] = [
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
                    icon: 'pi pi-fw pi-pencil',
                    items: [
                      {
                      label: 'Liste tag',
                     to: '/admin/view/doc/tag/list'
                      },
                      {
                      label: 'Liste document type',
                     to: '/admin/view/doc/document-type/list'
                      },
                    ]
                    },
                {
                    label: 'Document Management',
                    icon: 'pi pi-fw pi-pencil',
                    items: [
                      {
                      label: 'Liste document',
                     to: '/admin/view/doc/document/list'
                      },
                    ]
                    },
                {
                    label: 'Referentiel',
                    icon: 'pi pi-fw pi-pencil',
                    items: [
                      {
                      label: 'Liste acess management',
                     to: '/admin/view/referetiel/acess-management/list'
                      },
                      {
                      label: 'Liste acess share',
                     to: '/admin/view/referetiel/acess-share/list'
                      },
                    ]
                    },
                {
                    label: 'User Management',
                    icon: 'pi pi-fw pi-pencil',
                    items: [
                      {
                      label: 'Liste entite administrative',
                     to: '/admin/view/user/entite-administrative/list'
                      },
                      {
                      label: 'Liste utilisateur',
                     to: '/admin/view/user/utilisateur/list'
                      },
                      {
                      label: 'Liste groupe',
                     to: '/admin/view/user/groupe/list'
                      },
                    ]
                    },

                {
                    label: 'Timeline',
                    icon: 'pi pi-fw pi-calendar',
                    to: '/pages/timeline'
                },
                {
                    label: 'Not Found',
                    icon: 'pi pi-fw pi-exclamation-circle',
                    to: '/pages/notfound'
                },
                {
                    label: 'Empty',
                    icon: 'pi pi-fw pi-circle-off',
                    to: '/pages/empty'
                }
            ]
        },

    ];

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
