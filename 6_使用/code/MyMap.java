package com.wordCount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MyMap extends Mapper<LongWritable, Text, Text, IntWritable> {
    private final static IntWritable one= new IntWritable(1);
    private Text word=new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        System.out.println(value);
        /*StringTokenizer st = new StringTokenizer(value.toString()," ");
        while(st.hasMoreTokens()){
            word.set(st.nextToken());
            context.write(word,one);
        }*/

        String[] st=value.toString().split(" ");
        for(int i=0;i<st.length;i++){
            word.set(st[i]);
            context.write(word,one);
        }


    }
}

