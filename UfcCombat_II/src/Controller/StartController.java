package Controller;

import Model.Actions;
import Model.Championship;
import Model.Fighter;
import Model.FileViewModel;
import Model.Npc;

import java.io.IOException;
import java.util.ArrayList;
import File.Archive;

public class StartController {

	private Archive archive;
	private int archiveNumber = 0;
	private Championship championship;
	private FighterController fighterController;
	private ChampionshipController championshipController;
	private FighterChampionshipController fighterChampionshipController;
	private ArrayList<FileViewModel> listFileViewModel;
	private ArrayList<Fighter> listFighter;
	private int contadorLuta = 1;

	public StartController() {
		this.archive = new Archive();
		this.fighterController = new FighterController();
		this.championshipController = new ChampionshipController();
		this.fighterChampionshipController = new FighterChampionshipController();
	}

	public boolean Go() {
		InvokeFile();

		for (int i = 0; i < archive.GetCountArray(); i++) {
			archiveNumber = i;
			BindFile();
			BindFileEntity();
			if (i == 0) {
				BindFighter();
			}
			BindChampionship();
			BindFighterChampionship();
			championship.SetCombat();
			championship.InvokeCombat();
		}
		return true;
	}

	public void InvokeFile() {
		try {
			archive.ReadArchivesPath();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void BindFile() {
		try {
			archive.ReadArchives(archiveNumber);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void BindFighter() {
		for (Fighter fighter : listFighter) {
			fighterController.PersistEntityFighter(fighter);
		}
	}

	public void BindChampionship() {
		championship.SetFighterList(listFighter);
		championshipController.PersistEntityChampionship(championship);
	}

	public void BindFighterChampionship() {
		fighterChampionshipController.PersistEntityFighterChampionship(listFighter, championship);
	}

	public void BindFileEntity() {
		String anoChampionship = archive.GetArrayFile(archiveNumber).substring(4, 8);
		championship = new Championship(archiveNumber, archive.GetArrayFile(archiveNumber), anoChampionship);
		listFileViewModel = new ArrayList<FileViewModel>();
		listFileViewModel = archive.GetListFileViewModel();
		listFighter = new ArrayList<Fighter>();
		int contadorLinha = 0, fighterId = 0;
		contadorLuta = 1;
		Npc npc = new Npc(1, "Default");
		for (int i = 0; i < listFileViewModel.size(); i++) {
			if (contadorLuta == listFileViewModel.get(i).GetContadorLuta()) {

				ArrayList<Actions> ActionsListUm = new ArrayList<Actions>();
				ArrayList<Actions> ActionsListDois = new ArrayList<Actions>();
				Actions actionsUm;
				Actions actionsDois;
				Fighter fighterUm;
				Fighter fighterDois;

				for (FileViewModel fileViewModel : listFileViewModel) {
					if (contadorLuta == fileViewModel.GetContadorLuta()) {
						actionsUm = new Actions(fileViewModel.GetDefesaUm(), fileViewModel.GetAtaqueUm(),
								fileViewModel.GetSocoUm(), fileViewModel.GetChuteUm(), fileViewModel.GetPoderUm(),
								fileViewModel.GetModalidadeUm());
						actionsDois = new Actions(fileViewModel.GetDefesaDois(), fileViewModel.GetAtaqueDois(),
								fileViewModel.GetSocoDois(), fileViewModel.GetChuteDois(), fileViewModel.GetPoderDois(),
								fileViewModel.GetModalidadeDois());
						ActionsListUm.add(actionsUm);
						ActionsListDois.add(actionsDois);
						contadorLuta = fileViewModel.GetContadorLuta();
						contadorLinha++;
					}
				}
				int idInfo = contadorLinha - 1;
				fighterUm = new Fighter(listFileViewModel.get(idInfo).GetNomeUm(),
						listFileViewModel.get(idInfo).GetPaisUm(), listFileViewModel.get(idInfo).GetCategoriaUm(),
						listFileViewModel.get(idInfo).GetSexoUm(), npc, 0);
				fighterUm.SetActionsList(ActionsListUm);
				fighterUm.SetSkillsList();
				fighterUm.SetId(fighterId);
				fighterId++;
				fighterDois = new Fighter(listFileViewModel.get(idInfo).GetNomeDois(),
						listFileViewModel.get(idInfo).GetPaisDois(), listFileViewModel.get(idInfo).GetCategoriaDois(),
						listFileViewModel.get(idInfo).GetSexoDois(), npc, 0);
				fighterDois.SetActionsList(ActionsListDois);
				fighterDois.SetSkillsList();
				fighterDois.SetId(fighterId);
				fighterId++;
				contadorLuta++;
				listFighter.add(fighterUm);
				listFighter.add(fighterDois);
			}
		}
	}
}
