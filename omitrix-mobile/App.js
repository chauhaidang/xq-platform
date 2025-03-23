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
import { Ionicons } from '@expo/vector-icons'
import FavouritesContextProvider from './store/context/favourites-context'

const Stack = createNativeStackNavigator()
const Drawer = createDrawerNavigator()

function DrawerNavigator() {
  return (
    <Drawer.Navigator screenOptions={{
      headerStyle: { backgroundColor: CustomColors.background },
      headerTintColor: 'black',
      sceneStyle: { backgroundColor: CustomColors.background },
      drawerContentStyle: { backgroundColor: CustomColors.background },
      drawerActiveTintColor: CustomColors.textTitle,
      drawerInactiveTintColor: CustomColors.textBlack,
      drawerActiveBackgroundColor: CustomColors.buttonBackgroundDark,
    }}>
      <Drawer.Screen name={TITLES.CATEGORIES_OVERVIEW} component={CategoriesScreen} options={{
        title: TITLES.ALL_CATEGORIES,
        drawerIcon: ({ color, size }) => <Ionicons name={'list'} size={size} color={color} />,
      }} />
      <Drawer.Screen name={TITLES.FAVOURITES} component={FavouritesScreen} options={{
        drawerIcon: ({ color, size }) => <Ionicons name={'star'} size={size} color={color} />,
      }} />
    </Drawer.Navigator>
  )
}

export default function App() {
  return (
    <>
      <StatusBar barStyle={'default'} />
      <FavouritesContextProvider>
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
              title: TITLES.ABOUT_MEAL,
            }} />
          </Stack.Navigator>
        </NavigationContainer>
      </FavouritesContextProvider>
    </>
  )
}

const styles = StyleSheet.create({
  container: {},
})
