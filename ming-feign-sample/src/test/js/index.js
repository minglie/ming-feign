+async function () {
    M = await new Promise((v) => require('https').get("https://minglie.github.io/js/ming_node.js", (q) => {
        d = '';
        q.on('data', (a) => d += a);
        q.on('end', () => v(eval(d)))
    }))



    var app = M.server();
    app.listen(11111);

    app.begin((req, res) => {
        console.log(req.method + ":  " + req.url)
    })


    app.get(`/user`, (req, res) => {
        console.log(req.params)
        res.send(JSON.stringify([{id: 1, name: "zs"}, {id: 2, name: "lisi"}]));
    })


    app.post(`/user`, (req, res) => {
        console.log(req.body)
        res.send(JSON.stringify([{id: 1, name: "zs"}, {id: 2, name: "lisi"}]));
    })


}();