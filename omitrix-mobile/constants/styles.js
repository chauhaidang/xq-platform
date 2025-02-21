import { Platform } from 'react-native'
import CustomColors from './colors'

const ios = {
  buttonPressed: {
    opacity: 0.5,
    backgroundColor: CustomColors.ripple,
  },
}

const android = {}

const common = {
  shadow: {
    // for Android
    elevation: 10,
    // for ios
    shadowColor: 'black',
    shadowOffset: { width: 0, height: 10 },
    shadowRadius: 6,
    shadowOpacity: 0.25,
    backgroundColor: 'white',
    overflow: Platform.OS === 'android' ? 'hidden' : 'visible',
  },
}

export { ios, android, common }
