package com.john.fof;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import com.john.tianqi.TQMR;

public class MyFOF {
	
	public static void main(String[] args) throws Exception {
		
		//1,conf
		Configuration conf = new Configuration(true);
		//2,job
		Job job = Job.getInstance(conf);
		job.setJarByClass(MyFOF.class);
		//3,input,output
		Path input = new Path("/user/input/fof.txt");
		FileInputFormat.addInputPath(job, input);
		Path output = new Path("/user/output/fof");
		if(output.getFileSystem(conf).exists(output)){
			output.getFileSystem(conf).delete(output,true);
		}
		FileOutputFormat.setOutputPath(job, output );		
		//MR
		job.setMapperClass(FMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setReducerClass(FReducer.class);
		//Submit
		job.waitForCompletion(true);
	}
}
