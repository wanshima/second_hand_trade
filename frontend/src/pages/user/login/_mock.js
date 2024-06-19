// eslint-disable-next-line import/no-extraneous-dependencies
function getFakeCaptcha(req, res) {
  return res.json('captcha-xxx');
}

export default {
  'POST  /api/login/account': (req, res) => {
    const { password, userName, type } = req.body;

    if (password === 'ant.design' && userName === 'admin') {
      res.send({
        status: 'ok',
        type,
        currentAuthority: 'admin',
      });
      return;
    }

    if (password === 'ant.design' && userName === 'user') {
      res.send({
        status: 'ok',
        type,
        currentAuthority: 'user',
      });
      return;
    }

    if (type === 'mobile') {
      res.send({
        status: 'ok',
        type,
        currentAuthority: 'admin',
      });
      return;
    }

    res.send({
      status: 'error',
      type,
      currentAuthority: 'guest',
    });
  },
  'GET  /api/login/captcha': getFakeCaptcha,
  'POST /api/user/login': (req, res) => {
    let { username, password } = req.body;
    if (password === 'chang' && username === 'chang') {
      res.send({
        status: 0,
        data: {
          userId: "1594398372827641963",
          password: "",
          username: "chang",
          userEmail: "aaa@163.com",
          userAuthority: 1,
          userPhone: "8583491027",
          userAddress: "8026 Avenida Navidad",
          userBio: "hello",
          openid: null,
          userIcon: null,
          userStatus: 0,
          userStatus: 0,
          createTime: 1479048325000,
          updateTime: 1479048325000,
        }
      });
      return;
    } else {
      res.send({
        status: 11,
        msg: "invalid username or password",
      })
    }
  },
};
