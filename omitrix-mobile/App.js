import {useState} from 'react';
import {StatusBar} from 'expo-status-bar';
import {Button, FlatList, Modal, ScrollView, StyleSheet, Text, TextInput, View} from 'react-native';
import {SHA256} from 'crypto-js';
import GoalItem from "./components/GoalItem";
import GoalInput from "./components/GoalInput";

export default function App() {
    const [goals, setGoals] = useState([]);

    function generateRandomString(length) {
        let randomChars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
        let result = '';
        for (let i = 0; i < length; i++) {
            result += randomChars.charAt(Math.floor(Math.random() * randomChars.length));
        }
        return result;
    }

    function addGoalHandler(enterGoalTxt) {
        setGoals(currentGoals => [...currentGoals, {
            text: enterGoalTxt,
            id: generateRandomString(5)
        }])
    }

    function clearGoals() {
        setGoals([])
    }

    return (
        <View style={styles.appContainer}>
            <GoalInput onAddGoal={addGoalHandler} onClearGoals={clearGoals}/>
            <View style={styles.listItems}>
                <Text>#List of goals</Text>
                <FlatList
                    data={goals}
                    renderItem={itemData =>
                        <GoalItem index={itemData.index} value={itemData.item.text}/>
                    }
                    keyExtractor={(item, index) => item.id}
                    alwaysBounceVertical={false}
                />
            </View>
        </View>
    );
}

const styles = StyleSheet.create({
    appContainer: {
        flex: 1,
        paddingTop: 50,
        paddingHorizontal: 25
    },
    listItems: {
        flex: 8
    }
});
