import request from 'umi-request';

export async function submitAddItemForm(params) {
  return request('/api/products/create', {
    method: 'POST',
    data: params,
  });
}
