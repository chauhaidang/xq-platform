function fn() {
    let ConfigReader = Java.type('com.xq.ConfigReader');
    let config = new ConfigReader().loadConfig();
    let apis = karate.call('classpath:setup-api.js', { apiGateway: config.getApiGateway() });

    return {
        apis: apis,
        models: {
            Requirement: 'com.xq.testplan.api.model.Requirement'
        },
    };
}