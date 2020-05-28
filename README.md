# SpringBootCloudProperties
This has the example for spring cloud config server
The properties file is present in the .properties file which is part of a git repository.
This project also explains various ways to read properties file populate it as a Map or a List.
The examples are part of the configuration-client.properties file.

There are two projects:
1. TestCloudConfigClient
2. TestCloudConfigServer

1. TestCloudConfigClient
This is the spring boot client config project. This has the bean configuration that has the @RefreshScope annotation which refreshes

2. TestCloudConfigServer
This is also a spring boot project which has the git information of the properties file. 


configuration-client.properties
This is the properties file that needs to go in the git repository.