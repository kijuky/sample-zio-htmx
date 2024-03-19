import zio.*
import zio.http.*
import zio.http.template.*

object BFF extends ZIOAppDefault:
  override val run: Task[Nothing] =
    Server
      .serve(
        Routes(
          Method.GET / "" -> handler(
            Response(
              Status.Ok,
              Headers(Header.ContentType(MediaType.text.html).untyped),
              Body.fromCharSequence:
                <html>
                  <head>
                    <script src="https://unpkg.com/htmx.org@1.9.11"></script>
                  </head>
                  <body>
                    <button hx-post="/clicked" hx-swap="outerHTML">
                      Click Me
                    </button>
                  </body>
                </html>.toString
            )
          ),
          Method.POST / "clicked" -> handler(
            Response(
              Status.Ok,
              Headers(Header.ContentType(MediaType.text.html).untyped),
              Body.fromCharSequence:
                <b>clicked</b>.toString
            )
          )
        ).toHttpApp
      )
      .provide(Server.default)
