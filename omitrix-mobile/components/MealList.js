import { FlatList, StyleSheet, View } from 'react-native'
import InformativeItem from './InformativeItem'

export default function MealList({meals}) {
  function renderMealItem(itemData) {
    const item = itemData.item
    const mealProps = {
      id: item.id,
      title: item.title,
      imageUrl: item.imageUrl,
      duration: item.duration,
      complexity: item.complexity,
      affordability: item.affordability,
    }
    return <InformativeItem {...mealProps} />
  }

  return (
    <View style={styles.container}>
      <FlatList data={meals} renderItem={renderMealItem} keyExtractor={item => item.id} />
    </View>
  )
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 16,
  },
})