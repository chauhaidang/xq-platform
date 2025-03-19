import {NavigationContainer} from "@react-navigation/native";
import {createDrawerNavigator} from "@react-navigation/drawer";
import HomeScreen from "./screens/xq/HomeScreen";
import {TITLES} from "./constants/screens";
import TestPlansScreen from "./screens/xq/TestPlansScreen";
import TestCasesScreen from "./screens/xq/TestCasesScreen";
import TestReportsScreen from "./screens/xq/TestReportsScreen";
import React, {useCallback, useEffect, useState} from "react";
import CustomColors from "./constants/colors";
import {Ionicons} from "@expo/vector-icons";
import {loadAsync} from "expo-font";
import {preventAutoHideAsync} from "expo-splash-screen";
import {StatusBar} from "react-native";
import {hideAsync} from "expo-splash-screen";

// Keep the splash screen visible while we fetch resources
preventAutoHideAsync()
const Drawer = createDrawerNavigator()

export default function AppPocV2() {
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
            <StatusBar barStyle={'default'}/>
            <NavigationContainer onReady={onLayoutRootView}>
                <Drawer.Navigator initialRouteName={TITLES.HOME} screenOptions={{
                    headerStyle: {backgroundColor: CustomColors.background},
                    headerBackButtonDisplayMode: 'generic',
                    headerTitleAlign: 'center',
                    headerTintColor: CustomColors.textTitle,
                    headerTitleStyle: {
                        fontSize: 26,
                        fontFamily: 'open-sans-bold',
                        color: CustomColors.textTitle,
                    },
                    drawerActiveBackgroundColor: CustomColors.background,
                    drawerActiveTintColor: CustomColors.textTitle,
                    drawerStyle: {backgroundColor: CustomColors.listItem}
                }}>
                    <Drawer.Screen name="Home" component={HomeScreen} options={{
                        drawerLabel: 'Home',
                        drawerIcon: ({color, size}) => (<Ionicons name={"home"} color={color} size={size}/>)
                    }}/>
                    <Drawer.Screen name={TITLES.TEST_PLAN_OVERVIEW} component={TestPlansScreen} options={{
                        drawerIcon: ({color, size}) => (<Ionicons name={"document-text"} color={color} size={size}/>)
                    }}/>
                    <Drawer.Screen name={TITLES.TEST_CASE_OVERVIEW} component={TestCasesScreen} options={{
                        drawerIcon: ({color, size}) => (
                            <Ionicons name={"checkmark-done-circle-outline"} color={color} size={size}/>)
                    }}/>
                    <Drawer.Screen name={TITLES.TEST_REPORT_OVERVIEW} component={TestReportsScreen} options={{
                        drawerIcon: ({color, size}) => (
                            <Ionicons name={"stats-chart-outline"} color={color} size={size}/>)
                    }}/>
                </Drawer.Navigator>
            </NavigationContainer>

        </>
    )
}