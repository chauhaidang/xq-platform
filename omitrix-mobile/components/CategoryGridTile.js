import { Pressable, StyleSheet, Text, View, Platform } from 'react-native'
import CustomColors from '../constants/colors'
import { useNavigation } from '@react-navigation/native'
import { TITLES } from '../constants/screens'

function CategoryGridTile({ title, color, id }) {
  const navigation = useNavigation()
  return (
    <View style={styles.gridItem}>
      <Pressable
        android_ripple={{ color: CustomColors.ripple }}
        style={({ pressed }) => [styles.button, pressed ? styles.buttonPressedIOS : null]}
        onPress={() => {
          navigation.navigate(TITLES.MEAL_OVERVIEW, {
            categoryId: id,
          })
        }}
      >
        <View style={[styles.innerContainer, { backgroundColor: color }]}>
          <Text style={styles.heading}>{title}</Text>
        </View>
      </Pressable>
    </View>
  )
}

export default CategoryGridTile

const styles = StyleSheet.create({
  gridItem: {
    flex: 1,
    margin: 10,
    height: 150,
    borderRadius: 10,
    elevation: 4,
    shadowColor: 'black',
    shadowOpacity: 0.25,
    shadowOffset: { width: 0, height: 3 },
    shadowRadius: 8,
    backgroundColor: 'white',
    overflow: Platform.OS === 'android' ? 'hidden' : 'visible',
  },
  button: {
    flex: 1,
  },
  buttonPressedIOS: {
    opacity: 0.5,
  },
  innerContainer: {
    flex: 1,
    padding: 16,
    justifyContent: 'center',
    alignItems: 'center',
    borderRadius: 10,
  },
  heading: {
    fontWeight: 'bold',
    fontSize: 16,
  },
})
