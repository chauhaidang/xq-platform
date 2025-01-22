import { StyleSheet, View, Image, Text, Dimensions } from "react-native";
import Title from "../components/Title";
import CustomColors from "../constants/colors";
import PrimaryButton from "../components/PrimaryButton";

function GameOverScreen({ userNumber, roundsNumber, onStartNewGame }) {
    return (
        <View style={styles.screen}>
            <Title>GAME OVER</Title>
            <View style={styles.imageContainer}>
                <Image style={styles.image} source={require('../assets/images/success.png')} />
            </View>
            <Text style={styles.summaryText}>
                You need
                <Text style={styles.highlightText}> {roundsNumber} </Text>
                rounds to guess the number
                <Text style={styles.highlightText}> {userNumber}</Text>
            </Text>
            <PrimaryButton onPress={onStartNewGame}>NEW GAME</PrimaryButton>
        </View>
    )
}

export default GameOverScreen

const appScreenWidth = Dimensions.get('window').width

const styles = StyleSheet.create({
    screen: {
        flex: 1,
        justifyContent: 'flex-start',
        alignItems: 'center'
    },
    imageContainer: {
        width: appScreenWidth < 380 ? 150 : 300,
        height: appScreenWidth < 380 ? 150 : 300,
        borderRadius: appScreenWidth < 380 ? 75 : 150,
        borderWidth: 3,
        borderColor: CustomColors.borderColor,
        overflow: 'hidden',
        margin: 36,
        alignItems: 'center',
        justifyContent: 'center'
    },
    image: {
        width: '100%',
        height: '100%'
    },
    summaryText: {
        fontFamily: 'open-sans',
        fontSize: 24,
        textAlign: 'center',
        marginVertical: 10
    },
    highlightText: {
        fontFamily: 'open-sans-bold',
        color: CustomColors.primary
    }
})
