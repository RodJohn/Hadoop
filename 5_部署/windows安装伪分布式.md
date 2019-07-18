

# 参考
    
    https://blog.csdn.net/u010993514/article/details/82914827
    https://blog.csdn.net/u010993514/article/details/82079962

# 准备

    操作系统：Windows 10
    DK版本：jdk-8
    Hadoop版本:hadoop-2.7.3
    hadoop部署模式:伪分布式              
                   
# 配置jdk

jdk

    java -version

环境变量   

    变量名： JAVA_HOME
    变量值：C:\Program Files\Java\jdk1.8.0_181           
    
    变量名： Path
    变量值： %JAVA_HOME%\bin
    变量值： %JAVA_HOME%\jre\bin     
    
#  Hadoop安装

## 特别说明

    官网已经下载不了2.7.3
    使用原作者配置好的安装包
    （https://download.csdn.net/download/u010993514/10627460）
    但还是需要按照下面的步骤进行修改
    

## 安装包

下载Hadoop安装包

    hadoop-2.7.3.tar.gz
   
下载Windows配置文件

    https://github.com/PengShuaixin/hadoop-2.7.3_windows.git
  
替换
   
    用GitHub下载的配置文件替换掉第一步在官方下载的安装包中的bin和etc文件夹
    
## 配置hadoop

    配置文件位于Hadoop文件夹下的\etc\hadoop

hadoop-env.cmd

    将路径修改为你自己的JAVA_HOME路径
    set JAVA_HOME=C:\PROGRA~1\Java\jdk1.8.0_181        
    
hdfs-site.xml
 
    <configuration>
        <property>
            <name>dfs.replication</name>
            <value>1</value>
        </property>
        <property>
            <name>dfs.namenode.name.dir</name>
            <value>file:/D:/hadoopdata/namenode</value>
        </property>
        <property>
            <name>dfs.datanode.data.dir</name>
            <value>file:/D:/hadoopdata/datanode</value>
        </property>
    </configuration> 
    
    设置namenode和DataNode文件路径   
    
core-site.xml
    
    <configuration>
        <property>
            <name>fs.defaultFS</name>
            <value>hdfs://localhost:9000</value>
        </property>
    </configuration>
 
 mapred-site.xml
  
    <configuration>
        <property>
           <name>mapreduce.framework.name</name>
           <value>yarn</value>
        </property>
    </configuration>

 yarn-site.xml
 
     <configuration>
         <property>
            <name>yarn.nodemanager.aux-services</name>
            <value>mapreduce_shuffle</value>
         </property>
         <property>
            <name>yarn.nodemanager.aux-services.mapreduce.shuffle.class</name>
            <value>org.apache.hadoop.mapred.ShuffleHandler</value>
         </property>
     </configuration>

hadoop.dll
     
    将Hadoop文件夹\bin下的hadoop.dll复制到C:\Windows\System32    
 
# Hadoop环境变量配置


环境变量

    变量名：HADOOP_HOME
    变量值：D:\hadoop-2.7.3

    变量名: Path
    变量值：%HADOOP_HOME%\bin
    变量值：%HADOOP_HOME%\sbin
    
   
测试

    hadoop
    hadoop -version

# 初始化HDFS

命令

    hdfs namenode -format         


看到下面这句说明初始化成功：

    INFO common.Storage: Storage directory D:\hadoopdata\namenode has been successfully formatted.



# 启动Hadoop

命令

    start-all

效果

    会启动DataNode、NameNode、ResourceManager、NodeManager四个控制窗口

网页查看

    localhost:50070
    localhost:8088
    
# 常见问题

Error: JAVA_HOME is incorrectly set.

    hadoop-env.cmd中JAVA_HOME没有设置好    
    
    路径C:\Program Files中带有空格,直接写该路径系统无法正常识别,
    故在此用软链代替,将C:\Program Files写成C:\PROGRA~1;
    此处也可以用引号包围,即将C:\Program Files写成C:"\Program Files"
    
    
Couldn't find a package.json file 

    npm的yarn和hadoop的yarn冲突了
    
    You can edit your system PATH to make Hadoop be before the NPM libraries, 
    but then you're going to break your Nodejs development process
    
 
     
