// open hadoop
cd /home/chenfh5/chenfh5Java/hadoop-2.3.0/

//format
./bin/hadoop namenode -format

//open service
./sbin/start-all.sh;
// ./sbin/hadoop-daemon.sh start namenode;
// ./sbin/hadoop-daemon.sh start datanode;
// ./sbin/hadoop-daemon.sh start dfs;
// ./sbin/start-yarn.sh;

// see the node available
./bin/hadoop dfsadmin -report

//show in IE
http://127.0.1.1:50070/

//create new folder
./bin/hadoop fs -mkdir /input;

// close service
./sbin/stop-all.sh;

//put data into HDFS
./bin/hadoop fs -put /home/chenfh5/Desktop/someUrl /input

//open file in HDFS
./bin/hadoop fs -cat /input1/file2.txt

//get data from HDFS to local computer
./bin/hadoop fs -get /input1/file2.txt /home/chenfh5/Desktop

//remove data from HDFS
./bin/hadoop fs -rm r /input

