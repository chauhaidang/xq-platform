import { useRoute } from '@react-navigation/native'
import { CATEGORIES, MEALS } from '../data/dummy-data'
import { useLayoutEffect } from 'react'
import MealList from '../components/MealList'

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

  return <MealList meals={filteredMeals}/>
}

export default MealOverViewScreen
