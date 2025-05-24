function fn() {
    let ConfigReader = Java.type('com.xq.ConfigReader');
    let StringUtility = Java.type('com.xq.StringUtility');
    let config = new ConfigReader().loadConfig();
    let apis = karate.call('classpath:setup-api.js', { apiGateway: config.getApiGateway() });

    return {
        apis: apis,
        models: {
            Requirement: 'com.xq.testplan.api.model.Requirement'
        },
        randomStringPrefix: StringUtility.generateRandomString,
        randomTitle: StringUtility.fnGenerateRandomStringPrefix(10, 'Title-' )
    };
}