import { FlatList, StyleSheet, Text, View } from 'react-native'
import { useRoute } from '@react-navigation/native'
import { MEALS } from '../data/dummy-data'
import InformativeItem from '../components/InformativeItem'

function MealOverViewScreen() {
  const route = useRoute()
  const catId = route.params.categoryId
  const filteredMeals = MEALS.filter(meal => meal.categoryIds.includes(catId))

  function renderMealItem(itemData) {
    const item = itemData.item
    const mealProps = {
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
      <FlatList data={filteredMeals} renderItem={renderMealItem} keyExtractor={item => item.id} />
    </View>
  )
}

export default MealOverViewScreen

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 16,
  },
})
