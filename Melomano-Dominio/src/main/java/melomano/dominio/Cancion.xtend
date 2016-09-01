package melomano.dominio

import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Cancion {
	String nombre
	String cancionIncompleta
	String primeraPalabra
	String segundaPalabra
	String palabraIncorrectaUno
	String palabraIncorrectaDos
	String primerPregunta
	String respuestaReal
	String genero
	Integer idCancion
	
	new(){}
	
	new(String nombre, String canInc, String pripal, String segpal, String primPreg, String segPreg, 
	 String primResp, String segResp , String genero){
			this.nombre= nombre
			this.cancionIncompleta = canInc
			this.primeraPalabra = pripal
			this.segundaPalabra = segpal
			this.palabraIncorrectaUno = primPreg
			this.palabraIncorrectaDos = segPreg
			this.respuestaReal = primResp
			this.primerPregunta = segResp
			this.genero = genero
		}
		
	def void equals(Cancion cancion){
		this.nombre.equals(cancion.nombre)
	}
		
	
}