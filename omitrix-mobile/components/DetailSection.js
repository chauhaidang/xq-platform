import { StyleSheet, Text, View } from 'react-native'

function DetailSection({ duration, complexity, affordability, additionalStyle, textStyle }) {
  return (
    <View style={[styles.sectionDetail, additionalStyle]}>
      <Text style={[styles.sectionDetailItem, textStyle]}>{duration}min(s)</Text>
      <Text style={[styles.sectionDetailItem, textStyle]}>{complexity}</Text>
      <Text style={[styles.sectionDetailItem, textStyle]}>{affordability}</Text>
    </View>
  )
}

export default DetailSection

const styles = StyleSheet.create({
  sectionDetail: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'center',
    padding: 8,
  },
  sectionDetailItem: {
    fontSize: 12,
    marginHorizontal: 4,
  },
})
