var M = require("ming_node");
var app = M.server();
app.listen(11111);


app.begin((req,res)=>{console.log(req.method)})


app.get(`/user`, (req, res)=>{
    console.log(req.params)
    res.send(JSON.stringify([{id: 1, name: "zs"}, {id: 2, name: "lisi"}]));
})


app.post(`/user`, (req, res)=>{console.log(req.body)
    res.send(JSON.stringify([{id: 1, name: "zs"}, {id: 2, name: "lisi"}]));
})