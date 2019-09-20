package handlers

import com.google.gson.JsonParser
import data.Player
import org.eclipse.jetty.websocket.api.Session
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage
import org.eclipse.jetty.websocket.api.annotations.WebSocket
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.atomic.AtomicLong

@WebSocket
class Civ6RandomizeWSHandler {
    private val logger: Logger = LoggerFactory.getLogger(Civ6RandomizeWSHandler::class.java)

    private val players = HashMap<Session, Player>()
    private var uids = AtomicLong(0)

    @OnWebSocketConnect
    fun connected(session: Session) {
        session.remote.sendString("message")
        logger.info("connected")
    }

    @OnWebSocketMessage
    fun messageRecieved(session: Session, message: String) {
        val json = JsonParser().parse(message).getAsJsonObject()
        val messageType = json.get("type").asString
        val messageData = json.get("data")

        when (messageType) {
            "joinRoom" -> {
                val playerName = messageData.asString
                players[session] = Player(uids.getAndIncrement(), playerName)
                logger.info("player {} joined to the room")
            }
            "banCiv" -> {
                //
            }
            "changeRules" -> {
                //
            }
            "generate" -> {
                //
            }
            "restart" -> {
                //
            }
            "test" -> {
                println("test message received")
            }
        }
    }

    @OnWebSocketClose
    fun disconnected(session: Session, code: Int, reason: String) {
        logger.info("disconnected")
    }
}