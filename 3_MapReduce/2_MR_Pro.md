

# MapReduce

![](https://github.com/RodJohn/Hadoop/blob/master/pic/mapreduce.png?1563067218533)


	MapReduce一般包括Split、Map、Shuffle、Reduce四个流程
	

# split

过程

    split就是对block进行逻辑分块
    一个split对应一个map

目的

	避免block过大，一个map的压力过大
	从而分成多个map来处理
	
	
# Map

过程

    map内部是一个lineread
    每次读取文件的一行数据，
    用户需要将数据解析成键值对。

目的

    提取key作为分组依据

# shuffle

    shuffle对map产生的键值对进行分区排序
    最后提供给reduce或者自己处理

![](https://github.com/RodJohn/Hadoop/blob/master/pic/shuffle.png?1563067279407)

## 分区排序

分区分组

    map将键值对写入内存缓冲区
    shuffle会将键值对根据key进行分区
    
    如果存在一个reduce处理多个分区的情况
    还需要对分区内分组（二次排序}

归并排序
    
    如果一个文件被多个map处理，
    或者内存缓冲区溢出的情况
    还需要将所有的分区结果进行归并
    
目的

	提高Reduce的处理效率
	reduce可以批量接受批量处理	


## 压缩

    combine 数据压缩
	提前计算 减少传递


# Reduce

过程

    对相同组的对键值对进行迭代处理

特点

	同一组key只能在一个 reduce处理
	一个reduce能处理多组key



 	
