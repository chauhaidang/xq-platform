import { StyleSheet, StatusBar, SafeAreaView } from 'react-native'
import CategoriesScreen from './screens/CategoriesScreen'
import { NavigationContainer } from '@react-navigation/native'
import { createNativeStackNavigator } from '@react-navigation/native-stack'
import MealOverViewScreen from './screens/MealOverViewScreen'
import { TITLES } from './constants/screens'
import CustomColors from './constants/colors'
import MealDetailsScreen from './screens/MealDetailsScreen'

const Stack = createNativeStackNavigator()

export default function App() {
  return (
    <>
      <StatusBar barStyle={'default'} />
      {/*<SafeAreaView style={styles.container}>*/}
      <NavigationContainer>
        <Stack.Navigator
          initialRouteName={TITLES.CATEGORIES_OVERVIEW}
          screenOptions={{
            headerStyle: { backgroundColor: CustomColors.background },
            contentStyle: { backgroundColor: CustomColors.background },
            headerTintColor: 'black',
          }}
        >
          <Stack.Screen name={TITLES.CATEGORIES_OVERVIEW} component={CategoriesScreen} />
          <Stack.Screen
            name={TITLES.MEAL_OVERVIEW}
            component={MealOverViewScreen}
            options={() => ({
              title: TITLES.MEAL_OVERVIEW,
              headerStyle: { backgroundColor: CustomColors.background },
              contentStyle: { backgroundColor: CustomColors.background },
              headerTintColor: CustomColors.textTitle,
            })}
          />
          <Stack.Screen name={TITLES.MEAL_DETAIL} component={MealDetailsScreen} />
        </Stack.Navigator>
      </NavigationContainer>
      {/*</SafeAreaView>*/}
    </>
  )
}

const styles = StyleSheet.create({
  container: {},
})
