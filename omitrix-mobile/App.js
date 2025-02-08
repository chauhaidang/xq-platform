import { StyleSheet, Text, View, StatusBar, SafeAreaView } from 'react-native'
import CategoriesScreen from './screens/CategoriesScreen'
import { NavigationContainer } from '@react-navigation/native'
import { createNativeStackNavigator } from '@react-navigation/native-stack'

const Stack = createNativeStackNavigator()

export default function App() {
  return (
    <>
      <StatusBar barStyle={'default'} />
      {/*<SafeAreaView style={styles.container}>*/}
      <NavigationContainer>
        <Stack.Navigator>
          <Stack.Screen name="Categories" component={CategoriesScreen} />
        </Stack.Navigator>
      </NavigationContainer>
      {/*</SafeAreaView>*/}
    </>
  )
}

const styles = StyleSheet.create({
  container: {},
})
