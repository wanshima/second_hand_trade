#### 1. Login

**POST /user/login** 

###### request

Content-Type: application/json

```json
{
    "userEmail" : "2@com",
    "password" : "123456"
}
```

###### response

fail

```json
{
    "status": 11,
    "msg": "invalid username or password"
}
```

success

```json
{
    "status": 0,
    "data": {
        "userId": "159477922567016499",
        "userEmail": "2@com",
        "username": "2b",
        "userAuthority": 1,
        "userPhone": "",
        "userAddress": "",
        "userStatus": 0,
        "userIcon": "",
        "userBio": "",
        "createTime": "2020-07-14T19:13:45.000+0000",
        "updateTime": "2020-07-14T19:13:45.000+0000"
    }
}
```

#### 2.Register

**POST /user/register**

###### request

```json
{
    "userEmail" : "hanjiabeineo@gmail.com",
    "username" : "Neo333",
    "password" : "123456"
}
```

###### response

fail (user exists)

```json
{
    "status": 3,
    "msg": "email has been registered"
}
```

fail (form error)

```json
{
    "status": 2,
    "msg": "userEmail invalid email format"
}
```

#### 3.Get User Login Information

**GET /user**

###### request

```
no parameters
```

###### response

fail

```json
{
    "status": 10,
    "msg": "please login first"
}
```

success

```json
{
    "status": 0,
    "data": {
        "userId": "1594398372827641963",
        "userEmail": "hanjiabeineo@gmail.com",
        "username": "Neo333",
        "userAuthority": 1,
        "userPhone": "8583491027",
        "userAddress": "8026 Avenida Navidad",
        "userStatus": 0,
        "userBio": "hello",
        "createTime": "2020-07-10T09:26:13.000+0000",
        "updateTime": "2020-07-10T09:26:13.000+0000"
    }
}
```

#### 4.Logout

**POST /user/logout**

###### request

```
no parameters
```



###### respond

fail

```json
{
    "status": -1,
    "msg": "server error"
}
```

success

```json
{
    "status": 0,
    "msg": "success"
}
```

#### 5.Update

##### POST /user/update

###### request

```json
{
    "userPhone" : "12345678",
    "userAddress" : "xxxx xxxxx xxxxx",
    "userBio" : "ECE Master Student"
}
```

###### response

fail

```json
{
    "status": -1,
    "msg": "server error"
}
```

success

```json
{
    "status": 0,
    "msg": "success"
}
```

