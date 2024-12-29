import { StyleSheet, View, Text } from "react-native";
import CustomColors from "../constants/colors";

function NumberContainer({ children }) {

    return (
        <View style={styles.container}>
            <Text style={styles.text}>{children}</Text>
        </View>
    )
}

export default NumberContainer

const styles = StyleSheet.create({
    container: {
        borderWidth: 4,
        borderColor: CustomColors.border,
        padding: 24,
        margin: 24,
        borderRadius: 8,
        alignItems: "center",
        justifyContent: "center",
    },
    text: {
        color: CustomColors.text,
        fontSize: 36,
        fontWeight: 'bold',
    }
})