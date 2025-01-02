import { View, Text, StyleSheet, Alert } from 'react-native'
import { useEffect, useState } from "react"
import Title from '../components/Title'
import NumberContainer from '../components/NumberContainer'
import PrimaryButton from "../components/PrimaryButton"
import Card from '../components/Card'
import InstructionText from '../components/InstructionText'
import { randomBetween } from 'kit-common'

let minBoundary = 1
let maxBoundary = 100

function GameScreen({ userNumber, onGameOver }) {
  const initialGuess = randomBetween(1, 100, userNumber)
  const [currentGuess, setCurrentGuess] = useState(initialGuess)

  useEffect(() => {
    if (currentGuess === userNumber) {
      onGameOver()
    }
  }, [currentGuess, useEffect, onGameOver])

  function nextGuessHandler(direction) {
    if (direction === "lower" && currentGuess < userNumber
      || direction === "greater" && currentGuess > userNumber
    ) {
      Alert.alert("Don't like", "You know that this is wrong...", [
        { text: 'Sorry!', style: 'cancel' }
      ])
      return
    }
    if (direction === "lower") {
      maxBoundary = currentGuess
    } else {
      minBoundary = currentGuess
    }
    const newRandNum = randomBetween(minBoundary, maxBoundary, currentGuess)
    setCurrentGuess(newRandNum)
  }

  return (
    <View style={styles.screen}>
      <Title>Opponent's guess</Title>
      <NumberContainer>{currentGuess}</NumberContainer>
      <Card>
        <InstructionText>Higher or Lower</InstructionText>
        <View>
          <PrimaryButton onPress={() => nextGuessHandler('lower')}>-</PrimaryButton>
          <PrimaryButton onPress={() => nextGuessHandler('greater')}>+</PrimaryButton>
        </View>
      </Card>
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
