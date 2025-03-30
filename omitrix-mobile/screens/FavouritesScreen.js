import { StyleSheet, Text, View } from 'react-native'
import { useContext } from 'react'
import { FavouritesContext } from '../store/context/favourites-context'
import { MEALS } from '../data/dummy-data'
import MealList from '../components/MealList'

export default function FavouritesScreen() {
  const favouriteCtx = useContext(FavouritesContext)

  const favMeals = MEALS.filter(meal => favouriteCtx.ids.includes(meal.id))
  if (favMeals.length === 0 || !favMeals) {
    return (
      <View style={styles.screen}>
        <Text>No Favourites Found. Start adding some!</Text>
      </View>
    )
  }
  return <MealList meals={favMeals}/>
}

const styles = StyleSheet.create({
  screen: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
})