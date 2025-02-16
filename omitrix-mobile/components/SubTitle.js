import { StyleSheet, Text, View } from 'react-native'
import CustomColors from '../constants/colors'

function SubTitle({ children }) {
  return (
    <View style={styles.subTitleContainer}>
      <Text style={styles.subTitle}>{children}</Text>
    </View>
  )
}
export default SubTitle

const styles = StyleSheet.create({
  subTitle: {
    color: CustomColors.textTitle,
    fontSize: 18,
    fontWeight: 'bold',
    textAlign: 'center',
  },
  subTitleContainer: {
    padding: 8,
    borderBottomWidth: 2,
    borderBottomColor: CustomColors.border,
    marginHorizontal: 24,
    marginVertical: 4,
  },
})
