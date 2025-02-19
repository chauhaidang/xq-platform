import { StyleSheet, View, Dimensions, Text, Pressable, Platform } from 'react-native'
import CustomColors from '../constants/colors'
import { common, ios } from '../constants/styles'
import { useNavigation } from '@react-navigation/native'
import { testProps } from '../utils/test-utils'

function Card({ children }) {
  const navigation = useNavigation()
  return (
    <View style={styles.root}>
      <Pressable
        android_ripple={styles.androidRipple}
        style={({ pressed }) => [{ flex: 1 }, pressed && ios.buttonPressed]}
        onPress={() => {
          navigation.navigate(children, {})
        }}
      >
        <View {...testProps(`card-${children}`)} style={styles.innerContainer}>
          <Text style={styles.heading}>{children}</Text>
        </View>
      </Pressable>
    </View>
  )
}

export default Card

const appScreenWidth = Dimensions.get('window').width

const styles = StyleSheet.create({
  root: {
    flex: 1,
    marginHorizontal: 20,
    marginVertical: 15,
    maxHeight: appScreenWidth / 2.5,
    borderRadius: 10,
    borderWidth: 0.5,
    ...common.shadow,
  },
  innerContainer: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    borderRadius: 10,
  },
  heading: {
    fontFamily: 'open-sans-bold',
    fontSize: 22,
  },
  androidRipple: {
    color: CustomColors.ripple,
  },
})
