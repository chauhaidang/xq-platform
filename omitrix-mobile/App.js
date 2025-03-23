import { StyleSheet, StatusBar, SafeAreaView } from 'react-native'
import CategoriesScreen from './screens/CategoriesScreen'
import { NavigationContainer } from '@react-navigation/native'
import { createNativeStackNavigator } from '@react-navigation/native-stack'
import { createDrawerNavigator } from '@react-navigation/drawer'
import { TITLES } from './constants/screens'
import CustomColors from './constants/colors'
import MealDetailsScreen from './screens/MealDetailsScreen'
import FavouritesScreen from './screens/FavouritesScreen'
import MealOverViewScreen from './screens/MealOverViewScreen'

const Stack = createNativeStackNavigator()
const Drawer = createDrawerNavigator()

function DrawerNavigator() {
  return (
    <Drawer.Navigator screenOptions={{
      headerStyle: { backgroundColor: CustomColors.background },
      headerTintColor: 'black',
      sceneStyle: { backgroundColor: CustomColors.background },
    }}>
      <Drawer.Screen name={TITLES.CATEGORIES_OVERVIEW} component={CategoriesScreen} options={{
        title: TITLES.ALL_CATEGORIES
      }}/>
      <Drawer.Screen name={TITLES.FAVOURITES} component={FavouritesScreen} />
    </Drawer.Navigator>
  )
}

export default function App() {
  return (
    <>
      <StatusBar barStyle={'default'} />
      {/*<SafeAreaView style={styles.container}>*/}
      <NavigationContainer>
        <Stack.Navigator
          screenOptions={{
            headerStyle: { backgroundColor: CustomColors.background },
            headerTintColor: 'black',
            contentStyle: { backgroundColor: CustomColors.background },
            headerShown: true,
          }}
        >
          <Stack.Screen name={TITLES.ALL_CATEGORIES} component={DrawerNavigator}
                        options={{
                          headerShown: false,
                        }} />
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
          <Stack.Screen name={TITLES.MEAL_DETAIL} component={MealDetailsScreen} options={{
            title: TITLES.ABOUT_MEAL
          }}/>
        </Stack.Navigator>
      </NavigationContainer>
      {/*</SafeAreaView>*/}
    </>
  )
}

const styles = StyleSheet.create({
  container: {},
})
