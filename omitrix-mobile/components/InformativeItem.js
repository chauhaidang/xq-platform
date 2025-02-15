import { Pressable, StyleSheet, Text, View, Image, Platform } from 'react-native'
import CustomColors from '../constants/colors'
import { useNavigation } from '@react-navigation/native'
import { TITLES } from '../constants/screens'

function InformativeItem({ id, title, imageUrl, duration, complexity, affordability }) {
  const navigation = useNavigation()
  function navigateToMealDetail() {
    navigation.navigate(TITLES.MEAL_DETAIL, {
      mealId: id,
    })
  }
  return (
    <View style={styles.container}>
      <Pressable
        android_ripple={{ color: CustomColors.ripple }}
        style={({ pressed }) => (pressed ? styles.buttonPressedIOS : null)}
        onPress={navigateToMealDetail}
      >
        <View style={styles.innerContainer}>
          <Image source={{ uri: imageUrl }} style={styles.image} />
          <Text style={styles.title}>{title}</Text>
        </View>
        <View style={styles.sectionDetail}>
          <Text style={styles.sectionDetailItem}>{duration}min(s)</Text>
          <Text style={styles.sectionDetailItem}>{complexity}</Text>
          <Text style={styles.sectionDetailItem}>{affordability}</Text>
        </View>
      </Pressable>
    </View>
  )
}

export default InformativeItem

const styles = StyleSheet.create({
  container: {
    margin: 10,
    borderRadius: 8,
    backgroundColor: 'white',
    // for Android
    elevation: 10,
    // for ios
    shadowColor: 'black',
    shadowOffset: { width: 0, height: 7 },
    shadowRadius: 8,
    shadowOpacity: 0.25,
    overflow: Platform.OS === 'android' ? 'hidden' : 'visible',
  },
  innerContainer: { borderRadius: 8, overflow: 'hidden' },
  image: {
    width: '100%',
    height: 200,
  },
  title: {
    fontWeight: 'bold',
    textAlign: 'center',
    fontSize: 16,
    margin: 4,
  },
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
  buttonPressedIOS: { opacity: 0.5 },
})
