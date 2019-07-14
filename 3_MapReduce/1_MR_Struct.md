# 架构
    
    obClient：提交作业；
    JobTracker：初始化作业，分配作业，TaskTracker与其进行通信，协调监控整个作业；
    TaskTracker：定期与JobTracker通信，执行Map和Reduce任务；
    HDFS：保存作业的数据、配置、jar包、结果；
 
 
# hadoop1    	

图例

    
   MapReduce由一个JobTracker和多个TaskTracker组成，


## 角色

JobTracker

    调度所有的作业
    监控整个集群的资源负载
    核心，主，单点


TaskTracker

    执行具体的Task
    和JobTracker心跳，汇报资源，
    从，自身节点资源管理


Client


    提交作业资源到HDFS
    最终提交作业到JobTracker


## 弊端

    JobTracker：负载过重，单点故障
    资源管理与计算调度强耦合，其他计算框架需要重复实现资源管理
    不同框架对资源不能全局管理

# hadoop2

    	
![](https://github.com/RodJohn/Hadoop/blob/master/pic/mrstruct2.png?)

MapReduce存在的问题响系统
JobTracker访问压力大，影响系统扩展性
难以支持除MapReduce之外的计算框架，比如Spark、Storm等

     提出了全新的资源管理框架YARN，它将JobTracker中的资源管理和作业控制功能分开，
     分别由组件ResourceManager和ApplicationMaster实现。
     其中，ResourceManager负责所有应用程序的资源分配，而ApplicationMaster仅负责管理一个应用程序。
     相比于 Hadoop 1.0，Hadoop 2.0框架具有更好的扩展性、可用性、可靠性、向后兼容性和更高的资源利用率
     以及能支持除了MapReduce计算框架外的更多的计算框架，
     Hadoop 2.0目前是业界主流使用的Hadoop版本。

## 角色

ResourceManager

    主，核心
    集群节点资源管理

NodeManager

    与RM汇报资源
    管理Container生命周期
    计算框架中的角色都以Container表示
    
Container：
    
    【节点NM，CPU,MEM,I/O大小，启动命令】
    默认NodeManager启动线程监控Container大小，超出申请资源额度，kill

ApplicationMaster-Container

    作业为单位，避免单点故障，负载到不同的节点
    创建Task需要和RM申请资源（Container  /MR 1024MB）

Task-Container


