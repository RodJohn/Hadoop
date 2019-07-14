
# hadoop1


![](https://github.com/RodJohn/Hadoop/blob/master/pic/hdfsstrut1.png)



    HDFS由一个NameNode、一个SecondaryNameNode、多个DataNode组成


## 角色

NameNode

    主节点存放文件的元数据
        (元数据 属性信息 块大小 块偏移量)
    收集DataNode的block列表
    接受DataNode的心跳
    接受客户端的读写服务

DataNode

    从节点存放文件具体块数据
        使用本地文件系统存储文件
    存储本地block的元数据
    向NameNode提交block列表


Secondary NameNode

    负责NameNode的持久化
    
    NameNode 基于内存存储  
    两种持久化方法
      fsimage
        定点快照 存储到磁盘  写入满 恢复快
      edits
        增量的全局操作日志   对metadata的操作日志  写入快 恢复慢
      过程 format
      edits数据膨胀 edits合并到fsimages
      启动前先读取fsimages
     
# hadoop2

图例


HDFS存在的问题(2个)
NameNode单点故障，难以应用于在线场景    HA
NameNode压力过大，且内存受限，影扩展性   F


解决HDFS 1.0中单点故障和内存受限问题。
解决单点故障
HDFS HA：通过主备NameNode解决
如果主NameNode发生故障，则切换到备NameNode上
解决内存受限问题
HDFS Federation(联邦)
水平扩展，支持多个NameNode；
（2）每个NameNode分管一部分目录；
（1）所有NameNode共享所有DataNode存储资源
     提出了基于zookeeper的高可用方式，支持失败自动切换切回。
     针对Hadoop1.0中NameNode HA不支持自动切换且切换时间过长的风险，

## 主备NameNode
解决单点故障（属性，位置）
主NameNode对外提供服务，备NameNode同步主NameNode元数据，以待切换
所有DataNode同时向两个NameNode汇报数据块信息（位置）
JNN:集群（属性）
standby：备，完成了edits.log文件的合并产生新的image，推送回ANN
两种切换选择
手动切换：通过命令实现主备之间的切换，可以用HDFS升级等场合
自动切换：基于Zookeeper实现
基于Zookeeper自动切换方案
ZooKeeper Failover Controller：监控NameNode健康状态，
并向Zookeeper注册NameNode
NameNode挂掉后，ZKFC为NameNode竞争锁，获得ZKFC 锁的NameNode变为active



## Federation

通过多个namenode/namespace把元数据的存储和管理分散到多个节点中，使到namenode/namespace可以通过增加机器来进行水平扩展。
能把单个namenode的负载分散到多个节点中，在HDFS数据规模较大的时候不会也降低HDFS的性能。可以通过多个namespace来隔离不同类型的应用，把不同类型应用的HDFS元数据的存储和管理分派到不同的namenode中。
     
     提出了HDFS Federation机制
     它允许多个NameNode各自分管不同的命名空间进而实现数据访问隔离和集群横向扩展。
     针对Hadoop 1.0中的单NameNode制约HDFS的扩展性问题，，
 
 