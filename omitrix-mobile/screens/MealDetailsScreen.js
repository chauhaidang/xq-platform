import { View, Text } from 'react-native'

function MealDetailsScreen({ route }) {
  const mealId = route.params.mealId
  return (
    <View>
      <Text>Meal Detail Of {mealId}</Text>
    </View>
  )
}

export default MealDetailsScreen
