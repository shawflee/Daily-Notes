# 一、git 使用 SSH 和 HTTPS 方式提交远程库

+ 查看对应远程库地址  git remote -v  

### 1.使用https提交远程库

首先已经git commit -m “注释”;

本地仓库关联远程github服务器：git remote add origin  “https://XXXX.git”;

提交修改文件：git push origin master;

此处需要输入用户名密码：用户名就是登陆github的用户名，密码是github的密码;

如果你关联的远程仓库有文件没有pull到本地，此时需要git pull “https://XXX.git”

 

### 2.由https切换到ssh提交

先删除之前的http连接：git remote rm origin;

添加ssh连接：git remote add origin “git://XXXX.git”;

第一次提交修改文件：git push -u origin master;

再次提交只要git push;

ssh需要将.ssh文件夹中的公钥添加到github的Setting中SSH and GPG keys


# 二、配置git 通过ssh协议免密需要三个步骤：
1. 生成密钥对 
```
cd ~/.ssh
ls     //看是否存在 id_rsa 和 id_rsa.pub文件，如果存在，说明已经有SSH Key
ssh-keygen -t rsa -C "li823311847@gmail.com"    //若无 回车到底
```
2. 配置远程仓库（这里使用github）上的公钥 ，id_rsa文件内容复制到github-Settings中的ssh
3. 把git的 remote url 修改为git协议（以上两个步骤初次设置过以后，以后使用都不需要再次设置，此步骤视以后项目的remote url而定，如果以后其他项目的协议为https则需要此步骤）

# 三、git正确提交步骤
1. git init //初始化仓库
2. git add .(文件name) //添加文件到本地仓库
3. git commit -m “first commit” //添加文件描述信息
4. git remote add origin + 远程仓库地址 //链接远程仓库，创建主分支
5. git pull origin master // 把本地仓库的变化连接到远程仓库主分支
6. git push -u origin master //把本地仓库的文件推送到远程仓库

# 四、删除github个某个文件夹
```
$ git pull origin master                    # 将远程仓库里面的项目拉下来
$ dir                                                # 查看有哪些文件夹
$ git rm -r --cached target              # 删除target文件夹
$ git commit -m '删除了target'        # 提交,添加操作说明
$ git push -u origin master               # 将本次更改更新到github项目上去
```

