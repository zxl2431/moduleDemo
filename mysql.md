### 									MYSQL

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

​    

​    

​    



