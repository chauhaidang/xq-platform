import { ImageBackground, SafeAreaView, StyleSheet, StatusBar } from 'react-native'
import StartGameScreen from './screens/StartGameScreen'
import GameScreen from './screens/GameScreen'
import GameOverScreen from "./screens/GameOverScreen"
import { LinearGradient } from 'expo-linear-gradient'
import { useState, useEffect, useCallback } from 'react'
import { loadAsync } from 'expo-font'
// import AppLoading from 'expo-app-loading'
import { preventAutoHideAsync, hideAsync } from 'expo-splash-screen'

// Keep the splash screen visible while we fetch resources
preventAutoHideAsync();

export default function App() {
  const [userNum, setUserNum] = useState()
  const [isGameOver, setIsGameOver] = useState(true)
  const [appIsReady, setAppIsReady] = useState(false);
  const [guessRounds, setGuessRounds] = useState(0)

  useEffect(() => {
    async function prepare() {
      try {
        // Pre-load fonts, make any API calls you need to do here
        await loadAsync({
          'open-sans': require('./assets/fonts/OpenSans-Regular.ttf'),
          'open-sans-bold': require('./assets/fonts/OpenSans-Bold.ttf'),
        })
      } catch (e) {
        console.warn(e);
      } finally {
        // Tell the application to render
        setAppIsReady(true);
      }
    }

    prepare();
  }, []);

  const onLayoutRootView = useCallback(async () => {
    if (appIsReady) {
      // This tells the splash screen to hide immediately! If we call this after
      // `setAppIsReady`, then we may see a blank screen while the app is
      // loading its initial state and rendering its first pixels. So instead,
      // we hide the splash screen once we know the root view has already
      // performed layout.
      await hideAsync();
    }
  }, [appIsReady]);

  if (!appIsReady) {
    return null;
  }

  function pickedNumberHandler(pickedNumber) {
    setUserNum(pickedNumber)
    setIsGameOver(false)
  }

  function onGameOverHandler(numberOfRounds) {
    setIsGameOver(true)
    setGuessRounds(numberOfRounds)
  }

  function startNewGameHandler() {
    setUserNum(null)
    setGuessRounds(0)
  }

  let screen = <StartGameScreen onPickNumber={pickedNumberHandler} />

  if (userNum) {
    screen = <GameScreen userNumber={userNum} onGameOver={onGameOverHandler} />
  }

  if (isGameOver && userNum) {
    screen = <GameOverScreen userNumber={userNum} roundsNumber={guessRounds} onStartNewGame={startNewGameHandler} />
  }

  return (
    <>
      <StatusBar barStyle="dark" />
      <LinearGradient onLayout={onLayoutRootView} colors={['#EE6B6E', '#644b64']} style={styles.rootScreen}>
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
    </>
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
