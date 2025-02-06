import { StyleSheet, Text, View, StatusBar, SafeAreaView } from 'react-native'
import CategoriesScreen from './screens/CategoriesScreen'

export default function App() {
  return (
    <>
      <StatusBar barStyle={'default'} />
      <SafeAreaView style={styles.container}>
        <CategoriesScreen />
      </SafeAreaView>
    </>
  )
}

const styles = StyleSheet.create({
  container: {},
})
