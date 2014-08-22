// install
sudo -su
vi /etc/apt/sources.list
// and then add the soft source
#deb http://mirrors.ustc.edu.cn/CRAN/bin/linux/ubuntu/ precise/

// in the commond terminal
#apt-get update
#apt-get install r-base
#apt-get install r-base-dev

// go to R interface
R
// exit R interface
Ctrl+D


// Ubuntu环境下为R软件添加包  

1.首先在Ubuntu环境下安装R

2.进入R环境
命令行下输入 R
进入R语言编辑环境

3.添加包，
例如添加“igraph”

在R语言环境下输入 install.packages("igraph")
此时需要选择R包的镜像，可以选择China Beijing

出现如下信息，表明包已经添加成功。