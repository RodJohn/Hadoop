# 架构
    
    obClient：提交作业；
    JobTracker：初始化作业，分配作业，TaskTracker与其进行通信，协调监控整个作业；
    TaskTracker：定期与JobTracker通信，执行Map和Reduce任务；
    HDFS：保存作业的数据、配置、jar包、结果；
 
 
# hadoop1    	

图例

    
    一个JobTracker多个TaskTracker


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

    	
图例


MRv2：On YARN
YARN：解耦资源与计算

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

ApplicationMaster

    作业为单位，避免单点故障，负载到不同的节点
    创建Task需要和RM申请资源（Container  /MR 1024MB）

Task-Container


