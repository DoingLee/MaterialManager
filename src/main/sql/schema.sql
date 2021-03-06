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
  `count` INT UNSIGNED  NOT NULL  DEFAULT 1  COMMENT '产品数量',
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
  `action_time` DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',

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

-- 生产报告表
CREATE TABLE report(
  `report_id` INT UNSIGNED  NOT NULL  UNIQUE  AUTO_INCREMENT  COMMENT 'report id',
  `finished_order_count` INT UNSIGNED  NOT NULL COMMENT '完成订单数',
  `collect_count` INT UNSIGNED  NOT NULL COMMENT '完成取料单据数',
  `single_collect_count` INT UNSIGNED  NOT NULL COMMENT '完成单个取料动作数',
  `success_recheck_count` INT UNSIGNED  NOT NULL COMMENT '完成复核单据数',
  `single_recheck_count` INT UNSIGNED  NOT NULL COMMENT '完成单个复核动作数',
  `hang_up_count` INT UNSIGNED  NOT NULL COMMENT '挂单数',
  `produce_count` INT UNSIGNED  NOT NULL COMMENT '完成投料单据数',
  `single_produce_count` INT UNSIGNED  NOT NULL COMMENT '完成单个投料动作数',

  `avg_order_time` INT UNSIGNED  NOT NULL COMMENT '平均完成订单时间（秒）',
  `avg_collect_time` INT UNSIGNED  NOT NULL COMMENT '平均完成订单取料时间（秒）',
  `avg_single_collect_time` INT UNSIGNED  NOT NULL COMMENT '平均完成单个取料动作时间（秒）',
  `avg_success_recheck_time` INT UNSIGNED  NOT NULL COMMENT '平均完成订单成功复核时间（秒）',
  `avg_single_recheck_time` INT UNSIGNED  NOT NULL COMMENT '平均完成单个复核动作时间（秒）',
  `avg_produce_time` INT UNSIGNED  NOT NULL COMMENT '平均完成订单投料时间（秒）',
  `avg_single_produce_time` INT UNSIGNED  NOT NULL COMMENT '平均完成单个投料动作时间（秒）',
  `date` DATE  NOT NULL COMMENT '日期',
  PRIMARY KEY (report_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT='生产报告表';


-- 更改

-- 添加唯一性约束
ALTER TABLE `material_name` ADD UNIQUE(`material_name`);
ALTER TABLE `blender_name` ADD UNIQUE(`blender_name`);

-- 修改product_material
ALTER TABLE `product_material` ADD COLUMN `material_name_id`INT UNSIGNED NOT NULL COMMENT 'material name id';
ALTER TABLE `product_material` ADD CONSTRAINT  FOREIGN KEY (material_name_id) REFERENCES `material_name`(material_name_id);

SHOW CREATE TABLE product_material; #查看外键名称
ALTER TABLE product_material DROP FOREIGN KEY product_material_ibfk_1; #先删除外键约束
ALTER TABLE `product_material` DROP COLUMN `material_id`; #再删除列

-- 把product_material表与product_process表合并
ALTER TABLE product_process ADD COLUMN weight INT UNSIGNED NOT NULL COMMENT '所需原料质量';

-- 添加多列UNIQUE约束，防止重复步骤
ALTER TABLE product_process ADD CONSTRAINT unique_process UNIQUE (product_id, process_order);

-- user不能删除，添加isAvaliable标记，只能置为不可用0、可用1
ALTER TABLE user ADD COLUMN isAvaliable TINYINT UNSIGNED NOT NULL DEFAULT 1 COMMENT '员工是否可用';

-- 修改自增int类型主键order_id为char(36)类型UUID
SET FOREIGN_KEY_CHECKS = 0; -- 禁用外键约束检查
ALTER TABLE  `order` MODIFY order_id  CHAR(36) NOT NULL  UNIQUE COMMENT 'order id'; -- 更新主键类型
ALTER TABLE order_trace MODIFY order_id  CHAR(36) NOT NULL  COMMENT 'order id'; -- 更新外键类型
SET FOREIGN_KEY_CHECKS = 1; -- 启用外键约束检查-- 修改自增int类型order_id为char(36)类型UUID

-- 添加订单下单时间戳
ALTER TABLE  `order` ADD COLUMN order_time DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间';

