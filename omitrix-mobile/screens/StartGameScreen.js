import { Button, StyleSheet, TextInput, View } from 'react-native'
import PrimaryButton from '../components/PrimaryButton'

function StartGameScreen() {
  return (
    <View style={styles.inputContainer}>
      <TextInput
        style={styles.inputNumber}
        maxLength={2}
        keyboardType="number-pad"
        autoCapitalize="none"
        autoCorrect={false}
      />
      <PrimaryButton>Reset</PrimaryButton>
      <PrimaryButton>Confirm</PrimaryButton>
    </View>
  )
}

const styles = StyleSheet.create({
  inputContainer: {
    marginTop: 100,
    marginHorizontal: 25,
    padding: 16,
    backgroundColor: '#EE6B6E',
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
    borderBottomColor: '#ddb52f',
    borderBottomWidth: 2,
    color: 'black',
    marginVertical: 8,
    fontWeight: 'bold',
    textAlign: 'center',
  },
})

export default StartGameScreen
