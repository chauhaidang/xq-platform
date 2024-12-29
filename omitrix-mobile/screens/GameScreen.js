import { View, Text, StyleSheet } from 'react-native'
import { useState } from "react"
import Title from '../components/Title'
import NumberContainer from '../components/NumberContainer'

function generateRandomBetween(min, max, exclude) {
  const rand = Math.floor(Math.random() * (max - min + 1)) + min
  return rand === exclude ? generateRandomBetween(min, max, exclude) : rand
}

function GameScreen({ userNumber }) {
  const initialGuess = generateRandomBetween(0, 100, userNumber)
  const [currentGuess, setCurrentGuess] = useState(initialGuess)
  return (
    <View style={styles.screen}>
      <Title>Opponent's guess</Title>
      <NumberContainer>{currentGuess}</NumberContainer>
      <View>
        <Text>Higher or Lower</Text>
      </View>
      <View></View>
    </View>
  )
}

export default GameScreen

const styles = StyleSheet.create({
  screen: {
    flex: 1,
    padding: 24
  }
})
