import { StyleSheet, Text, View } from 'react-native'

function TestCasesScreen({ navigation }) {
  return (
    <View style={styles.root}>
      <Text>Test Cases Are Coming Soon!</Text>
    </View>
  )
}

export default TestCasesScreen

const styles = StyleSheet.create({
  root: {
    flex: 1,
    alignItems: 'center',
  },
})
