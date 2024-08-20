import {useState} from 'react';
import {StatusBar} from 'expo-status-bar';
import {Button, FlatList, Modal, ScrollView, StyleSheet, Text, TextInput, View} from 'react-native';
import {SHA256} from 'crypto-js';
import GoalItem from "./components/GoalItem";
import GoalInput from "./components/GoalInput";

export default function App() {
    const [goals, setGoals] = useState([]);
    const [goalModalVisible, setGoalModalVisible] = useState(false);

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
        setGoalModalVisible(false)
    }

    function clearGoals() {
        setGoals([])
    }

    function deleteGoalHandler(id) {
        setGoals(currentGoals => currentGoals.filter(goal => goal.id !== id))
    }

    function addNewGoalHandler() {
        setGoalModalVisible(true)
    }

    function dismissModal() {
        setGoalModalVisible(false)
    }

    return (
        <View style={styles.appContainer}>
            <Button title={'ADD NEW GOAL'} onPress={addNewGoalHandler} color='#EE6B6E'/>
            <GoalInput isVisible={goalModalVisible} onAddGoal={addGoalHandler} onClearGoals={clearGoals} onDismiss={dismissModal}/>
            <View style={styles.listItems}>
                <Text>#List of goals</Text>
                <FlatList
                    data={goals}
                    renderItem={itemData =>
                        <GoalItem index={itemData.index} value={itemData.item.text} id={itemData.item.id} onDelete={deleteGoalHandler}/>
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
