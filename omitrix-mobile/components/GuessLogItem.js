import { View, Text, StyleSheet } from "react-native";
import CustomColors from "../constants/colors";

function GuessLogItem({ roundNumber, guess }) {
    return (
        <View style={styles.container}>
            <Text style={styles.text}>#{roundNumber}</Text>
            <Text style={styles.text}>Opponent's guess: {guess}</Text>
        </View>
    );
}

export default GuessLogItem;

const styles = StyleSheet.create({
    container: {
        borderColor: CustomColors.border,
        borderWidth: 1,
        borderRadius: 40,
        padding: 12,
        marginVertical: 8,
        backgroundColor: CustomColors.listItem,
        flexDirection: "row",
        justifyContent: "space-between",
        width: "100%",
        elevation: 4,
        shadowColor: CustomColors.shadow,
        shadowOffset: { width: 0, height: 0 },
        shadowOpacity: 0.5,
        shadowRadius: 3
    },
    text: {
        fontSize: 20,
        fontFamily: 'open-sans',
        fontStyle: 'italic',
    },
});