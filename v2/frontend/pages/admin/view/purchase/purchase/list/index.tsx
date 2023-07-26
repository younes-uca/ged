import {NextPageWithLayout} from 'next';
import {ReactNode} from 'react';

import PurchasesList from 'app/component/admin/view/purchase/purchase/list/purchase-list-admin.component';
import Layout from 'layout/layout';

const Purchases: NextPageWithLayout = () => {
    return <PurchasesList />
}

Purchases.getLayout = function getLayout(page: ReactNode) {
    return (
        <Layout>
            {page}
        </Layout>
    )
}

export default Purchases;
