# java-wheels
业务开发过程中常用的轮子代码。欢迎提交代码，一起提升业务开发效率。
# 为什么有这个项目？
混迹与各大互联网公司的底层开发人员是不是还在不断重复写一样的逻辑（比如分转元，元转分）。
为了完成类似的业务逻辑，我们不得不重复的写几乎一样的代码。有的时候，为了提升开发速度，我们在其他项目（或者网站）在不断的copy-plaste。

为什么我们不把这些常用的业务逻辑集合在一起，给出一个best practise呢？这也是这个项目的初衷。

可喜的是在github上已经有一些这样的实践。工程将借鉴这些工程，并在此基础上不断完善，给出可扩展，通用，优雅的最佳实践。

# 项目做什么？
项目关注的不是常说的轮子，项目关注代码层次而非项目层次。
所有提交的代码必须是可扩展，通用的逻辑。并且是优雅的最佳实践。

# 目前收录的轮子列表

| 功能 | 类 | 功能和对应的方法 |
|-------------|-----------------|-------------------|
| 随机数工具类 | RandomUtils    | 1. 生成[a,b)区间的随机数   double rangeRandom(double include, double exclude) <br/> 2. 一定概率生成一定区间的随机数，比如30%概率生成[0,99)的随机数 double probRandom(double startValue, double value, double endValue,double lessThanRatio)<br/> |

配置
| 功能 | 类 | 功能和对应的方法 |
|-------------|-----------------|-------------------|
| gitignore | ![.igore](java-wheels-configs/src/main/java/git/.gitignore)    |  |
