

# 操作


# 命令

    可以通过hadoop命令

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




# 管理界面

    HDFS管理界面(端口50070)可以查找和下载上传的文件
    


# spring-data-hadoop
