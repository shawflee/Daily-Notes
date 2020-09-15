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

# 五、Github如何弥补提交记录contributions
+ 提交记录contributions为什么会丢失？
- 很多朋友在提交本地项目到gihub时发现，仅仅在项目初始化时才会显示一条contributions，后续再commit就不会有了。这是因为：
1. 进行Commits的用户、邮箱不是你的Github帐号的用户名和邮箱。
2. 不是在这个版本库的默认分支进行的Commit。
3. 这个仓库是一个Fork仓库，而不是独立仓库。

+ git用户和邮箱不是github的弥补方法

1、将本地开发环境的github的用户名和邮箱改为自己github的。
1、查看用户名和地址
```
git config user.name
git config user.email
```
2、修改用户名和地址
```
git config --global user.name "your name"
git config --global user.email "your email"
```

2、创建存储库的全新裸克隆：
```
git clone --bare https://github.com/user/your-repo.git
cd your-repo.git
```

3、在git bash执行以下两个脚本

第一个脚本：修改以前邮箱用错的commit记录

```
git filter-branch --env-filter '
OLD_EMAIL="错误的邮箱"
CORRECT_NAME="github用户名"
CORRECT_EMAIL="github邮箱"
if [ "$GIT_COMMITTER_EMAIL" = "$OLD_EMAIL" ]
then
    export GIT_COMMITTER_NAME="$CORRECT_NAME"
    export GIT_COMMITTER_EMAIL="$CORRECT_EMAIL"
fi
if [ "$GIT_AUTHOR_EMAIL" = "$OLD_EMAIL" ]
then
    export GIT_AUTHOR_NAME="$CORRECT_NAME"
    export GIT_AUTHOR_EMAIL="$CORRECT_EMAIL"
fi
' --tag-name-filter cat -- --branches --tags;
```
 

第二个脚本：修改以前用户名用错的commit记录

```
git filter-branch --env-filter '
OLD_NAME="错误的用户名"
CORRECT_NAME="github用户名"
CORRECT_EMAIL="github邮箱"
if [ "$GIT_COMMITTER_NAME" = "$OLD_NAME" ]
then
    export GIT_COMMITTER_NAME="$CORRECT_NAME"
    export GIT_COMMITTER_EMAIL="$CORRECT_EMAIL"
fi
if [ "$GIT_AUTHOR_NAME" = "$OLD_NAME" ]
then
    export GIT_AUTHOR_NAME="$CORRECT_NAME"
    export GIT_COMMITTER_EMAIL="$CORRECT_EMAIL"
fi
' --tag-name-filter cat -- --branches --tags;
```


4、按Enter键运行脚本。


5、查看新的Git历史记录是否有错误。
```
git log
```

6、将更正的历史记录推送到GitHub：
```
git push --force --tags origin 'refs/heads/*'
```
