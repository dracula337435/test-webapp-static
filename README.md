# 试验tomcat中不同webapp对static的隔离

虽然是```static```，但是在```tomcat```的不同```webapp```中，于是各```static```依然“独立”。  
核心类为```io.dracula.test.webapp.static0.TestStaticServlet```，其中有三个```int```变量：  
1. ```count```变量用于记录此类个数  
1. ```current```变量用于记录这是第几个此类  
1. ```i```变量用于展示隔离  

试验过程：
1. 执行```mvn package```得到```test-webapp-static.war```包  
1. 部署此```war```包到```tomcat```  
1. 访问```/test-webapp-static/static1```  
1. 访问```/test-webapp-static/static2```，可见```count```和```current```发生变化  
1. 访问```/test-webapp-static/static1?step```，可见```i```发生变化，再次访问到```/static2```也可见```i```便化。
即：```webapp```内的```static```是```共享的，不隔离的```  
1. 进入```tomcat```的```webapps```目录，执行```cp test-webapp-static.war test-webapp-static2.war```
1. 访问```/test-webapp-static2/static1```，可见```i```仍为初值。
即：```webapp```之间的```static```是```不共享的，隔离的```  