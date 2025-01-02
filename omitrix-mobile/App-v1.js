import { useState } from 'react';
import { Button, FlatList, StyleSheet, Text, View } from 'react-native';
import EntityItem from "./components/EntityItem";
import EntityInput from "./components/EntityInput";
import { randomByLength } from 'kit-common';

export default function App() {
    const [entities, setEntities] = useState([]);
    const [entityModalVisible, setEntityModalVisible] = useState(false);

    function addEntityHandler(enteredTxt) {
        setEntities(currentEntities => [...currentEntities, {
            text: enteredTxt,
            id: randomByLength(5)
        }])
        setEntityModalVisible(false)
    }

    function clearEntities() {
        setEntities([])
    }

    function deleteEntityHandler(id) {
        setEntities(currentEntities => currentEntities.filter(entity => entity.id !== id))
    }

    function addNewEntityHandler() {
        setEntityModalVisible(true)
    }

    function dismissModal() {
        setEntityModalVisible(false)
    }

    return (
        <View style={styles.appContainer}>
            <Button title={'ADD NEW ENTITY'} onPress={addNewEntityHandler} color='#EE6B6E' />
            <EntityInput isVisible={entityModalVisible} onAddEntity={addEntityHandler} onClearEntities={clearEntities} onDismiss={dismissModal} />
            <View style={styles.listItems}>
                <Text>#List of entities</Text>
                <FlatList
                    data={entities}
                    renderItem={itemData =>
                        <EntityItem index={itemData.index} value={itemData.item.text} id={itemData.item.id} onDelete={deleteEntityHandler} />
                    }
                    keyExtractor={(item, index) => item.id}
                    alwaysBounceVertical={false}
                />
            </View>
        </View>
    );
}

const styles = StyleSheet.create({
    appContainer: {
        flex: 1,
        paddingTop: 50,
        paddingHorizontal: 25
    },
    listItems: {
        flex: 8
    }
});
