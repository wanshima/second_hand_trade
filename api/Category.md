#### 1.All Categories

##### GET /categories

###### request

```
no need to login
```

###### response

success

```json
{
    "status": 0,
    "data": [
        {
            "categoryId": 100001,
            "parentId": 0,
            "categoryName": "Household Appliances",
            "sortOrder": 1,
            "subCategories": [
                {
                    "categoryId": 100010,
                    "parentId": 100001,
                    "categoryName": "Televisions",
                    "sortOrder": 1,
                    "subCategories": []
                },
                {
                    "categoryId": 100011,
                    "parentId": 100001,
                    "categoryName": "Wshing Machines",
                    "sortOrder": 1,
                    "subCategories": []
                },
                {
                    "categoryId": 100012,
                    "parentId": 100001,
                    "categoryName": "Refrigerators",
                    "sortOrder": 1,
                    "subCategories": []
                }
            ]
        },
        {
            "categoryId": 100002,
            "parentId": 0,
            "categoryName": "Electronics",
            "sortOrder": 1,
            "subCategories": [
                {
                    "categoryId": 100021,
                    "parentId": 100002,
                    "categoryName": "Computers",
                    "sortOrder": 1,
                    "subCategories": [
                        {
                            "categoryId": 100211,
                            "parentId": 100021,
                            "categoryName": "Mac",
                            "sortOrder": 1,
                            "subCategories": []
                        },
                        {
                            "categoryId": 100212,
                            "parentId": 100021,
                            "categoryName": "PC",
                            "sortOrder": 1,
                            "subCategories": []
                        }
                    ]
                },
                {
                    "categoryId": 100022,
                    "parentId": 100002,
                    "categoryName": "Smartphones",
                    "sortOrder": 1,
                    "subCategories": []
                },
                {
                    "categoryId": 100023,
                    "parentId": 100002,
                    "categoryName": "Tablets",
                    "sortOrder": 1,
                    "subCategories": []
                },
                {
                    "categoryId": 100024,
                    "parentId": 100002,
                    "categoryName": "Cameras",
                    "sortOrder": 1,
                    "subCategories": []
                },
                {
                    "categoryId": 100025,
                    "parentId": 100002,
                    "categoryName": "Accessories",
                    "sortOrder": 1,
                    "subCategories": []
                },
                {
                    "categoryId": 100026,
                    "parentId": 100002,
                    "categoryName": "Gaming",
                    "sortOrder": 1,
                    "subCategories": []
                }
            ]
        },
        {
            "categoryId": 100003,
            "parentId": 0,
            "categoryName": "Clothes&Furniture",
            "sortOrder": 1,
            "subCategories": [
                {
                    "categoryId": 100031,
                    "parentId": 100003,
                    "categoryName": "Women Clothes",
                    "sortOrder": 1,
                    "subCategories": []
                },
                {
                    "categoryId": 100032,
                    "parentId": 100003,
                    "categoryName": "Men Clothes",
                    "sortOrder": 1,
                    "subCategories": []
                },
                {
                    "categoryId": 100033,
                    "parentId": 100003,
                    "categoryName": "Bags&Suitcases",
                    "sortOrder": 1,
                    "subCategories": []
                },
                {
                    "categoryId": 100034,
                    "parentId": 100003,
                    "categoryName": "Sofa",
                    "sortOrder": 1,
                    "subCategories": []
                },
                {
                    "categoryId": 100035,
                    "parentId": 100003,
                    "categoryName": "Tables&Chairs",
                    "sortOrder": 1,
                    "subCategories": []
                },
                {
                    "categoryId": 100036,
                    "parentId": 100003,
                    "categoryName": "Lamps",
                    "sortOrder": 1,
                    "subCategories": []
                },
                {
                    "categoryId": 100037,
                    "parentId": 100003,
                    "categoryName": "Beds&Mattresses",
                    "sortOrder": 1,
                    "subCategories": []
                },
                {
                    "categoryId": 100038,
                    "parentId": 100003,
                    "categoryName": "Shoes",
                    "sortOrder": 1,
                    "subCategories": []
                }
            ]
        },
        {
            "categoryId": 100004,
            "parentId": 0,
            "categoryName": "Transportation",
            "sortOrder": 1,
            "subCategories": [
                {
                    "categoryId": 100041,
                    "parentId": 100004,
                    "categoryName": "Automobile",
                    "sortOrder": 1,
                    "subCategories": [
                        {
                            "categoryId": 100411,
                            "parentId": 100041,
                            "categoryName": "SUV",
                            "sortOrder": 1,
                            "subCategories": []
                        },
                        {
                            "categoryId": 100412,
                            "parentId": 100041,
                            "categoryName": "Coupe",
                            "sortOrder": 1,
                            "subCategories": []
                        },
                        {
                            "categoryId": 100413,
                            "parentId": 100041,
                            "categoryName": "Sedan",
                            "sortOrder": 1,
                            "subCategories": []
                        }
                    ]
                },
                {
                    "categoryId": 100042,
                    "parentId": 100004,
                    "categoryName": "Bike",
                    "sortOrder": 1,
                    "subCategories": []
                },
                {
                    "categoryId": 100043,
                    "parentId": 100004,
                    "categoryName": "Others",
                    "sortOrder": 1,
                    "subCategories": []
                }
            ]
        },
        {
            "categoryId": 100005,
            "parentId": 0,
            "categoryName": "Rental",
            "sortOrder": 1,
            "subCategories": []
        },
        {
            "categoryId": 100006,
            "parentId": 0,
            "categoryName": "Daily Necessities",
            "sortOrder": 1,
            "subCategories": [
                {
                    "categoryId": 100061,
                    "parentId": 100006,
                    "categoryName": "Kitchenware",
                    "sortOrder": 1,
                    "subCategories": []
                },
                {
                    "categoryId": 100062,
                    "parentId": 100006,
                    "categoryName": "General",
                    "sortOrder": 1,
                    "subCategories": []
                }
            ]
        },
        {
            "categoryId": 100007,
            "parentId": 0,
            "categoryName": "Others",
            "sortOrder": 1,
            "subCategories": []
        }
    ]
}
```

