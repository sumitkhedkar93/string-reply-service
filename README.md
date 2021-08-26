# String Reply Service #
**String Reply Service** is basically SpringBootApplication which contains REST EndPoint that accepts string input 
and returns transformed string as an output.

## Build project

To build the project, simply run
```
./gradlew build
```

## Run the project

To start the project, simply run
```
./gradlew bootRun
```
## Tools & Frameworks used
```
SpringBoot
Apache Tomcat Server
Java 8
Sl4j Logger
```

# Executing REST EndPoint #
The input string will now be comprised of two components, a rule and a string, separated by a dash (-).
Rules always contain two numbers. Each number represents a string operation.

The supported numbers are:

- `1`: reverse the string

   E.g. `kbzw9ru` becomes `ur9wzbk`

- `2`: encode the string via MD5 hash algorithm

   E.g. `kbzw9ru` becomes `0fafeaae780954464c1b29f765861fad`

Sample Examples :
```
GET /v2/reply/11-kbzw9ru
{
    "data": "kbzw9ru"
}
```
```
GET /v2/reply/12-kbzw9ru
{
    "data": "5a8973b3b1fafaeaadf10e195c6e1dd4"
}
```
```
GET /v2/reply/22-kbzw9ru
{
    "data": "e8501e64cf0a9fa45e3c25aa9e77ffd5"
}
```


Once the service started, the endpoint will be available at `localhost:8080`.

```json
GET localhost:8080/reply/v2/<message-input>

{
    message: "<transformed-string>"
}
```
