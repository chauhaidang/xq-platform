import { StyleSheet, View } from 'react-native'
import Title from '../../components/Title'
import Card from '../../components/Card'

function HomeScreen() {
  return (
    <View style={styles.root}>
      <Card>Test Plan</Card>
      <Card>Test Cases</Card>
      <Card>Report</Card>
    </View>
  )
}

export default HomeScreen

const styles = StyleSheet.create({
  root: {
    flex: 1,
  },
})
