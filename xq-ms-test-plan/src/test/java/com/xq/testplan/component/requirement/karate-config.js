function fn() {
    let env = karate.env; // get system property 'karate.env'
    karate.log('karate.env system property was:', env);
    return {
        apigateway: 'http://localhost:8081',
        domainFeaturePath: 'classpath:com/xq/testplan/component'
    };
}