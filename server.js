import SocketServer from "websocket/server"
import http from "http"

const port = 8080;
const server = http.createServer((req, res) => {})

server.listen(port, () => {
    console.log(`Listening on port ${port}...`)
})

wsServer = new SocketServer({ httpServer:server })

const allConnections = []

wsServer.on('request', (req) => {
    const connection = req.accept()
    console.log('new connection')
    allConnections.push(connection)

    connection.on('message', (mes) => {
        allConnections.forEach(element => {
            if (element != connection)
                element.sendUTF(mes.utf8Data)
        })
    })

    connection.on('close', (resCode, des) => {
        console.log('connection closed')
        allConnections.splice(allConnections.indexOf(connection), 1)
    })

})
