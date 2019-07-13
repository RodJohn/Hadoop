

  
# HDFS读写模型


    图例

    client 请求读写
    NameNode 接受client请求，分配具体的DataNode进行读写
    DataNode 读写具体数据块

 # 写流程
 
     客户端向NameNode请求写数据
      （客户端切割文件）
     NameNode会返回用于存储的DataNode集合 并记录在文件分配表
     客户端向对应DataNode存储数据  
     DataNode保存数据后会自动请求其他DataNode保存数据副本
     所有副本保存完，会给客户端发送确认消息，数据才被认为写入完成
     
  
 # 读流程
 
    客户端向NameNode请求读取数据
    NameNode发送数据块的信息给客户端。
    (数据块信息包含了保存着文件副本的DataNode的IP地址，以及DataNode在本地硬盘查找数据块所需要的数据块ID。)
    客户端检查数据块信息，向相关的DataNode，请求数据块
    客户端并行从不同的DataNode中获取一个文件的数据块，然后联结这些数据块，拼成完整的文件

  
  
  