import { StyleSheet, Text, View, StatusBar, SafeAreaView } from 'react-native'
import CategoriesScreen from './screens/CategoriesScreen'
import { NavigationContainer } from '@react-navigation/native'
import { createNativeStackNavigator } from '@react-navigation/native-stack'
import MealOverViewScreen from './screens/MealOverViewScreen'
import { TITLES } from './constants/screens'

const Stack = createNativeStackNavigator()

export default function App() {
  return (
    <>
      <StatusBar barStyle={'default'} />
      {/*<SafeAreaView style={styles.container}>*/}
      <NavigationContainer>
        <Stack.Navigator initialRouteName={TITLES.CATEGORIES_OVERVIEW}>
          <Stack.Screen name={TITLES.CATEGORIES_OVERVIEW} component={CategoriesScreen} />
          <Stack.Screen name={TITLES.MEAL_OVERVIEW} component={MealOverViewScreen} />
        </Stack.Navigator>
      </NavigationContainer>
      {/*</SafeAreaView>*/}
    </>
  )
}

const styles = StyleSheet.create({
  container: {},
})
