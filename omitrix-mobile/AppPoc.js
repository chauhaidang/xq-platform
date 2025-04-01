import React, { useEffect, useState, useCallback } from 'react'
import { SafeAreaView, StatusBar, StyleSheet } from 'react-native'
import { loadAsync } from 'expo-font'
import CustomColors from './constants/colors'
import { preventAutoHideAsync, hideAsync } from 'expo-splash-screen'
import HomeScreen from './screens/xq/HomeScreen'
import { NavigationContainer } from '@react-navigation/native'
import { createNativeStackNavigator } from '@react-navigation/native-stack'
import { TITLES } from './constants/screens'
import TestPlansScreen from './screens/xq/TestPlansScreen'
import TestCasesScreen from './screens/xq/TestCasesScreen'
import TestReportsScreen from './screens/xq/TestReportsScreen'
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs'
import DevScreen from './screens/DevScreen'
import { Ionicons } from '@expo/vector-icons'
import TestRequirementContextProvider from './store/context/test-requirement-context'

// Keep the splash screen visible while we fetch resources
preventAutoHideAsync()
const Stack = createNativeStackNavigator()
const BottomTab = createBottomTabNavigator()

function BottomTabNavigator() {
  return (
    <BottomTab.Navigator screenOptions={{
      headerStyle: { backgroundColor: CustomColors.background },
      headerBackButtonDisplayMode: 'generic',
      headerTitleAlign: 'center',
      headerTintColor: CustomColors.textTitle,
      headerTitleStyle: {
        fontSize: 26,
        fontFamily: 'open-sans-bold',
        color: CustomColors.textTitle,
      },
      tabBarActiveTintColor: CustomColors.textTitle,
    }}>
      <BottomTab.Screen
        name={TITLES.HOME} component={HomeScreen}
        options={{
          tabBarIcon: ({ color, size }) => (<Ionicons name={'home'} color={color} size={size} />),
        }}
      />
      <BottomTab.Screen name={TITLES.DEV_MODE} component={DevScreen} options={{
        tabBarIcon: ({ color, size }) => (<Ionicons name={'code-slash-outline'} color={color} size={size} />),
      }} />
    </BottomTab.Navigator>
  )
}

export default function App() {
  const [appIsReady, setAppIsReady] = useState(false)
  useEffect(() => {
    async function prepare() {
      try {
        // Pre-load fonts, make any API calls you need to do here
        await loadAsync({
          'open-sans': require('./assets/fonts/OpenSans-Regular.ttf'),
          'open-sans-bold': require('./assets/fonts/OpenSans-Bold.ttf'),
        })
      } catch (e) {
        console.warn(e)
      } finally {
        // Tell the application to render
        setAppIsReady(true)
      }
    }

    prepare()
  }, [])

  const onLayoutRootView = useCallback(async () => {
    if (appIsReady) {
      // This tells the splash screen to hide immediately! If we call this after
      // `setAppIsReady`, then we may see a blank screen while the app is
      // loading its initial state and rendering its first pixels. So instead,
      // we hide the splash screen once we know the root view has already
      // performed layout.
      await hideAsync()
    }
  }, [appIsReady])

  if (!appIsReady) {
    return null
  }

  return (
    <>
      <StatusBar barStyle={'default'} />
      <TestRequirementContextProvider>
        <NavigationContainer onReady={onLayoutRootView}>
          <Stack.Navigator screenOptions={{
            headerStyle: { backgroundColor: CustomColors.background },
            headerBackButtonDisplayMode: 'generic',
            headerTitleAlign: 'center',
            headerTintColor: CustomColors.textTitle,
            headerTitleStyle: {
              fontSize: 26,
              fontFamily: 'open-sans-bold',
              color: CustomColors.textTitle,
            },
          }}>
            <Stack.Screen name={TITLES.HOME} component={BottomTabNavigator} options={{
              headerShown: false,
            }} />
            <Stack.Screen name={TITLES.TEST_PLAN_OVERVIEW} component={TestPlansScreen} />
            <Stack.Screen name={TITLES.TEST_CASE_OVERVIEW} component={TestCasesScreen} />
            <Stack.Screen name={TITLES.TEST_REPORT_OVERVIEW} component={TestReportsScreen} />
          </Stack.Navigator>
        </NavigationContainer>
      </TestRequirementContextProvider>
    </>
  )
}

const styles = StyleSheet.create({
  root: {
    backgroundColor: CustomColors.background,
    flex: 1,
  },
})
