import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import database.TipsSqlDelightDataSource
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import ktor.TipsKtorDataSource
import models.Tip
import org.junit.Before
import org.junit.Test
import org.larkes.contacts.TipsDatabase
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TestTipsRepository {

    private lateinit var tipsRepository:TipsRepository

    @Before
    fun setup(){
        runBlocking {
            val driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
            TipsDatabase.Schema.create(driver).await()
            val db = TipsDatabase(driver)
            val httpClient = HttpClient(OkHttp) {
                install(ContentNegotiation) {
                    json(Json{
                        ignoreUnknownKeys = true
                    })
                }
                defaultRequest {
                    url("http://0.0.0.0:8084")
                }
            }
            val ktorSource = TipsKtorDataSource(httpClient)
            val sqlSource =TipsSqlDelightDataSource(db)
            tipsRepository = TipsRepositoryImpl(
                tipsKtorDataSource = ktorSource,
                tipsSqlDelightDataSource = sqlSource
            )
        }
    }

    @Test
    fun `delete 100 tips`(){
        runBlocking {
            tipsRepository.fetchTips(true, 100, 1).forEach {
                 tipsRepository.deleteTip(it.id!!)
            }
        }
    }

    @Test
    fun `fetch 5 and 5 tips`(){
        runBlocking {

            // pumping tips
            (0..10).forEach {
                val testTip = Tip(
                    color = 12434,
                    description = "Some description...",
                    title = "My title $it"
                )
                tipsRepository.insertTip(testTip)

            }
            //fetching
            var offset = 1
            val limit = 5

            // first iterating
            val tips1 = tipsRepository.fetchTips(true, limit, offset)
            offset += limit

            // second iterating
            val tips2 = tipsRepository.fetchTips(true, limit, offset)

            assertTrue(tips1 != tips2)

        }
    }

    @Test
    fun `should fetch 7 tips`(){
        runBlocking {
            val tips = mutableListOf<Tip>()
            var offset = 1
            val limit = 5
            tips += tipsRepository.fetchTips(refresh = false, offset = offset, limit = limit)
            offset+=limit
            tips += tipsRepository.fetchTips(refresh = false, offset = offset, limit = limit)
            offset+=limit
            tips += tipsRepository.fetchTips(refresh = false, offset = offset, limit = limit)
            offset+=limit
            tips.forEach {
                println(it.title)
            }
            assertEquals(tips.size , 7)



        }

    }

    @Test
    fun `should show 5 tips`(){
        runBlocking {
            // pumping tips
            (0..4).forEach {
                val testTip = Tip(
                    color = 12434,
                    description = "Some description...",
                    title = "My title $it"
                )
                tipsRepository.insertTip(testTip)

            }
            val tips = tipsRepository.fetchTips(true, 5, 1)
            assertEquals(tips.size, 5)
        }
    }

    @Test
    fun `delete tip`(){
        runBlocking {

            val testTip = Tip(
                color = 12434,
                description = "Some description...",
                title = "My title4"
            )
            tipsRepository.insertTip(testTip)

            tipsRepository.fetchTips(false, 100, 1).forEach {
                tipsRepository.deleteTip(id = it.id!!)

            }
            val tips = tipsRepository.fetchTips(false, 100, 1)
            assertTrue(tips.isEmpty())
        }
    }

    @Test
    fun `should edit tip`(){
        runBlocking {
            val testTip = Tip(
                color = 12434,
                description = "Some description...",
                title = "title to edit"
            )
            val id = tipsRepository.insertTip(testTip)
            val tip = tipsRepository.fetchTip(id)
            tip.title = "edited title"
            tipsRepository.editTip(tip)
            val tip2 = tipsRepository.fetchTip(id)
            assertEquals(tip2.title , "edited title")

        }

    }

    @Test
    fun `should add and fetch one tip`(){
        runBlocking {
            val testTip = Tip(
                color = 12434,
                description = "Some description...",
                title = "one tip title"
            )
            val id = tipsRepository.insertTip(testTip)
            val tip = tipsRepository.fetchTip(id)
            assertEquals(testTip.title , tip.title)

        }

    }



}