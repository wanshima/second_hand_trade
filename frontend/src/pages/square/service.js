import request from 'umi-request';

export async function queryProductList(params) {
  return request('/api/products', {
    params,
  });
}

export async function queryCategoryList() {
  return request('/api/categories');
}
