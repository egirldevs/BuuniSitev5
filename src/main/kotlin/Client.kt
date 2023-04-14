import kotlinx.browser.document
import kotlinx.browser.window
import react.createContext
import react.dom.render
import react.functionalComponent
import react.useState

fun main() {
    val container = document.createElement("div")
    document.body!!.appendChild(container)

    val welcome = Welcome.create {
        name = "Kotlin/JS"
    }

    render(container) {
        welcomeComponent()
    }
}

val WelcomeContext = createContext("")

interface WelcomeProps : RProps {
    var name: String
}

val Welcome = functionalComponent<WelcomeProps> { props ->
    val (welcomeText, setWelcomeText) = useState("Welcome to")

    WelcomeContext.Provider(value = props.name) {
        setWelcomeText("$welcomeText ${props.name}")

        h1 {
            +welcomeText
        }
    }
}

fun RBuilder.welcomeComponent() = Welcome {}