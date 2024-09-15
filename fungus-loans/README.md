## XQ-SVC-LOANS `{version 0.0.1}`
[CHANGELOG](./CHANGELOG.md)
### Start service
`./gradlew clean bootRun`

### Test service
```
./gradlew xqStartApp
./gradlew msCompTest
./gradlew xqStopApp
```

### View service
Example request
```curl
curl --request POST \
  --url 'http://localhost:8090/api/loans/create?mobileNumber=4391291022' \
  --header 'accept: application/json'
```
Go to [Open API definition](http://localhost:8090/swagger-ui/index.html) to view API