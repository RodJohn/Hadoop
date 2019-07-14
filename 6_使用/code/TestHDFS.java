package com.john;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DFSConfigKeys;
import org.apache.hadoop.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestHDFS {
	Configuration conf = null;
	FileSystem fs = null;

	@Before
	public void conn() throws IOException {

		conf = new Configuration();
		fs = FileSystem.get(conf);
		
	}

	
	@Test
	public void mkdir() throws IOException{
		
		Path path = new Path("/mytemp");
		if(fs.exists(path))
			fs.delete(path,true);
		fs.mkdirs(path);
		
	}
	
	@Test
	public void uploadFile() throws IOException{
		Path path = new Path("/mytemp/haha.txt");
		FSDataOutputStream fdos = fs.create(path);
		InputStream is = new BufferedInputStream(new FileInputStream("D:/hadoop/06test/test.txt"));
		IOUtils.copyBytes(is, fdos, conf, true);
		
	}
	
	@Test
	public void readFile() throws IOException{
		Path f = new Path("/user/input/word.txt");
		FileStatus file = fs.getFileStatus(f );
		BlockLocation[] blks = fs.getFileBlockLocations(file, 0, file.getLen());
		for (BlockLocation blk : blks) {
			System.out.println(blk);
		}
	}
	
	@After
	public void close() throws IOException {
		fs.close();
	}

}
