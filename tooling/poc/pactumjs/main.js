const { spec } = require('pactum')

const table = {
    rawTable: [
        { discordUsername: "david" },
        { bio: "david" },
        { avatar: "davidicon" }
    ]
}

console.log(table.rawTable.reduce((result, current) => {
    return current;
}, {}));


const run = async () => {
    const request = spec()
    request.get('https://randomuser.me/api')
    await request.toss()
    const res = request.response()
    res.to.have.status(200)
}

run().then(() => { })



