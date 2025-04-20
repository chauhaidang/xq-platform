import {Configuration, Requirement, RESTAPISTestPlanApi} from "testplan-client";
const config = new Configuration({
    basePath: 'http://localhost:8080', // Replace with the actual API base URL
});

const api = new RESTAPISTestPlanApi(config);

async function run() {
    const req: Requirement = {
        title: 'Test Requirement',
        description: 'This is a test requirement',
        tags: 'tag1,tag2',
        scopes: 'scope1,scope2',
        references: 'http://example.com',
    }
    try {
        const response = await api.createRequirement(req); // Replace with a valid test plan ID
        console.log('Test Plan:', response.data);
    } catch (error) {
        console.error('Error:', error);
    }
}

run();