# StudentScoreApp
学生成绩查询系统（基于javafx实现）
1、满足用户输入学号或姓名，点击按钮查询，返回该学生的语数外三门课程的分数及平均分，成绩有两种表现形式，一种是百分制，最高100，最低为0；一种是五级制，即ABCDE,分别对应90、75、60、45、30。界面上展示的均为百分制，布局自行确定；
2、信息保存在文件里，文件名为score.txt,行数要超过20行，格式为如下形式：
学号，学生姓名，语文成绩，数学成绩，外语成绩
实例：
BA225010,张三，93,85,74
BA225024,李四，A,B,B
3、处理各种异常情况，如成绩大于100或小于0，不是ABCDE的任何一种，学号不正确等。界面、商业逻辑、对文件的处理封装在不同的类，计算平均分尽量使用重载函数
