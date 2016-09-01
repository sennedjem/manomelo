package melomano.dominio.services

import melomano.dominio.hbmUtils.SessionManager
import melomano.dominio.daoHbm.CancionDao
import melomano.dominio.Cancion

class ServicioCancion {
	
	new(){

	}
	def getPorGenero(String genero){
		SessionManager.runInSession([|
		new CancionDao().getPorGenero(genero.toLowerCase())
		]);
	}
	
	def guardarCancion(Cancion can){
		SessionManager.runInSession([|
		new CancionDao().save(can)
		1
		]);
	}
	
	def eliminarCancion(Cancion can){
		SessionManager.runInSession([|
		new CancionDao().delete(can)
		1
		]);
	}
	
}