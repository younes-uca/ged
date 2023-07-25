import {NextPageWithLayout} from 'next';
import {ReactNode} from 'react';

import ClientCategorysList from '../../../../../../app/component/admin/view/commun/client-category/list/client-category-list-admin.component';
import Layout from '../../../../../../layout/layout';

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
