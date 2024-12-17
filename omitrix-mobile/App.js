import { ImageBackground, StyleSheet } from 'react-native'
import StartGameScreen from './screens/StartGameScreen'
import { LinearGradient } from 'expo-linear-gradient'

const styles = StyleSheet.create({
  rootScreen: {
    flex: 1,
  },
  backgroundImage: {
    opacity: 0.15,
  },
})

export default function App() {
  return (
    <LinearGradient colors={['#EE6B6E', '#644b64']} style={styles.rootScreen}>
      <ImageBackground
        source={require('./assets/images/background-image-2.jpg')}
        resizeMode={'cover'}
        style={styles.rootScreen}
        imageStyle={styles.backgroundImage}
      >
        <StartGameScreen />
      </ImageBackground>
    </LinearGradient>
  )
}
