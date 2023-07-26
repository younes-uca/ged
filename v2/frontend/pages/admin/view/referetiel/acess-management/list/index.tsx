import {NextPageWithLayout} from 'next';
import {ReactNode} from 'react';

import AcessManagementsList from 'app/component/admin/view/referetiel/acess-management/list/acess-management-list-admin.component';
import Layout from 'layout/layout';

const AcessManagements: NextPageWithLayout = () => {
    return <AcessManagementsList />
}

AcessManagements.getLayout = function getLayout(page: ReactNode) {
    return (
        <Layout>
            {page}
        </Layout>
    )
}

export default AcessManagements;
