*Log Parser Application*
1. File Loader --> It reads the log file, for this sample project, it read the file path from application.properties, if not provided will read from resource
2. Service Layer --> Convert the flat log file into JAVA Object, So we can apply business logic to filer or fetch the data from log, in this project
   * The number of unique IP addresses
   * The top 3 most visited URLs
   * he top 3 most active IP addresses
    
    ```Assumption : Log file format will be fixed and data attributes are mapped to the postion```
3. REST Endpoint is expose to view the summary details from the converted log data

*How To run this project:*

Project is build on JDK11 and maven
   ```mvn spring-boot:run```
And test result:
`curl 'http://localhost:8080/log/summary' \
-H 'Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9' \
--compressed`

To run test cases, ```mvn test```
or import project in IDE

Test Cases Path
src/test/java