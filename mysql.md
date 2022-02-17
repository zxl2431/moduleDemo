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

###### 	5.1 为什么需要外键

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

###### 5.3、创建外键

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

###### 5.4 删除外键

```mysql
-- 删除外键
ALTER TABLE employee DROP FOREIGN KEY emp_depid_ref_dep_id_fk; 

-- 添加外键
ALTER TABLE employee ADD CONSTRAINT emp_depid_ref_dep_id_fk FOREIGN KEY(dep_id) REFERENCES department(id);
```

