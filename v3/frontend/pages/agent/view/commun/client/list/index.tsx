import {NextPageWithLayout} from 'next';
import {ReactNode} from 'react';

import ClientsList from 'app/component/agent/view/commun/client/list/client-list-agent.component';
import Layout from 'layout/layout';

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
