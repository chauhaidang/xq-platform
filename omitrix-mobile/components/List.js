import React from 'react'
import { View, Text, FlatList, StyleSheet } from 'react-native'

/**
 * List component to render text items in a FlatList
 * @param {} input as an array of strings
 * @returns a FlatList component with the data from the transformed input ({id, text})
 */
const List = ({ input, renderHandler }) => {
  // Inject identifier to each item in the list if there is no id provided
  const data = input.map((value, index) => {
    return {
      id: value.id ?? index + 1,
      ...value
    }
  })
  return (
    <FlatList
      data={data}
      renderItem={renderHandler}
      keyExtractor={(item, index) => item.id}
      alwaysBounceVertical={false}
    />
  )
}

export default List
