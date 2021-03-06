spring-fun and friend
===

Integration of different libraries/framework with spring-boot

- [x] spring-boot
- [ ] spring-boot test
- [x] dozer
- [x] RESTFull way
- [ ] hibernate search

# 1. How to run the web-application ?

Simply running maven
`mvn spring-boot:run -Denv_type=dev -Dos_type=windows` or running with java after creating your jar with `mvn package` command `java -jar target/spring-fun-0.0.1-SNAPSHOT.jar`.

<table>
	<tr>
		<td>os_type</td>
		<td>env_type</td>
	</tr>
	<tr>
		<td>windows</td>
		<td>dev</td>
	</tr>
	<tr>
		<td>mac</td>
		<td>prod</td>
	</tr>
	<tr>
		<td>linux</td>
		<td>-</td>
	</tr>
</table>

# 2. How to run a REST request ?

Before to start you need a software that handle all HTTP Methods (GET, POST, PUT, DELETE, PATCH...). Every GET request
can be done directly in the url bar of your favorite browser but for the other you need an application (plugin or standalone app)

- Hello world example (GET) : [http://localhost:8080/greeting](http://localhost:8080/greeting) answers a `HTTP/1.1 200 OK`
 with body `{"id":1,"content":"Hello, World!"}`.
- Create a customer (POST) : [http://localhost:8080/customer?firstname=tyler&lastname=durden](http://localhost:8080/customer?firstname=tyler&lastname=durden)
answers a `HTTP/1.1 200 OK` with body `{"content":"Customer[id=1, firstName='tyler', lastName='durden']"}` and where `id` is the unique identifier from the database.
- Find a customer by lastName (GET) : [http://localhost:8080/customer/durden](http://localhost:8080/customer/durden) answers a `HTTP/1.1 200 OK` with body `{"id":1,"firstName":"tyler","lastName":"durden"}` where the `id` is the same as previously.

# 3. How to debug the web-application ?

Simply add the following parameter to java `-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005` then connect remotly to the port 5005

