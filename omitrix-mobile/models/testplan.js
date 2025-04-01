export default class TestPlan {
  constructor(id, description, priority, status, createdDate, lastUpdatedDate = null, assignedTo, acceptanceCriteria = []) {
    this.id = id
    this.description = description
    this.priority = priority
    this.status = status
    this.createdDate = createdDate
    this.lastUpdatedDate = lastUpdatedDate
    this.assignedTo = assignedTo
    this.acceptanceCriteria = acceptanceCriteria
  }
}

export function generateDummyTestPlans(total) {
  const testReqs = []
  const date = new Date().toISOString()
  for (let i = 0; i < total; i++) {
    testReqs.push(
      new TestPlan(
        i, `Requirement description ${i}`, 'Medium', 'Open', date, date,
        `User ${i}`, [`Acceptance criteria ${i}-1`, `Acceptance criteria ${i}-2`],
      ),
    )
  }

  return testReqs
}