import { Text, StyleSheet } from 'react-native'
import CustomColors from '../constants/colors'
import { testProps } from '../utils/test-utils'

function Title({ children }) {
  return (
    <Text {...testProps('test-data-title')} style={styles.title}>
      {children}
    </Text>
  )
}

export default Title

const styles = StyleSheet.create({
  title: {
    fontSize: 26,
    fontFamily: 'open-sans-bold',
    fontWeight: 'semibold',
    color: CustomColors.textTitle,
    textAlign: 'center',
    borderColor: CustomColors.borderTitle,
    padding: 5,
    borderBottomWidth: 1,
    marginTop: 10,
    fontStyle: 'normal',
    maxWidth: '100%',
    minWidth: 300,
  },
})
