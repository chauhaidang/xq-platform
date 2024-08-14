import {Text, View, StyleSheet, Pressable} from "react-native";

function GoalItem(props) {
    const index = props.index
    const content = props.value
    return (
        <View style={styles.goalItem}>
            <Pressable
                android_ripple={styles.androidRipple}
                onPress={() => {
                    props.onDelete(props.id)
                }}
                style={({pressed})=> pressed && styles.iosRipple}
            >
                <Text style={styles.goalItemText}>
                    {index}. {content}
                </Text>
            </Pressable>
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
        borderRadius: 5
    },
    goalItemText: {
        padding: 5,
        color: 'black'
    },
    androidRipple: {
        color: '#EE6B6E'
    },
    iosRipple: {
        opacity: 0.5,
        backgroundColor: '#EE6B6E'
    }
})

export default GoalItem