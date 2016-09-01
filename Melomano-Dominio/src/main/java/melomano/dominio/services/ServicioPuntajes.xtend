package melomano.dominio.services

import melomano.dominio.hbmUtils.SessionManager
import melomano.dominio.PuntajeDeJugada
import melomano.dominio.daoHbm.PuntajeDeJugadaDao

class ServicioPuntajes {
	new(){

	}
	
	def getPorGenero(String genero){
		SessionManager.runInSession([|
		new PuntajeDeJugadaDao().getPorGenero(genero.toLowerCase())
		]);
	}
	
	def guardarPuntaje(PuntajeDeJugada can){
		SessionManager.runInSession([|
		new PuntajeDeJugadaDao().save(can)
		1
		]);
	}
	
	def eliminarPuntaje(PuntajeDeJugada can){
		SessionManager.runInSession([|
		new PuntajeDeJugadaDao().delete(can)
		1
		]);
	}
	
	def getAll(){
		SessionManager.runInSession([|
		new PuntajeDeJugadaDao().getAll()
		]);
	}
	
	def get10(){
		SessionManager.runInSession([|
		new PuntajeDeJugadaDao().get10()
		]);
	}
}