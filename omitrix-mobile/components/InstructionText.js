import React from 'react';
import { Text, StyleSheet } from 'react-native';
import CustomColors from '../constants/colors';

const InstructionText = ({ children, style }) => {
    return <Text style={[styles.instructionText, style]}> {children}</Text >;
};

const styles = StyleSheet.create({
    instructionText: {
        fontSize: 24,
        color: CustomColors.text,
        textAlign: 'center',
        marginVertical: 10,
    },
});

export default InstructionText;