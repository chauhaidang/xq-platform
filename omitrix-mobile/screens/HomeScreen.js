import { View, Text, StyleSheet } from 'react-native'
import Title from '../components/Title'
import List from '../components/List'
import CustomColors from '../constants/colors'
import EntityItem from '../components/EntityItem'
import { testProps } from '../utils/test-utils'

const renderEntityHandler = itemData => (
  <EntityItem index={itemData.item.id} value={itemData.item.text} onDelete={() => {}} />
)

export default function HomeScreen() {
  const mockData = []
  for (let i = 1; i <= 20; i++) {
    mockData.push('Requirement description ' + i)
  }
  return (
    <View style={styles.container}>
      <Title>Home</Title>
      <List input={mockData} renderHandler={renderEntityHandler} />
      <View style={styles.footer}>
        <Text {...testProps('test-data-footer')} style={styles.text}>
          Navigation
        </Text>
      </View>
    </View>
  )
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    marginTop: '5%',
  },
  footer: {
    fontSize: 20,
    fontFamily: 'open-sans-bold',
    color: CustomColors.textTitle,
    borderColor: CustomColors.borderTitle,
    borderTopWidth: 0.5,
    alignItems: 'center',
    padding: 5,
  },
  text: {
    fontSize: 20,
    fontFamily: 'open-sans-bold',
    fontStyle: 'normal',
  },
})
