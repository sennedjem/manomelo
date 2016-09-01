package melomano.dominio.hbmUtils

import java.util.concurrent.Callable

interface ServiceCommand<T> extends Callable<T> {
	override def T call()
}