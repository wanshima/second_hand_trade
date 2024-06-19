// eslint-disable-next-line import/no-extraneous-dependencies
export default {
  'POST  /api/user/register': (_, res) => {
    res.send({
      status: 0,
      msg: 'Success',
    });
  },
};
