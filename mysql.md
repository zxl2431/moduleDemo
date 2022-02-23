

MYSQL

#### 一、基本概念

1、SQL 结构化查询语句(Structured Query Language) 是对数据库进行操作的一种语言

2、SQL是数据库管理系统都需要遵守的规范. 不同的数据库生产厂商都支持SQL,但都有特有的内容比如MySQL特有和Oracle特有.

3、SQL分类

1. DDL(Data Definition Language)数据定义语言(用于创建、修改、删除数据库以及表) create, drop, alter等

2. DML(Data Manipulation Language)数据操作语言(用于对数据库中表的数据进行增删改) insert, delete,update等

3. DCL (Data Control Language) 数据控制语言 (用于定义数据库的访问权限和安全级别,创建用户).GRANT, REVOKE

4. TCL(Transaction Control Language) 事务控制语言(用于控制数据库的事务操作) COMMIT, SAVEPOINT, ROLLBACK等

5. DQL(Data Query Language) 数据查询语言 DQL并不是属于MYSQL官方的分类




#### 二、数据库登录

1. 命令行登录格式1: mysql -u用户名 -p密码  eg: mysql -uroot -proot
2. 命令行登录格式2: mysql -u用户名 -p回车 (先输入账号,后密码)
3. 命令行登录格式3(连接另一台电脑的MySQL) mysql -h127.0.0.1 -uroot -proot 
4. 命令行登录格式4: mysql --host=localhost --user=root --password=root
5. 退出MySQL: exit 



#### 三、DDL语句

##### 3.1 DDL语句操作数据库

1. 直接创建数据库 ---create database 数据库名

2. 判断是否存在并创建数据库 ---create database if not exists 数据库名

3. 创建数据库并指定字符集(编码表) ---create database 数据库名 character set 字符集  

4. 查看所有的数据库 ---show databases;

5. 查看某个数据库的定义信息 ---show create database 数据库名

6. 删除数据库 ---drop database db2

7. 查看正在使用的数据库 ---select database()

8. 使用/切换数据库 --- use 数据库名

9. 修改数据库字符集 ---alter database 数据库名 character set 字符集

   ​	--- alter database db3 character set utf8

    

##### 3.2 DDL语句操作表

1. 创建表 create table 表名(字段1 字段类型1, 字段2 字段类型2...);  常见的数据类型 int double varchar date 

2. 查看某个数据库中的所有表 ---show tables

3. 查看表结构 ---desc 表名

4. 查看创建表的SQL语句 ---show create table 表名 

5. 快速创建一个表结构相同的表 ---create table 新表名 like 旧表名

6. 修改表结构(添加列) alter table 表名 add 列名 类型  ---alter table student add remark varchar(20);

7. 修改列类型 alter table 表名 modify 列名 新的类型;  ---alter table student modify remark varchar(100);

8. 修改列名 alter table 表名 change 旧列名 新列名 类型 

   ​	---alter table student change remark intro varchar(30);

9. 删除列 alter table 表名 drop 列名 ---alter table student drop intro;

10. 修改表名 rename table 表名 to 新表名  --- rename table student to student2

11. 修改字符集 alter table 表名 character set 字符集  --- alter table student character set gbk;




##### 3.3 DML语句

1. 插入 insert --- insert into 表名() values()  

2. 蠕虫复制 ---insert into student2 select * from student;

3. 更新表记录 update 表名 set 字段名 = 值 where 字段名=值;

4. 删除表记录 ---delete from 表名 where 字段名=值;

5. truncate删除表记录 ---truncate table 表名;

   **truncate和delete的区别**

   - delete是将表中的数据一条一条删除
   - truncate是将整个表摧毁, 重新创建一个新的表和原来的结构一模一样



##### 3.4 DQL查询语句

1. select * from 表名

2. 去重查询 ---select **distinct** name, age from student;

3. 查询math和English成绩之和 ---select math+English 总成绩 from student;

4. 查询姓名、年龄、并将年龄+10 ---select name, age, age+10 from student;

5. 条件查询(数学成绩大于80) ---select * from student3 where math>80;

6. 条件查询(age>35且性别为男) ---select * from student3 where age>35 and sex = '男';

7. 条件查询(age>35或者性别为男) ---select * from student3 where age>35 or sex= '男';

8. 条件查询(id是1或3或5)的学生 ---select * from student3 where id=1 or id=3 or id=5;

   ​													---select * from student2 where id in (1, 3, 5);

9. 条件查询(id不是1或3或5)  ---select * from student3 where **not**(id in(1, 3, 5));

10. 条件查询范围(between and) ---SELECT * FROM student3 WHERE English>=75 AND English <=90;

11. 条件查询(模糊查询 like) ---SELECT * FROM student3 WHERE NAME LIKE '马%';

    

#### 四、多表查询

#####     1、排序 

​		**order by xxx desc/asc**

##### 	2、组合排序

​	先按照第一个字段进行排序,如果第一个字段相同,才安装第二个字段进行排序

​	select * from student3 where 字段=值 order by 字段名1 [asc|desc], 字段名2 [asc|desc]

​	SELECT * FROM student3 WHERE age > 20 ORDER BY math ASC, english ASC;

##### 	3、聚合函数 

​	之前的查询都是横向查询,都是根据条件一行一行的进行判断, 而使用聚合函数查询是纵向查询, 对一列的值进行计算,然后返回一个结果

- **count** 统计指定列记录数, 记录为NULL的不统计

  ```mysql
  SELECT COUNT(english) FROM student3;
  // 为了避免把值为null的统计掉
  SELECT COUNT(IFNULL(english, 0)) FROM student3;
  // 带条件的
  SELECT COUNT(*) FROM student3 WHERE age > 40;
  ```

- **sum** 计算指定列的数值和, 如果不是数值类型, 那么结果为0

  ```mysql
  // 计算math这一列加起来的总和
  SELECT SUM(math) FROM student3;
  ```

- **max** 计算指定列的最大值

  ```mysql
  // 计算数学成绩的最高分
  SELECT MAX(math) FROM student3;
  ```

- **min** 计算指定列的最小值

  ```mysql
  // 计算数学成绩的最低分
  SELECT MIN(math) FROM student3;
  ```

- **avg**  计算指定列的平均值

  ```mysql
  // 计算数学成绩的平均分
  SELECT AVG(math) FROM student3;
  ```



##### 	4、分组

​	    分组查询是指使用**Group by**语句对查询信息进行分组, 相同数据作为一组, 并且返回**每组的第一条数据**,所以单独分组没什么用途, 分组的目的就是为了统计, 一般分组会跟聚合函数一起使用.

```mysql
select * from 表名 GROUP BY 分组字段 [having 条件]
// 根据sex分组 计算每组math的总成绩
SELECT *, SUM(math) FROM student3 GROUP BY sex;
// 根据sex分组, 计算每组的总数
SELECT COUNT(*), sex FROM student3 GROUP BY sex;
// 1.先过滤掉年龄小于25的 2.根据sex分组 3.最后统计每组的人数
SELECT sex, COUNT(*) FROM student3 WHERE age > 25 GROUP BY sex;
// 1.先过滤掉年龄小于25的 2.根据sex分组 3.最后统计每组的人数 4.只显示人数大于2的那一组
SELECT sex, COUNT(*) total FROM student3 WHERE age > 25 GROUP BY sex HAVING COUNT(*) >2
```

​    **having和where的区别**

- having是在分组后对数据进行过滤, 写在group by的后面
- where是在分组前对数据进行过滤, 写在group by的前面
- having后面可以使用聚合函数
- where后面不可以使用聚合函数



##### 5、limit分页

**limit offset, length**或者**limit length**

```mysql
select * from 表名 [where 条件] [group by 字段] [having 子句条件] [order by 字段] [limit子句] 
// 
SELECT * FROM student3 LIMIT 2,6;
// 使用limit获取年龄最大的学生信息
SELECT * FROM student3 ORDER BY age DESC LIMIT 0,1;
```



#### 五、数据库备份与还原

##### 1、数据库备份

```mysql
mysqldump -uroot -proot db1 > E:\sqlbak\db1.sql
```

##### 5、数据库还原

```mysql
mysql -uroot -proot
use db2;
select database();
source E:\sqlbak\db2.sql
```



#### 六、数据库约束

##### 1、约束的种类

- **PRIMARY KEY 主键**  主键必须包含唯一的值 && 主键列不能包含NULL值
- **UNIQUE 唯一**
- **NOT NULL 非空**
- **DEFAULT 默认**
- **FOREIGN KEY 外键**



##### 2、主键

###### 2.1、主键的作用

​	用来唯一标识一条记录, 每个表都应该有一个主键,并且每个表只能有一个主键. 通常不用业务字段作为主键,单独给每张表设计一个id字段, 把id作为主键.

###### 2.2、主键的创建方式

- 在创建表的时候给字段添加主键 --字段名 字段类型 PRIMARY KEY

- 主键自增 auto_increment 

- 在已有表中添加主键 -- ALTER TABLE 名表 ADD PRIMARY KEY (字段名)

- 删除主键 --ALTER TABLE 表名 DROP PRIMARY KEY 

  

```mysql
CREATE TABLE st5(
 id INT PRIMARY KEY,
 NAME VARCHAR(20),
 age INT
)
```



##### 3、唯一

###### 3.1 唯一约束的作用

​	设置某一列唯一约束, 不能出现重复的值

```mysql
CREATE TABLE st7 (
id INT, 
nama VARCHAR(20) UNIQUE
)

// 因为null是没有值,所以不存在重复的问题
INSERT INTO st7 VALUES (6, NULL); 
INSERT INTO st7 VALUES (7, NULL);

```



##### 4、非空

###### 4.1 非空约束的作用

​	设置某一列必须设置值, 不能是NULL

```mysql
CREATE TABLE st8(
 id INT, 
 NAME VARCHAR(20) NOT NULL,
 gender CHAR(2)
)

// '' 这个是可以的
INSERT INTO st8 VALUES (4, '', '男');
// null是不行的
INSERT INTO st8 VALUES (4, NULL, '男');

```

###### 4.2 默认值

​	在往表中添加数据时, 如果不指定这个字段的数据,就使用默认值

```mysql
CREATE TABLE st9(
id INT, 
NAME VARCHAR(20),
address VARCHAR(50) DEFAULT '广州'
);

SELECT * FROM st9;

INSERT INTO st9 (id, NAME) VALUES (1, '刘德华');
INSERT INTO st9 VALUES (2, '张学友', '香港');
```



**非空+唯一 VS 主键的区别**

- 一张表只有一个字段可以设置为主键

- 一张表可以多个字段非空与唯一约束

- 主键可以自动增长, 非空与唯一约束的字段不能自动增长

  

##### 5、外键 

###### 	5.1 、为什么需要外键

​	一张表不足于描述 或则换一种表述方式一张表描述起来字段太多有冗余

```mysql
CREATE TABLE emp(
id INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(30),
age INT,
dep_name VARCHAR(30),
dep_location VARCHAR(30)
)

INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('张三', 20, '研发部', '广州'); 
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('李四', 21, '研发部', '广州');
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('王五', 20, '研发部', '广州'); 
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('老王', 20, '销售部', '深圳'); 
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('大王', 22, '销售部', '深圳'); 
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('小王', 18, '销售部', '深圳');
```

​	明显表中有重复数据, 如果需要改一下部门位置那需要改三个地方, 可以拆成两张表员工表和部门表

```mysql
// 创建部门表
CREATE TABLE department(
id INT PRIMARY KEY AUTO_INCREMENT,
dep_name VARCHAR(20),
dep_location VARCHAR(20)
)

// 创建员工表
CREATE TABLE employee(
 id INT PRIMARY KEY AUTO_INCREMENT,
 NAME VARCHAR(20),
 age INT, 
 dep_id INT
)

--插入数据
INSERT INTO department (dep_name, dep_location) VALUES ('研发部', '广州'), ('销售部', '深圳');

INSERT INTO employee (NAME, age, dep_id) VALUES
('张三', 20, 1), 
('李四', 21, 1), 
('王五', 20, 1), 
('老王', 20, 2), 
('大王', 22, 2),
('小王', 18, 2);
```

###### 5.2 、什么是外键约束

​	**一张表的某个字段引用另一个表的主键** 

​	**主键**: 约束别人 department  **副表**: 使用别人的数据 被别人约束

###### 5.3 、创建外键

​	新增表时:	[constraint] [外键约束名称] foreign key(外键字段名) references 主表名(主键字段名)

​    已有表时: alter table 从表 add [constraint] [外键约束名称] foreign key(外键字段名) references 主表名(主键字段名)

```mysql
CREATE TABLE employee (
 id INT PRIMARY KEY AUTO_INCREMENT, 
 NAME VARCHAR(20),
 age INT, 
 dep_id INT, 
 -- 添加一个外键
 CONSTRAINT emp_depid_ref_dep_id_fk FOREIGN KEY(dep_id) REFERENCES department(id)
);

-- 插入报错 因为department表中没有 id=3的部门 
INSERT INTO employee(NAME, age, dep_id) VALUES ('瞎混', 56, 3)
```

###### 5.4 、删除外键

```mysql
-- 删除外键
ALTER TABLE employee DROP FOREIGN KEY emp_depid_ref_dep_id_fk; 

-- 添加外键
ALTER TABLE employee ADD CONSTRAINT emp_depid_ref_dep_id_fk FOREIGN KEY(dep_id) REFERENCES department(id);
```

###### 5.5 外键的级联 

​	有外键约束的情况下, 如果副表中引用的数据, 不能直接修改主表主键.

​	**级联操作**: 在修改和删除主表主键时, 同时更新或者删除副表的外键值 称为级联操作 

- on update cascade --级联更新 主键发生更新时 外键也会更新
- on delete cascade -- 级联删除 主键发生删除时 外键也会删除

```mysql
-- 这个不行 因为在employee表中已经引用了department中的主键id 
UPDATE department SET id=5 WHERE id=2;
DELETE FROM department WHERE id=1;

-- 删除外键
ALTER TABLE employee DROP FOREIGN KEY emp_depid_ref_dep_id_fk; 

-- 添加外键 增加级联操作
ALTER TABLE employee ADD CONSTRAINT emp_depid_ref_dep_id_fk FOREIGN KEY(dep_id) REFERENCES department(id)
ON UPDATE CASCADE ON DELETE CASCADE;

-- 现在就可以更新主表的主键
UPDATE department SET id=5 WHERE id=2;
DELETE FROM department WHERE id=1;
```



#### 七、表关系

##### 1、表关系的概念

- 一对一 : 老公对老婆
- 一对多 : 班级对学生, 部门对员工, 客户对订单 建表原则: 在对方(从表)创建一个字段作为外键指向一方(主表)的主键
- 多对多 : 老师对学生, 学生对课程, 用户对角色 建表原则: 需要创建第三张表, 中间表至少有两个字段,这两个字段分别作为外键指向两张表的主键.  

##### 2、检查外键的配置项

```mysql
-- 删除表 删除不掉
DROP TABLE tab_route;
-- 查看检查外键配置项
SHOW VARIABLES LIKE "foreign%";
-- 关闭外键约束检查
SET FOREIGN_KEY_CHECKS = 0;
-- 开启外键约束检查
SET FOREIGN_KEY_CHECKS = 0;
```



##### 3、一对多练习

```mysql
-- 创建旅游线路分类表
CREATE TABLE tab_category (
  -- 旅游线路分类主键
  cid INT PRIMARY KEY AUTO_INCREMENT,
  -- 旅游 
  cname VARCHAR(100) NOT NULL UNIQUE 
);

INSERT INTO tab_category (cname) VALUES ('周边游'), ('出境游'), ('国内游'), ('港澳游');


-- 创建旅游线路表
CREATE TABLE tab_route(
  rid INT PRIMARY KEY AUTO_INCREMENT, -- 旅游线路主键 
  rname VARCHAR(100) NOT NULL UNIQUE, -- 旅游线路名称 
  price DOUBLE NOT NULL, -- 价格 
  routeIntroduce VARCHAR(200), -- 线路介绍 
  rflag CHAR(1) NOT NULL, -- 是否上架 
  rdate VARCHAR(19) NOT NULL, -- 上架时间 
  isThemeTour CHAR(1) NOT NULL, -- 是否主题旅游 
  acount INT DEFAULT 0, -- 收藏数量 
  cid INT NOT NULL, -- 所属分类 
  rimage VARCHAR(200) NOT NULL, -- 缩略图地址
  CONSTRAINT ro_cid_ref_cate_id FOREIGN KEY(cid) REFERENCES tab_category(cid)
);


INSERT INTO tab_route VALUES 
(NULL, '【厦门+鼓浪屿+南普陀寺+曾厝垵 高铁3天 惠贵团】尝味友鸭面线 住1晚鼓浪屿', 1499, '春节国内游优 惠：即日起至2018年1月31号，5-9人同时报名立减￥100/人，10人及以上同时报名立减￥150/人。仅限2月10-22日春 节期间出发享优惠，自由行及特价产品不参与！', 1, '2018-01-27', 0, 100, 3, 'c:\1.png'), 
(NULL, '【浪漫桂林 阳朔西街高铁3天纯玩 高级团】城徽象鼻山 兴坪漓江 西山公园', 699, '春节国内游优惠：即 日起至2018年1月31号，5-9人同时报名立减￥100/人，10人及以上同时报名立减￥150/人。仅限2月10-22日春节期间 出发享优惠，自由行及特价产品不参与！', 1, '2018-01-27', 0, 66, 3, 'c:\2.png'), 
(NULL, '【爆款￥1699秒杀】泰国 曼谷 芭堤雅 金沙岛 杜拉拉水上市场 双飞六天【含送签费 泰风情 广州往返 特价 团】', 1699, '1月15日至2月11日官网特卖！①出境全线正价线路（特价线除外）满2人立减￥60！满4人立减￥200！ 满5人立减￥500！', 1, '2018-01-27', 0, 15, 2, 'c:\123.png'), 
(NULL, '【经典·狮航 ￥2399秒杀】巴厘岛双飞五天 抵玩【广州往返 特价团】', 2399, '官网特卖！2-3月出发，前 10名网付立享￥2399/人！', 1, '2018-01-27', 0, 22, 2, 'c:\3.png'), 
(NULL, '香港迪士尼乐园自由行2天【永东跨境巴士广东至迪士尼去程交通+迪士尼一日门票+香港如心海景酒店暨会议 中心标准房1晚住宿】', 799, '永东巴士提供广东省内多个上车地点，购买后需自行致电永东巴士客服电话 4008861668预约车位', 1, '2018-01-27', 0, 38, 4, 'c:\4.png');

-- 用户表
CREATE TABLE tab_user ( 
 uid INT PRIMARY KEY AUTO_INCREMENT, -- 用户id 
 username VARCHAR(100) NOT NULL UNIQUE, -- 用户名 
 PASSWORD VARCHAR(30) NOT NULL, -- 密码 
 NAME VARCHAR(100), -- 真实姓名 
 birthday DATE, -- 生日 
 sex CHAR(1), -- 性别 
 telephone VARCHAR(11), -- 手机号 
 email VARCHAR(100), -- 邮箱 
 STATUS CHAR(1) NOT NULL, -- 是否激活状态 
 CODE VARCHAR(32) NOT NULL UNIQUE -- 激活码 
 );
 
 -- 插入用户名
 INSERT INTO tab_user VALUES 
 (NULL, 'cz110', 123456, '老王', '1977-07-07', '男', '13888888888', '66666@qq.com', '是', '1386'), 
 (NULL, 'cz119', 654321, '小王', '1999-09-09', '男', '13999999999', '99999@qq.com', '是', '9898');
 
 -- 收藏表
 CREATE TABLE tab_favorite ( 
     fid INT PRIMARY KEY AUTO_INCREMENT, -- 收藏主键 
     rid INT NOT NULL, -- 旅游线路id 
     DATE DATE NOT NULL, -- 收藏时间 
     uid INT NOT NULL -- 用户id 
 );
 
 -- 插入收藏表数据 
 INSERT INTO tab_favorite VALUES 
 (NULL, 1, '2018-01-01', 1), -- 老王选择厦门 
 (NULL, 1, '2018-01-01', 2), -- 老王选择桂林 
 (NULL, 1, '2018-01-01', 3), -- 老王选择泰国 
 (NULL, 2, '2018-01-01', 2), -- 小王选择桂林 
 (NULL, 2, '2018-01-01', 3), -- 小王选择泰国 
 (NULL, 2, '2018-01-01', 5); -- 小王选择迪士尼

```



#### 八、多表查询

##### 	1、笛卡尔积现象

​	左边的每条数据和右表的每条数据组合, 这种效果成为笛卡尔积

```mysql
SELECT COUNT(*) FROM dept; -- 3条数据
SELECT COUNT(*) FROM emp;  -- 5条数据
SELECT COUNT(*) FROM dept, emp;   -- 15条数据
```

##### 	2、内连接

​	用左边表的记录去匹配右边表的记录, 如果符合条件的则显示

```mysql
-- 显示内连接
SELECT * FROM dept INNER JOIN emp ON emp.`dept_id`= dept.`id`;

-- 隐式内连接
SELECT * FROM dept, emp WHERE dept.`id` = emp.`dept_id`;
```

##### 	3、左外连接

​	在内连接的基础上**保证左表的数据全部显示**

```mysql
SELECT * FROM dept LEFT OUTER JOIN emp ON emp.`dept_id` = dept.`id`;
```

##### 4、右外连接

​	在内连接的基础上**保证有表的数据全部显示**

```mysql
SELECT * FROM dept RIGHT OUTER JOIN emp ON emp.`dept_id`=dept.`id`;
```



#### 九、子查询

```mysql
-- 子查询的结果是单列
SELECT MAX(salary) FROM emp;
SELECT * FROM emp WHERE salary=(SELECT MAX(salary) FROM emp);

SELECT AVG(salary) FROM emp;
SELECT * FROM emp WHERE salary<(SELECT AVG(salary) FROM emp);

-- 子查询的结果是单列多行 
SELECT dept_id FROM emp WHERE salary > 5000;
SELECT dept.name FROM dept WHERE dept.id IN (SELECT dept_id FROM emp WHERE salary > 5000);

SELECT id FROM dept WHERE NAME IN ('开发部', '财务部');
SELECT * FROM emp WHERE dept_id IN (SELECT id FROM dept WHERE NAME IN ('开发部', '财务部'));


-- 子查询的结果是多行多列(只要只查询的结果是多列,肯定是在from后面作为表)
SELECT * FROM emp WHERE join_date > '2011-1-1';
SELECT * FROM dept d, (SELECT * FROM emp WHERE join_date > '2011-1-1') e WHERE e.dept_id = d.`id`;
```



#### 十、多表查询练习

```mysql
-- 查询所有员工信息。显示员工编号，员工姓名，工资，职务名称，职务描述
SELECT * FROM emp, job WHERE emp.`job_id` = job.`id`;
SELECT * FROM emp e INNER JOIN job j ON e.`job_id`=j.`id`;

-- 查询所有员工信息。显示员工编号，员工姓名，工资，职务名称，职务描述，部门名称，部门位置
SELECT * FROM emp, job, dept WHERE emp.`dept_id`= dept.id AND emp.`job_id` = job.`id`;

-- 查询所有员工信息。显示员工姓名，工资，职务名称，职务描述，部门名称，部门位置，工资等级
SELECT * FROM emp, job, dept, salarygrade WHERE 
emp.`dept_id`=dept.`id` AND emp.`job_id`=job.`id` 
AND emp.`salary` BETWEEN salarygrade.`losalary` AND salarygrade.`hisalary`; 


-- 查询经理的信息。显示员工姓名，工资，职务名称，职务描述，部门名称，部门位置，工资等级
SELECT * FROM emp, job, dept, salarygrade WHERE 
emp.`job_id` = job.`id` AND 
emp.`dept_id` = dept.`id` AND 
emp.`salary` BETWEEN salarygrade.`losalary` AND 
salarygrade.`hisalary` AND
job.`jname`='经理';


-- 查询出部门编号、部门名称、部门位置、部门人数
SELECT  dept.`id`, dept.`dname`, dept.`loc`, COUNT(*) 
FROM emp, dept WHERE emp.`dept_id` = dept.`id` GROUP BY dept_id;

SELECT * FROM dept d INNER JOIN (SELECT dept_id, COUNT(*) FROM emp GROUP BY dept_id) e ON e.dept_id = d.`id`;

-- 查询所有员工信息。显示员工信息和部门名称，没有员工的部门也要显示
SELECT * FROM dept LEFT JOIN emp ON dept.`id` = emp.`dept_id`;

-- 查询所有员工信息。显示员工姓名，员工工资，职务名称，工资等级，并按工资升序排序
SELECT * FROM emp, job, salarygrade WHERE 
emp.`job_id`=job.id AND 
emp.`salary` BETWEEN salarygrade.`losalary` AND salarygrade.`hisalary`
ORDER BY emp.`salary` ASC;

-- 列出所有员工的姓名及其直接上级的姓名,没有领导的员工也需要显示
SELECT * FROM emp e1, emp e2 WHERE e1.mgr = e2.`id`;
SELECT * FROM emp e1 LEFT JOIN  emp e2 ON e1.mgr = e2.`id`;

SELECT e1.`ename`, IFNULL(e2.`ename`, '没有') 上司 FROM emp e1 LEFT JOIN  emp e2 ON e1.mgr = e2.`id`; 


-- 查询入职期早于直接上级的所有员工编号、姓名、部门名称
SELECT * FROM emp e1, emp e2, dept d WHERE e1.`mgr`= e2.`id` AND e1.`joindate` < e2.`joindate` AND e1.`dept_id`=d.`id`;

-- 查询工资高于公司平均工资的所有员工信息。显示员工信息，部门名称，上级领导，工资等级
SELECT * FROM emp e1, emp e2, dept d, salarygrade salary 
WHERE e1.dept_id=d.id AND 
e1.mgr = e2.id AND
e1.salary BETWEEN salary.`losalary` AND salary.`hisalary` AND 
e1.salary > (SELECT AVG(salary) FROM emp);
```



#### 十一、事务安全

##### 1、事务由来

​	一个业务要发送多条SQL语句给数据库执行, 需要将这多次访问看作一个整体, 要么全部失败,要么全部成功.

##### 2、操作事务

```mysql
-- 1.手动提交事务
-- 开启事务
start transaction;
-- 提交事务
commit;
-- 回滚事务
rollback;

-- 2.自动提交事务
-- mysql的每一条DML(增删改)语句都是一个单独的事务, 每条语句都会自动开启一个事务,执行完毕自动提交
-- 查看全局变量
SHOW VARIABLES LIKE '%commit%';
-- 关闭自动提交
SET autocommit = 0;
-- 打开自动提交
SET autocommit = 1;
```

##### 3、事务原理

​        事务开启之后,所有的操作都会临时保存到**事务日志**, 事务日志只有在得到commit命令才会同步到数据库表中,其他情况都会清空事务日志(rollback, 断开连接)

##### 4、回滚点

```mysql
-- 开启事务
start transaction
-- 扣钱三次
UPDATE account SET balance = balance - 100 WHERE id=1;
UPDATE account SET balance = balance - 100 WHERE id=1;
UPDATE account SET balance = balance - 100 WHERE id=1;
-- 设置回滚点
savepoint abc;
-- 继续扣钱三次
UPDATE account SET balance = balance - 100 WHERE id=1;
UPDATE account SET balance = balance - 100 WHERE id=1;
UPDATE account SET balance = balance - 100 WHERE id=1;
-- 回到回滚点
rollback to abc;
-- 提交
commit;

```

##### 5、事务的四大特性

| 事务特性            | 含义                                                         |
| ------------------- | :----------------------------------------------------------- |
| 原子性(Atomicity)   | 事务是一个不可分割的工作单位,要么都成功要么都失败            |
| 一致性(Consistency) | 事务前后数据的完整性必须保持一致                             |
| 隔离性(Isolation)   | 多个用户并发访问数据库时,一个用户的事务不能被其他用户的事务所干扰,多个并发事务之间数据要隔离 |
| 持久性(Durability)  | 一个事务一旦被提交,它对数据库的改变是永久性的                |

##### 6、事务的隔离级别

| 并发访问   | 含义                                                         |
| ---------- | ------------------------------------------------------------ |
| 脏读       | 一个事务读取到了另一个事务中尚未提交的数据                   |
| 不可重复读 | 一个事务中两次读取的数据内容不一致,要求的是一个事务中多次读取时数据是一致的,这是事务update引起的 |
| 幻读       | 一个事务中两次读取的数据的数量不一致, 要求在一个事务多次读取的数据的数量是一致的,这是insert或者delete引发的 |

| 级别 | 名字     | 隔离级别         | 脏读 | 不可重复读 | 幻读 | 数据库默认隔离级别   |
| ---- | -------- | ---------------- | ---- | ---------- | ---- | -------------------- |
| 1    | 读未提交 | read uncommitted | 是   | 是         | 是   |                      |
| 2    | 读以提交 | read committed   | 否   | 是         | 是   | Oracle 和 SQL Server |
| 3    | 可重复读 | repeatable read  | 否   | 否         | 是   | mysql                |
| 4    | 串行化   | serializable     | 否   | 否         | 否   |                      |



```mysql
-- 查询全局事务隔离级别
show variable like '%isolation%'

-- 设置事务隔离级别 要退出mysql再进才能看到
set global transaction isolation level 级别字符串;（修改全局的，不建议） 
set session transaction isolation level 隔离级别;(修改当次)
```



#### 十二、DCL 数据库控制语句

##### 1、创建用户

```mysql
-- create user '用户名'@'主机名' identified by '密码'
-- 主机名: 指定用户从那台主机上登录, 如果是本地用户可可以localhost, 远程的可以使用通配符%

-- user1用户只能在localhost这个IP登录mysql服务器 
CREATE USER 'user1'@'localhost' IDENTIFIED BY '123'; 
-- user2用户可以在任何电脑上登录mysql服务器 
CREATE USER 'user2'@'%' IDENTIFIED BY '123';
```



##### 2、授权用户

​	新创建的用户基本没什么权限

```mysql
-- 授权用户
-- GRANT 权限1, 权限2... ON 数据库名.表名 TO '用户名'@'主机名';
-- 给user1用户分配对test这个数据库操作的权限
GRANT CREATE,ALTER,DROP,INSERT,UPDATE,DELETE,SELECT ON test.* TO 'user1'@'localhost';
-- 给user2用户分配对所有数据库操作的权限
GRANT ALL ON *.* TO 'user2'@'%';

-- 撤销权限
-- REVOKE 权限1, 权限2... ON 数据库名.表名 TO '用户名'@'主机名';
-- 撤销user1用户对test操作的权限
REVOKE ALL ON test.* FROM 'user1'@'localhost';

-- 查看权限
-- show GRANTS FOR '用户名'@'主机名';
-- 查看user1用户的权限
SHOW GRANTS FOR 'user1'@'localhost';

-- 删除用户
-- DROP USER '用户名'@'主机名';
DROP USER 'user2'@'%';

-- 修改用户密码
-- 修改管理员密码 mysqladmin -uroot -p password 新密码 -- 新密码不需要加上引号
mysqladmin -uroot -p password 123456 
-- 输入老密码

-- 修改普通用户密码
set password for 'user1'@'localhost' = password('666666');

```

