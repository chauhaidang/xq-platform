import { StyleSheet, Text, View } from 'react-native'
import CustomColors from '../constants/colors'

function StaticList({ data }) {
  return data.map(value => (
    <View key={value} style={styles.entityItem}>
      <Text style={styles.entityItemText}>{value}</Text>
    </View>
  ))
}

export default StaticList

const styles = StyleSheet.create({
  entityItem: {
    backgroundColor: '#fdfdfd',
    borderStyle: 'solid',
    borderColor: CustomColors.border,
    marginHorizontal: 12,
    marginVertical: 4,
    paddingHorizontal: 8,
    paddingVertical: 4,
    borderRadius: 6,
  },
  entityItemText: {
    fontSize: 20,
    fontFamily: 'open-sans',
    fontStyle: 'italic',
    textAlign: 'center',
  },
})
