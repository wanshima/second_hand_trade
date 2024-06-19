#### 1.Product List

##### GET /products

###### request

```
categoryId(Not necessary)
pageNum(default=1)
pageSize(default=10)
```

###### response

```json
{
    "status": 0,
    "data": {
        "total": 0,
        "list": [
            {
                "productId": "1594702256159890728",
                "categoryId": 100413,
                "sellerId": "1",
                "name": "2016 Honda Civic",
                "mainImage": "",
                "price": 14000.00,
                "status": 1,
                "updateTime": "2020-07-14T19:09:29.000+0000",
                "member": {
                    "username": "admin",
                    "userIcon": "https://gw.alipayobjects.com/zos/rmsportal/ZiESqWwCXBRQoaPONSJe.png"
                }
            },
            {
                "productId": "1594708702681438322",
                "categoryId": 100411,
                "sellerId": "1594698431209452243",
                "name": "RAV-4",
                "mainImage": "",
                "price": 15500.00,
                "status": 1,
                "updateTime": "2020-07-14T19:09:35.000+0000",
                "member": {
                    "username": "Neo333",
                    "userIcon": "https://gw.alipayobjects.com/zos/rmsportal/sBxjgqiuHMGRkIjqlQCd.png"
                }
            },
            {
                "productId": "1594778510415339347",
                "categoryId": 100412,
                "sellerId": "1594698431209452243",
                "name": "C43-AMG",
                "mainImage": "",
                "price": 35000.00,
                "status": 1,
                "updateTime": "2020-07-14T19:01:50.000+0000",
                "member": {
                    "username": "Neo333",
                    "userIcon": "https://gw.alipayobjects.com/zos/rmsportal/sBxjgqiuHMGRkIjqlQCd.png"
                }
            },
            {
                "productId": "26",
                "categoryId": 100022,
                "sellerId": "1",
                "name": "Apple iPhone 7 Plus (A1661) 128G 玫瑰金色 移动联通电信4G手机",
                "mainImage": "http://img.springboot.cn/241997c4-9e62-4824-b7f0-7425c3c28917.jpeg",
                "price": 6999.00,
                "status": 1,
                "updateTime": "2000-04-13T21:45:41.000+0000",
                "member": {
                    "username": "admin",
                    "userIcon": "https://gw.alipayobjects.com/zos/rmsportal/ZiESqWwCXBRQoaPONSJe.png"
                }
            }
        ],
        "pageNum": 0,
        "pageSize": 0,
        "size": 0,
        "startRow": 0,
        "endRow": 0,
        "pages": 0,
        "prePage": 0,
        "nextPage": 0,
        "isFirstPage": false,
        "isLastPage": false,
        "hasPreviousPage": false,
        "hasNextPage": false,
        "navigatePages": 0,
        "navigatepageNums": null,
        "navigateFirstPage": 0,
        "navigateLastPage": 0
    }
}
```

#### 2.Product Detail

##### GET /products/{productId}

###### request

```
productId
```

###### response

```json
{
    "status": 0,
    "data": {
        "productId": "26",
        "categoryId": 100022,
        "sellerId": "1",
        "name": "Apple iPhone 7 Plus (A1661) 128G 玫瑰金色 移动联通电信4G手机",
        "subtitle": "iPhone 7，现更以红色呈现。",
        "mainImage": "http://img.springboot.cn/241997c4-9e62-4824-b7f0-7425c3c28917.jpeg",
        "subImages": "241997c4-9e62-4824-b7f0-7425c3c28917.jpeg,b6c56eb0-1748-49a9-98dc-bcc4b9788a54.jpeg,92f17532-1527-4563-aa1d-ed01baa0f7b2.jpeg,3adbe4f7-e374-4533-aa79-cc4a98c529bf.jpeg",
        "detail": "<p><img alt=\"10000.jpg\" src=\"http://img.springboot.cn/00bce8d4-e9af-4c8d-b205-e6c75c7e252b.jpg\" width=\"790\" height=\"553\"><br></p><p><img alt=\"20000.jpg\" src=\"http://img.springboot.cn/4a70b4b4-01ee-46af-9468-31e67d0995b8.jpg\" width=\"790\" height=\"525\"><br></p><p><img alt=\"30000.jpg\" src=\"http://img.springboot.cn/0570e033-12d7-49b2-88f3-7a5d84157223.jpg\" width=\"790\" height=\"365\"><br></p><p><img alt=\"40000.jpg\" src=\"http://img.springboot.cn/50515c02-3255-44b9-a829-9e141a28c08a.jpg\" width=\"790\" height=\"525\"><br></p><p><img alt=\"50000.jpg\" src=\"http://img.springboot.cn/c138fc56-5843-4287-a029-91cf3732d034.jpg\" width=\"790\" height=\"525\"><br></p><p><img alt=\"60000.jpg\" src=\"http://img.springboot.cn/c92d1f8a-9827-453f-9d37-b10a3287e894.jpg\" width=\"790\" height=\"525\"><br></p><p><br></p><p><img alt=\"TB24p51hgFkpuFjSspnXXb4qFXa-1776456424.jpg\" src=\"http://img.springboot.cn/bb1511fc-3483-471f-80e5-c7c81fa5e1dd.jpg\" width=\"790\" height=\"375\"><br></p><p><br></p><p><img alt=\"shouhou.jpg\" src=\"http://img.springboot.cn/698e6fbe-97ea-478b-8170-008ad24030f7.jpg\" width=\"750\" height=\"150\"><br></p><p><img alt=\"999.jpg\" src=\"http://img.springboot.cn/ee276fe6-5d79-45aa-8393-ba1d210f9c89.jpg\" width=\"790\" height=\"351\"><br></p>",
        "price": 6999.00,
        "stock": 100,
        "status": 1,
        "updateTime": "2000-04-13T21:45:41.000+0000"
    }
}
```

#### 3.Product Create

##### POST /products/create

###### request

```
categoryId (required);
name (required);
subtitle;
mainImage;
subImages;
detail;
price (required);
stock (required);
```

###### response

fail

```json
{
    "status": -1,
    "msg": "server error"
}
Or
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
        "productId": "1594778510415339347",
        "categoryId": 100412,
        "sellerId": "1594698431209452243",
        "name": "C43-AMG",
        "subtitle": "",
        "mainImage": "",
        "subImages": "",
        "detail": "",
        "price": 35000,
        "stock": 1,
        "status": 1
    }
}
```

#### 4. Product Update

##### POST /products/update

###### request

```
categoryId;
name;
subtitle;
mainImage;
subImages;
detail;
price;
stock;
```

###### response

fail

```json
{
    "status": -1,
    "msg": "server error"
}
Or
{
    "status": 10,
    "msg": "please login first"
}
```

success

```json
{
    "status": 0,
    "msg": "success"
}
```

#### 5.List products of a user

##### GET /products/user

###### request

```
uid(userId) (PathParam)
pageNum(default=1)
pageSize(default=10)
```

###### response

fail

```json
{
    "status": -1,
    "msg": "server error"
}
Or
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
        "total": 0,
        "list": [
            {
                "productId": "1594702256159890728",
                "categoryId": 100413,
                "sellerId": "1",
                "name": "2016 Honda Civic",
                "subtitle": "",
                "mainImage": "",
                "price": 14000.00,
                "status": 1,
                "updateTime": "2020-07-14T19:09:29.000+0000"
            },
            {
                "productId": "26",
                "categoryId": 100022,
                "sellerId": "1",
                "name": "Apple iPhone 7 Plus (A1661) 128G 玫瑰金色 移动联通电信4G手机",
                "subtitle": "iPhone 7，现更以红色呈现。",
                "mainImage": "http://img.springboot.cn/241997c4-9e62-4824-b7f0-7425c3c28917.jpeg",
                "price": 6999.00,
                "status": 1,
                "updateTime": "2000-04-13T21:45:41.000+0000"
            },
            {
                "productId": "27",
                "categoryId": 100012,
                "sellerId": "1",
                "name": "Midea/美的 BCD-535WKZM(E)冰箱双开门对开门风冷无霜智能电家用",
                "subtitle": "送品牌烤箱，五一大促",
                "mainImage": "http://img.springboot.cn/ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg",
                "price": 3299.00,
                "status": 1,
                "updateTime": "2000-04-13T21:45:41.000+0000"
            },
            {
                "productId": "28",
                "categoryId": 100022,
                "sellerId": "1",
                "name": "4+64G送手环/Huawei/华为 nova 手机P9/P10plus青春",
                "subtitle": "NOVA青春版1999元",
                "mainImage": "http://img.springboot.cn/0093f5d3-bdb4-4fb0-bec5-5465dfd26363.jpeg",
                "price": 1999.00,
                "status": 1,
                "updateTime": "2000-04-13T21:45:41.000+0000"
            },
            {
                "productId": "29",
                "categoryId": 100011,
                "sellerId": "1",
                "name": "Haier/海尔HJ100-1HU1 10公斤滚筒洗衣机全自动带烘干家用大容量 洗烘一体",
                "subtitle": "门店机型 德邦送货",
                "mainImage": "http://img.springboot.cn/173335a4-5dce-4afd-9f18-a10623724c4e.jpeg",
                "price": 4299.00,
                "status": 1,
                "updateTime": "2000-04-13T21:45:41.000+0000"
            }
        ],
        "pageNum": 0,
        "pageSize": 0,
        "size": 0,
        "startRow": 0,
        "endRow": 0,
        "pages": 0,
        "prePage": 0,
        "nextPage": 0,
        "isFirstPage": false,
        "isLastPage": false,
        "hasPreviousPage": false,
        "hasNextPage": false,
        "navigatePages": 0,
        "navigatepageNums": null,
        "navigateFirstPage": 0,
        "navigateLastPage": 0
    }
}
```

