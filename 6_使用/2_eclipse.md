# 概述

    1.在eclipse中使用可视化插件管理HDFS
    2.在eclipse中运行HDFS Api
    2.在eclipse中运行Mapreduce Api

# 设置windows下的hadoop

部署hadoop

    1.获取和集群上一样的hadoop安装包
    2.解压
    3.下载windows的bin包
        https://github.com/srccodes/hadoop-common-2.2.0-bin
    4.将windows的bin包覆盖到原先的bin目录下  
    5.将windows的bin包内的hadoop.dll放到 c:/windows/system32下  

配置环境变量

    HADOOP_HOME
        hadoop目录
    Path
        %HADOOP_HOME%\bin
    HADOOP_USER_NAME 
        root

    
# eclipse的HDFS可视化插件

eclipse

    下载最新版

plugins

    1.下载
    
    2.安装
        将jar包放到的Eclipse的dropins文件下
    3.重启eclipse        
        重启后可在project explore中看到 DFS location
配置plugins    
    
    1.选择windows-preference-mapreduce
        设置hadoop部署路径
    2.选择windows-showview -other-mapreduce
        可以看到mapreduce的视图
    3.配置mapreduce
        点击mapreduce的视图右上角位置的小象，进入配置页面   
        Location name自定义一个名字就行，
        Host为hadoop节点的hostname，
        DFS Mastrer下的port为HDFS端口号，
        User name为安装Hadoop节点用户名称
        如果host是域名不是ip，需要添加windows下的域名解析。 
 
 
使用

    在project explore的DFS location进行使用
            
参考

    https://www.cnblogs.com/zimo-jing/p/8579065.html                    



# eclipse 依赖

准备依赖

    将部署文件\share\hadoop下所有的jar包拷出来放到一个新的文件夹（hadoop-lib）
        包括每个lib子目录下的jar包

准备user library

    eclipse-windows-preference-java-build path -user library-new
    对新建的user library 选择 add extenal jar ，然后选择hadoop-lib文件夹

# hdfs项目

建立项目

    新建java项目
    使用TestHDFS.java作文源码
    在src下添加core-site.xml文件
    
添加依赖

    右键项目-buildpath -libraries -add lib -user lib -选择 刚刚建立的user lib

启动

    使用junit启动
    
# hdmapreduce项目

建立项目

    新建java项目
    使用Main、MyMap、MyReducer作文源码
    在src下添加core-site.xml文件
    
添加依赖

    右键项目-buildpath -libraries -add lib -user lib -选择 刚刚建立的user lib
  
设置启动参数

    1.选中项目主类右键在run as里选中 run configuration 
    2.选择第2个选项卡 (x)=Arguments 
    3.在Program arguments里输入参数，参数之间用空格隔开，点Apply     
        

启动

    选中项目主类右键在run as hadoop



