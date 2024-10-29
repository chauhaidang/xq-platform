## XQ-SVC-CARDS `{version 0.0.1}`
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
  --url 'http://localhost:8030/api/cards' \
  --header 'accept: application/json'
```
Go to [Open API definition](http://localhost:8030/swagger-ui/index.html) to view API