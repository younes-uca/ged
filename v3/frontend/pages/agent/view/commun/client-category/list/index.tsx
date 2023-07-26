import {NextPageWithLayout} from 'next';
import {ReactNode} from 'react';

import ClientCategorysList from 'app/component/agent/view/commun/client-category/list/client-category-list-agent.component';
import Layout from 'layout/layout';

const ClientCategorys: NextPageWithLayout = () => {
    return <ClientCategorysList />
}

ClientCategorys.getLayout = function getLayout(page: ReactNode) {
    return (
        <Layout>
            {page}
        </Layout>
    )
}

export default ClientCategorys;
