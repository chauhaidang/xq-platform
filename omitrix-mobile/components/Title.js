import { Text, StyleSheet } from 'react-native'
import CustomColors from '../constants/colors'

function Title({ children }) {
    return <Text style={styles.title}>{children}</Text>
}

export default Title

const styles = StyleSheet.create({
    title: {
        fontSize: 26,
        fontFamily: 'open-sans-bold',
        fontWeight: 'semibold',
        color: CustomColors.textTitle,
        textAlign: 'center',
        borderColor: CustomColors.borderTitle,
        padding: 5,
        borderBottomWidth: 1,
        marginTop: 10,
        fontStyle: 'normal',
        maxWidth: '80%',
        minWidth: 300,
    },
})
