# HandlerLearning
## 简介
1. 该项目为手写handler的实现，参考framework层handler源码来完成

## 使用方式
1. 在TestMain.java中右键，选择 "run Main"选项即可运行

## 详细介绍
1. Handler: 线程切换的解决方案
* sendMessage(): 在子线程中发送消息
* handleMessage(): 在主线程中接受消息并作出对应的响应
2. Message: 消息实体
3. MessageQueue: 消息队列，存放消息的队列
4. Looper: 循环体，循环获取消息队列中的消息