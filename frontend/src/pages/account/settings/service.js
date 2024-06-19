import request from 'umi-request';

export async function queryCurrent() {
  return request('/api/user');
}
export async function query() {
  return request('/api/users');
}
