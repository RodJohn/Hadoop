# 概述

client


# split
block
FileSplit 记录


# map

可以只有map 没有reduce 优化的时候

入口MapTask  mapper

recordread key-value
LineRecordRead 行读取器

防止数据切割的数据不完整
非第一个切片 放弃第一行
多读一行

keyvalue

# 缓冲  

目的


缓冲区 批量处理 

溢出 溢出比例 默认0.8 

排序  
	排序器 比较器

combine

	map端的reduce 可以先处理数据 减少传输  优化手段 将

QuickSort

# partition

partitions 为 reduce的数量


# reduce

完整的同一组数据 

shuffle
拉取数据 从不同map的缓冲区
sort
二次排序
reduce
迭代计算

一个reduce处理多个分组

组排序

























