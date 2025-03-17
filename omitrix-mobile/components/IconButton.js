import { Ionicons } from '@expo/vector-icons'
import {Pressable, StyleSheet} from "react-native";

function IconButton({name, color, onPress}) {
   return (
       <Pressable onPress={onPress} style={({pressed}) => pressed && styles.root}>
           <Ionicons name={name} color={color}/>
       </Pressable>
   )
}

export default IconButton

const styles = StyleSheet.create({
    root: {
        opacity: 0.7
    }
})