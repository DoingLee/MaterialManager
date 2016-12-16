-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE material_manager_db;

-- 使用数据库
USE material_manager_db;

-- 创建表
-- 用户信息表
CREATE TABLE user(
  `user_id` INT UNSIGNED  NOT NULL  UNIQUE  AUTO_INCREMENT  COMMENT 'user id',
  `account_id` BIGINT UNSIGNED  NOT NULL  UNIQUE  COMMENT '登录名',
  `password` varchar(45) NOT NULL  DEFAULT '123456' COMMENT '口令',
  `user_name` varchar(45) NOT NULL  COMMENT '名字',
  `user_type` varchar(30) NOT NULL  COMMENT '用户类型:root、warehouse_manager、product_planner、line_worker',
#   KEY idx_user_id(user_id) COMMENT '为user_id创建索引',
  PRIMARY KEY (user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT='用户信息表';

-- 产品信息表
CREATE TABLE product(
  `product_id` INT UNSIGNED  NOT NULL  UNIQUE  AUTO_INCREMENT  COMMENT 'product id',
  `product_name` varchar(45) NOT NULL  COMMENT '产品名称',
  `description` varchar(450) DEFAULT '无' COMMENT '产品描述',
  PRIMARY KEY (product_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT='产品信息表';

-- 原料名表
CREATE TABLE material_name(
  `material_name_id` INT UNSIGNED  NOT NULL  UNIQUE  AUTO_INCREMENT  COMMENT 'material name id',
  `material_name` varchar(45) NOT NULL  COMMENT '原料名字',
  PRIMARY KEY (material_name_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT='原料名表';

-- 混料罐名表
CREATE TABLE blender_name(
  `blender_name_id` INT UNSIGNED  NOT NULL  UNIQUE  AUTO_INCREMENT  COMMENT 'blender name id',
  `blender_name` varchar(45) NOT NULL  COMMENT '混料罐名字',
  PRIMARY KEY (blender_name_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT='混料罐名表';

-- 订单表
CREATE TABLE `order`(
  `order_id` INT UNSIGNED  NOT NULL  UNIQUE  AUTO_INCREMENT  COMMENT 'order id',
  `product_id` INT UNSIGNED  NOT NULL  COMMENT 'product id',
  `count` TINYINT UNSIGNED  NOT NULL  DEFAULT 1  COMMENT '产品数量',
  `status` VARCHAR(45)  NOT NULL  DEFAULT 'unsolved'  COMMENT '订单状态：未处理unsolved、正在处理solving、已经处理solved',
  `client_name` VARCHAR(45)  NOT NULL  COMMENT '订单客户名称',
  `client_tel` VARCHAR(45)  NOT NULL  COMMENT '订单客户联系电话',
  PRIMARY KEY (order_id),
  FOREIGN KEY (product_id) REFERENCES `product`(product_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT='订单表';

-- 订单处理流程跟踪表
CREATE TABLE order_trace(
  `order_trace_id` INT UNSIGNED  NOT NULL  UNIQUE  AUTO_INCREMENT  COMMENT  'order trace id',
  `order_id` INT UNSIGNED  NOT NULL  COMMENT 'order id',
  `user_id` INT UNSIGNED  NOT NULL  COMMENT '操作员 user id',
  `action` VARCHAR(100)  NOT NULL  COMMENT '操作动作',
  `action_time` TIMESTAMP  NOT NULL  COMMENT '操作时间',

  PRIMARY KEY (order_trace_id),
  FOREIGN KEY (order_id) REFERENCES `order`(order_id),
  FOREIGN KEY (user_id) REFERENCES `user`(user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT='订单处理流程跟踪表';

-- 原料库表
CREATE TABLE material_inventory(
  `material_id` INT UNSIGNED  NOT NULL  UNIQUE  AUTO_INCREMENT  COMMENT  'material id',
  `material_name_id` INT UNSIGNED  NOT NULL  UNIQUE  COMMENT 'material name id',
  `total_weight` INT  NOT NULL  COMMENT '原料总质量',
  `location` VARCHAR(100)  NOT NULL UNIQUE  COMMENT '原料位置',

  PRIMARY KEY (material_id),
  FOREIGN KEY (material_name_id) REFERENCES `material_name`(material_name_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT='原料库表';

-- 产品原料表
CREATE TABLE product_material(
  `product_material_id` INT UNSIGNED  NOT NULL  UNIQUE  AUTO_INCREMENT  COMMENT  'product material id',
  `material_id` INT UNSIGNED  NOT NULL  COMMENT 'material id',
  `product_id` INT UNSIGNED  NOT NULL  COMMENT 'product id',
  `weight` INT UNSIGNED  NOT NULL  COMMENT '所需原料质量',

  PRIMARY KEY (product_material_id),
  FOREIGN KEY (material_id) REFERENCES `material_inventory`(material_id),
  FOREIGN KEY (product_id) REFERENCES `product`(product_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT='产品原料表';

-- 产品生产流程表
CREATE TABLE product_process(
  `product_process_id` INT UNSIGNED  NOT NULL  UNIQUE  AUTO_INCREMENT  COMMENT  'product process id',
  `product_id` INT UNSIGNED  NOT NULL  COMMENT 'product id',
  `process_order` TINYINT UNSIGNED  NOT NULL  COMMENT '操作顺序',
  `material_name_id` INT UNSIGNED  NOT NULL  COMMENT '原料名称 material name id',
  `blender_name_id` INT UNSIGNED  NOT NULL  COMMENT '混料罐名称 blender name id',

  PRIMARY KEY (product_process_id),
  FOREIGN KEY (product_id) REFERENCES `product`(product_id),
  FOREIGN KEY (material_name_id) REFERENCES `material_name`(material_name_id),
  FOREIGN KEY (blender_name_id) REFERENCES `blender_name`(blender_name_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT='产品生产流程表';


-- 初始化数据
# insert into
#   user(user_id, user_name)
# values
#   (1001, "张三");

-- 上线V1.0
