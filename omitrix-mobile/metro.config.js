const { getDefaultConfig } = require('expo/metro-config');
const path = require('path');

/** @type {import('expo/metro-config').MetroConfig} */
const config = getDefaultConfig(__dirname);

config.resolver = {
    extraNodeModules: {
        fs: path.resolve(__dirname, 'mocks/fs.js'),
        path: path.resolve(__dirname, 'mocks/path.js'),
    },
};

module.exports = config;
