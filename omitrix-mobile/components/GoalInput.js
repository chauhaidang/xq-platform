import {Button, StyleSheet, TextInput, View} from "react-native";
import {useState} from "react";

function GoalInput(props) {
    const [enterGoalTxt, setEnterGoalTxt] = useState('')

    const goalInputHandler = (txt) => {
        setEnterGoalTxt(txt)
    }

    function addGoalHandler() {
        props.onAddGoal(enterGoalTxt)
        setEnterGoalTxt('')
    }

    return (
        <View style={styles.inputContainer}>
            <TextInput style={styles.textInput} placeholder={'Enter your course goal here'}
                       onChangeText={goalInputHandler} value={enterGoalTxt} />
            <View style={styles.viewButton}>
                <Button title={'Add Goal'} onPress={addGoalHandler} color='#EE6B6E'/>
            </View>
            <View style={styles.viewButton}>
                <Button title={'Clear All'} onPress={props.onClearGoals}/>
            </View>
        </View>
    )
}

const styles = StyleSheet.create({
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
    viewButton: {
        width: '17%',
    },
})

export default GoalInput