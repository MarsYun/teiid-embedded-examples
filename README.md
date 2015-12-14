ca(7.x) Analytic Database Server, Vertica JDBC Driverttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt
## Teiid Examples

Teiid Examples show how to integrate multiple, heterogenous data stores and enterprise services in a light-weight, micro-service way.

## Build

* install JDK 1.7 or higher
* install maven 3 - http://maven.apache.org/download.html
* Create a github account and fork Teiid Examples

Enter the following:

~~~
$ git clone https://github.com/<yourname>/teiid-embedded-examples.git
$ cd teiid-embedded-examples
$ mvn clean install -s settings.xml
~~~

## Available Examples

| **Quickstart Name** | **Features Demonstrated** | **Description** | **Prerequisites** |
|:-----------|:-----------|:-----------|:-----------|:-----------|
|[embedded-portfolio](embedded-portfolio) |Teiid, Dynamic VDB, Native Queries, Data Federation, JDBC Translator, File Translator, TEXTTABLE |Demonstrates how to expose multiple data sources for data federation  |None |
|[embedded-portfolio-logging](embedded-portfolio-logging) |Teiid, Dynamic VDB, Native Queries, Data Federation, JDBC Translator, File Translator, TEXTTABLE, JBoss LogManager, JBoss Logging |Demonstrates how to use JBoss LogManager with Teiid Embedded |None |
|[embedded-portfolio-security](embedded-portfolio-security) |Teiid, Dynamic VDB, Native Queries, Data Federation, JDBC Translator, File Translator, TEXTTABLE, Jaas/Security |Demonstrates security authentication in Teiid Embedded |None |
|[embedded-caching](embedded-caching) | Dynamic VDB, Native Queries, JDBC Translator, Results Caching, Materialized Views, Translator Results Caching |Demonstrates how Results Caching, Materialized Views works in Teiid |None |
|[hbase-as-a-datasource](bigdata-integration/hbase-as-a-datasource) |Teiid, Dynamic VDB, Foreign Table, HBase Translator |Demonstrates using the HBase Translator with Phoenix Data Source to access data in HBase |HBase Server, Phoenix Server |
|[hadoop-integration-hive](bigdata-integration/hadoop-integration-hive) |Teiid, Dynamic VDB, View, Hive Translator |Demonstrates using the Hive Translator with HiveServer2 JDBC Driver to access data in Hadoop HDFS |Hadoop Services, HiveServer2 |
|[spark-integration-hive](bigdata-integration/spark-integration-hive) |Teiid, Dynamic VDB, View, Hive Translator |Demonstrates using the Hive Translator with HiveServer2 JDBC Driver to access Spark data |Spark Thrift JDBC/ODBC server, HiveServer2 |   
|[vertica-as-a-datasource](vertica-as-a-datasource) |Teiid, Dynamic VDB, View, Vertica Translator |Demonstrates using the Vertica Translator to access data in Vertica Server |HP Vertica(7.x) Analytic Database Server, Vertica JDBC Driver |
|[drools-integration](drools-integration) |Teiid, Dynamic VDB, User Defined Function, VIRTUAL FUNCTION, Drools API |Demonstrates using Teiid User Defined Function trigger and fire business rules |None |
|[cassandra-as-a-datasourse](cassandra-as-a-datasourse) |Teiid, Dynamic VDB, Cassandra Translator |Demonstrates using the Cassandra Translator to access table in Cassandra. |Cassandra Server installed, keyspace and table created |
|[excel-as-a-datasource](excel-as-a-datasource) |Teiid, Dynamic VDB, Foreign Table, Excel Translator |Demonstrates using Excel Translator query Excel file with JDBC |None |
|[ldap-as-a-datasource](ldap-as-a-datasource) |Teiid, Dynamic VDB, Ldap Translator |Demonstrates using the ldap Translator to access data in OpenLDAP Server |OpenLDAP Server installed, Group 'HR' be created |    
|[mongodb-as-a-datasource](mongodb-as-a-datasource) |Teiid, Dynamic VDB, MongoDB Translator |Demonstrates using the MongoDB Translator to access data in mongodb |MongoDB Server installed, 'mydb' be created |
|[twitter-as-a-datasource](socialmedia-integration/twitter-as-a-datasource) |Teiid, Dynamic VDB, View, WS Translator, OAuth 1, JAAS |Demonstrates using the WS Translator to interact with Twitter API |Create App in Twitter |
|[odataservice-as-a-datasource](odataservice-as-a-datasource) |Teiid, Dynamic VDB, FOREIGN TABLE,  OData Translator |Demonstrates using the WebService Connector connecting to an OData source and OData Translator to transform OData source to Teiid Foreign Table |None |
|[odata4service-as-a-datasource](odata4service-as-a-datasource) |Teiid, Dynamic VDB, FOREIGN TABLE,  OData4 Translator |Demonstrates using the WebService Connector connecting to an OData4 source and OData4 Translator to transform OData source to Teiid Foreign Table |None |
|[restservice-as-a-datasource](restservice-as-a-datasource) |Teiid, Dynamic VDB, XMLTABLE, XMLPARSE,  WS Translator |Demonstrates using the WS Translator to call a REST web services and transform the web service results into relational results |customer service |
|[soapservice-as-a-datasource](soapservice-as-a-datasource) |Teiid, Dynamic VDB, VIRTUAL PROCEDURE, XMLTABLE, SOAP Service, WS Translator | Demonstrates using the WS Translator to call a generic soap service |StateService service |
 
## Run

### Run from Source code

Import `teiid-embedded-examples` source code to a IDE(Eclipse), run each examples with corresponding Main methods.

### Run from mvn 

With above **Build** section steps, make sure examples build success, navigating to a example execute mvn exec commands, for example:

~~~
$ cd teiid-embedded-examples/embedded-portfolio
$ mvn exec:java
~~~

## Link

* [Teiid Website](http://teiid.org)
* [Teiid Documentation](http://www.jboss.org/teiid/docs)
* [Teiid Examples Documentation](https://docs.jboss.org/author/display/teiidexamples/Teiid+Examples)
* [Teiid JIRA](https://issues.jboss.org/browse/TEIID)
* [Teiid User Forum](https://community.jboss.org/en/teiid?view=discussions)
