## SVN

### 一、SVN简介

#### 1、什么是SVN 

1. 全称subVersion. 操作简单、支持跨平台操作、支持版本回退功能(时间机器)

#### 2、获取SVN软件

	1. 服务端软件: VisualSVN 网址:
 	2. 客户端软件: Tortoisesvn 网址:

#### 3、常用指令

1. svn的常见地址svn://192.168.1.1/shop
2.  第一次与svn服务器建立连接 使用**Checkout(检出)**
3. 以后需要更新本地代码使用**Update(更新)**
4. 需要上传代码使用**Commit(提交)**





### 二、SVN服务端

#### 1、服务器端软件安装(VisualSVN)

#### 2、SVN服务端配置

##### 	2.1 创建一个项目

1. 首先在SVN服务端创建一个公有目录WebApp作为项目目录
2. 在WebApp目录下创建Shop文件夹,作为Shop(版本仓库)
3. 创建版本仓库 指令 **svnadmin create Shop**文件夹路径(Shop仓库)
4. 如果Shop仓库配置成功,Shop文件夹下会有几个文件



##### 	2.2 进行服务端监管

 1. Apache -> http://localhost 或(ip地址)访问到htdocs目录下的相关文件(监管)

 2. SVN ->

 3. 权限控制 

    

### 三、SVN客户端

##### 1、客户端的安装

##### 2、使用客户端软件连接SVN服务器

	1. 在项目目录鼠标右键 -> TortoiseSVN -> 版本库浏览器 -> 输入SVN服务器地址



### 四、SVN使用详解

#### 1、图标集 

#### 2、忽略文件

#### 3、版本回退 

​	3.1 空白右键 更新到版本(根据日志或者版本号)

#### 4、版本冲突

	1. 解决冲突方法 更新服务器端数据到本地 会多出来三个文件

- index.java 整合或的index.java
- index.java.mine 最后修改的index.java文件
- index.java.rx (x小的表示最初的index.java文件 x大的表示最初和最后之间更新的那个版本)

2. 删除index.java 以外的三个文件  修改index.java文件
3. 重新上传index.java

#### 5、配置多仓库与权限控制

##### 5.1 配置多仓库

​	在实际项目开发中,我们可能会同时开发多个项目, 那么如何进行多项目监管呢? 

##### 5.2 权限控制 

​	如果要使用权限控制有一个前提: 必须首先开启权限功能.在每一个仓库中都有一个conf文件夹,里面有三个文件

- authz文件: **授权文件** 告诉哪些用户具有哪些权限 这个文件默认是禁用的
- passwd文件: **认证文件** 标识当前svn系统中某个仓库具有哪些用户以及响应的密码 默认禁用
- svnserve.conf **配置文件** 开启授权文件和认证文件 



#### 6、SVN服务配置与管理

##### 	5.1 配置自启动服务







