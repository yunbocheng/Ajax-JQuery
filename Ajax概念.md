# Ajax前端技术

**xhr是XMLHttpRequest的简称** 

- 前端技术：在浏览器中执行的程序都是前端，html、css、js等

- 后端技术：在服务器中执行的程序，使用Java元语言开发的后端程序。

  ​				   servlet、jsp、jdbc、mysql、tomcat等等····

## 1 .全局刷新与全局刷新

### 全局刷新

- 概念：使用form、href等发起的请求是全局刷新

- 用户在发起请求，视图改变了，跳转视图，使用新的数据添加到页面

- 缺点：
  - 传递数据量比较大，占用网络的宽带
  - 浏览器需要重新的渲染整个页面
  - 用户体验不是很好

### 局部刷新

- 概念：在当前页面中，发起请求，获取数据，更新当前网页的dom对象。对视图部分刷新。
- 特点：
  - 数据比较小，在网络中传输速度快
  - 更新页面内容，使部分页面更新，浏览器不用全部更新
  - 在一个页面中，可以做多个局部刷新
  - 从服务器获取的是数据，拿到更新的视图

## 2.异步请求对象

**异步对象  XMLHttpRequest

**在局部刷新中，使用异步请求对象，在浏览器内部发起请求，获取数据**

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210725135041.png" style="zoom:50%;" />

- 异步对象是在浏览器的内部的一种 JavaScript对象。各大浏览器都能支持异步对象的使用。

  chrom、firework、ie、opper中都可以使用异步对象。在这些浏览器中写法可能不同，

  但是原理都是一样的。

## 3. 异步对象XMLHttpRequest介绍

- Js中的一种对象，使用Js语法创建和使用这个对象
- var xmlhttp  = new XMLHttpRequest();
- 之后可以使用xmlhttp对象的属性或者函数，进行异步对象的操作

**使用异步对象实现局部刷新，异步对象主要负责发起请求，传递请求参数，并从服务端接收数据。**

### 3.1局部刷新需要使用哪些技术：

- JavaScript ： 创建XMLHttpRequest对象，调用它的属性或者方法

  负责创建异步对象，发送请求，更新页面的dom对象。

- dom : 处理dom，更新 Servlet的数据 

- css：处理视图，更新，美化。

- servlet : 服务端技术，需要服务端的数据

- 数据格式 ：网络中传输的数据格式，使用json代替了xml

  ![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210725150541.png)

**把以上这些技术的综合使用叫做Ajax（阿贾克斯）**

## 4. Ajax介绍

- **AJAX 是一种在无需重新加载整个网页的情况下，能够更新部分页面内容的新方法**
  
- **使用AjAx实现局部刷新** 

- **AjAx =  AsynChronous JavaScript and XML（异步的JavaScript和XML）。**

  -  synChronous : 异步的意思
  - JavaScript : javaScript脚本，在浏览器中执行
  - and : 和

  - XMl : 一种数据格式

- AJAX 不单需要前端的技术，同时需要后端（服务器）的配合。服务器需要提供数据，数据
  是 AJAX 请求的响应结果。

- **AjAX 是一种在无需重新加载整个网页的情况下，能够更新部分页面内容的新方法。**

- 注意：AjAx只是一种新的技术，多种技术的综合应用，不是一种新的编程语言。

​			包含了javaScript、dom、css、服务端技术、servlet、jsp、jdbc等，还有json数据格式。

- Ajax核心是JavaScript 和 XML 但是在近些年json技术替代了XML，

  所以现在的Ajax的核心是 ：JavaScript 与 json 

## 5.AJAX异步对象（XMLHttpRequest）实现步骤

- 第一步 ：创建一个异步对象（使用的是JS语言）

> var xmlHttp = new XMLHttpRequest();

- 第二步 ：给异步对象绑定事件，onreadstatechange事件，当异步对象发起请求，获取了				数据都会触发这个事件。这个事件需要指定一个函数，在函数中处理状态的变化

```javascript
// 这段代码是以前JS中给函数绑定事件的方式
btn.onclick = function(){
	alert("按钮单击");
}
```

当请求被发送到服务端时，我们需要执行一些基于响应的任务。每当 readyState 改变时，就会触发 onreadstatechange事件 。从事件可以指定一个处理函数 function。通过判断 XMLHttpRequest对象的状态，获取服务端返回的数据。

```javascript
// 这段代码是ajax中异步对象绑定事件的方式
xmlHttp.onreadstatechange = function(){
    // 处理请求的状态变化;
    if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
        // 此时说明可以处理服务端的数据，更新当前页面
        var data = xmlHttp.responseText;
        document.getElementById("name").value = data;
    }
}
```

- 第三步：初始异步请求对象

  异步的方法　open()
  注意：第一个参数：get或者post，第二个参数：访问地址 第三个参数：是一个boolean类型的值(true/false)
  > xmlHttp.open(请求方式get/post,"服务器的访问地址",同步/异步请求(默认是true，异步请求)

  例如：
  
  ```javascript
  xmlHttp.open("get","loginServlet?name=cyb&password=123",true)
  ```
  
- 第四步：使用异步对象发送请求

  ```
  xmlHttp.send();
  ```

  怎么获取服务端返回的数据，使用异步对象的属性 responseText 

  使用例子：

  ```javascript
  xmlHttp.responseText
  ```


## 6. 异步对象的属性 

**XMLHttpRequest 对象有三个重要的属性 **

### 6.1属性说明

onreadstatechange属性：一个js函数名 或 直接定义函数，每当 readyState 属性改变时，就会调											  用该函数。

### 6.2 readyState 属性

- 存在 XMLHttpRequest 的状态，从0到4发生变化

- 异步对象的属性 readyState 表示异步对象请求的状态变化

  - 0 ： 创建异步对象时， new XMLHttpRequest ();
  - 1 :   初始化异步请求对象， xmlHttp.open();
  - 2 :   发送请求 ， xmlHttp.send();

  - 3 :   从服务端获取带了数据，此时3，注意3是异步对象内部使用，获取了原始数据。

  - 4 :   异步对象把接收到的数据处理完成后，此时开发人员在4的时候处理数据。

    ​		在4的时候，开发人员做什么？更新当前页面。

### 6.3 status 属性

- 异步对象的status属性，表示网络请求的状况：
  - 200(请求成功)  
  -  404(请求失败) 
  -  500(Java代码出现问题)

- **在当 status == 200 时，表示网络请求成功。此时才可以进行数据的传输处理**

### 6.4 responseText 属性

- 获取服务端返回的数据，使用异步对象的属性 responseText

  >  xmlHttp.responseText

## 7. 项目一：全局刷新计算bmi

- 项目介绍：通过用户输入的信息，计算这个人的bmi，判断bmi的数值在哪个区间，返回测试结果给用户。
- **通过全局刷新计算bim，不使用Ajax异步对象**

 **这个项目的源代码，<mark style="color:red">点击星球进行免费获取 [星球](https://github.com/yunbocheng/Ajax-JQuery) (Github地址)</mark>如果没有Github的小伙伴儿。可以关注本人微信公众号：<mark style ="color : red">Java学术趴</mark>，发送Ajax，免费给发给大家项目源码，代码是经过小编亲自测试的，绝对可靠。免费拿去使用。**

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210725162953.png" style="zoom:67%;" />

## 8.项目二：局部刷新计算bim（使用Ajax异步请求对象）

- 项目介绍：这个项目和以上所需要完成的请求是一样的，只是实现的方式不同。

- 这个项目是使用的Ajax异步对象进行的局部刷新原理。

- **通过局部刷新计算bmi，使用Ajax异步对象完成局部刷新**

   **这个项目的源代码，<mark style="color:red">点击星球进行免费获取 [星球](https://github.com/yunbocheng/Ajax-JQuery) (Github地址)</mark>如果没有Github的小伙伴儿。可以关注本人微信公众号：<mark style ="color : red">Java学术趴</mark>，发送Ajax，免费给发给大家项目源码，代码是经过小编亲自测试的，绝对可靠。免费拿去使用。**

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210725162953.png" style="zoom:67%;" />



## 9.项目三：根据ID查询省份（Ajax异步对象实现）

- 项目介绍：这个是使用的 <font style="color:red">AJAX异步对象</font>，通过获取用户输入的省份ID，查询到这个省份的名称、省份简称、省份的省会等信息。

 **这个项目的源代码，<mark style="color:red">点击星球进行免费获取 [星球](https://github.com/yunbocheng/Ajax-JQuery) (Github地址)</mark>如果没有Github的小伙伴儿。可以关注本人微信公众号：<mark style ="color : red">Java学术趴</mark>，发送Ajax，免费给发给大家项目源码，代码是经过小编亲自测试的，绝对可靠。免费拿去使用。**

- 这个项目的实现需要有一张省份的数据库表支持。大家可以按照下边的表文件自己新建一个。

  <img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20210727102117620.png" alt="image-20210727102117620" style="zoom: 80%;" />

- 下边是这个表文件的建表语句，大家可以参考一下。

  <img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210727103539.png" style="zoom:80%;" />

- 运行的结果图：当用书输入的<font style="color:red">id=3</font>的时候的查询结果如下：此时使用的是Ajax进行的局部刷新，不会刷新整个页面。

- ![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210727103330.png)


## 9.异步请求和同步请求

### 9.1 异步请求
XMLHttpRequest 对象 open( method , url, true ) 第三个参数 true 表示异步请求
异步请求特点：
1)某一个时刻，浏览器可以委托多个异步请求对象发送请求，无需等待请求处理完成。
2)浏览器委托异步请求对象工作期间，浏览器处于活跃状态。可以继续向下执行其他命令。
3) 当响应就绪后再对响应结果进行处理

### 9.2 同步请求
XMLHttpRequest 对象 open( method , url, false ) 第三个参数 false 表示同步请求
同步请求特点：
1)某一个时刻，浏览器只能委托一个异步请求对象发送请求，必须等待请求处理完成。
2)浏览器委托异步请求对象工作期间，浏览器处于等待状态。不能执行其他命令。
3)不推荐使用。

### 9.3异步请求和同步请求对比
- xmlHttp.open(get/post,url,true) : 异步处理请求。使用异步对象发起请求之后，不用等待数据处理完毕，
  就可以执行其他的操作,在send之后执行其他代码。可以同时执行多个异步请求。

- xmlHttp.open(get/post,url,false) :同步，异步对象必须在处理完成请求，从服务端获取数据之后，才能执行send之后的代码。
  在任意的。一次只能执行一个异步请求，必须在处理完成之后（也就是必须等待向服务端发送请求，并且服务端将数据发送回来），
  才能执行其他的请求处理。
        





