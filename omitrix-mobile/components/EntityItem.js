import { Text, View, StyleSheet, Pressable } from "react-native";
import { testProps } from "../utils/test-utils";
import CustomColors from "../constants/colors";

function EntityItem(props) {
    const index = props.index
    const content = props.value
    return (
        <View style={styles.entityItem}>
            <Pressable
                {...testProps(`item-entity-${index}`)}
                android_ripple={styles.androidRipple}
                onPress={() => {
                    props.onDelete(props.id)
                }}
                style={({ pressed }) => pressed && styles.iosRipple}
            >
                <Text style={styles.entityItemText}>
                    {content}
                </Text>
            </Pressable>
        </View>
    )
}

const styles = StyleSheet.create({
    entityItem: {
        backgroundColor: '#fdfdfd',
        padding: 15,
        borderBottomWidth: 0.3,
        borderStyle: 'solid',
        borderColor: CustomColors.border
    },
    entityItemText: {
        fontSize: 20,
        fontFamily: 'open-sans',
        fontStyle: 'italic',
    },
    androidRipple: {
        color: CustomColors.ripple
    },
    iosRipple: {
        opacity: 0.3,
        backgroundColor: CustomColors.ripple,
    }
})

export default EntityItem