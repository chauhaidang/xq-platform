// filepath: mocks/fs.js
export const readFileSync = () => {
    throw new Error("fs.readFileSync is not supported in React Native");
};

export const writeFileSync = () => {
    throw new Error("fs.writeFileSync is not supported in React Native");
};