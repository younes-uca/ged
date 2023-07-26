import {NextPageWithLayout} from 'next';
import {ReactNode} from 'react';

import PurchasesList from 'app/component/agent/view/purchase/purchase/list/purchase-list-agent.component';
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
