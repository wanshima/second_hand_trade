CREATE TABLE `product_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类别Id',
  `parent_id` int(11) NOT NULL COMMENT '父类别id当id=0时说明是根节点,一级类别',
  `category_name` varchar(50) NOT NULL DEFAULT '' COMMENT '类别名称',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '类别状态1-正常,2-已废弃',
  `sort_order` int(4) NOT NULL DEFAULT '1' COMMENT '排序编号,同类展示顺序,数值相等则自然排序',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100414 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `user_info` (
  `user_id` varchar(32) NOT NULL,
  `user_email` varchar(64) NOT NULL COMMENT '用户注册邮箱',
  `username` varchar(32) NOT NULL COMMENT '用户昵称',
  `password` varchar(32) NOT NULL COMMENT '用户密码',
  `user_authority` int(3) NOT NULL DEFAULT '0' COMMENT '用户权限',
  `openid` varchar(32) DEFAULT NULL COMMENT '用户第三方id',
  `user_phone` varchar(16) DEFAULT '' COMMENT '用户手机',
  `user_address` varchar(128) DEFAULT '' COMMENT '用户大概的位置',
  `user_status` int(3) NOT NULL DEFAULT '0' COMMENT '账户状态',
  `user_icon` varchar(512) DEFAULT '' COMMENT '用户头像',
  `user_bio` varchar(512) DEFAULT '' COMMENT '用户个人介绍',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_email` (`user_email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';

INSERT INTO `user_info` (`user_id`,`user_email`,`username`,`password`,`user_authority`,`user_status`,`create_time`,`update_time`)
VALUES
('1','admin@admin','admin','e10adc3949ba59abbe56e057f20f883e',0,0,'2020-07-10 23:25:40','2020-07-10 23:25:40');

CREATE TABLE `shipping_info` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户id',
  `receiver_name` varchar(20) DEFAULT NULL COMMENT '收货姓名',
  `receiver_phone` varchar(20) DEFAULT NULL COMMENT '收货固定电话',
  `receiver_mobile` varchar(20) DEFAULT NULL COMMENT '收货移动电话',
  `receiver_state` varchar(20) DEFAULT NULL COMMENT '所在州',
  `receiver_city` varchar(20) DEFAULT NULL COMMENT '城市',
  `receiver_address` varchar(200) DEFAULT NULL COMMENT '详细地址',
  `receiver_zip` varchar(6) DEFAULT NULL COMMENT '邮编',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `shipping_info_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `product_category` (`category_id`, `parent_id`, `category_name`, `status`, `sort_order`, `create_time`, `update_time`)
VALUES
  (100001,0,'Household Appliances',1,1,'2000-03-25 16:46:00','2000-03-25 16:46:00'),
  (100002,0,'Electronics',1,1,'2000-03-25 16:46:21','2000-03-25 16:46:21'),
  (100003,0,'Clothes&Furniture',1,1,'2000-03-25 16:49:53','2000-03-25 16:49:53'),
  (100004,0,'Transportation',1,1,'2000-03-25 16:50:19','2000-03-25 16:50:19'),
  (100005,0,'Rental',1,1,'2000-03-25 16:50:29','2000-03-25 16:50:29'),
  (100006,0,'Daily Necessities',1,1,'2000-03-25 16:52:15','2000-03-25 16:52:15'),
  (100007,0,'Others',1,1,'2000-03-25 16:52:17','2000-03-25 16:52:17'),
  (100010,100001,'Televisions',1,1,'2000-03-25 16:52:26','2000-03-25 16:52:26'),
  (100011,100001,'Wshing Machines',1,1,'2000-03-25 16:52:39','2000-03-25 16:52:39'),
  (100012,100001,'Refrigerators',1,1,'2000-03-25 16:52:45','2000-03-25 16:52:45'),
  (100021,100002,'Computers',1,1,'2000-03-25 16:53:18','2000-03-25 16:53:18'),
  (100022,100002,'Smartphones',1,1,'2000-03-25 16:53:27','2000-03-25 16:53:27'),
  (100023,100002,'Tablets',1,1,'2000-03-25 16:53:35','2000-03-25 16:53:35'),
  (100024,100002,'Cameras',1,1,'2000-03-25 16:53:56','2000-03-25 16:53:56'),
  (100025,100002,'Accessories',1,1,'2000-03-25 16:54:07','2000-03-25 16:54:07'),
  (100026,100002,'Gaming',1,1,'2000-03-25 16:54:09','2000-03-25 16:54:09'),
  (100031,100003,'Women Clothes',1,1,'2000-03-25 16:54:44','2000-03-25 16:54:44'),
  (100032,100003,'Men Clothes',1,1,'2000-03-25 16:54:51','2000-03-25 16:54:51'),
  (100033,100003,'Bags&Suitcases',1,1,'2000-03-25 16:55:02','2000-03-25 16:55:02'),
  (100034,100003,'Sofa',1,1,'2000-03-25 16:55:09','2000-03-25 16:55:09'),
  (100035,100003,'Tables&Chairs',1,1,'2000-03-25 16:55:18','2000-03-25 16:55:18'),
  (100036,100003,'Lamps',1,1,'2000-03-25 16:55:18','2000-03-25 16:55:18'),
  (100037,100003,'Beds&Mattresses',1,1,'2000-03-25 16:55:19','2000-03-25 16:55:19'),
  (100038,100003,'Shoes',1,1,'2000-03-25 16:55:14','2000-03-25 16:55:14'),
  (100041,100004,'Automobile',1,1,'2000-03-25 16:55:30','2000-03-25 16:55:30'),
  (100042,100004,'Bike',1,1,'2000-03-25 16:55:37','2000-03-25 16:55:37'),
  (100043,100004,'Others',1,1,'2000-03-25 16:55:47','2000-03-25 16:55:47'),
  (100061,100006,'Kitchenware',1,1,'2000-03-25 16:55:56','2000-03-25 16:55:56'),
  (100062,100006,'General',1,1,'2000-03-25 16:56:06','2000-03-25 16:56:06'),
  (100411,100041,'SUV',1,1,'2000-03-25 16:56:22','2000-03-25 16:56:22'),
  (100412,100041,'Coupe',1,1,'2000-03-25 16:56:30','2000-03-25 16:56:30'),
  (100413,100041,'Sedan',1,1,'2000-03-25 16:56:37','2000-03-25 16:56:37'),
  (100211,100021,'Mac',1,1,'2000-03-25 16:56:45','2000-03-25 16:56:45'),
  (100212,100021,'PC',1,1,'2000-03-25 16:57:05','2000-03-25 16:57:05');

CREATE TABLE `product_info` (
  `product_id` varchar(32) NOT NULL,
  `category_id` int(11) NOT NULL COMMENT '分类id,对应mall_category表的主键',
  `seller_id` varchar(32) NOT NULL COMMENT '卖家id',
  `name` varchar(64) NOT NULL COMMENT '商品名称',
  `subtitle` varchar(256) DEFAULT '' COMMENT '商品副标题',
  `main_image` varchar(500) DEFAULT '' COMMENT '产品主图,url相对地址',
  `sub_images` text COMMENT '图片地址,json格式,扩展用',
  `detail` text COMMENT '商品详情',
  `price` decimal(16,2) NOT NULL COMMENT '单价',
  `stock` int(11) NOT NULL DEFAULT '1' COMMENT '库存',
  `status` int(6) NOT NULL DEFAULT '1' COMMENT '商品状态.1-在售 2-下架 3-删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`product_id`),
  KEY `seller_id` (`seller_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `product_info_ibfk_1` FOREIGN KEY (`seller_id`) REFERENCES `user_info` (`user_id`) ON DELETE CASCADE,
  CONSTRAINT `product_info_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `product_category` (`category_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品信息表';

INSERT INTO `product_info` (`product_id`, `category_id`, `seller_id`, `name`, `subtitle`, `main_image`, `sub_images`, `detail`, `price`, `stock`, `status`, `create_time`, `update_time`)
VALUES
	('26',100022,'1','Apple iPhone 7 Plus (A1661) 128G 玫瑰金色 移动联通电信4G手机','iPhone 7，现更以红色呈现。','http://img.springboot.cn/241997c4-9e62-4824-b7f0-7425c3c28917.jpeg','241997c4-9e62-4824-b7f0-7425c3c28917.jpeg,b6c56eb0-1748-49a9-98dc-bcc4b9788a54.jpeg,92f17532-1527-4563-aa1d-ed01baa0f7b2.jpeg,3adbe4f7-e374-4533-aa79-cc4a98c529bf.jpeg','<p><img alt=\"10000.jpg\" src=\"http://img.springboot.cn/00bce8d4-e9af-4c8d-b205-e6c75c7e252b.jpg\" width=\"790\" height=\"553\"><br></p><p><img alt=\"20000.jpg\" src=\"http://img.springboot.cn/4a70b4b4-01ee-46af-9468-31e67d0995b8.jpg\" width=\"790\" height=\"525\"><br></p><p><img alt=\"30000.jpg\" src=\"http://img.springboot.cn/0570e033-12d7-49b2-88f3-7a5d84157223.jpg\" width=\"790\" height=\"365\"><br></p><p><img alt=\"40000.jpg\" src=\"http://img.springboot.cn/50515c02-3255-44b9-a829-9e141a28c08a.jpg\" width=\"790\" height=\"525\"><br></p><p><img alt=\"50000.jpg\" src=\"http://img.springboot.cn/c138fc56-5843-4287-a029-91cf3732d034.jpg\" width=\"790\" height=\"525\"><br></p><p><img alt=\"60000.jpg\" src=\"http://img.springboot.cn/c92d1f8a-9827-453f-9d37-b10a3287e894.jpg\" width=\"790\" height=\"525\"><br></p><p><br></p><p><img alt=\"TB24p51hgFkpuFjSspnXXb4qFXa-1776456424.jpg\" src=\"http://img.springboot.cn/bb1511fc-3483-471f-80e5-c7c81fa5e1dd.jpg\" width=\"790\" height=\"375\"><br></p><p><br></p><p><img alt=\"shouhou.jpg\" src=\"http://img.springboot.cn/698e6fbe-97ea-478b-8170-008ad24030f7.jpg\" width=\"750\" height=\"150\"><br></p><p><img alt=\"999.jpg\" src=\"http://img.springboot.cn/ee276fe6-5d79-45aa-8393-ba1d210f9c89.jpg\" width=\"790\" height=\"351\"><br></p>',6999.00,96,1,NULL,'2000-04-13 21:45:41'),
	('27',100012,'1','Midea/美的 BCD-535WKZM(E)冰箱双开门对开门风冷无霜智能电家用','送品牌烤箱，五一大促','http://img.springboot.cn/ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg','ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg,4bb02f1c-62d5-48cc-b358-97b05af5740d.jpeg,36bdb49c-72ae-4185-9297-78829b54b566.jpeg','<p><img alt=\"miaoshu.jpg\" src=\"http://img.springboot.cn/9c5c74e6-6615-4aa0-b1fc-c17a1eff6027.jpg\" width=\"790\" height=\"444\"><br></p><p><img alt=\"miaoshu2.jpg\" src=\"http://img.springboot.cn/31dc1a94-f354-48b8-a170-1a1a6de8751b.jpg\" width=\"790\" height=\"1441\"><img alt=\"miaoshu3.jpg\" src=\"http://img.springboot.cn/7862594b-3063-4b52-b7d4-cea980c604e0.jpg\" width=\"790\" height=\"1442\"><img alt=\"miaoshu4.jpg\" src=\"http://img.springboot.cn/9a650563-dc85-44d6-b174-d6960cfb1d6a.jpg\" width=\"790\" height=\"1441\"><br></p>',3299.00,99,1,'2000-04-13 18:51:54','2000-04-13 21:45:41'),
	('28',100022,'1','4+64G送手环/Huawei/华为 nova 手机P9/P10plus青春','NOVA青春版1999元','http://img.springboot.cn/0093f5d3-bdb4-4fb0-bec5-5465dfd26363.jpeg','0093f5d3-bdb4-4fb0-bec5-5465dfd26363.jpeg,13da2172-4445-4eb5-a13f-c5d4ede8458c.jpeg,58d5d4b7-58d4-4948-81b6-2bae4f79bf02.jpeg','<p><img alt=\"11TB2fKK3cl0kpuFjSsziXXa.oVXa_!!1777180618.jpg\" src=\"http://img.springboot.cn/5c2d1c6d-9e09-48ce-bbdb-e833b42ff664.jpg\" width=\"790\" height=\"966\"><img alt=\"22TB2YP3AkEhnpuFjSZFpXXcpuXXa_!!1777180618.jpg\" src=\"http://img.springboot.cn/9a10b877-818f-4a27-b6f7-62887f3fb39d.jpg\" width=\"790\" height=\"1344\"><img alt=\"33TB2Yyshk.hnpuFjSZFpXXcpuXXa_!!1777180618.jpg\" src=\"http://img.springboot.cn/7d7fbd69-a3cb-4efe-8765-423bf8276e3e.jpg\" width=\"790\" height=\"700\"><img alt=\"TB2diyziB8kpuFjSspeXXc7IpXa_!!1777180618.jpg\" src=\"http://img.springboot.cn/1d7160d2-9dba-422f-b2a0-e92847ba6ce9.jpg\" width=\"790\" height=\"393\"><br></p>',1999.00,100,1,'2000-04-13 18:57:18','2000-04-13 21:45:41'),
	('29',100011,'1','Haier/海尔HJ100-1HU1 10公斤滚筒洗衣机全自动带烘干家用大容量 洗烘一体','门店机型 德邦送货','http://img.springboot.cn/173335a4-5dce-4afd-9f18-a10623724c4e.jpeg','173335a4-5dce-4afd-9f18-a10623724c4e.jpeg,42b1b8bc-27c7-4ee1-80ab-753d216a1d49.jpeg,2f1b3de1-1eb1-4c18-8ca2-518934931bec.jpeg','<p><img alt=\"1TB2WLZrcIaK.eBjSspjXXXL.XXa_!!2114960396.jpg\" src=\"http://img.springboot.cn/ffcce953-81bd-463c-acd1-d690b263d6df.jpg\" width=\"790\" height=\"920\"><img alt=\"2TB2zhOFbZCO.eBjSZFzXXaRiVXa_!!2114960396.jpg\" src=\"http://img.springboot.cn/58a7bd25-c3e7-4248-9dba-158ef2a90e70.jpg\" width=\"790\" height=\"1052\"><img alt=\"3TB27mCtb7WM.eBjSZFhXXbdWpXa_!!2114960396.jpg\" src=\"http://img.springboot.cn/2edbe9b3-28be-4a8b-a9c3-82e40703f22f.jpg\" width=\"790\" height=\"820\"><br></p>',4299.00,100,1,'2000-04-13 19:07:47','2000-04-13 21:45:41');


DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master` (
  `order_id` varchar(32) NOT NULL,
  `buyer_id` varchar(32) NOT NULL COMMENT '买家id',
  `shipping_id` int(16) NOT NULL,
  `buyer_username` varchar(32) NOT NULL COMMENT '买家用户名',
  `buyer_phone` varchar(32) NOT NULL COMMENT '买家电话',
  `buyer_address` varchar(200) DEFAULT NULL COMMENT '详细地址',
  `buyer_openid` varchar(32) DEFAULT NULL COMMENT '用户第三方id',
  `order_amount` decimal(16,2) NOT NULL COMMENT '订单总金额',
  `payment` decimal(16,2) DEFAULT NULL COMMENT '实际付款金额,单位是元,保留两位小数',
  `payment_type` int(4) DEFAULT NULL COMMENT '支付类型,1-在线支付',
  `status` int(10) DEFAULT NULL COMMENT '订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭',
  `payment_time` datetime DEFAULT NULL COMMENT '支付时间',
  `shipping_time` datetime DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime DEFAULT NULL COMMENT '交易完成时间',
  `close_time` datetime DEFAULT NULL COMMENT '交易关闭时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`order_id`),
  KEY `idx_buyer_id` (`buyer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
  `item_id` varchar(32) NOT NULL,
  `order_id` varchar(32) NOT NULL,
  `product_id` varchar(32) NOT NULL,
  `seller_id` varchar(32) NOT NULL COMMENT '卖家id',
  `seller_username` varchar(32) NOT NULL COMMENT '卖家用户名',
  `seller_phone` varchar(32) NOT NULL COMMENT '卖家电话',
  `product_name` varchar(64) NOT NULL COMMENT '商品名称',
  `current_unit_price` decimal(8,2) NOT NULL COMMENT '商品当前价格',
  `product_quantity` int(11) NOT NULL COMMENT '数量',
  `product_image` varchar(512) DEFAULT NULL COMMENT '商品图片',
  `total_price` decimal(16,2) NOT NULL COMMENT '订单细则总价',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`item_id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order_master` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;





