import request from 'umi-request';

export async function Register(params) {
  return request('/api/user/register', {
    method: 'POST',
    data: params,
  });
}
