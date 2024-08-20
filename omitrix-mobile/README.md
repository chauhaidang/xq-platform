# ONBOARDING

### Build using eas-cli
`eas login`

`yarn install`

`eas build -p <platform> --profile snapshot`


### Build using manual expo-cli
`yarn install`

`yarn expo prebuild --no-install --platform <platform_name>`

`cd android && ./gradlew :app:assembleRelease`