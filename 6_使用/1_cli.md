

# 概述

    在集群中运行mapreduce

# 步骤

建立项目

    新建maven项目
    使用pom.xml文件
    使用Main、MyMap、MyReducer作文源码
    导出jar包
    

上传jar

    将文件从windows上传到linux


上传待分析文件

    将文件从linux上传到HDFS
    hadoop fs -mkdir /user/input
    hadoop fs -put /file/wordCount.txt /user/input/word.txt


运行实例

    hadoop jar /file/wordcount.jar com.wordCount.Main /user/input/word.txt /user/output/wc
    要使用完整类名
    输出位置不应该存在

查看结果

    hadoop fs -cat /user/output/wc/part-r-00000