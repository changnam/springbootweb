# springbootweb

jsp 와 thymeleaf 를 동시에 사용하기 위해서는,

spring.mvc.view.prefix=/WEB-INF/jsp/

spring.mvc.view.suffix=.jsp

spring.thymeleaf.view-names=thymeleaf/*

pom.xml 에 dependency 추가

		
		<dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
		</dependency>
		
folder 생성
src/main/webapp/WEB-INF/jsp

templates/thymeleaf


------------------ xml 설정 -------------------
![image](https://user-images.githubusercontent.com/31008617/117141032-094da200-ade9-11eb-935d-46e39b9733c6.png)
-------------------------------------------------------------------

jsp 와 thymeleaf 의 viewResolver order 를 사용하여, 우선순위를 변경할수 있다. (기본은 thymeleaf 의 order 값이 작음 (우선순위 높음). internalResourceNameResolver를 가장 낮게할것. (view가 없으면 exception 발생)

spring properties file 을 사용하여 설정하도록 한다.

--------------------------- properties 설정 -----------------------

spring.mvc.view.prefix=/WEB-INF/jsp/

spring.mvc.view.suffix=.jsp

spring.mvc.view-names=jsp/*

spring.thymeleaf.prefix=classpath:templates/

spring.thymeleaf.suffix=.html

spring.thymeleaf.order=0

spring.thymeleaf.view-names=thymeleaf/*

--------------------------------------------------------------------

Anyway, the tomcat-embed-jasper is marked as provided, so indicates that you expect the JDK or a container to provide the dependency at runtime. This scope is only available on the compilation and test classpath, and is not transitive.
In conclusion, the spring-boot-starter-web includes the tomcat embedded dependency but it doesn't includes the jasper embedded dependency, so that should be the reason to declare it separately.

출처: <https://stackoverflow.com/questions/42154614/springboot-embedded-tomcat-and-tomcat-embed-jasper> 
![image](https://user-images.githubusercontent.com/31008617/117125494-8b7f9b80-add4-11eb-8617-78f233992f1d.png)


