## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- [MariaDB](https://mariadb.org/)

## Installation
Run query create database.
```
create database mem_db;
```
Run query create table.
```
CREATE TABLE mem_db.member (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  username varchar(50) NOT NULL,
  email varchar(255) NOT NULL,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  phone_number varchar(20) NOT NULL,
  address varchar(2000) DEFAULT NULL,
  post_code varchar(255) DEFAULT NULL,
  salary double NOT NULL,
  reference_cod varchar(255) DEFAULT NULL,
  enabled tinyint(1) DEFAULT 1,
  create_date datetime(6) DEFAULT NULL,
  create_by varchar(255) DEFAULT NULL,
  update_by varchar(255) DEFAULT NULL,
  update_date datetime(6) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY member_un (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

Build project
```
mvn clean package
```

Start project
```
java -jar ./target/member-1.0.0.jar
```
Testing RESTful Calls

Register member
![picture](https://github.com/silapakorn/member/blob/master/request_register.png?raw=true)

Authenticate get token
![picture](https://github.com/silapakorn/member/blob/master/request_authen.png?raw=true)

 Get infomation by token
![picture](https://github.com/silapakorn/member/blob/master/request_info.png?raw=true)

