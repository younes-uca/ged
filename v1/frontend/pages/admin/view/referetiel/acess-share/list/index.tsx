import {NextPageWithLayout} from 'next';
import {ReactNode} from 'react';

import AcessSharesList from '../../../../../../app/component/admin/view/referetiel/acess-share/list/acess-share-list-admin.component';
import Layout from '../../../../../../layout/layout';

const AcessShares: NextPageWithLayout = () => {
    return <AcessSharesList />
}

AcessShares.getLayout = function getLayout(page: ReactNode) {
    return (
        <Layout>
            {page}
        </Layout>
    )
}

export default AcessShares;
