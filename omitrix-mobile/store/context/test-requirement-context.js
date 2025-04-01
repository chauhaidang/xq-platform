import { createContext, useState } from 'react'
import { generateDummyTestPlans } from '../../models/testplan'

export const TestRequirementContext = createContext({
  requirements: [],
})

const TestRequirementContextProvider = ({ children }) => {
  const initialRequirements = generateDummyTestPlans(10)
  const value = {
    requirements: initialRequirements,
  }
  return <TestRequirementContext.Provider value={value}>{children}</TestRequirementContext.Provider>
}

export default TestRequirementContextProvider