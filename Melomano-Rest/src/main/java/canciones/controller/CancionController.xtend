package canciones.controller


import org.uqbar.xtrest.api.Result
import org.uqbar.xtrest.api.XTRest
import org.uqbar.xtrest.api.annotation.Body
import org.uqbar.xtrest.api.annotation.Controller
import org.uqbar.xtrest.api.annotation.Get
import org.uqbar.xtrest.api.annotation.Post
import org.uqbar.xtrest.http.ContentType
import org.uqbar.xtrest.json.JSONUtils
import java.util.ArrayList
import java.util.List
import melomano.dominio.services.ServicioCancion
import melomano.dominio.Cancion
import melomano.dominio.services.ServicioPuntajes
import melomano.dominio.PuntajeDeJugada

@Controller
class CancionController {


	var ServicioCancion serv = new ServicioCancion	
	var ServicioPuntajes servpunt = new ServicioPuntajes	

	extension JSONUtils = new JSONUtils

	@Get('/generos')
	def Result carreras() {
		var generos = #["Rock", "Cumbia","Tango","Pop","Rap", "Electronica"]
		response.contentType = ContentType.APPLICATION_JSON
		ok(generos.toJson)
	}

	@Get('/canciones/:genero')
	def Result turnos() {
		var canciones = serv.getPorGenero(genero)
		response.contentType = ContentType.APPLICATION_JSON
		ok(canciones.toJson)
	}

	@Get('/puntajes')
	def Result puntajes() {
		var canciones = servpunt.get10
		response.contentType = ContentType.APPLICATION_JSON
		ok(canciones.toJson)
	}
	
	@Get('/puntajes/:genero')
	def Result puntajesPorGenero() {
		var canciones = servpunt.getPorGenero(genero)
		response.contentType = ContentType.APPLICATION_JSON
		ok(canciones.toJson)
		
	}
	
	@Post("/puntajess")
	def Result convertir(@Body String body) {
		var PuntajeDeJugada puntaje = body.fromJson(PuntajeDeJugada)
		if(puntaje.estaCompleta){servpunt.guardarPuntaje(puntaje)}
		ok(true.toJson)
	}

	def static void main(String[] args) {
		XTRest.start(CancionController, 9800)
		
		
	}
}
