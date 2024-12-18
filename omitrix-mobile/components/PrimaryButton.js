import { Pressable, StyleSheet, Text, View } from 'react-native'

function PrimaryButton({ children, onPress }) {
  return (
    <View style={styles.buttonOuterContainer}>
      <Pressable
        style={({ pressed }) => (pressed ? [styles.buttonContainer, styles.pressed] : styles.buttonContainer)}
        onPress={onPress}
        android_ripple={{ color: '#ffffff' }}
      >
        <Text style={styles.buttonText}>{children}</Text>
      </Pressable>
    </View>
  )
}

const styles = StyleSheet.create({
  buttonOuterContainer: {
    borderRadius: 28,
    margin: 4,
    overflow: 'hidden',
  },
  buttonContainer: {
    backgroundColor: '#ec494c',
    paddingVertical: 8,
    paddingHorizontal: 16,
    elevation: 10,
  },
  buttonText: {
    color: 'white',
    textAlign: 'center',
  },
  pressed: {
    opacity: 0.75,
  },
})

export default PrimaryButton
