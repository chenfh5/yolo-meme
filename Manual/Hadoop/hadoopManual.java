// open hadoop
cd /home/chenfh5/chenfh5Java/hadoop-2.3.0/

//format
./bin/hadoop namenode -format

//open service
sbin/start-dfs.sh
./sbin/start-all.sh;

// see the node available
./bin/hadoop dfsadmin -report

//show in IE
http://localhost:50070/   

//create new folder
./bin/hadoop fs -mkdir /input;

// close service
./sbin/stop-all.sh;

//put data into HDFS
./bin/hadoop fs -put /home/chenfh5/Desktop/inputFromLocal /input

//open file in HDFS
./bin/hadoop fs -cat /input1/file2.txt

//get data from HDFS to local computer
./bin/hadoop fs -get /input1/file2.txt /home/chenfh5/Desktop

//remove data from HDFS
./bin/hadoop fs -rm -r /input

//example
./bin/hadoop jar share/hadoop/mapreduce/hadoop-mapreduce-examples-2.3.0.jar grep input output 'dfs[a-z.]+'

Ref:
http://archive.cloudera.com/cdh5/cdh/5/hadoop/hadoop-project-dist/hadoop-common/SingleCluster.html