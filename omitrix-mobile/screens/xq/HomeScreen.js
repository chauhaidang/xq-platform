import {StyleSheet, View} from 'react-native'
import Title from '../../components/Title'
import Card from '../../components/Card'
import {TITLES} from '../../constants/screens'

function HomeScreen() {
    return (
        <View style={styles.root}>
            <Card>{TITLES.TEST_PLAN_OVERVIEW}</Card>
            <Card>{TITLES.TEST_CASE_OVERVIEW}</Card>
            <Card>{TITLES.TEST_REPORT_OVERVIEW}</Card>
        </View>
    )
}

export default HomeScreen

const styles = StyleSheet.create({
    root: {
        flex: 1,
    },
})
