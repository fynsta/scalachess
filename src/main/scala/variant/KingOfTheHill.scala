package chess
package variant

case object KingOfTheHill
    extends Variant(
      id = 4,
      key = "kingOfTheHill",
      name = "King of the Hill",
      shortName = "KotH",
      title = "Bring your King to the center to win the game.",
      standardInitialPosition = true
    ) {

  def pieces = Standard.pieces

  override def specialEnd(situation: Situation) =
    situation.board.kingPosOf(!situation.color) exists PosSet.center.has

  /**
    * You only need a king to be able to win in this variant
    */
  override def opponentHasInsufficientMaterial(situation: Situation) = false
  override def isInsufficientMaterial(board: Board)                  = false
}
