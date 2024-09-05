import {Button, Image, Modal, StyleSheet, TextInput, View} from "react-native";
import {useState} from "react";
import {testProps} from "../utils/test-utils";

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
        <Modal visible={props.isVisible} animationType={'slide'}>
            <View style={styles.inputContainer}>
                <Image style={styles.image} source={require('../assets/omitrix-logo.png')}/>
                <TextInput {...testProps('input-goal')} style={styles.textInput} placeholder={'Enter your course goal here'}
                           onChangeText={goalInputHandler} value={enterGoalTxt}/>
                <View style={styles.buttonContainer}>
                    <View style={styles.button}><Button title={'Add Goal'} onPress={addGoalHandler}
                                                        color='#EE6B6E'/></View>
                    <View style={styles.button}><Button title={'Clear All'} onPress={props.onClearGoals}/></View>
                    <View style={styles.button}><Button title={'Close'} onPress={props.onDismiss}/></View>
                </View>
            </View>
        </Modal>
    )
}

const styles = StyleSheet.create({
    inputContainer: {
        flex: 1,
        flexDirection: 'column',
        justifyContent: 'center',
        alignItems: 'center',
        marginBottom: 10,
    },
    textInput: {
        borderColor: '#DCDCDC',
        borderWidth: 1,
        width: '100%',
        padding: 9,
    },
    buttonContainer: {
        marginTop: 15,
        flexDirection: 'row'
    },
    button: {
        width: '30%',
        marginHorizontal: 5,
        borderStyle: 'solid',
        borderWidth: 1,
        borderRadius: 8,
        borderColor: '#EE6B6E'
    },
    image: {
        width: 100,
        height: 100,
        marginBottom: 30
    }
})

export default GoalInput