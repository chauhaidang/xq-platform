import { Alert, StyleSheet, ScrollView, TextInput, View, KeyboardAvoidingView } from 'react-native'
import PrimaryButton from '../components/PrimaryButton'
import { useState } from 'react'
import CustomColors from '../constants/colors'
import Title from '../components/Title'
import Card from '../components/Card'
import InstructionText from '../components/InstructionText'

function StartGameScreen({ onPickNumber }) {
  const [enteredNumber, setEnteredNumber] = useState('')

  function changeTextHandler(userInput) {
    setEnteredNumber(userInput)
    console.log(userInput)
  }

  function onConfirmHandler() {
    const checkingNumber = parseInt(enteredNumber)

    if (isNaN(checkingNumber) || checkingNumber <= 0 || checkingNumber > 99) {
      Alert.alert('Invalid number', 'Entered value has to be a valid number', [
        { text: 'OK', style: 'destructive', onPress: onResetInputHandler },
      ])
      return
    }
    onPickNumber(checkingNumber)
  }

  function onResetInputHandler() {
    setEnteredNumber('')
  }

  return (
    <ScrollView style={styles.screen}>
      <KeyboardAvoidingView style={styles.screen} behavior="position">
        <View style={styles.rootContainer}>
          <Title>Guess My Number</Title>
          <Card>
            <InstructionText>Input number</InstructionText>
            <TextInput
              style={styles.inputNumber}
              maxLength={2}
              keyboardType="number-pad"
              autoCapitalize="none"
              autoCorrect={false}
              value={enteredNumber}
              onChangeText={changeTextHandler}
            />
            <View style={styles.buttonsContainer}>
              <View style={styles.buttonContainer}>
                <PrimaryButton onPress={onResetInputHandler}>Reset</PrimaryButton>
              </View>
              <View style={styles.buttonContainer}>
                <PrimaryButton onPress={onConfirmHandler}>Confirm</PrimaryButton>
              </View>
            </View>
          </Card>
        </View>
      </KeyboardAvoidingView>
    </ScrollView>
  )
}

const styles = StyleSheet.create({
  screen: {
    flex: 1,
  },
  rootContainer: {
    flex: 1,
    marginTop: 100,
    alignItems: 'center'
  },
  inputNumber: {
    height: 50,
    width: 50,
    fontSize: 32,
    borderBottomColor: CustomColors.border,
    borderBottomWidth: 2,
    color: 'black',
    marginVertical: 8,
    fontFamily: 'open-sans',
    textAlign: 'center',
  },
  buttonsContainer: {
    flexDirection: 'row',
  },
  buttonContainer: {
    flex: 1,
  },

})

export default StartGameScreen
