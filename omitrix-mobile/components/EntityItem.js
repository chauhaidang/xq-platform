import { Text, View, StyleSheet, Pressable, Platform } from 'react-native'
import { testProps } from '../utils/test-utils'
import CustomColors from '../constants/colors'

function EntityItem(props) {
  const index = props.index
  const content = props.value
  return (
    <View style={styles.entityItem}>
      <View style={styles.entityItemContainer}>
        <Pressable
          {...testProps(`item-entity-${index}`)}
          android_ripple={styles.androidRipple}
          onPress={() => {
            props.onDelete(props.id)
          }}
          style={({ pressed }) => [styles.button, pressed && styles.iosRipple]}
        >
          <Text style={styles.entityItemText}>{content}</Text>
        </Pressable>
      </View>
    </View>
  )
}

const styles = StyleSheet.create({
  entityItem: {
    flex: 1,
    marginVertical: 5,
    padding: 10,
  },
  entityItemContainer: {
    borderBottomWidth: 0.2,
    marginHorizontal: 20,
  },
  entityItemText: {
    fontSize: 24,
    fontFamily: 'open-sans',
    fontStyle: 'italic',
  },
  button: {
    flex: 1,
  },
  androidRipple: {
    color: CustomColors.ripple,
  },
  iosRipple: {
    opacity: 0.5,
    backgroundColor: CustomColors.ripple,
  },
})

export default EntityItem
