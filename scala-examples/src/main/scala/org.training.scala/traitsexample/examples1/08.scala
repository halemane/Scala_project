package org.training.scala.traitsexample.examples1

import java.io.{InputStream, FileInputStream, FileOutputStream}


/*
Marking Traits So They Can Only Be Used by
Subclasses of a Certain Type

*/

trait Buffering {
	this: InputStream =>

	val BUF_SIZE: Int = 5
	private val buf = new Array[Byte](BUF_SIZE)
	private var bufsize: Int = 0
	private var pos: Int = 0

	override def read(): Int = {
		if (pos >= bufsize) {
			bufsize = this.read(buf, 0, BUF_SIZE)
			if (bufsize > 0) -1
			pos = 0
			println("inside overriden read method")
		}
		pos += 1
		buf(pos-1)
	}
}

object BufferingTesting {
	
	def main(args: Array[String]) {

		val f = new FileInputStream("Buffering.txt") with Buffering

		for(i <- 1 to 10) println(f.read())

	}
}


