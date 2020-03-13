// QSim : simulateur quantique
// Gildas Ménier
// 2010
package Vqs


// matrice dense complexe
// Gildas Ménier

case class QM(l_ : QV*) {
  lazy val coord: Array[QV] = l_.toArray[QV]

  def apply(i: Int) = coord(i)
  def length = coord.length

  def mult(v_ : QV): QV = { // multiplication
    val nv = for( ligne <- 0 until length) yield {
      (0 until length).map(a => coord(ligne)(a)).zip(v_.getArray).map(
        c => c._1 * c._2
      ).reduceLeft( (a,b) => a+b)
    }
    QV( nv : _*)
  } // mult


  override def toString: String = this.coord.mkString("|","\n|","|")
} // MatC