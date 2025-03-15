function fn() {
  let env = karate.env; // get system property 'karate.env'
  karate.log('karate.env system property was:', env);
  var config = {
    domainFeaturePath: 'classpath:com/xq/testplan/component'
  };
  return config;
}