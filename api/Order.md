#### 1.Create a new Order

##### POST /orders

###### request

```
shippingId
```

###### response

```json
{
  "status": 0,
  "data": {
    "orderId": "159588497874351000",
    "buyerUsername": "admin",
    "buyerPhone": "",
    "buyerAddress": "",
    "orderAmount": 6999.00,
    "payment": 6999.00,
    "paymentType": 1,
    "status": 10,
    "orderItemVoList": [
      {
        "orderId": "159588497874351000",
        "productId": "26",
        "sellerId": "1",
        "sellerUsername": "admin",
        "sellerPhone": "",
        "productName": "Apple iPhone 7 Plus (A1661) 128G 玫瑰金色 移动联通电信4G手机",
        "currentUnitPrice": 6999.00,
        "productQuantity": 1,
        "productImage": "http://img.springboot.cn/241997c4-9e62-4824-b7f0-7425c3c28917.jpeg",
        "totalPrice": 6999.00
      }
    ],
    "shippingId": 2,
    "shippingVo": {
      "id": 2,
      "userId": "1",
      "receiverName": "ADMIN",
      "receiverPhone": "8582341922",
      "receiverMobile": "8582341928",
      "receiverState": "NY",
      "receiverCity": "NY",
      "receiverAddress": "1234 B St",
      "receiverZip": "12345",
      "createTime": "Jul 27, 2020, 2:22:17 PM",
      "updateTime": "Jul 27, 2020, 2:22:17 PM"
    }
  }
}
```

#### 2.List Orders

##### GET /orders

###### request

```
pageSize(default=10)
pageNum(default=1)
```

订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭

###### response

```json
{
  "status": 0,
  "data": {
    "pageNum": 1,
    "pageSize": 2,
    "size": 2,
    "startRow": 1,
    "endRow": 2,
    "pages": 3,
    "prePage": 0,
    "nextPage": 2,
    "isFirstPage": true,
    "isLastPage": false,
    "hasPreviousPage": false,
    "hasNextPage": true,
    "navigatePages": 8,
    "navigatepageNums": [
      1,
      2,
      3
    ],
    "navigateFirstPage": 1,
    "navigateLastPage": 3,
    "total": 6,
    "list": [
      {
        "orderId": "159580791333854402",
        "buyerUsername": "admin",
        "buyerPhone": "",
        "buyerAddress": "",
        "orderAmount": 62991.00,
        "payment": 62991.00,
        "paymentType": 1,
        "status": 10,
        "createTime": "Jul 26, 2020, 4:58:33 PM",
        "orderItemVoList": [
          {
            "orderId": "159580791333854402",
            "productId": "26",
            "sellerId": "1",
            "sellerUsername": "admin",
            "sellerPhone": "",
            "productName": "Apple iPhone 7 Plus (A1661) 128G 玫瑰金色 移动联通电信4G手机",
            "currentUnitPrice": 6999.00,
            "productQuantity": 9,
            "productImage": "http://img.springboot.cn/241997c4-9e62-4824-b7f0-7425c3c28917.jpeg",
            "totalPrice": 62991.00,
            "createTime": "Jul 26, 2020, 4:58:33 PM"
          }
        ],
        "shippingId": 2,
        "shippingVo": {
          "id": 2,
          "userId": "1",
          "receiverName": "ADMIN",
          "receiverPhone": "8582341922",
          "receiverMobile": "8582341928",
          "receiverState": "NY",
          "receiverCity": "NY",
          "receiverAddress": "1234 B St",
          "receiverZip": "12345",
          "createTime": "Jul 27, 2020, 2:22:17 PM",
          "updateTime": "Jul 27, 2020, 2:22:17 PM"
        }
      },
      {
        "orderId": "159580793254319575",
        "buyerUsername": "admin",
        "buyerPhone": "",
        "buyerAddress": "",
        "orderAmount": 62991.00,
        "payment": 62991.00,
        "paymentType": 1,
        "status": 10,
        "createTime": "Jul 26, 2020, 4:58:55 PM",
        "orderItemVoList": [
          {
            "orderId": "159580793254319575",
            "productId": "26",
            "sellerId": "1",
            "sellerUsername": "admin",
            "sellerPhone": "",
            "productName": "Apple iPhone 7 Plus (A1661) 128G 玫瑰金色 移动联通电信4G手机",
            "currentUnitPrice": 6999.00,
            "productQuantity": 9,
            "productImage": "http://img.springboot.cn/241997c4-9e62-4824-b7f0-7425c3c28917.jpeg",
            "totalPrice": 62991.00,
            "createTime": "Jul 26, 2020, 4:58:57 PM"
          }
        ],
        "shippingId": 2,
        "shippingVo": {
          "id": 2,
          "userId": "1",
          "receiverName": "ADMIN",
          "receiverPhone": "8582341922",
          "receiverMobile": "8582341928",
          "receiverState": "NY",
          "receiverCity": "NY",
          "receiverAddress": "1234 B St",
          "receiverZip": "12345",
          "createTime": "Jul 27, 2020, 2:22:17 PM",
          "updateTime": "Jul 27, 2020, 2:22:17 PM"
        }
      }
    ]
  }
}
```

#### 3.Order Detail

##### GET /orders/{orderId}

###### request

```
orderId
```

###### response

fail

```json
{
    "status": 51,
    "msg": "order does not exist"
}
```

success

```json
{
  "status": 0,
  "data": {
    "orderId": "159588497861739125",
    "buyerUsername": "admin",
    "buyerPhone": "",
    "buyerAddress": "",
    "orderAmount": 6999.00,
    "payment": 6999.00,
    "paymentType": 1,
    "status": 10,
    "createTime": "Jul 27, 2020, 2:22:58 PM",
    "orderItemVoList": [
      {
        "orderId": "159588497861739125",
        "productId": "26",
        "sellerId": "1",
        "sellerUsername": "admin",
        "sellerPhone": "",
        "productName": "Apple iPhone 7 Plus (A1661) 128G 玫瑰金色 移动联通电信4G手机",
        "currentUnitPrice": 6999.00,
        "productQuantity": 1,
        "productImage": "http://img.springboot.cn/241997c4-9e62-4824-b7f0-7425c3c28917.jpeg",
        "totalPrice": 6999.00,
        "createTime": "Jul 27, 2020, 2:22:58 PM"
      }
    ],
    "shippingId": 2,
    "shippingVo": {
      "id": 2,
      "userId": "1",
      "receiverName": "ADMIN",
      "receiverPhone": "8582341922",
      "receiverMobile": "8582341928",
      "receiverState": "NY",
      "receiverCity": "NY",
      "receiverAddress": "1234 B St",
      "receiverZip": "12345",
      "createTime": "Jul 27, 2020, 2:22:17 PM",
      "updateTime": "Jul 27, 2020, 2:22:17 PM"
    }
  }
}
```

#### 4. Cancel Order

##### PUT /orders/{orderId}

###### request

```
orderId
```

###### response

fail

```json
{
    "status": 51,
    "msg": "order does not exist"
}
```

success

```json
{
    "status": 0,
    "msg": "success"
}
```
