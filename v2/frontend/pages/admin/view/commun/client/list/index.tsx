import {NextPageWithLayout} from 'next';
import {ReactNode} from 'react';

import ClientsList from '../../../../../../app/component/admin/view/commun/client/list/client-list-admin.component';
import Layout from '../../../../../../layout/layout';

const Clients: NextPageWithLayout = () => {
    return <ClientsList />
}

Clients.getLayout = function getLayout(page: ReactNode) {
    return (
        <Layout>
            {page}
        </Layout>
    )
}

export default Clients;
