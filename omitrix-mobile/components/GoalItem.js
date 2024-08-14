import {Text, View, StyleSheet} from "react-native";

function GoalItem(props) {
    const index = props.index
    const content = props.value
    return (
        <View style={styles.goalItem}>
            <Text style={styles.goalItemText}>
                {index}. {content}
            </Text>
        </View>
    )
}

const styles = StyleSheet.create({
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
})

export default GoalItem