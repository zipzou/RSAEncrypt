# RSAEncrypt基于JAVA实现的RSA加解密工具

本项目基于java自带加解密工具实现，其中密钥对使用BASE64对称加密技术进行加解密。
## 项目编译安装
该项目以maven进行管理，用户在使用时，可以在安装了maven的情况下，通过使用命令shell执行maven相关任务。

+ 打包jar文件
  1. 在cmd(Windows)、shell(Linux)下，使用cd命令进入项目根目录；
  2. 在命令中输入；`mvn clean package`，将在target目录下生成jar文件。
+ 安装到本地仓库
  1. 使用maven的本地仓库，可以在其他maven项目中使用maven的依赖方式，使用该项目；
  2. 在cmd(Windows)、shell(Linux)下，使用cd命令进入项目根目录；
  3. 在命令中输入；`mvn clean install`，将生成jar文件，并将其拷贝到maven所配置的本地仓库中，在其他maven项目中，可以使用dependency的方式进行引用。
+ ​安装源码到本地仓库
  1. 在cmd(Windows)、shell(Linux)下，使用cd命令进入项目根目录；
  2. 执行命令：`mvn clean source:jar install`，该命令将会产生源码文件，并安装到本地仓库，供其他项目引用和依赖。

  > mvn操作需要安装maven并配置环境变量，相关内容自行安装配置。

  相关问题，请发送邮件至：frankdeveloper@126.com