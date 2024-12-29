import { Alert, StyleSheet, TextInput, View } from 'react-native'
import PrimaryButton from '../components/PrimaryButton'
import { useState } from 'react'
import CustomColors from '../constants/colors'

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
    <View style={styles.inputContainer}>
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
    </View>
  )
}

const styles = StyleSheet.create({
  inputContainer: {
    justifyContent: 'center',
    alignItems: 'center',
    marginTop: 100,
    marginHorizontal: 25,
    padding: 16,
    backgroundColor: CustomColors.background,
    borderRadius: 8,
    // for Android
    elevation: 10,
    // for ios
    shadowColor: 'black',
    shadowOffset: { width: 0, height: 10 },
    shadowRadius: 6,
    shadowOpacity: 0.25,
  },
  inputNumber: {
    height: 50,
    width: 50,
    fontSize: 32,
    borderBottomColor: CustomColors.border,
    borderBottomWidth: 2,
    color: 'black',
    marginVertical: 8,
    fontWeight: 'bold',
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
