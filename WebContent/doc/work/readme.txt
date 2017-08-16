2017-08-07课题场景
1） 婚礼现场，由司仪主持游戏猜测新郎新娘第一次见面日期。
2）如果日期猜测错误，告之日期太晚或太早，直至猜测正确。
3）显示嘉宾猜测的次数，以及猜测的时长。

- 代码的命名规范
- Java代码的编程目录结构规范 例如：MVC框架
- 面向于对象的代码规范
- 模拟司仪操作完成以上场景的程序

标准：没有最好，只有更好，有多大能力，做多少事情。


review:
1) public protected....
2) static jvm memory management -stack 队列 堆

2017-08-08
review:
1)overload override
2)extends implements constructor method and static block
3)encapsulation and ploy. 
4)java programming architecture ->dao impl
5)db ->er diagram
6)IDE tools application etc.
work:
1)completed tree construction ->HashMap & Map.Entry class app.
2)模拟数据内容将结构打印在控制台内显示。
3）生成系统管理 ER 图表。
4）根据自己制定的计划复习。


2017-08-09
业务场景： 30m
1）String; StringBuffer; StringBuilder
2) 校验提交文件的名字及文件格式，统计应交人数与实交人数，并将结果打印出来
3）代码循环的的校验每天所交作业的人数及统计结果。

- 封装性
- 代码重用

1) 罗列业务场景中的具体功能（是否需要生成工具类）
2）如果是工具类（类中不应该出现具体的数值）输入参数，输出内容 保证方法的独立性
3）业务类：将需要的功能按照逻辑顺序依次的调用。
4）测试类：初始化数据并调试
- 校验文件名字
- 将所有的文件名字串联生成一个独立的字符串
- 获取的文件名字是一个字符串集合组成的 需要分割获取
- service 根据日期分组获取文件名字的集合<Set>
- 打印内容

homework:
1)java 加密md5工具 
2）java des 加密

review:
1)junit
2)debugging
3)Exception
4)集合类
5）排序

2017-08-10
1)Java log4j setting & running app.
2)java jcl
3)java slf4j
4)show project(Session management system) dev.
5)Generic Type App.

job:
1) 请书写工具类 “日历”
2）通过不同的模板样式输出需要的结果例如：
        输入 年份2015和8月份显示：
  2015年8月
    日    一   二 三 四 五 六
			1 2	3
  4  5 6  7 8 9 10
  ...............
  ...............
3) 通过Calander 转换成Date 类型格式化输出
4）计算一年中的第几星期是几号
5）计算某一天是一年中的第几星期 

2017-08-11    IO
1)IO 字节流和字符流    四个抽象类
2）InputStream & OutputStream
job1: 完善2017-08-09 的任务，检查某一个指定的文件夹，
	 查找其中的文件，并将所有文件的名字罗列显示出
	 将其中的结果保存到一个指定文件中去。

job2:继续完善以上任务
标准：1）学员名单（txt）
	2）指定一个文件夹路径，获取文件夹中文件
	3）filter（！zip） delete
	4）count 学员的名字
	5）显示学员应交人数，实交人数，缺省的人名
	6）将以上结果保存一个结果集的文件中显示。
	7）注意log运用,junit类。
	
	//Pattern Matcher
Homework:
	1)调研Java正则表达式。
	2)完成系统管理模块的ER图
	3)review current week java content
	4)开发本周会议管理系统

2017-08-14
	1)Thread & Runnable
	2)synchronized
	
work:
	1)父亲开了一个银行账户，分别生成两张子卡给他的子女一人一张，两位分别取取钱
	2）最终显示账户余额多少，及子女分别取钱次数和数值。
	poi excel

2017-08-15

	1)Lock Read & Write Lock
	2)JDBC
	3)SQL DML & SELECT
	