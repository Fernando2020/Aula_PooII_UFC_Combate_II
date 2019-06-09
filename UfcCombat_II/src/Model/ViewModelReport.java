package Model;

/**
 * Classe modelo para armazenar o tipo ViewModelReport, onde serão contidos,
 * valores e métodos para o mesmo.
 * 
 * @author Fernando G. Nogueira
 * @version 1.0
 */
public class ViewModelReport {
	private Fighter fighter = new Fighter();
	private Championship championship = new Championship();
	private Combat combat = new Combat();
	private int CountAux = 0;

	public ViewModelReport() {

	}

	public Fighter GetFighter() {
		return fighter;
	}

	public void SetFighter(Fighter fighter) {
		this.fighter = fighter;
	}

	public Championship GetChampionship() {
		return championship;
	}

	public void SetChampionship(Championship championship) {
		this.championship = championship;
	}

	public Combat GetCombat() {
		return combat;
	}

	public void SetCombat(Combat combat) {
		this.combat = combat;
	}

	public int GetCountAux() {
		return CountAux;
	}

	public void SetCountAux(int countAux) {
		this.CountAux = countAux;
	}
}
