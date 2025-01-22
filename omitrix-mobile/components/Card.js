import { StyleSheet, View, Dimensions } from "react-native"
import CustomColors from "../constants/colors"
import { metrics } from "../constants/device"


function Card({ children }) {
    return (
        <View style={styles.card}>
            {children}
        </View>
    )
}

export default Card

const appScreenWidth = Dimensions.get('window').width

const styles = StyleSheet.create({
    card: {
        justifyContent: 'center',
        alignItems: 'center',
        marginTop: appScreenWidth < metrics.screenWidth ? 28 : 36,
        marginHorizontal: 24,
        padding: 16,
        backgroundColor: CustomColors.background,
        borderRadius: 8,
        // for Android
        elevation: 10,
        // for ios
        shadowColor: 'black',
        shadowOffset: { width: 0, height: 10 },
        shadowRadius: 6,
        shadowOpacity: 0.25,
    },
})