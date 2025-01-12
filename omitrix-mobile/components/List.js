import React from 'react';
import { View, Text, FlatList, StyleSheet } from 'react-native';
import EntityItem from './EntityItem';

const List = ({ input }) => {
    let data = []
    for (let index = 1; index <= 20; index++) {
        data.push({
            text: `${index}. user navigate to test requirement succesfully`,
            id: index
        })
    }
    data = input ?? data

    const renderItem = (itemData) => (
        <EntityItem index={itemData.index} value={itemData.item.text} onDelete={() => { }} />
    );

    return (
        <FlatList
            data={data}
            renderItem={renderItem}
            keyExtractor={(item, index) => item.id}
            alwaysBounceVertical={false}
        />
    );
};

export default List;