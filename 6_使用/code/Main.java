package com.wordCount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class Main /*extends Configured implements Tool*/ {
    public static void main(String[] args) throws Exception{
        Configuration conf = new Configuration();
        String[] otherArgs =new GenericOptionsParser(conf, args).getRemainingArgs();
        if (otherArgs.length !=2) {
            System.err.println("Usage: wordcount <in> <out>");
            System.exit(2);
        }
        Job job =new Job(conf, "word count");    //设置一个用户定义的job名称
        job.setJarByClass(Main.class);
        job.setJobName("MainWordCounter");

        job.setMapperClass(MyMap.class);    //为job设置Mapper类
        //job.setCombinerClass(Reducer.class);    //为job设置Combiner类
        job.setReducerClass(MyReducer.class);    //为job设置Reducer类

        job.setOutputKeyClass(Text.class);        //为job的输出数据设置Key类
        job.setOutputValueClass(IntWritable.class);    //为job输出设置value类
        job.setOutputFormatClass(TextOutputFormat.class);

        FileInputFormat.addInputPath(job, new Path(otherArgs[0]));    //为job设置输入路径
        FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));//为job设置输出路径

        System.exit(job.waitForCompletion(true) ?0 : 1);        //运行job
    }

    /*@Override
    public int run(String[] strings) throws Exception {
        return 0;
    }*/
}
