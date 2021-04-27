# atguiguJavaSEStudy
尚硅谷JavaSE学习过程记录，以便培养良好的代码编写习惯和思维风格。

在此过程中借助git分支管理工具将本地仓库的相关文件成功推送至远程仓库，同时删除了不必要的分支。
记录一下推送过程
### 本地项目名称JavaSE
练手代码编写完毕并测试通过后`cd`到项目的文件夹，
执行了`git init`命令以便初始化
接着依次执行
- `git add .`
- `git commit -m "XXX"`
- `git remote add origin XXX(远端仓库地址)`
- `git push -u origin master`<br>

以上四条命令以便推送到远端
  
### github项目名称为atguiguJavaSEStudy
此时查看github项目有main和master双分支
- 其中main是主分支
- master是推送的分支
###合并远程分支
- 执行`git clone XXX(远端项目地址)`重新克隆远程项目到本地
- 执行`cd XXX`进入到项目文件夹
- 执行`git branch -a`检查项目分支状况

应当会发现有main和master分支

- 执行 `git merge master --allow-unrelated-histories` 进行强制合并
- 执行`ls`命令会发现master分支下的文件已经带过来

依次执行
- `git add .`
- `git commit -m "XXX"`
- `git push`

顺利推送到远端仓库

### 删除不必要的分支
- 执行`git push origin --delete XXXX(要删除的分支名称)`

此时再打开github的项目，发现只剩下主分支main。
