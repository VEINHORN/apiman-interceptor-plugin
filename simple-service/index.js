var express = require('express'),
    bodyParser = require('body-parser')
    app = express();

// parse application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({ extended: false }))

app.use(bodyParser.text({ type: 'text/xml' }))

// respond with "hello world" when a GET request is made to the homepage
app.get('/', function(req, res) {
  res.send('hello world');
});

app.post('/', function(req, res) {
  res.send('hello world 2');
  console.log(req.body.xml);
});

app.listen(3000);
console.log('Express started on port 3000');
