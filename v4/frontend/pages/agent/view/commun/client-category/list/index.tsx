import {NextPageWithLayout} from 'next';
import {ReactNode} from 'react';

import ClientCategorysList from 'app/component/agent/view/commun/client-category/list/client-category-list-agent.component';
import Layout from 'layout/layout';
import AuthGuard from 'app/component/auth/auth-guard.component';

const ClientCategorys: NextPageWithLayout = () => {
    return <ClientCategorysList />
}

ClientCategorys.getLayout = function getLayout(page: ReactNode) {
    return (
    <AuthGuard>
        <Layout>
            {page}
        </Layout>
    </AuthGuard>
    )
}

export default ClientCategorys;
