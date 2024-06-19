import request from 'umi-request';

export async function queryItem(productId) {
  return request(`/api/products/${productId}`);
}