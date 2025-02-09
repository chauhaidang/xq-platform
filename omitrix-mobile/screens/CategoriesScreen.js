import { FlatList, StyleSheet, Text, View } from 'react-native'
import CategoryGridTile from '../components/CategoryGridTile'
import { CATEGORIES } from '../data/dummy-data'

function renderCategoryItem(itemData) {
  return (
    <CategoryGridTile
      title={itemData.item.title}
      color={itemData.item.color}
      id={itemData.item.id}
    />
  )
}

function CategoriesScreen() {
  return (
    <View style={styles.container}>
      <FlatList
        data={CATEGORIES}
        keyExtractor={item => item.id}
        renderItem={renderCategoryItem}
        numColumns={2}
      />
    </View>
  )
}

export default CategoriesScreen

const styles = StyleSheet.create({
  container: {},
})
