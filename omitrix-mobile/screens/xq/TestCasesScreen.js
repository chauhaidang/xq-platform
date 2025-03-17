import {Button, StyleSheet, Text, View} from 'react-native'
import PrimaryButton from "../../components/PrimaryButton";

function TestCasesScreen({navigation}) {
  function openMenuHandler() {
    navigation.toggleDrawer()
  }
  return (
    <View style={styles.root}>
      <Text>Test Cases Are Coming Soon!</Text>
      <PrimaryButton onPress={openMenuHandler}>Menu</PrimaryButton>
    </View>
  )
}

export default TestCasesScreen

const styles = StyleSheet.create({
  root: {
    flex: 1,
    alignItems: 'center',
  },
  button: {

  }
})
