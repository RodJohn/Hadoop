

# 命令

    通过命令操作HDFS
    
# 常用

创建目录
    
    hadoop fs -mkdir -p /user/input 

插入数据

    hadoop fs -put /home/file.txt /user/input 

查看文件

    hadoop fs -ls /user/input 

查看文件

    hadoop fs -cat /user/input/file.txt

下载文件
	
    hadoop fs -get /user/output/ /home/hadoop_tp/ 

删除文件

    hadoop fs -rm /test1/test.txt


# 管理界面

作用

    查找和下载文件
    查看文件的存储信息

入口

    HDFS管理界面(端口50070)
    Utilities->Browse the file system
    