package melomano.dominio

import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class PuntajeDeJugada {
	
	String nombre
	String genero
	Integer puntaje
	Integer idPuntaje
	
	new(){}
	
	new(String nombre,Integer puntaje, String genero){
			this.nombre = nombre
			this.puntaje = puntaje
			this.genero = genero
		}
		
	def boolean estaCompleta(){
		return nombre!=null && genero !=null && puntaje !=null
	}	
}