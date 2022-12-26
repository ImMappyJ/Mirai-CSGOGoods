# Mirai-CSGOGoods
基于Mirai-QQ框架的CS饰品价格查询

------------

# BUFF商品查询
### 母指令:/buff
**子指令1: search *`<keyword>` `(<page>)`***
###### keyword-商品关键字，若存在空格则加上""，如/buff search "M4A1 消音型 | 印花集"
###### page-页数(没有则默认第一页)
###### 群内成员发送
#### 回复该页数内所有饰品价格详情
------------
# 管理员
### 母指令:/csgood /csgoods
**子指令1: reload**
###### 群内管理员发送 | 控制台发送
#### 重启配置

------------

**子指令2: admin *del | add*  `<QQ>`**
###### 控制台发送
#### 删除 添加管理员

# 关于配置
csgoods.json:
**{
  "buff_cookie": "your buff cookie"
  "admin_qq": [
    10001
  ]
}**

###### 浏览器登录buff后在主页响应界面打开浏览器开发者模式，在网络内选择csgo，在标头内找到Cookie即为你的cookie，粘贴到配置文件中重新加载配置即可。
------------

> The MIT License (MIT)
Copyright © 2022 Funworld

>Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

>The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

>THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.


