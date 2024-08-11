import {useState} from 'react';
import {StatusBar} from 'expo-status-bar';
import {Button, FlatList, Modal, ScrollView, StyleSheet, Text, TextInput, View} from 'react-native';
import {SHA256} from 'crypto-js';

export default function App() {
    const [enterGoalTxt, setEnterGoalTxt] = useState('')
    const [goals, setGoals] = useState([]);

    function generateRandomString(length) {
        let randomChars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
        let result = '';
        for (let i = 0; i < length; i++) {
            result += randomChars.charAt(Math.floor(Math.random() * randomChars.length));
        }
        return result;
    }

    const goalInputHandler = (txt) => {
        setEnterGoalTxt(txt)
    }

    const addGoalHandler = () => {
        setGoals(currentGoals => [...currentGoals, {
            text: enterGoalTxt,
            id: generateRandomString(5)
        }])
        setEnterGoalTxt('')
    }

    function clearGoals() {
        setGoals([])
    }

    return (
        <View style={styles.appContainer}>
            <View style={styles.inputContainer}>
                <TextInput style={styles.textInput} placeholder={'Enter your course goal here'}
                           onChangeText={goalInputHandler} value={enterGoalTxt}/>
                <View style={styles.viewButton}>
                    <Button style={styles.button} title={'Add Goal'} onPress={addGoalHandler} color='#EE6B6E'/>
                </View>
                <View style={styles.viewButton}>
                    <Button style={styles.button} title={'Clear All'} onPress={clearGoals}/>
                </View>
            </View>
            <View style={styles.listItems}>
                <Text>#List of goals</Text>
                <FlatList
                    data={goals}
                    renderItem={itemData =>
                        (
                            <View style={styles.goalItem}>
                                <Text style={styles.goalItemText}>
                                    {itemData.index}. {itemData.item.text}
                                </Text>
                            </View>
                        )}
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
    inputContainer: {
        flex: 1,
        flexDirection: 'row',
        justifyContent: 'space-between',
        alignItems: 'center',
        borderBottomWidth: 1,
        borderBottomColor: 'black',
        marginBottom: 10,
    },
    textInput: {
        borderColor: '#DCDCDC',
        borderWidth: 1,
        width: '65%',
        marginRight: 5,
        padding: 9
    },
    listItems: {
        flex: 8
    },
    viewButton: {
        width: '17%',
    },
    buttonText: {
        color: '#EE6B6E',
        fontSize: 15
    },
    goalItem: {
        backgroundColor: '#FBFBFB',
        borderWidth: 1,
        borderColor: '#EE6B6E',
        borderStyle: 'solid',
        borderCurve: 'circular',
        marginTop: 5,
        padding: 5,
        borderRadius: 5
    },
    goalItemText: {}
});
