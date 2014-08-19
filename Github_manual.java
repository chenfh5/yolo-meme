cd /home/chenfh5/Test_Github

git init
git add test.java
git commit -m "first time for java upload to github" 
git remote add origin https://github.com/chenfh5/yolo-meme.git
(older one have been recorded)   

git push -u origin master

git push -u origin master -f

git pull origin master


git status
git log --stat

//update codes
git add .     或者添加具体的文件 git add 你要添加的文件(test/test/test.txt)
git commit -m "description"
git push -u origin master     //还记的这个别名吗  origin  这个别名就是你用第一种方法首次 向 GITHUB提交代码 你用的 别名

//delete the file have already in the internet
git rm -r --cached .
git add .
git commit -m "description"
git push -u origin master 

//--clone someone's repo
git clone https://github.com/chenfh5/stream-lib.git

//--branch
git checkout -b mybranch




//--------------
网上搜索了下，是因为远程 repository和我本地的
repository冲突导致的，而我在创建版本库后，在github的版本库页面点击了创建README.md文件的按钮创建了说明文档，但是却没有pull到本地。这样就产生了版本冲突的问题。

有如下几种解决方法：

1.使用强制push的方法：

$ git push -u origin master -f 

这样会使远程修改丢失，一般是不可取的，尤其是多人协作开发的时候。

2.push前先将远程repository修改pull下来

$  git pull origin master

$ git push -u origin master

3.若不想merge远程和本地修改，可以先创建新的分支：

$  git branch [name]

然后push

$  git push -u origin [name] 


//------------------------------
如果希望保留生产服务器上所做的改动,仅仅并入新配置项, 处理方法如下:

git stash
git pull
git stash pop

然后可以使用git diff -w +文件名 来确认代码自动合并的情况.


反过来,如果希望用代码库中的文件完全覆盖本地工作版本. 方法如下:

git reset --hard
git pull

http://blog.gogojimmy.net/
http://my.oschina.net/apeng/blog/109945