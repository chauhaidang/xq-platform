import { FlatList, StyleSheet, Text, View } from 'react-native'
import { useRoute } from '@react-navigation/native'
import { CATEGORIES, MEALS } from '../data/dummy-data'
import InformativeItem from '../components/InformativeItem'
import { useLayoutEffect } from 'react'

function MealOverViewScreen({ navigation }) {
  const route = useRoute()
  const catId = route.params.categoryId
  const filteredMeals = MEALS.filter(meal => meal.categoryIds.includes(catId))

  useLayoutEffect(() => {
    //Reset the route's title base on data hold in navigation obj
    const catTitle = CATEGORIES.find(category => category.id === catId).title
    navigation.setOptions({
      title: catTitle,
    })
  }, [catId, navigation])

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
