import { StyleSheet, View, Text, Dimensions } from 'react-native'
import CustomColors from '../constants/colors'
import { metrics } from '../constants/device'

function NumberContainer({ children }) {
    return (
        <View style={styles.container}>
            <Text style={styles.text}>{children}</Text>
        </View>
    )
}

export default NumberContainer

const appScreenWidth = Dimensions.get('window').width

const styles = StyleSheet.create({
    container: {
        borderWidth: 4,
        borderColor: CustomColors.border,
        padding: appScreenWidth < metrics.screenWidth ? 12 : 24,
        margin: appScreenWidth < metrics.screenWidth ? 12 : 24,
        borderRadius: 8,
        alignItems: 'center',
        justifyContent: 'center',
    },
    text: {
        color: CustomColors.text,
        fontSize: appScreenWidth < metrics.screenWidth ? 28 : 36,
        fontFamily: 'open-sans-bold',
    },
})
