import { View, Text, StyleSheet } from 'react-native'
import Title from '../../components/Title'
import List from '../../components/List'
import CustomColors from '../../constants/colors'
import EntityItem from '../../components/EntityItem'
import { testProps } from '../../utils/test-utils'


/**
 * Render handler for the test requirements list
 * @param itemData which should contain the id and description fields
 * @returns {JSX.Element}
 */
const renderTestRequirementsHandler = itemData => (
  <EntityItem index={itemData.item.id} data={itemData.item.description} onDelete={() => {}} />
)

const generateDummyRequirements = (count) => {
  const requirements = [];
  for (let i = 1; i <= count; i++) {
    requirements.push({
      id: i,
      description: `Requirement description ${i}`,
      priority: 'Medium',
      status: 'Open',
      createdDate: new Date().toISOString(),
      lastUpdatedDate: new Date().toISOString(),
      assignedTo: `User ${i}`,
      acceptanceCriteria: [
        `Acceptance criteria ${i}-1`,
        `Acceptance criteria ${i}-2`
      ]
    });
  }
  return requirements;
};

export default function TestPlansScreen() {
  const requirements = generateDummyRequirements(10)
  return (
    <View style={styles.root}>
      <List input={requirements} renderHandler={renderTestRequirementsHandler} />
    </View>
  )
}

const styles = StyleSheet.create({
  root: {
    flex: 1,
  },
  footer: {
    fontSize: 20,
    fontFamily: 'open-sans-bold',
    color: CustomColors.textTitle,
    borderColor: CustomColors.borderTitle,
    borderTopWidth: 0.5,
    alignItems: 'center',
    padding: 5,
  },
  text: {
    fontSize: 20,
    fontFamily: 'open-sans-bold',
    fontStyle: 'normal',
  },
})
