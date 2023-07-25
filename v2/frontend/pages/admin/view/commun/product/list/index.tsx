import {NextPageWithLayout} from 'next';
import {ReactNode} from 'react';

import ProductsList from '../../../../../../app/component/admin/view/commun/product/list/product-list-admin.component';
import Layout from '../../../../../../layout/layout';

const Products: NextPageWithLayout = () => {
    return <ProductsList />
}

Products.getLayout = function getLayout(page: ReactNode) {
    return (
        <Layout>
            {page}
        </Layout>
    )
}

export default Products;
