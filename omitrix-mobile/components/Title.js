import { Text, StyleSheet } from "react-native"
import CustomColors from '../constants/colors'

function Title({ children }) {
    return <Text style={styles.title}>{children}</Text>
}

export default Title

const styles = StyleSheet.create({
    title: {
        fontSize: 24,
        fontFamily: 'open-sans-bold',
        color: CustomColors.textTitle,
        textAlign: 'center',
        borderWidth: 2,
        borderColor: CustomColors.borderTitle,
        padding: 20
    }
})
