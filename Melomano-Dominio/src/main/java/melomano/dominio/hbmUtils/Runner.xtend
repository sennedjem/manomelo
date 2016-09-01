package melomano.dominio.hbmUtils

interface Runner {
	
	def <T> T run(ServiceCommand<T> s)
}