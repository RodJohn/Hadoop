block > split
1:1
N:1
1:N
split > map
1:1
map > reduce
N:1
N:N
1:1
1:N
group(key)>partition
1:1
N:1
N:N
1:N?  >违背了原语
partition > outputfile




cd $HADOOP_PERFIX
cd share/hadoop/mapreduce
hadoop jar hadoop-mapreduce-examples-2.6.5.jar wordcount  /input  /output
*input:是hdfs文件系统中数据所在的目录
*ouput:是hdfs中不存在的目录，mr程序运行的结果会输出到该目录

以下是输出目录的内容：
-rw-r--r--   3 root supergroup          0 2017-07-02 02:49 /mr/test/output/_SUCCESS
-rw-r--r--   3 root supergroup         49 2017-07-02 02:49 /mr/test/output/part-r-00000
/_SUCCESS：是信号/标志文件
/part-r-00000：是reduce输出的数据文件，r：reduce的意思，00000是对应的reduce
多个reduce会有多个数据文件



