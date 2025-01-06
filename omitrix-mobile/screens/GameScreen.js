import { View, Text, StyleSheet, Alert } from 'react-native'
import { useEffect, useState } from "react"
import Title from '../components/Title'
import NumberContainer from '../components/NumberContainer'
import PrimaryButton from "../components/PrimaryButton"
import Card from '../components/Card'
import InstructionText from '../components/InstructionText'
import { randomBetween } from 'kit-common'
import { Ionicons } from '@expo/vector-icons'

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
        <InstructionText style={styles.instructionText}>Higher or Lower</InstructionText>
        <View style={styles.buttonsContainer}>
          <View style={styles.buttonContainer}>
            <PrimaryButton onPress={() => nextGuessHandler('lower')}>
              <Ionicons name="remove-circle-outline" size={24} color="white" />
            </PrimaryButton>
          </View>
          <View style={styles.buttonContainer}>
            <PrimaryButton onPress={() => nextGuessHandler('greater')}>
              <Ionicons name="add-circle-outline" size={24} color="white" />
            </PrimaryButton>
          </View>
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
  },
  buttonsContainer: {
    flexDirection: 'row',
  },
  buttonContainer: {
    flex: 1,
  },
  instructionText: {
    margin: 24
  },
})
