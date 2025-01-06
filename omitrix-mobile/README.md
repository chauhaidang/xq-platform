# ONBOARDING

### Commands used during development?

`expo install expo-font`
`expo install @expo-google-fonts/inter`
`expo install expo-splash-screen`

### Build using eas-cli

`eas login`

`yarn install`

`eas build -p <platform> --profile snapshot`

### Build using manual expo-cli

`yarn install`

`yarn expo prebuild --no-install --platform <platform_name>`

_Android build_:

`cd android && ./gradlew :app:assembleRelease`

_iOS build_:

`gem install cocoapods`

`cd ios && pod install`

`xcodebuild -resolvePackageDependencies -workspace ./omitrixmobile.xcworkspace -scheme omitrixmobile -configuration Release -derivedDataPath ./build -destination generic/platform\=iOS\ Simulator`

`xcodebuild -showBuildSettings -workspace ./omitrixmobile.xcworkspace -scheme omitrixmobile -configuration Release -derivedDataPath ./build -destination generic/platform\=iOS\ Simulator 2>&1`

`set -o pipefail && xcodebuild -workspace ./omitrixmobile.xcworkspace -scheme omitrixmobile -configuration Release -derivedDataPath ./build -destination 'generic/platform=iOS Simulator' build | tee ./logs/omitrixmobile-omitrixmobile.log > /dev/null`
