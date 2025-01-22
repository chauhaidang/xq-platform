import { View, Text, StyleSheet, Alert } from 'react-native'
import { useEffect, useState } from 'react'
import Title from '../components/Title'
import NumberContainer from '../components/NumberContainer'
import PrimaryButton from '../components/PrimaryButton'
import Card from '../components/Card'
import InstructionText from '../components/InstructionText'
import { randomBetween } from 'kit-common'
import { Ionicons } from '@expo/vector-icons'
import List from '../components/List'
import GuessLogItem from '../components/GuessLogItem'

let minBoundary = 1
let maxBoundary = 100

function GameScreen({ userNumber, onGameOver }) {
  const initialGuess = randomBetween(1, 100, userNumber)
  const [currentGuess, setCurrentGuess] = useState(initialGuess)
  const [rounds, setRounds] = useState([])

  useEffect(() => {
    if (currentGuess === userNumber) {
      onGameOver(rounds.length)
    }
  }, [currentGuess, useEffect, onGameOver])

  //This effect will run only once when the component is mounted the first time
  useEffect(() => {
    minBoundary = 1
    maxBoundary = 100
  }, [])

  function nextGuessHandler(direction) {
    if (
      (direction === 'lower' && currentGuess < userNumber) ||
      (direction === 'greater' && currentGuess > userNumber)
    ) {
      Alert.alert("Don't like", 'You know that this is wrong...', [
        { text: 'Sorry!', style: 'cancel' },
      ])
      return
    }
    if (direction === 'lower') {
      maxBoundary = currentGuess
    } else {
      minBoundary = currentGuess
    }
    const newRandNum = randomBetween(minBoundary, maxBoundary, currentGuess)
    setCurrentGuess(newRandNum)
    setRounds(currentRounds => [newRandNum, ...currentRounds])
  }

  const guessRoundsListLength = rounds.length

  const renderGuessLogItem = itemData => {
    console.log('itemData', itemData);

    return (
      <GuessLogItem roundNumber={guessRoundsListLength - itemData.index} guess={itemData.item.text} />
    )
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
      <List input={rounds} renderHandler={renderGuessLogItem} />
    </View>
  )
}

export default GameScreen

const styles = StyleSheet.create({
  screen: {
    flex: 1,
    padding: 24,
    alignItems: 'center',
  },
  buttonsContainer: {
    flexDirection: 'row',
  },
  buttonContainer: {
    flex: 1,
  },
  instructionText: {
    margin: 24,
  },
})
