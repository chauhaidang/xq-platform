import { ImageBackground, SafeAreaView, StyleSheet } from 'react-native'
import StartGameScreen from './screens/StartGameScreen'
import GameScreen from './screens/GameScreen'
import GameOverScreen from "./screens/GameOverScreen"
import { LinearGradient } from 'expo-linear-gradient'
import { useState } from 'react'

export default function App() {
  const [userNum, setUserNum] = useState()
  const [isGameOver, setIsGameOver] = useState(true)

  function pickedNumberHandler(pickedNumber) {
    setUserNum(pickedNumber)
    setIsGameOver(false)
  }

  function onGameOverHandler() {
    setIsGameOver(true)
  }

  let screen = <StartGameScreen onPickNumber={pickedNumberHandler} />

  if (userNum) {
    screen = <GameScreen userNumber={userNum} onGameOver={onGameOverHandler} />
  }

  if (isGameOver && userNum) {
    screen = <GameOverScreen />
  }

  return (
    <LinearGradient colors={['#EE6B6E', '#644b64']} style={styles.rootScreen}>
      <ImageBackground
        source={require('./assets/images/background-image-2.jpg')}
        resizeMode={'cover'}
        style={styles.rootScreen}
        imageStyle={styles.backgroundImage}
      >
        <SafeAreaView style={styles.rootScreen}>
          {screen}
        </SafeAreaView>
      </ImageBackground>
    </LinearGradient>
  )
}

const styles = StyleSheet.create({
  rootScreen: {
    flex: 1,
  },
  backgroundImage: {
    opacity: 0.15,
  },
})
